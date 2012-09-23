package org.agoncal.book.javaee7.chapter20.ex02;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.file.Paths;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class DomParsingWithValidation {

    public static void main(String[] args) {
        File xmlDocument = Paths.get("src/main/resources/invalidOrder.xml").toFile();
        File xmlSchema = Paths.get("src/main/resources/order.xsd").toFile();

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            //Setting the Schema for validation
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = schemaFactory.newSchema(xmlSchema);
            factory.setSchema(schema);

            ErrorHandler handler = new BestSAXChecker();
            builder.setErrorHandler(handler);

            Document document = builder.parse(xmlDocument);

            String root = document.getDocumentElement().getTagName();
            System.out.println(">> " + root);

            Node creditCard = document.getElementsByTagName("cc").item(0);
            System.out.println(">>>>> " + creditCard.getAttributes().getNamedItem("number").getNodeName());

        } catch (SAXException | IOException | ParserConfigurationException e) {
            e.printStackTrace();
        }
    }
}

class BestSAXChecker implements ErrorHandler {
    public void warning(SAXParseException exception) {
        System.out.println("### Warning: " + exception.getMessage());
    }

    public void error(SAXParseException exception) {
        System.out.println("### Error: " + exception.getMessage());
    }

    public void fatalError(SAXParseException exception) {
        System.out.println("### Fatal Error: " + exception.getMessage());
    }
}

