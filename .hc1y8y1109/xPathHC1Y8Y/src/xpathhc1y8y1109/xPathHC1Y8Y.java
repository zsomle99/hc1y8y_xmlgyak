package xpathhc1y8y1109;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;

public class xPathHC1Y8Y {

	public static void main(String[] args) throws Exception {

		// File xmlFile = new File("class.xml");

		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		factory.setNamespaceAware(true);
		DocumentBuilder builder = factory.newDocumentBuilder();
		Document doc = builder.parse("studentHC1Y8Y.xml");
		doc.getDocumentElement().normalize();

		XPathFactory xpathfactory = XPathFactory.newInstance();
		XPath xpath = xpathfactory.newXPath();
		System.out.println("Print out the firstnames of the students");

		XPathExpression expr = xpath.compile("//student[@id>0]/firstname/text()");
		Object result = expr.evaluate(doc, XPathConstants.NODESET);
		NodeList nodes = (NodeList) result;
		for (int i = 0; i < nodes.getLength(); i++) {
			System.out.println(nodes.item(i).getNodeValue());
		}
		System.out.println("End of firstname");
		System.out.println();
		
		System.out.println("Print out the lastnames of the students");
		XPathExpression expr2 = xpath.compile("//student[@id>0]/lastname/text()");
		Object result2 = expr2.evaluate(doc, XPathConstants.NODESET);
		NodeList nodes2 = (NodeList) result2;
		for (int j = 0; j < nodes2.getLength(); j++) {
			System.out.println(nodes2.item(j).getNodeValue());
		}
		System.out.println("End of lastname");
		System.out.println();
		
		System.out.println("Print out the nicknames of the students");
		XPathExpression expr3 = xpath.compile("//student[@id>0]/nickname/text()");
		Object result3 = expr3.evaluate(doc, XPathConstants.NODESET);
		NodeList nodes3 = (NodeList) result3;
		for (int k = 0; k < nodes3.getLength(); k++) {
			System.out.println(nodes3.item(k).getNodeValue());
		}
		System.out.println("End of nickname");
		System.out.println();
		
		System.out.println("Print out the ages of the students");
		XPathExpression expr4 = xpath.compile("//student[@id>0]/age/text()");
		Object result4 = expr4.evaluate(doc, XPathConstants.NODESET);
		NodeList nodes4 = (NodeList) result4;
		for (int l = 0; l < nodes4.getLength(); l++) {
			System.out.println(nodes4.item(l).getNodeValue());
		}
		System.out.println("End of age");
	}
}
