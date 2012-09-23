package org.agoncal.book.javaee7.chapter20.ex02;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class DomBuildingTest {

    public static final String order = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<order date=\"05/06/2013\" id=\"1234\">\n" +
            "    <customer first_name=\"James\" last_name=\"Rorrison\">\n" +
            "        <email>j.rorri@me.com</email>\n" +
            "        <phoneNumber>+44 1234 1234</phoneNumber>\n" +
            "    </customer>\n" +
            "</order>";

    @Test
    public void shouldBuildOrder() throws Exception {

        String orderXML = new DomBuilding().buildOrder() ;

        assertEquals(order, orderXML);

    }
}
