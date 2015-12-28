/**
 * 
 */
package fakocka.model;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import org.xml.sax.SAXException;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * @author fakocka
 *
 */
public class CircuitLoader 
{
	/**
	 * az .xml file-bol feltontendo digitalis aramkor
	 */
	private DigitalCircuit digitalCircuit;
	
	/**
	 * .xml file neve
	 */
	private String fileName;
	
	/**
	 * a beolvasott .xml file-t reprezentalo DOM objektum
	 */
	private Document document;
	
	/**
	 * az xml document gyokereleme
	 */
	private Element rootElement;
	
	/**
	 * 
	 */
	//private Composite composite;
	
	private ArrayList<Composite> internalComposites = new ArrayList<Composite>();
	
	private int beagyazasMelysege = 0;
	
	/**
	 * @param digitalCircuit ezt a digitalis aramkort tolti fel az .xml filebol
	 * @param fileName az .xml file neve
	 * 
	 * Konstruktor
	 */
	public CircuitLoader(DigitalCircuit digitalCircuit, String fileName)
	{
		this.digitalCircuit = digitalCircuit;
		this.fileName = fileName;
		
		// DocumentBuilderFactory letrehozasa
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		try
		{
			// DocumentBuilder letrehozasa a Factory segitsegevel
			DocumentBuilder db = dbf.newDocumentBuilder();
			// a megadott .xml file beolvasa egy DOM objektumba
			document = db.parse(new File(this.fileName));
			// gyoker elem lekerdezese
			rootElement = document.getDocumentElement();
		}
		catch(ParserConfigurationException pce) 
		{
			pce.printStackTrace();
			System.out.println(pce.getMessage());
		}
		catch(SAXException se)
		{
			se.printStackTrace();
			System.out.println(se.getMessage());
		}
		catch(IOException ioe) 
		{
			ioe.printStackTrace();
			System.out.println(ioe.getMessage());
		}
	}
	
	/**
	 * feltolti a megadott digitalis aramkort a megadott .xml filebol
	 */
	public void loadCircuit()
	{		
		NodeList elemek = rootElement.getChildNodes();
		
		// az osszes elemen vegigmegyunk es valogatunk
		for (int i = 0; i < elemek.getLength(); i++) 
		{
			Node child = elemek.item(i);
			/* <component> tag */
			if (child.getNodeName().equals("component")) 
			{
				// component-ek lekerdezese a nodelistabol
				Element component = (Element)child;
				// digitalis komponens letrehozas a kiovasott component-bol, null, mert most nem kompozit elembe toltunk bele
				createComponentByType(component,false);
			}
		}
	}

	/**
	 * @param component .xml file-bol kinyert component element
	 * @return az elementbol letrehozott digitalis komponens
	 */
	private void createComponentByType(Element component, boolean compositeMode) 
	{
		// tipus lekerdezese
		//String type = getStringValue(component,"type");
		String type = getErtek(getGyerek(component,"type"));
		
		//System.out.println("lodaing component: " + type + ", id: " + getErtek(getGyerek(component,"id")));
		
		// tipusnak megfelelo komponens peldanyositas
		if(type.equals("andgate"))
		{
			createANDGate(component,compositeMode);
		}
		else if(type.equals("orgate"))
		{
			createORGate(component,compositeMode);
		}
		else if(type.equals("inverter"))
		{
			createInverter(component,compositeMode);
		}
		else if(type.equals("node"))
		{
			createNode(component,compositeMode);
		}
		else if(type.equals("switch"))
		{
			createSwitch(component,compositeMode);
		}
		else if(type.equals("signalgenerator"))
		{
			createSignalGenerator(component,compositeMode);
		}
		else if(type.equals("display"))
		{
			createDisplay(component,compositeMode);
		}
		else if(type.equals("scope"))
		{
			createScope(component,compositeMode);
		}
		else if(type.equals("wire"))
		{
			createWire(component,compositeMode);
		}
		else if(type.equals("composite"))
		{
			createComposite(component,compositeMode);
		}
		else
		{
			System.out.println("XML error: Invalid type");
		}
	}

