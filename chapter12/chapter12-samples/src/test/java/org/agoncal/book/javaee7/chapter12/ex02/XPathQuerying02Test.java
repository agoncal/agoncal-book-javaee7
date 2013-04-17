package org.agoncal.book.javaee7.chapter12.ex02;

import com.sun.org.apache.xpath.internal.NodeSet;
import org.junit.Ignore;
import org.junit.Test;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;
import java.io.File;
import java.nio.file.Paths;

import static org.junit.Assert.assertEquals;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class XPathQuerying02Test {

  @Test @Ignore
  public void shouldTransformOrder() throws Exception {

    File xmlDocument = Paths.get("src/main/resources/order.xml").toFile();


    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder = factory.newDocumentBuilder();
    Document document = builder.parse(xmlDocument);

    // evaluate the XPath expression against the Document
    XPath xpath = XPathFactory.newInstance().newXPath();

    // Order node
    NodeSet nodes = (NodeSet) xpath.evaluate("//*", document, XPathConstants.NODESET);
    nodes.getLength();
    assertEquals("1234", xpath.evaluate("//*", document, XPathConstants.NODESET));
    assertEquals("1234", xpath.evaluate("/order/@id", document, XPathConstants.STRING));
    assertEquals("1234", xpath.evaluate("/order/@id", document));
    assertEquals("05/06/2013", xpath.evaluate("/order/@date", document));

    // Customer node
    assertEquals("j.rorri@me.com", xpath.evaluate("/order/customer/email", document));
    assertEquals("j.rorri@me.com", xpath.evaluate("//email", document));
    assertEquals("James", xpath.evaluate("/order/customer/@first_name", document));
    assertEquals("James", xpath.evaluate("//@first_name", document));
    assertEquals("+44 1234 1234", xpath.evaluate("/order/customer/phoneNumber", document));

    // Order line node
    assertEquals("H2G2", xpath.evaluate("/order/content/order_line[1]/@item", document));
    assertEquals("23.5", xpath.evaluate("/order/content/order_line[1]/unit_price", document));
    assertEquals("Harry Potter", xpath.evaluate("/order/content/order_line[2]/@item", document));
    assertEquals("34.99", xpath.evaluate("/order/content/order_line[2]/unit_price", document));

    // Credit card node
    assertEquals("123412341234", xpath.evaluate("/order/credit_card/@number", document));
    assertEquals("10/13", xpath.evaluate("/order/credit_card/@expiry_date", document));
    assertEquals("234", xpath.evaluate("/order/credit_card/@control_number", document));
    assertEquals("234", xpath.evaluate("//credit_card/@control_number", document));
  }

}
