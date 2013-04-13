package org.agoncal.book.javaee7.chapter12.ex04;

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
public class SaxParsingWithValidation04 extends DefaultHandler {

  private String elementName = "";
  private int nbTabs;
  private StringBuffer buffer = new StringBuffer();

  public void parseOrderXML() throws SAXException, IOException, ParserConfigurationException {

    File xmlDocument = Paths.get("src/main/resources/invalidOrder.xml").toFile();
    File xmlSchema = Paths.get("src/main/resources/order.xsd").toFile();
    DefaultHandler handler = new SaxParsingWithValidation04();
    SAXParserFactory factory = SAXParserFactory.newInstance();
    //Setting the Schema for validation
    SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
    Schema schema = schemaFactory.newSchema(xmlSchema);
    factory.setSchema(schema);
    SAXParser saxParser = factory.newSAXParser();
    saxParser.parse(xmlDocument, this);
  }

  public void startElement(String namespaceURI, String localName, String qualifiedName, Attributes attrs) throws SAXException {

    if (localName != null && !localName.isEmpty())
      elementName = localName;
    else
      elementName = qualifiedName;

    buffer.append(tabs() + elementName + "{\n");
    nbTabs++;
    if (attrs != null) {
      for (int i = 0; i < attrs.getLength(); i++) {
        buffer.append(tabs() + attrs.getLocalName(i) + "=" + attrs.getValue(i) + "\n");
      }
    }
  }

  public void endElement(String namespaceURI, String localName, String qualifiedName) throws SAXException {
    nbTabs--;
    buffer.append(tabs() + "}\n");
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

  public String getOutput() {
    return buffer.toString();
  }
}
