/**
 *
 */
package fakocka;

/**
 * Szkeleton osztaly, ami a modell teszteleset vegzi. A tesztek lehetove teszik,
 * hogy a modell mukodesehez elengedhetetlen helyes metodushivasi sorrendet 
 * leellenorizzuk es osszehasonlitsuk a szekvencia diagramokon vazoltakkal.
 * A felhasznalo egy menurendszer segitsegevel valaszthat a futtatando
 * tesztesetek kozul. Minden tesztesethez kulon tarol egy digitalis aramkort,
 * amit majd a kivalasztott tesztesetnek megfeleloen fog inicializalni.
 * 
 * @author fakocka
 * 
 * @version Szkeleton
 */
public class Skeleton 
{
	/**
	 * Az elso tesztesethez tartozo digitalis aramkor
	 */
	private static DigitalCircuit digitalCircuit1;
	
	/**
	 * A masodik tesztesethez tartozo digitalis aramkor
	 */
	private static DigitalCircuit digitalCircuit2;
	
	/**
	 * A harmadik tesztesethez tartozo digitalis aramkor
	 */
	private static DigitalCircuit digitalCircuit3;
	
	/**
	 * A negyedik tesztesethez tartozo digitalis aramkor
	 */
	private static DigitalCircuit digitalCircuit4;
	
	/**
	 * Az otodik tesztesethez tartozo digitalis aramkor
	 */
	private static DigitalCircuit digitalCircuit5;
	
	/**
	 * A hatodik tesztesethez tartozo digitalis aramkor
	 */
	private static DigitalCircuit digitalCircuit6;
	
	/**
	 * A szkeleton program belepesi pontja. A felhasznalonak egy menurendszert 
	 * kinal fel, majd a valasztasnak megfeleloen lefuttatja azt.
	 * 
	 * @param args parancssori param�terek
	 */
	public static void main(String[] args) 
	{
		// amig fut a szkeleton addig true
		boolean run;
		
		do
		{
			// fut
			run = true;
			// menu mutatasa
			showMenu();
			
			// futtatando teszteset sorszamanak bekerese a felhasznalotol
			String choice = UserInput.readConsoleLine();
			int testCaseNumber = Integer.parseInt(choice);
			
			// megefelelo teszteset futtatasa
			switch(testCaseNumber)
			{
				case 0:
					// 0 eseten kilepunk a szkeletonbol
					run = false;
					System.out.println("Exit Skeleton...");
				break;
				
				case 1:
					// Az elso teszteset inicializalasa
					initTestCase1();
				break;
				
		        case 2:
		        	// Az elso teszteset futtatasa
		        	runTestCase1();
		        break;
		        
		        case 3:
		        	// A masodik teszteset inicializalasa
		        	initTestCase2();
		        break;
		        
		        case 4:
		        	// A masodik teszteset futtatasa
		        	runTestCase2();
		        break;
		        
		        case 5:
		        	// A harmadik teszteset inicializalasa
		        	initTestCase3();
		        break;
		        
		        case 6:
		        	// A harmadik teszteset futtatasa
		        	runTestCase3();
		        break;
		        
		        case 7:
		        	// A negyedik teszteset inicializalasa
		        	initTestCase4();
		        break;
		        
		        case 8:
		        	// A negyedik teszteset futtatasa
		        	runTestCase4();
		        break;
		        
		        case 9:
		        	// Az otodik teszteset inicializalasa
		        	initTestCase5();
		        break;
		        
		        case 10:
		        	// Az otodik teszteset futtatasa
		        	runTestCase5();
		        break;
		        
		        case 11:
		        	// Az hatodik teszteset inicializalasa
		        	initTestCase6();
		        break;
		        
		        case 12:
		        	// Az hatodik teszteset futtatasa
		        	runTestCase6();
		        break;
		        
		        default:
		        	// Nincs ilyen teszteset
		        	System.out.println("Invalid TestCase! Choose another one!");
		        break;
			}
		}
		while(run);
	}
	
	/**
	 * A menurendszer jeleniti meg a felhasznalo szamara, amibol a
	 * megfelelo szam beirasaval valaszthat.
	 */
	public static void showMenu()
	{
		System.out.println("");
		System.out.println("#00 - Exit Skeleton");
		System.out.println("#01 - initTestCase1");
		System.out.println("#02 - runTestCase1");
		System.out.println("#03 - initTestCase2");
		System.out.println("#04 - runTestCase2");
		System.out.println("#05 - initTestCase3");
		System.out.println("#06 - runTestCase3");
		System.out.println("#07 - initTestCase4");
		System.out.println("#08 - runTestCase4");
		System.out.println("#09 - initTestCase5");
		System.out.println("#10 - runTestCase5");
		System.out.println("#11 - initTestCase6");
		System.out.println("#12 - runTestCase6");
		System.out.println("");
	}
	
