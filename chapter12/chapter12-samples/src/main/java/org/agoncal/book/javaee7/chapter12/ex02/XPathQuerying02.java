package org.agoncal.book.javaee7.chapter12.ex02;

import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class XPathQuerying02 {

  public static void main(String[] args) {
    String xmlDocument = "src/main/resources/order.xml";

    try {
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      DocumentBuilder builder = factory.newDocumentBuilder();
      Document document = builder.parse(xmlDocument);

      // evaluate the XPath expression against the Document
      XPath xpath = XPathFactory.newInstance().newXPath();
      String expression = "/order/@total_amount";
      Double totalAmount = (Double) xpath.evaluate(expression, document, XPathConstants.NUMBER);
      System.out.println("totalAmount " + totalAmount);

    } catch (ParserConfigurationException | SAXException | XPathExpressionException | IOException e) {
      e.printStackTrace();
    }
  }
}