	private void createCompositeDefinition(int reference) 
	{
		NodeList elemek = rootElement.getChildNodes();
		// az osszes elemen vegigmegyunk es valogatunk
		for (int i = 0; i < elemek.getLength(); i++) 
		{
			// composite tag-ek megkeresese
			Node child = elemek.item(i);
			if (child.getNodeName().equals("composite"))
			{
				// composite elem cid tagjenek megkeresese
				int cid = Integer.parseInt(getErtek(getGyerek(child,"cid")));
				// ha a cid megegyezik a letrehozando composit elem referenciajaval...
				if(cid == reference)
				{
					// composite gyereknodejainak lekerdezese
					NodeList kompozit = child.getChildNodes();
					// vegigmegyunk a tagek listajan
					for (int j = 0; j < kompozit.getLength(); j++) 
					{
						Node kompozit_gyereke = kompozit.item(j);
						// parts tag megkeresese
						if(kompozit_gyereke.getNodeName().equals("parts"))
						{
							// composite alkotoinak lekerdezese
							NodeList kompozit_alkotoi = kompozit_gyereke.getChildNodes();
							for (int k = 0; k < kompozit_alkotoi.getLength(); k++)
							{
								Node kompozit_alkotoi_darab = kompozit_alkotoi.item(k);
								//kivalasztjuk az <component> tag-eket, mivel a megjegyzesek is kulon tag-nek szamitanak */
								if(kompozit_alkotoi_darab.getNodeName().equals("component"))
								{
									//System.out.println("komponens (" + getErtek(getGyerek(kompozit_alkotoi_darab,"type")) + ", id: " + getErtek(getGyerek(kompozit_alkotoi_darab,"id")) + ")");
									// component-ek lekerdezese a nodelistabol
									Element component = (Element)kompozit_alkotoi_darab;
									// digitalis komponens letrehozas a kiovasott component-bol kompozit mode-ban
									createComponentByType(component,true);
								}							
							}
						}
					}
				}
			}
		}
	}
	
	/**
	 * Kompozit elem letrehozasa az .xml-bol kinyert elementbol
	 */
	private void createComposite(Element component, boolean compositeMode) 
	{
		// azonosito lekerdezese
		int id = Integer.parseInt(getErtek(getGyerek(component,"id")));
		// komponens leiro azonositojanak lekerdezese
		int reference = Integer.parseInt(getErtek(getGyerek(component,"reference")));
		// composite elem bemeno labanak lekerdezese
		int inPins = Integer.parseInt(getErtek(getGyerek(component,"inpins")));
		// composite elem kimeno labanak lekerdezese
		int outPins = Integer.parseInt(getErtek(getGyerek(component,"outpins")));
			
		
		if(compositeMode)
		{
			// beagyazas melysegenek novelese
			beagyazasMelysege++;
			
			Composite composite = new Composite(inPins,outPins,id);
			internalComposites.add(beagyazasMelysege,composite);
			createCompositeDefinition(reference);
			
			// beagyazott composite elemhez hozzadas
			Composite feltoltott = internalComposites.get(beagyazasMelysege);
			Composite szulo = internalComposites.get(beagyazasMelysege-1);
			szulo.addInternalDigitalComponent(feltoltott);

			// beagyazas melysegenek csokkentese
			beagyazasMelysege--;
			
		}
		else
		{
			Composite composite = new Composite(inPins,outPins,id);
			internalComposites.add(beagyazasMelysege,composite);
			createCompositeDefinition(reference);
			digitalCircuit.addDigitalComponent(internalComposites.get(beagyazasMelysege));
		}
	}

