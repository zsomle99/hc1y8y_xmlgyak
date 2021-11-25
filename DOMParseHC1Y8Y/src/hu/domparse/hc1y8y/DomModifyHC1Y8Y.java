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
         Node hibakezeles = doc.getFirstChild();
         Node hiba = doc.getElementsByTagName("hiba").item(0);
         
         NamedNodeMap attr = hiba.getAttributes();
         Node nodeAttr = attr.getNamedItem("hid");
         nodeAttr.setTextContent("02");
         
         NodeList list = hiba.getChildNodes();
         
         for (int temp = 0; temp < list.getLength(); temp++) {
        	 Node node = list.item(temp);
        	 if (node.getNodeType() == Node.ELEMENT_NODE) {
        		 Element hElement = (Element) node ;
        		 if ("h�nyszor".equals(hElement.getNodeName())) {
        			 if("3".equals(hElement.getTextContent())) 
        				hElement.setTextContent("2"); 
        			 }
        		 if("mi�ta".equals(hElement.getNodeName())) {
        			 if("10:00".equals(hElement.getTextContent()))
        				 hElement.setTextContent("11:00");
        		 }
        	 }
        	 NodeList childNodes = hibakezeles.getChildNodes();
        	 for(int count = 0; count < childNodes.getLength(); count++) {
        		 Node node2 = childNodes.item(count);
        		 
        		 if("Mi�ta".equals(node.getNodeName()))
        			 hiba.removeChild(node2);
        	 }
         }
        	 TransformerFactory transformerFactory = TransformerFactory.newInstance();
             Transformer transformer = transformerFactory.newTransformer();
             DOMSource source = new DOMSource(doc);
             System.out.println("-----------M�dos�tott File-----------");
             StreamResult consoleResult = new StreamResult(System.out);
             transformer.transform(source, consoleResult);
          } catch (Exception e) {
             e.printStackTrace();
         }
        
        
    }
}
