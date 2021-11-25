package hu.domparse.hc1y8y;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.io.File;

public class DomQueryHC1Y8Y {
	
	public static void main(String argv[]) {
		try {
			File inputFile = new File("XMLHC1Y8Y.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
			System.out.println("Root element: ");
			System.out.println(doc.getDocumentElement().getNodeName());
			NodeList nlist = doc.getElementsByTagName("hiba");
			System.out.println("-------------------------------------------");
			
			for(int temp =0; temp < nlist.getLength(); temp++) {
				Node nNode = nlist.item(temp);
				System.out.println("\n Current Element: ");
				System.out.println(nNode.getNodeName());
				
				if(nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element hElement = (Element) nNode;
					System.out.print("id : ");
					System.out.println(hElement.getAttribute("hid"));
					NodeList hiba�zenetlist = hElement.getElementsByTagName("hiba�zenet");
					
					for (int count = 0; count < hiba�zenetlist.getLength(); count++) {
						Node node = hiba�zenetlist.item(count);
						
						if (node.getNodeType() == Node.ELEMENT_NODE) {
							Element hiba�zenet = (Element) node;
							System.out.print("hiba�zenet: :");
							System.out.println(hiba�zenet.getTextContent());
						}
					}
				}
				if(nNode.getNodeType() == Node.ELEMENT_NODE) {
					Element hElement = (Element) nNode;
					System.out.print("id : ");
					System.out.println(hElement.getAttribute("hid"));
					NodeList beoszt�slist = hElement.getElementsByTagName("beoszt�s");
					
					for (int count = 0; count < beoszt�slist.getLength(); count++) {
						Node node = beoszt�slist.item(count);
						
						if (node.getNodeType() == Node.ELEMENT_NODE) {
							Element beoszt�s = (Element) node;
							System.out.print("beoszt�s: :");
							System.out.println(beoszt�s.getTextContent());
						}
					}
				}
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