	/**
	 * Vezetek letrehozasa az .xml-bol kinyert elementbol
	 */
	private void createWire(Element component, boolean compositeMode)
	{
		// azonosito lekerdezese
		//int id = getIntValue(component,"id");
		int id = Integer.parseInt(getErtek(getGyerek(component,"id")));
		// wire letrehozasa
		Wire wire = new Wire(id);
		
		Node kapcsolatok = getGyerek(component,"connections");
		//System.out.println("Kivalasztva: " + kapcsolatok.getNodeName());
		Node kapcsolatok_in = getGyerek(kapcsolatok,"in");
		Node kapcsolatok_out = getGyerek(kapcsolatok,"out");
		//System.out.println("Kivalasztva: " + kapcsolatok_in.getNodeName());
		Node kapcsolatok_in_id = getGyerek(kapcsolatok_in,"id");
		Node kapcsolatok_in_pin = getGyerek(kapcsolatok_in,"pin");
		
		Node kapcsolatok_out_id = getGyerek(kapcsolatok_out,"id");
		Node kapcsolatok_out_pin = getGyerek(kapcsolatok_out,"pin");
		//System.out.println("Kivalasztva: " + kapcsolatok_in_id.getNodeName());

		//System.out.println("Kapcsolatok in id: " + kapcsolatok_in_id.getFirstChild().getNodeValue());
		
		int inConnectionId = Integer.parseInt(kapcsolatok_in_id.getFirstChild().getNodeValue());
		int inConnectionPin = Integer.parseInt(kapcsolatok_in_pin.getFirstChild().getNodeValue());
		int outConnectionId = Integer.parseInt(kapcsolatok_out_id.getFirstChild().getNodeValue());
		int outConnectionPin = Integer.parseInt(kapcsolatok_out_pin.getFirstChild().getNodeValue());
		
//		// kapcsolodo komponensek lekerdezese a digitalis aramkorbol
//		// bejovo kapcsolat lekerdezese
//		DigitalComponent inConnection = null;
//		// eloszor a komponensek kozott keresunk
//		inConnection = digitalCircuit.getDigitalComponent(inConnectionId);
//		// ha kapcsolo vagy jegenerator akkor a jelforrasok listajaban keresunk
//		if(inConnection == null)
//		{
//			inConnection = digitalCircuit.getSignalSource(inConnectionId);
//		}
//		
//		// kimeno kapcsolat lekerdezese
//		DigitalComponent outConnection = null;
//		// eloszor a komponensek kozott keresunk
//		outConnection = digitalCircuit.getDigitalComponent(outConnectionId);
//		// ha kapcsolo vagy jegenerator akkor a jelforrasok listajaban keresunk
//		if(outConnection == null)
//		{
//			outConnection = digitalCircuit.getSignalSource(outConnectionId);
//		}
//		
//		// osszekapcsolas vezetekkel
//		wire.setInConnection(inConnection, inConnectionPin);
//		wire.setOutConnection(outConnection, outConnectionPin);

		// hozzadasa a digitalis aramkorhoz.
		// digitalCircuit.addWire(wire);
		if(compositeMode)
		{
			// kapcsolodo komponensek lekerdezese a composite elem digitalis aramkorebol
			// bejovo kapcsolat lekerdezese
			DigitalComponent inConnection = null;
			// eloszor a komponensek kozott keresunk
			inConnection = internalComposites.get(beagyazasMelysege).getInternalCircuit().getDigitalComponent(inConnectionId);
			// ha kapcsolo vagy jegenerator akkor a jelforrasok listajaban keresunk
			if(inConnection == null)
			{
				inConnection = internalComposites.get(beagyazasMelysege).getInternalCircuit().getSignalSource(inConnectionId);
			}
			
			// kimeno kapcsolat lekerdezese
			DigitalComponent outConnection = null;
			// eloszor a komponensek kozott keresunk
			outConnection = internalComposites.get(beagyazasMelysege).getInternalCircuit().getDigitalComponent(outConnectionId);
			// ha kapcsolo vagy jegenerator akkor a jelforrasok listajaban keresunk
			if(outConnection == null)
			{
				outConnection = internalComposites.get(beagyazasMelysege).getInternalCircuit().getSignalSource(outConnectionId);
			}
			
			// osszekapcsolas vezetekkel
			wire.setInConnection(inConnection, inConnectionPin);
			wire.setOutConnection(outConnection, outConnectionPin);
			
			internalComposites.get(beagyazasMelysege).addInternalWire(wire);
		}
		else
		{
			// kapcsolodo komponensek lekerdezese a digitalis aramkorbol
			// bejovo kapcsolat lekerdezese
			DigitalComponent inConnection = null;
			// eloszor a komponensek kozott keresunk
			inConnection = digitalCircuit.getDigitalComponent(inConnectionId);
			// ha kapcsolo vagy jegenerator akkor a jelforrasok listajaban keresunk
			if(inConnection == null)
			{
				inConnection = digitalCircuit.getSignalSource(inConnectionId);
			}
			
			// kimeno kapcsolat lekerdezese
			DigitalComponent outConnection = null;
			// eloszor a komponensek kozott keresunk
			outConnection = digitalCircuit.getDigitalComponent(outConnectionId);
			// ha kapcsolo vagy jegenerator akkor a jelforrasok listajaban keresunk
			if(outConnection == null)
			{
				outConnection = digitalCircuit.getSignalSource(outConnectionId);
			}
			
			// osszekapcsolas vezetekkel
			wire.setInConnection(inConnection, inConnectionPin);
			wire.setOutConnection(outConnection, outConnectionPin);
			digitalCircuit.addWire(wire);
		}
	}

