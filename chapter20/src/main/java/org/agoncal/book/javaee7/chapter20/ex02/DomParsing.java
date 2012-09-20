package org.agoncal.book.javaee7.chapter20.ex02;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class DomParsing {

    public static void main(String[] args) {
        File xmlDocument = Paths.get("src/main/resources/order.xml").toFile();

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(xmlDocument);

            System.out.println("getDOMImplementation : " + builder.getDOMImplementation().toString());
            System.out.println("getDocumentURI : " + document.getDocumentURI());
            System.out.println("getInputEncoding : " + document.getInputEncoding());
            System.out.println("getXmlVersion : " + document.getXmlVersion());

            String root = document.getDocumentElement().getTagName();
            System.out.println(">> " + root);

            Node creditCard = document.getElementsByTagName("credit_card").item(0);
            System.out.println(">>>>> " + creditCard.getAttributes().getNamedItem("number").getNodeName());

        } catch (SAXException | IOException | ParserConfigurationException e) {
            e.printStackTrace();
        }
    }
}