	/**
	 * Az elso teszteset inicializalasa:
	 * 1 kapcsolo, 1 vezetek, 1 kijelzo
	 */
	public static void initTestCase1()
	{
		System.out.println("");
		System.out.println("initTestCase1 started!");
		System.out.println("");
		
		// Digitalis aramkor letrehozasa
		System.out.println("\n// Digitalis aramkor letrehozasa");
		digitalCircuit1 = new DigitalCircuit();
		
		// Komponensek letrehozasa
		System.out.println("\n// Komponensek letrehozasa");
		Switch s1 = new Switch(1);	
		Wire w1 = new Wire(1);
		Display d1 = new Display(1);
		
		// Komponensek osszekapcsolasa vezetekkel
		System.out.println("\n// Komponensek osszekapcsolasa vezetekkel");
		w1.setInConnection(s1,0);
		w1.setOutConnection(d1,0);
		
		// Switch beallitasa
		System.out.println("\n// Switch beallitasa");
		s1.setState(true);

		// Komponensek hozzaadasa az aramkorhoz
		System.out.println("\n// Komponensek hozzaadasa az aramkorhoz");
		digitalCircuit1.addSignalSource(s1);
		digitalCircuit1.addDigitalComponent(d1);
		digitalCircuit1.addWire(w1);
		
		System.out.println("");
		System.out.println("initTestCase1 finished!");
		System.out.println("");
	}
	
	/**
	 * Masodik teszteset inicializalasa:
	 * 1 jelgenerator, 1 vezetek, 1 kijelzo
	 * Letrehozza a digitalis aramkort, majd az elemeket.
	 * Ezutan osszekapcsolja, majd hozzaadaja oket az aramkohoz.
	 */
	public static void initTestCase2()
	{
		System.out.println("");
		System.out.println("initTestCase2 started!");
		System.out.println("");
		
		// Digitalis aramkor letrehozasa
		System.out.println("\n// Digitalis aramkor letrehozasa");
		digitalCircuit2 = new DigitalCircuit();
		
		// Komponensek letrehozasa
		System.out.println("\n// Komponensek letrehozasa");
		SignalGenerator sg1 = new SignalGenerator(1);
		Wire w1 = new Wire(1);
		Display d1 = new Display(1);
		
		// Komponensek osszekapcsolasa vezetekkel
		System.out.println("\n// Komponensek osszekapcsolasa vezetekkel");
		w1.setInConnection(sg1,0);
		w1.setOutConnection(d1,0);
		
		// SignalGenerator beallitasa
		System.out.println("\n// SignalGenerator beallitasa");
		sg1.addSignal(false);

		// Komponensek hozzaadasa az aramkorhoz
		System.out.println("\n// Komponensek hozzaadasa az aramkorhoz");
		digitalCircuit2.addSignalSource(sg1);
		digitalCircuit2.addWire(w1);
		digitalCircuit2.addDigitalComponent(d1);
			
		System.out.println("");
		System.out.println("initTestCase2 finished!");
		System.out.println("");
	}
	
	/**
	 * A harmadik teszteset inicializalasa:
	 * 1 inverter, 1 kapcsolo, 1 kijelzo, 2 vezetek
	 */
	public static void initTestCase3()
	{
		System.out.println("");
		System.out.println("initTestCase3 started!");
		System.out.println("");
		
		// Digitalis aramkor letrehozasa
		System.out.println("\n// Digitalis aramkor letrehozasa");
		digitalCircuit3 = new DigitalCircuit();
		
		// Komponensek letrehozasa
		System.out.println("\n// Komponensek letrehozasa");
		Switch s1 = new Switch(1);				
		Inverter inverter = new Inverter(2);
		Wire w1 = new Wire(1);
			Wire w2 = new Wire(2);
		Display display = new Display(1);
		
		
		// Komponensek osszekapcsolasa vezetekkel
		System.out.println("\n// Komponensek osszekapcsolasa vezetekkel");
		w1.setInConnection(s1,0);
		w1.setOutConnection(inverter,0);
		
		w2.setInConnection(inverter,1);
		w2.setOutConnection(display,0);
		
		// Switchek beallitasa
		System.out.println("\n// Switchek beallitasa");
		s1.setState(true);

		// Komponensek hozzaadasa az aramkorhoz
		System.out.println("\n// Komponensek hozzaadasa az aramkorhoz");
		digitalCircuit3.addSignalSource(s1);
		digitalCircuit3.addWire(w1);
		digitalCircuit3.addWire(w2);
		digitalCircuit3.addDigitalComponent(inverter);
		digitalCircuit3.addDigitalComponent(display);
		
		System.out.println("");
		System.out.println("initTestCase3 finished!");
		System.out.println("");
	}
	
