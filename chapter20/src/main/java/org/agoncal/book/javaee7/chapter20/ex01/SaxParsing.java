package org.agoncal.book.javaee7.chapter20.ex01;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
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
public class SaxParsing extends DefaultHandler {

    private String elementName = "";
    private int nbTabs;
    private StringBuffer buffer = new StringBuffer();

    public void parseOrderXML() {

        try {
            File xmlDocument = Paths.get("src/main/resources/order.xml").toFile();
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            saxParser.parse(xmlDocument, this);
        } catch (SAXException | IOException | ParserConfigurationException e) {
            e.printStackTrace();
        }
    }

    public void startElement(String namespaceURI, String localName, String qualifiedName, Attributes attrs) throws SAXException {

        if (localName != null && !localName.isEmpty())
            elementName = localName;
        else
            elementName = qualifiedName;

        buffer.append(tabs() + elementName + "{");
        nbTabs++;
        if (attrs != null) {
            for (int i = 0; i < attrs.getLength(); i++) {
                buffer.append(tabs() + attrs.getLocalName(i) + "=" + attrs.getValue(i));
            }
        }
    }

    public void endElement(String namespaceURI, String localName, String qualifiedName) throws SAXException {
        nbTabs--;
        buffer.append(tabs() + "}");
    }

    private String tabs() {
        String tabs = "";
        for (int i = 0; i < nbTabs; i++) {
            tabs += "\t";
        }
        return tabs;
    }

    public String getOutput() {
        return buffer.toString();
    }
}
