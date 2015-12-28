package fakocka;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class CircuitLoader {

	 public static void main(String argv[]) {
		 
		 try {
		 
		    File fXmlFile = new File("H:\\Other\\fakocka\\fakocka\\src\\fakocka\\components.xml");
		    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		    Document doc = dBuilder.parse(fXmlFile);
		    doc.getDocumentElement().normalize();
		 
		    /* gyoker elem */
		    //System.out.println("Root element:" + doc.getDocumentElement().getNodeName());
		    //System.out.println("-----------------------");
		    
		    /* "component" tipusu elemek */
		    NodeList nList = doc.getElementsByTagName("component");
		 
		    for (int temp = 0; temp < nList.getLength(); temp++) {
		 
		       Node nNode = nList.item(temp);	    
		       if (nNode.getNodeType() == Node.ELEMENT_NODE) {
		 
		          Element eElement = (Element) nNode;
		 /*
		          System.out.println("Id: "  + getTagValue("id",eElement));
		          System.out.println("Type: "  + getTagValue("type",eElement));
		          System.out.println("Connections:");
		  */        
		          String elem_id = getTagValue("id",eElement);
		          String elem_tipus = getTagValue("type",eElement);

		          if (elem_tipus.equals("andgate")){ /* ES kapu */
		        	  System.out.println("ES kapu (" + elem_id + ")");
		        	  System.out.println("pin count: " + getTagValue("pincount",eElement));
		          }
		          else if (elem_tipus.equals("orgate")){ /* VAGY kapu */
		        	  System.out.println("VAGY kapu (" + elem_id + ")");
		        	  System.out.println("pin count: " + getTagValue("pincount",eElement));
		          }
		          else if (elem_tipus.equals("inverter")){ /* Inverter */
		        	  System.out.println("Inverter (" + elem_id + ")");
		          }
		          else if (elem_tipus.equals("node")){ /* Csomopont */
		        	  System.out.println("Csomopont (" + elem_id + ")");
		        	  System.out.println("pin count: " + getTagValue("pincount",eElement));
		          }
		          else if (elem_tipus.equals("switch")){ /* Kapcsolo */
		        	  System.out.println("Kapcsolo (" + elem_id + ")");
		        	  System.out.println("value: " + getTagValue("value",eElement));
		          }
		          else if (elem_tipus.equals("display")){ /* Kijelzo */
		        	  System.out.println("Kijelzo (" + elem_id + ")");
		          }
		          else if (elem_tipus.equals("signalgenerator")){ /* Jelgenerator */
		        	  System.out.println("Jelgenerator (" + elem_id + ")");
		        	  System.out.println("value: " + getTagValue("value",eElement));
		          }
		          else if (elem_tipus.equals("scope")){ /* Oszcilloszkop */
		        	  System.out.println("Oszcilloszkop (" + elem_id + ")");
		          }
		          else if (elem_tipus.equals("wire")){ /* Vezetek */
		        	  System.out.println("Vezetek (" + elem_id + ")");
		        	//System.out.println("tag: " + getTagValue("id",eElement));
		        	//System.out.println(" " + Integer.toString(eElement.getChildNodes().getLength()) );
		        	  //System.out.println(" " eElement.getChild() );
		        	  /*
		        	  NodeList fstNmElmntLst = eElement.getElementsByTagName("connections");
		              Element fstNmElmnt = (Element) fstNmElmntLst.item(0);
		              NodeList fstNm = fstNmElmnt.getChildNodes();
		              System.out.println("First Name : "  + ((Node) fstNm.item(0)).getNodeValue());
		        	  */
		        	  
		        	  //System.out.println(" " + eElement.getChildNodes().item(6).getNodeName() );
		        	  /*
			          NodeList subnList = doc.getElementsByTagName("connection");
			          for(int tempsnl = 0; tempsnl < subnList.getLength(); tempsnl++){
			        	  Node snNode = subnList.item(tempsnl);
			        	  if(snNode.getNodeType() == Node.ELEMENT_NODE){
			        	   Element seElement = (Element) snNode;
			        	   System.out.println("Id: "  + getTagValue("id",seElement));
			        	  }
			          }
		        	  */
		        	System.out.println("-");
		          }
		          else if (elem_tipus.equals("composite")){ /* Kompozit elem */
		        	  
		          }
		          else { System.out.println("Hiba: ismeretlen elem: " + elem_tipus); } /* debug */
		         
		          /*
		          NodeList subnList = doc.getElementsByTagName("connection");
		          for(int tempsnl = 0; tempsnl < subnList.getLength(); tempsnl++){
		        	  Node snNode = subnList.item(tempsnl);
		        	  if(snNode.getNodeType() == Node.ELEMENT_NODE){
		        	   Element seElement = (Element) snNode;
		        	   System.out.println("Id: "  + getTagValue("id",seElement));
		        	  }
		          }
*/		          
		          //System.out.println("Nick Name : "  + getTagValue("nickname",eElement));
		          //System.out.println("Salary : "  + getTagValue("salary",eElement));
		          //System.out.println("");
		 
		        }
		    }
		  } catch (Exception e) {
		    e.printStackTrace();
		  }
		 }
		 
		 private static String getTagValue(String sTag, Element eElement){
		    NodeList nlList = eElement.getElementsByTagName(sTag).item(0).getChildNodes();
		    Node nValue = (Node) nlList.item(0); 
		 
		    return nValue.getNodeValue();    
		 }
	
	
}
