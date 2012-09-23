package org.agoncal.book.javaee7.chapter20.ex01;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.XMLConstants;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class SaxParsingWithValidation extends DefaultHandler {

    public static void main(String[] args) {
        File xmlDocument = Paths.get("src/main/resources/invalidOrder.xml").toFile();
        File xmlSchema = Paths.get("src/main/resources/order.xsd").toFile();

        try {
            DefaultHandler handler = new SaxParsingWithValidation();
            SAXParserFactory factory = SAXParserFactory.newInstance();
            //Setting the Schema for validation
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = schemaFactory.newSchema(xmlSchema);
            factory.setSchema(schema);
            SAXParser saxParser = factory.newSAXParser();
            saxParser.parse(xmlDocument, handler);
        } catch (SAXException | IOException | ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    private String elementName = "";
    private int nbTabs;

    public void startElement(String namespaceURI, String localName, String qualifiedName, Attributes attrs) throws SAXException {

        if (localName != null && !localName.isEmpty())
            elementName = localName;
        else
            elementName = qualifiedName;

        System.out.println(tabs() +elementName + "{");
        nbTabs++;
        if (attrs != null) {
            for (int i = 0; i < attrs.getLength(); i++) {
                System.out.println(tabs() + attrs.getLocalName(i) + "=" + attrs.getValue(i));
            }
        }
    }

    public void endElement(String namespaceURI, String localName, String qualifiedName) throws SAXException {
        nbTabs--;
        System.out.println(tabs() + "}");
    }

    @Override
    public void error(SAXParseException exception) throws SAXException {
        throw new SAXException(exception.getMessage());
    }

    @Override
    public void fatalError(SAXParseException exception) throws SAXException {
        throw new SAXException(exception.getMessage());
    }

    private String tabs() {
        String tabs = "";
        for (int i = 0; i < nbTabs; i++) {
            tabs += "\t";
        }
        return tabs;
    }
}
