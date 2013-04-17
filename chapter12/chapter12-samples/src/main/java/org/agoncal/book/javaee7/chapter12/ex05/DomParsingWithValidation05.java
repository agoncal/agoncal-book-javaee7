package org.agoncal.book.javaee7.chapter12.ex05;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXParseException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class DomParsingWithValidation05 {

  public List<OrderLine05> parseOrderLines() throws Exception {

    List<OrderLine05> orderLines = new ArrayList<>();
    File xmlDocument = Paths.get("src/main/resources/invalidOrder.xml").toFile();
    File xmlSchema = Paths.get("src/main/resources/order.xsd").toFile();

    // DOM Factory
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

    // Setting the Schema for validation
    SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
    Schema schema = schemaFactory.newSchema(xmlSchema);
    factory.setSchema(schema);

    // Parsing the document
    DocumentBuilder documentBuilder = factory.newDocumentBuilder();
    documentBuilder.setErrorHandler(new DomParsingErrorHandler05());
    Document document = documentBuilder.parse(xmlDocument);

    // Getting the order_line node
    NodeList orderLinesNode = document.getElementsByTagName("order_line");
    for (int i = 0; i < orderLinesNode.getLength(); i++) {
      Element orderLineNode = (Element) orderLinesNode.item(i);
      OrderLine05 orderLine = new OrderLine05();
      orderLine.setItem(orderLineNode.getAttribute("item"));
      orderLine.setQuantity(Integer.valueOf(orderLineNode.getAttribute("quantity")));

      Node unitPriceNode = orderLineNode.getChildNodes().item(1);
      orderLine.setUnitPrice(Double.valueOf(unitPriceNode.getFirstChild().getNodeValue()));

      orderLines.add(orderLine);
    }

    return orderLines;
  }
}

class DomParsingErrorHandler05 implements ErrorHandler {
  public void warning(SAXParseException saxParseException) throws SAXParseException {
    throw saxParseException;
  }

  public void error(SAXParseException saxParseException) throws SAXParseException {
    throw saxParseException;
  }

  public void fatalError(SAXParseException saxParseException) throws SAXParseException {
    throw saxParseException;
  }
}