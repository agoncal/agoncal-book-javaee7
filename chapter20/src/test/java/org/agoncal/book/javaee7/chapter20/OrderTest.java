package org.agoncal.book.javaee7.chapter20;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class OrderTest {

    // ======================================
    // =             Attributes             =
    // ======================================

    private static Date creationDate;
    public static final String orderXML = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><order id=\"1234\" date=\"11/08/2012\" total_amount=\"93.48\"><customer first_name=\"James\" last_name=\"Rorrison\"><email>j.rorri@me.com</email><phoneNumber>+44 1234 1234</phoneNumber></customer><content><order_line item=\"H2G2\"><unit_price>23.5</unit_price><quantity>1</quantity></order_line><order_line item=\"Harry Potter\"><unit_price>34.99</unit_price><quantity>2</quantity></order_line></content><credit_card number=\"123412341234\"><expiry_date>10/13</expiry_date><control_number>234</control_number><type>Visa</type></credit_card></order>";

    // ======================================
    // =          Lifecycle Methods         =
    // ======================================

    @BeforeClass
    public static void init() throws IOException {
        creationDate = new Date();
    }

    @After
    public void stop() {
    }

    // ======================================
    // =              Unit tests            =
    // ======================================

    @Test
    public void shouldMarshallAnOrder() throws JAXBException {

        Order order = new Order(1234L, 93.48, creationDate);
        order.addOrderLine(new OrderLine("H2G2", 23.5, 1));
        order.addOrderLine(new OrderLine("Harry Potter", 34.99, 2));
        order.setCreditCard(new CreditCard("123412341234", "10/13", 234, "Visa"));
        order.setCustomer(new Customer("James", "Rorrison", "j.rorri@me.com", "+44 1234 1234"));

        StringWriter writer = new StringWriter();
        JAXBContext context = JAXBContext.newInstance(Order.class);
        Marshaller m = context.createMarshaller();
        m.marshal(order, writer);

        System.out.println(writer);

        assertEquals(orderXML, writer.toString());

    }

    @Test
    public void shouldUnmarshallAnOrder() throws JAXBException {
        StringReader reader = new StringReader(orderXML);
        JAXBContext context = JAXBContext.newInstance(Order.class);
        Unmarshaller u = context.createUnmarshaller();
        Order order = (Order) u.unmarshal(reader);

        assertEquals((Object) 1234L, order.getId());
        assertEquals((Object) 93.48, order.getTotalAmount());
        assertEquals(2, order.getOrderLines().size());
        assertEquals("Rorrison", order.getCustomer().getLastName());
        assertEquals("123412341234", order.getCreditCard().getNumber());
    }
}