	/**
	 * A negyedik teszteset inicializalasa:
	 * 1 ESkapu, 2 kapcsolo, 1 kijelzo, 3 vezetek
	 */
	public static void initTestCase4()
	{
		System.out.println("");
		System.out.println("initTestCase4 started!");
		System.out.println("");
		
		// Digitalis aramkor letrehozasa
		System.out.println("\n// Digitalis aramkor letrehozasa");
		digitalCircuit4 = new DigitalCircuit();
		
		// Komponensek letrehozasa
		System.out.println("\n// Komponensek letrehozasa");
		Switch s1 = new Switch(1);
                Switch s2 = new Switch(2);
                ANDGate a1 = new ANDGate(2,1);
		Wire w1 = new Wire(1);
                Wire w2 = new Wire(2);
                Wire w3 = new Wire(3);
		Display d1 = new Display(1);
		
		// Komponensek osszekapcsolasa vezetekkel
		System.out.println("\n// Komponensek osszekapcsolasa vezetekkel");
		w1.setInConnection(s1,0);
		w1.setOutConnection(a1,1);
		w2.setInConnection(s2,0);
		w2.setOutConnection(a1,2);
                w3.setInConnection(a1,0);
		w3.setOutConnection(d1,0);

		// Switchek beallitasa
		System.out.println("\n// Switchek beallitasa");
		s1.setState(true);
                s2.setState(true);

		// Komponensek hozzaadasa az aramkorhoz
		System.out.println("\n// Komponensek hozzaadasa az aramkorhoz");
		digitalCircuit4.addSignalSource(s1);
                digitalCircuit4.addSignalSource(s2);
		digitalCircuit4.addWire(w1);
                digitalCircuit4.addWire(w2);
                digitalCircuit4.addWire(w3);
                digitalCircuit4.addDigitalComponent(a1);
		digitalCircuit4.addDigitalComponent(d1);
		
		System.out.println("");
		System.out.println("initTestCase4 finished!");
		System.out.println("");
	}
	
	/**
	 * Az otodik teszteset inicializalasa:
	 * 1 VAGYkapu, 2 kapcsolo, 1 kijelzo, 3 vezetek
	 */
	public static void initTestCase5()
	{
		System.out.println("");
		System.out.println("initTestCase5 started!");
		System.out.println("");
		
		// Digitalis aramkor letrehozasa
		System.out.println("\n// Digitalis aramkor letrehozasa");
		digitalCircuit5 = new DigitalCircuit();

		// Komponensek letrehozasa
		System.out.println("\n// Komponensek letrehozasa");
		Switch s1 = new Switch(1);
                Switch s2 = new Switch(2);
                ORGate o1 = new ORGate(2,1);
		Wire w1 = new Wire(1);
                Wire w2 = new Wire(2);
                Wire w3 = new Wire(3);
		Display d1 = new Display(1);

		// Komponensek osszekapcsolasa vezetekkel
		System.out.println("\n// Komponensek osszekapcsolasa vezetekkel");
		w1.setInConnection(s1,0);
		w1.setOutConnection(o1,1);
		w2.setInConnection(s2,0);
		w2.setOutConnection(o1,2);
                w3.setInConnection(o1,0);
		w3.setOutConnection(d1,0);

		// Switchek beallitasa
		System.out.println("\n// Switchek beallitasa");
		s1.setState(true);
                s2.setState(false);

		// Komponensek hozzaadasa az aramkorhoz
		System.out.println("\n// Komponensek hozzaadasa az aramkorhoz");
		digitalCircuit5.addSignalSource(s1);
                digitalCircuit5.addSignalSource(s2);
		digitalCircuit5.addWire(w1);
                digitalCircuit5.addWire(w2);
                digitalCircuit5.addWire(w3);
                digitalCircuit5.addDigitalComponent(o1);
		digitalCircuit5.addDigitalComponent(d1);
		
		System.out.println("");
		System.out.println("initTestCase5 finished!");
		System.out.println("");
	}
	
