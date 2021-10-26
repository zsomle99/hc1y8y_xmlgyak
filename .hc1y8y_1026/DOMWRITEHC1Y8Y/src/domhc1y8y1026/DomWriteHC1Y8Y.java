package domhc1y8y1026;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;


public class DomWriteHC1Y8Y {
	
	public static void main(String[] args) throws ParserConfigurationException, TransformerException {

        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();

        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("users");
        rootElement.setAttribute("xlmns", "domHC1Y8Y");
        doc.appendChild(rootElement);
      
        
        Element user = doc.createElement("user");
        rootElement.appendChild(user);
        user.setAttribute("id", "1");
        
        Element firstname = doc.createElement("firstname");
        firstname.setTextContent("asd");
        user.appendChild(firstname);
        
        Element lastname = doc.createElement("lastname");
        lastname.setTextContent("asd");
        user.appendChild(lastname);
        
        Element profession = doc.createElement("profession");
        profession.setTextContent("asd");
        user.appendChild(profession);
	
	
	try {
		FileOutputStream fos = new FileOutputStream(new File("user1HC1Y8Y.xml"));
		writeXml(doc, fos);
	} catch (IOException e) {
		e.printStackTrace();
	}
	}
       
	
    private static void writeXml(Document doc, OutputStream output) throws TransformerException {

        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(output);
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");;

        transformer.transform(source, result);

    }
}