	/**
	 * Oszcilloszkop letrehozasa az .xml-bol kinyert elementbol
	 */
	private void createScope(Element component, boolean compositeMode) 
	{
		// azonosito lekerdezese
		//int id = getIntValue(component,"id");
		int id = Integer.parseInt(getErtek(getGyerek(component,"id")));
		// oszcilloszkop letrehozasa
		Scope scope = new Scope(id);
		// hozzadasa a digitalis aramkorhoz.
		//digitalCircuit.addDigitalComponent(scope);
		
		if(compositeMode)
		{
			internalComposites.get(beagyazasMelysege).addInternalDigitalComponent(scope);
		}
		else
		{
			digitalCircuit.addDigitalComponent(scope);
		}
	}

	/**
	 * Kijelzo letrehozasa az .xml-bol kinyert elementbol
	 */
	private void createDisplay(Element component, boolean compositeMode) 
	{
		// azonosito lekerdezese
		//int id = getIntValue(component,"id");
		int id = Integer.parseInt(getErtek(getGyerek(component,"id")));
		// Kijelzo letrehozasa
		Display display = new Display(id);
		// hozzadasa a digitalis aramkorhoz.
		// digitalCircuit.addDigitalComponent(display);
		if(compositeMode)
		{
			internalComposites.get(beagyazasMelysege).addInternalDigitalComponent(display);
		}
		else
		{
			digitalCircuit.addDigitalComponent(display);
		}
	}

	/**
	 * Jelgenerator letrehozasa az .xml-bol kinyert elementbol
	 */
	private void createSignalGenerator(Element component, boolean compositeMode) 
	{
		// azonosito lekerdezese
		//int id = getIntValue(component,"id");
		int id = Integer.parseInt(getErtek(getGyerek(component,"id")));
		
		// kezdoertek lekerdezese sztring formaban
		//String values = getStringValue(component,"value");
		String values = getErtek(getGyerek(component,"value"));
		
		// jelgenerator letrehozasa
		SignalGenerator sg = new SignalGenerator(id);
/*fafix_begin*/
/* true-t es false-t var, de az xml fajlban csak 0 vagy 1 lehet, ezt alakitja */
		values = values.replace("1"," true");
		values = values.replace("0"," false");
/*fafix_end*/		
		// kezdoertekek tokenekre bontasa
		StringTokenizer tokens = new StringTokenizer(values);
		// kezdoertekek kinyeresea tokenekbol
		for(int i = 0; tokens.hasMoreTokens(); i++)
		{
			// token lekerdezese
			String value = tokens.nextToken();
			// bool-a alakitas
			boolean signal = Boolean.parseBoolean(value);
			// jel hozzadasa a jelgeneratorhoz
			sg.addSignal(signal);
		}
		// hozzadasa a digitalis aramkorhoz.
		// digitalCircuit.addSignalSource(sg);
		if(compositeMode)
		{
			internalComposites.get(beagyazasMelysege).addInternalSignalSource(sg);
		}
		else
		{
			digitalCircuit.addSignalSource(sg);
		}
	}

	/**
	 * Kapcsolo letrehozasa az .xml-bol kinyert elementbol
	 */
	private void createSwitch(Element component, boolean compositeMode) 
	{		
		// azonosito lekerdezese
		//int id = getIntValue(component,"id");
		// kezdoertek lekerdezese
		//boolean state = getBoolValue(component,"value");
		
		// azonosito lekerdezese
		int id = Integer.parseInt(getErtek(getGyerek(component,"id")));
		
		// kezdoertek lekerdezese
		int beolvasott = Integer.parseInt(getErtek(getGyerek(component,"value")));
		boolean state;
		if(beolvasott == 0)
			state = false;
		else
			state = true;
			
		// Kapcoslo letrehozasa
		Switch sw = new Switch(id);
		// kezdoertek beallitasa
		sw.setState(state);	
		// hozzadasa a digitalis aramkorhoz.
		//digitalCircuit.addSignalSource(sw);
		if(compositeMode)
		{
			internalComposites.get(beagyazasMelysege).addInternalSignalSource(sw);
		}
		else
		{
			digitalCircuit.addSignalSource(sw);
		}
	}

