package org.agoncal.book.javaee7.chapter12.ex05;

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
public class DomParsing05 {

  public List<OrderLine05> parseOrderLines() {

    List<OrderLine05> orderLines = new ArrayList<>();

    try {
      File xmlDocument = Paths.get("src/main/resources/order.xml").toFile();

      // DOM Factory
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

      // Parsing the document
      DocumentBuilder documentBuilder = factory.newDocumentBuilder();
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

    } catch (SAXException | IOException | ParserConfigurationException e) {
      e.printStackTrace();
    }
    return orderLines;
  }
}
