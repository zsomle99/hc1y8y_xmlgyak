package hu.domparse.hc1y8y;

import org.w3c.dom.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;

public class DomModifyHC1Y8Y {
    
    public static void main(String[] args) {
    try {
    	File inputFile = new File("XMLHC1Y8Y.xml");
    	 DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
         DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
         Document doc = docBuilder.parse(inputFile);
         Node hiba = doc.getElementsByTagName("hiba").item(0);
         
         //02-re módosítjuk a hid-t 01ről
         NamedNodeMap attr = hiba.getAttributes();
         Node nodeAttr = attr.getNamedItem("hid");
         nodeAttr.setTextContent("02");
         
         NodeList list = hiba.getChildNodes();
         
         //a hibaüzenetet megváltoztatjuk
         for (int temp = 0; temp < list.getLength(); temp++) {
        	 Node node = list.item(temp);
        	 if (node.getNodeType() == Node.ELEMENT_NODE) {
        		 Element hElement = (Element) node ;
        		 if ("hibaüzenet".equals(hElement.getNodeName())) {
        			 if("TV hibaüzenet".equals(hElement.getTextContent())) 
        				hElement.setTextContent("asd"); 
        			 }		 
        	 }
   
        	 }
         //nodelist létrehozása az ügyfél alapján
         NodeList list2 = doc.getElementsByTagName("ügyfél");
         for (int j = 0; j < list2.getLength(); j++) {
        	 Node ügyfél = list2.item(j);
        	 if(ügyfél.getNodeType() == Node.ELEMENT_NODE) {
        		 //üid alapján megkeressük a megfelelő ügyfélt
        		 String id = ügyfél.getAttributes().getNamedItem("üid").getTextContent();
        		 if ("01".equals(id.trim())) {
        			 NodeList gyerekNodes = ügyfél.getChildNodes();
        			 for (int k = 0; k < gyerekNodes.getLength(); k++) {
        				 Node item = gyerekNodes.item(k);
        				 if (item.getNodeType() == Node.ELEMENT_NODE) {
        					 //kitöröljük az ügyfélből a kód mezőt
        					 if("kód".equalsIgnoreCase(item.getNodeName())) {
        						 ügyfél.removeChild(item);
        					 }
        					 // módosítjuk az 1-es ügyfélidvel rendelkező nevét
        					 if ("név".equalsIgnoreCase(item.getNodeName())) {
        						 item.setTextContent("XYK");
        					 }
        				 }
        			 }
        		 }
        	 }
         }
         
         //kiíratás
        	 TransformerFactory transformerFactory = TransformerFactory.newInstance();
             Transformer transformer = transformerFactory.newTransformer();
             DOMSource source = new DOMSource(doc);
             System.out.println("-----------Módosított File-----------");
             StreamResult consoleResult = new StreamResult(System.out);
             transformer.transform(source, consoleResult);
          } catch (Exception e) {
             e.printStackTrace();
         }
        
        
    }
}
