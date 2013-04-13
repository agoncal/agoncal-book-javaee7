package org.agoncal.book.javaee7.chapter12.ex06;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;
import java.io.StringWriter;
import java.nio.file.Paths;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class XsltTransforming06 {

  public static void main(String[] args) {
    String order = new XsltTransforming06().transformOrder();
    System.out.println(order);
  }

  public String transformOrder() {

    StringWriter writer = new StringWriter();

    try {
      File xmlDocument = Paths.get("src/main/resources/order.xml").toFile();
      File stylesheet = Paths.get("src/main/resources/order.xsl").toFile();

      // Saxon Factory for using XSLT 2
      TransformerFactory factory = TransformerFactory.newInstance("net.sf.saxon.TransformerFactoryImpl", null);

      // Transforming the document
      Transformer transformer = factory.newTransformer(new StreamSource(stylesheet));
      transformer.transform(new StreamSource(xmlDocument), new StreamResult(writer));

    } catch (TransformerException e) {
      e.printStackTrace();
    }

    return writer.toString();
  }
}