	/**
	 * A harmadik teszteset inicializalasa:
	 * 1 csomopont, 1 kapcsolo, 1 kijelzo, 3 vezetek
	 */
	public static void initTestCase6()
	{
		System.out.println("");
		System.out.println("initTestCase6 started!");
		System.out.println("");
		
		// Digitalis aramkor letrehozasa
		System.out.println("\n// Digitalis aramkor letrehozasa");
		digitalCircuit6 = new DigitalCircuit();

		// Komponensek letrehozasa
		System.out.println("\n// Komponensek letrehozasa");
		Switch s1 = new Switch(1);
                Node n1 = new Node(3,1);
		Wire w1 = new Wire(1);
                Wire w2 = new Wire(2);
                Wire w3 = new Wire(3);
		Display d1 = new Display(1);
                Display d2 = new Display(2);

		// Komponensek osszekapcsolasa vezetekkel
		System.out.println("\n// Komponensek osszekapcsolasa vezetekkel");
		w1.setInConnection(s1,0);
		w1.setOutConnection(n1,1);
		w2.setInConnection(n1,1);
		w2.setOutConnection(d1,0);
                w3.setInConnection(n1,2);
		w3.setOutConnection(d2,0);

		// Switchek beallitasa
		System.out.println("\n// Switch beallitasa");
		s1.setState(true);

		// Komponensek hozzaadasa az aramkorhoz
		System.out.println("\n// Komponensek hozzaadasa az aramkorhoz");
		digitalCircuit6.addSignalSource(s1);
		digitalCircuit6.addWire(w1);
                digitalCircuit6.addWire(w2);
                digitalCircuit6.addWire(w3);
                digitalCircuit6.addDigitalComponent(n1);
		digitalCircuit6.addDigitalComponent(d1);
                digitalCircuit6.addDigitalComponent(d2);
		
		System.out.println("");
		System.out.println("initTestCase6 finished!");
		System.out.println("");
	}
	
	/**
	 * Az elso teszteset szimulacioja
	 */
	public static void runTestCase1()
	{
		System.out.println("");
		System.out.println("TestCase1 started!");
		System.out.println("");
		
		// Digitalis aramkor szimulacioja
		System.out.println("\n// Digitalis aramkor szimulacioja");
		digitalCircuit1.stepSimulation();
		
		System.out.println("");
		System.out.println("TestCase1 finished!");
		System.out.println("");
	}
	
	/**
	 * A masodik teszteset szimulacioja:
	 * A mar korabban megfeleloen inicializalt halozatot szimulalja le. 
	 */
	public static void runTestCase2()
	{
		System.out.println("");
		System.out.println("TestCase2 started!");
		System.out.println("");
		
		// Digitalis aramkor szimulacioja
		System.out.println("\n// Digitalis aramkor szimulacioja");
		digitalCircuit2.stepSimulation();	
		
		System.out.println("");
		System.out.println("TestCase2 finished!");
		System.out.println("");
	}
	
	/**
	 * A harmadik teszteset szimulacioja
	 */
	public static void runTestCase3()
	{
		System.out.println("");
		System.out.println("TestCase3 started!");
		System.out.println("");
		
		// Digitalis aramkor szimulacioja
		System.out.println("\n// Digitalis aramkor szimulacioja");
		digitalCircuit3.stepSimulation();
		
		System.out.println("");
		System.out.println("TestCase3 finished!");
		System.out.println("");
	}
	
	/**
	 * A negyedik teszteset szimulacioja
	 */
	public static void runTestCase4()
	{
		System.out.println("");
		System.out.println("TestCase4 started!");
		System.out.println("");
		
		// Digitalis aramkor szimulacioja
		System.out.println("\n// Digitalis aramkor szimulacioja");
		digitalCircuit4.stepSimulation();
		
		System.out.println("");
		System.out.println("TestCase4 finished!");
		System.out.println("");
	}
	
	/**
	 * Az otodik teszteset szimulacioja
	 */
	public static void runTestCase5()
	{
		System.out.println("");
		System.out.println("TestCase5 started!");
		System.out.println("");
		
		// Digitalis aramkor szimulacioja
		System.out.println("\n// Digitalis aramkor szimulacioja");
		digitalCircuit5.stepSimulation();
		
		System.out.println("");
		System.out.println("TestCase5 finished!");
		System.out.println("");
	}
	
	/**
	 * A hatodik teszteset szimulacioja
	 */
	public static void runTestCase6()
	{
		System.out.println("");
		System.out.println("TestCase6 started!");
		System.out.println("");
		
		// Digitalis aramkor szimulacioja
		System.out.println("\n// Digitalis aramkor szimulacioja");
		digitalCircuit6.stepSimulation();
		
		System.out.println("");
		System.out.println("TestCase6 finished!");
		System.out.println("");
	}
}
