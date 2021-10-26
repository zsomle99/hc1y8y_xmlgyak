package domHC1Y8Y1026;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;


public class DomReadHC1Y8Y {

	  public static void main(String[] args) throws SAXException, IOException, ParserConfigurationException{	
	      DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	      try {   
	          
	          DocumentBuilder db = dbf.newDocumentBuilder();
	          Document doc = db.parse(new File("usersHC1Y8Y.xml")); 
	          doc.getDocumentElement().normalize();
	          
	          System.out.println("Root Element :" + doc.getDocumentElement().getNodeName());
	          System.out.println();
	          
	          NodeList list = doc.getElementsByTagName("user");
	    
	          
	          for (int temp = 0; temp < list.getLength(); temp++) {
	              Node node = list.item(temp);
	              if (node.getNodeType() == Node.ELEMENT_NODE) {
	                  Element element = (Element) node;  
	                  //id elérése
	                  String id = element.getAttribute("id"); 
	                  
	                  //Stringek elérése
	                  String firstname = element.getElementsByTagName("firstname").item(0).getTextContent();
	                  String lastname = element.getElementsByTagName("lastname").item(0).getTextContent();
	                  String profession = element.getElementsByTagName("profession").item(0).getTextContent();
	                  
	                  //Kiiratás
	                  System.out.println("Current Element :" + node.getNodeName());
	                  System.out.println("User Id : " + id);
	                  System.out.println("First Name : " + firstname);
	                  System.out.println("Last Name : " + lastname);
	                  System.out.println("Profession : " + profession);
	                  
	              }
	          }

	      } catch (ParserConfigurationException | SAXException | IOException e) {
	          e.printStackTrace();
	      }

	  }

	}


