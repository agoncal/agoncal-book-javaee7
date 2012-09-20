package org.agoncal.book.javaee7.chapter20.ex01;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class SaxParsing extends DefaultHandler {

    public static void main(String[] args) {
        File xmlDocument = Paths.get("src/main/resources/order.xml").toFile();

        try {
            DefaultHandler handler = new SaxParsingWithValidation();
            SAXParserFactory factory = SAXParserFactory.newInstance();
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

        System.out.println(tabs() + elementName + "{");
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

    private String tabs() {
        String tabs = "";
        for (int i = 0; i < nbTabs; i++) {
            tabs += "\t";
        }
        return tabs;
    }
}