	/**
	 * Csomopont letrehozasa az .xml-bol kinyert elementbol
	 */
	private void createNode(Element component, boolean compositeMode) 
	{
		// azonosito lekerdezese
		//int id = getIntValue(component,"id");
		int id = Integer.parseInt(getErtek(getGyerek(component,"id")));
		// labak szamanak lekerdezese
		//int pins = getIntValue(component,"pincount");
		int pins = Integer.parseInt(getErtek(getGyerek(component,"pincount")));
		// csomopont letrehozasa (teljes nevet kell hasznalni, mert meg kell kulonboztetni az xml-es Node-tol)
		fakocka.model.Node node = new fakocka.model.Node(pins,id);
		// hozzadasa a digitalis aramkorhoz.
		//digitalCircuit.addDigitalComponent(node);
		if(compositeMode)
		{
			internalComposites.get(beagyazasMelysege).addInternalDigitalComponent(node);
		}
		else
		{
			digitalCircuit.addDigitalComponent(node);
		}
	}

	/**
	 * Inverter letrehozasa az .xml-bol kinyert elementbol
	 */
	private void createInverter(Element component, boolean compositeMode) 
	{
		// azonosito lekerdezese
		//int id = getIntValue(component,"id");
		int id = Integer.parseInt(getErtek(getGyerek(component,"id")));
		// Inverter letrehozasa
		Inverter inverter = new Inverter(id);
		// hozzadasa a digitalis aramkorhoz.
		// digitalCircuit.addDigitalComponent(inverter);
		if(compositeMode)
		{
			internalComposites.get(beagyazasMelysege).addInternalDigitalComponent(inverter);
		}
		else
		{
			digitalCircuit.addDigitalComponent(inverter);
		}
	}

	/**
	 * VAGY kapu letrehozasa az .xml-bol kinyert elementbol
	 */
	private void createORGate(Element component, boolean compositeMode) 
	{
		// azonosito lekerdezese
		//int id = getIntValue(component,"id");
		int id = Integer.parseInt(getErtek(getGyerek(component,"id")));
		// labak szamanak lekerdezese
		//int pins = getIntValue(component,"pincount");
		int pins = Integer.parseInt(getErtek(getGyerek(component,"pincount")));
		// VAGY kapu letrehozasa
		ORGate orGate = new ORGate(pins,id);
		// hozzadasa a digitalis aramkorhoz.
		// digitalCircuit.addDigitalComponent(orGate);
		if(compositeMode)
		{
			internalComposites.get(beagyazasMelysege).addInternalDigitalComponent(orGate);
		}
		else
		{
			digitalCircuit.addDigitalComponent(orGate);
		}
	}

	/**
	 * ES kapu letrehozasa az .xml-bol kinyert elementbol
	 */
	private void createANDGate(Element component, boolean compositeMode) 
	{
		// azonosito lekerdezese
		//int id = getIntValue(component,"id");
		int id = Integer.parseInt(getErtek(getGyerek(component,"id")));
		// labak szamanak lekerdezese
		//int pins = getIntValue(component,"pincount");
		int pins = Integer.parseInt(getErtek(getGyerek(component,"pincount")));
		// ES kapu letrehozasa
		ANDGate andGate = new ANDGate(pins,id);
		// hozzadasa a digitalis aramkorhoz.
		// digitalCircuit.addDigitalComponent(andGate);
		if(compositeMode)
		{
			internalComposites.get(beagyazasMelysege).addInternalDigitalComponent(andGate);
		}
		else
		{
			digitalCircuit.addDigitalComponent(andGate);
		}
	}
/*debug*/
	private Node getGyerek(Node gyerek, String melyik)
	{

		        NodeList gyerekei = gyerek.getChildNodes();

		        Node connchild = null;

		        for (int i = 0; i < gyerekei.getLength(); i++) {
		        	connchild = gyerekei.item(i);
		            if(connchild.getNodeName().equals(melyik)){
		            	return connchild;
		            }
		        }
		        return connchild;
		    }

	private String getErtek(Node elem){
		return elem.getFirstChild().getNodeValue();
	}

}
