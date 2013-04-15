package org.agoncal.book.javaee7.chapter12.ex05;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class DomBuilding05Test {

    public static final String ORDER_XML = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<order date=\"05/06/2013\" id=\"1234\">\n" +
            "    <content>\n" +
            "        <order_line item=\"H2G2\" quantity=\"1\">\n" +
            "            <unit_price>23.5</unit_price>\n" +
            "        </order_line>\n" +
            "        <order_line item=\"Harry Potter\" quantity=\"2\">\n" +
            "            <unit_price>34.99</unit_price>\n" +
            "        </order_line>\n" +
            "    </content>\n" +
            "</order>";

    @Test
    public void shouldBuildOrder() throws Exception {

        String orderXML = new DomBuilding05().buildOrder() ;

        assertEquals(ORDER_XML, orderXML);

    }
}
