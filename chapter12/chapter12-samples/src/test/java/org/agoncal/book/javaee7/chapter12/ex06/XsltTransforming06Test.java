package org.agoncal.book.javaee7.chapter12.ex06;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class XsltTransforming06Test {

  public static final String ORDER_XML = "<html>\n" +
          "   <body>\n" +
          "      <h2>Sold Items</h2>\n" +
          "      <table border=\"1\">\n" +
          "         <tr>\n" +
          "            <th>Title</th>\n" +
          "            <th>Quantity</th>\n" +
          "            <th>Unit Price</th>\n" +
          "         </tr>\n" +
          "         <tr>\n" +
          "            <td>H2G2</td>\n" +
          "            <td>1</td>\n" +
          "            <td>23.5</td>\n" +
          "         </tr>\n" +
          "         <tr>\n" +
          "            <td>Harry Potter</td>\n" +
          "            <td>2</td>\n" +
          "            <td bgcolor=\"#FF0000\">34.99</td>\n" +
          "         </tr>\n" +
          "      </table>\n" +
          "   </body>\n" +
          "</html>";

  @Test
  public void shouldTransformOrder() throws Exception {

    String orderXML = new XsltTransforming06().transformOrder();

    assertEquals(ORDER_XML, orderXML);

  }
}
