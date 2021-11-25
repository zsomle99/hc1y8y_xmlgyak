package hu.domparse.hc1y8y;

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
	
	public static void main(String[] args) throws IOException, ParserConfigurationException, SAXException{
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
	      try {   
	          
	          DocumentBuilder db = dbf.newDocumentBuilder();
	          Document doc = db.parse(new File("XMLHC1Y8Y.xml")); 
	          doc.getDocumentElement().normalize();
	          
	          System.out.println("Root Element :" + doc.getDocumentElement().getNodeName());
	          System.out.println();
	          
	          NodeList list = doc.getElementsByTagName("hiba");
	    
	          
	          for (int temp = 0; temp < list.getLength(); temp++) {
	              Node node = list.item(temp);
	              if (node.getNodeType() == Node.ELEMENT_NODE) {
	                  Element element = (Element) node;  
	                  //id el�r�se
	                  String hid = element.getAttribute("hid"); 
	                  
	                  //Stringek el�r�se
	                  String hiba�zenet = element.getElementsByTagName("hiba�zenet").item(0).getTextContent();
	                  String mi�ta = element.getElementsByTagName("mi�ta").item(0).getTextContent();
	                  String h�nyszor = element.getElementsByTagName("h�nyszor").item(0).getTextContent();
	                  
	                  //Kiirat�s
	                  System.out.println("Current Element :" + node.getNodeName());
	                  System.out.println("Hiba Id : " + hid);
	                  System.out.println("Hiba�zenet : " + hiba�zenet);
	                  System.out.println("A hiba fenn�ll : " + mi�ta + " �ta");
	                  System.out.println("A hiba el�fordult : " + h�nyszor);
	                  System.out.println();
	                  
	                  NodeList �gyfel = doc.getElementsByTagName("�gyf�l");
		                Node �node = �gyfel.item(temp);
						if(�node.getNodeType() == Node.ELEMENT_NODE) {
							Element �element = (Element) �node;
							
							String �id = �element.getAttribute("�id");	
							String sz�l_id� = �element.getElementsByTagName("sz�l_id�").item(0).getTextContent();
							String sz�l_hely = �element.getElementsByTagName("sz�l_hely").item(0).getTextContent();
							String k�d = �element.getElementsByTagName("k�d").item(0).getTextContent();
							String n�v = �element.getElementsByTagName("n�v").item(0).getTextContent();
								
							System.out.println("Az �gyf�l idja : " + �id);
							System.out.println("Az �gyf�l sz�l. ideje : " + sz�l_id�);
				            System.out.println("Az �gyf�l sz�l. helye : " + sz�l_hely);
				            System.out.println("Az �gyf�l k�dja : " + k�d);
				            System.out.println("Az �gyf�l neve : " + n�v);
				            System.out.println();
				            
				            
				       NodeList �gyintezo = doc.getElementsByTagName("�gyint�z�");
				       		Node �gynode = �gyintezo.item(temp);
							if(�gynode.getNodeType() == Node.ELEMENT_NODE) {
								Element �gyelement = (Element) �gynode;
								
								String �gyid = �gyelement.getAttribute("�gyid");	
								String szint = �gyelement.getElementsByTagName("szint").item(0).getTextContent();
								String beoszt�s = �gyelement.getElementsByTagName("beoszt�s").item(0).getTextContent();
								String �gyn�v = �gyelement.getElementsByTagName("n�v").item(0).getTextContent();
									
								System.out.println("Az �gyint�z� idja : " + �gyid);
								System.out.println("Az �gyint�z� szintje : " + szint);
					            System.out.println("Az �gyint�z� beoszt�sa : " + beoszt�s);
					            System.out.println("Az �gyint�z� neve : " + �gyn�v);
					            System.out.println();
					          
					  NodeList vezeto = doc.getElementsByTagName("vezet�");
					       	Node vnode = vezeto.item(temp);
							if(vnode.getNodeType() == Node.ELEMENT_NODE) {
								Element velement = (Element) vnode;
									
								String vid = velement.getAttribute("vid");	
								String vszint = velement.getElementsByTagName("szint").item(0).getTextContent();
								String vbeoszt�s = velement.getElementsByTagName("beoszt�s").item(0).getTextContent();
								String vn�v = velement.getElementsByTagName("n�v").item(0).getTextContent();
										
								System.out.println("A vezet� idja : " + vid);
								System.out.println("A vezet� szintje : " + vszint);
						        System.out.println("A vezet� beoszt�sa : " + vbeoszt�s);
						        System.out.println("A vezet� neve : " + vn�v);
						        System.out.println();
								}

							}
		                }
	                  
	              }
	          }

	      } catch (ParserConfigurationException | SAXException | IOException e) {
	          e.printStackTrace();
	      }

	  }

	}
