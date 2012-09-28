package org.agoncal.book.javaee7.chapter19.ex03;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class XsltTransformingTest {

  public static final String ORDER_XML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
          "<order total_amount=\"93.48\" id=\"1234\" date=\"05/06/2013\">\n" +
          "   <content>\n" +
          "      <order_line item=\"H2G2\" quantity=\"1\">\n" +
          "         <unit_price>23.5</unit_price>\n" +
          "      </order_line>\n" +
          "      <order_line item=\"Harry Potter\" quantity=\"2\">\n" +
          "         <unit_price>34.99</unit_price>\n" +
          "      </order_line>\n" +
          "   </content>\n" +
          "</order>\n";

  @Test
  public void shouldTransformOrder() throws Exception {

    String orderXML = new XsltTransforming().transformOrder();

    assertEquals(ORDER_XML, orderXML);

  }
}
