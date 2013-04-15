package org.agoncal.book.javaee7.chapter12.ex05;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringWriter;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class DomBuilding05 {

  public static void main(String[] args) {
    String order = new DomBuilding05().buildOrder();
    System.out.println(order);
  }

  public String buildOrder() {

    StringWriter writer = new StringWriter();

    try {
      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      DocumentBuilder builder = factory.newDocumentBuilder();
      Document document = builder.newDocument();

      Element order = document.createElement("order");
      order.setAttribute("date", "05/06/2013");
      order.setAttribute("id", "1234");
      document.appendChild(order);

      Element content = document.createElement("content");
      order.appendChild(content);

      Element order_line1 = document.createElement("order_line");
      order_line1.setAttribute("item", "H2G2");
      order_line1.setAttribute("quantity", "1");
      Element unit_price1 = document.createElement("unit_price");
      unit_price1.appendChild(document.createTextNode("23.5"));
      order_line1.appendChild(unit_price1);
      content.appendChild(order_line1);

      Element order_line2 = document.createElement("order_line");
      order_line2.setAttribute("item", "Harry Potter");
      order_line2.setAttribute("quantity", "2");
      Element unit_price2 = document.createElement("unit_price");
      unit_price2.appendChild(document.createTextNode("34.99"));
      order_line2.appendChild(unit_price2);
      content.appendChild(order_line2);

      XMLSerializer ser = new XMLSerializer(writer, new OutputFormat("xml", "UTF-8", true));
      ser.serialize(document);

    } catch (IOException | ParserConfigurationException e) {
      e.printStackTrace();
    }

    return writer.toString().trim();
  }
}
