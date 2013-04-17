package org.agoncal.book.javaee7.chapter12.ex99;

import org.junit.After;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.IOException;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Calendar;
import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class Order99Test {

  // ======================================
  // =             Attributes             =
  // ======================================

  private static Date creationDate;
  public static final String orderXML = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><order id=\"1234\" date=\"05/06/2013\"><customer first_name=\"James\" last_name=\"Rorrison\"><email>j.rorri@me.com</email><phoneNumber>+44 1234 1234</phoneNumber></customer><content><order_line item=\"H2G2\" quantity=\"1\"><unit_price>23.5</unit_price></order_line><order_line item=\"Harry Potter\" quantity=\"2\"><unit_price>34.99</unit_price></order_line></content><credit_card number=\"123412341234\" expiry_date=\"10/13\" control_number=\"234\" type=\"Visa\"/></order>";

  // ======================================
  // =          Lifecycle Methods         =
  // ======================================

  @BeforeClass
  public static void init() throws IOException {
    Calendar calendar = Calendar.getInstance();
    calendar.set(2013, Calendar.JUNE, 5);
    creationDate = calendar.getTime();
  }

  @After
  public void stop() {
  }

  // ======================================
  // =              Unit tests            =
  // ======================================

  @Test @Ignore
  public void shouldMarshallAnOrder() throws JAXBException {

    Order99 order = new Order99(1234L, 93.48, creationDate);
    order.addOrderLine(new OrderLine99("H2G2", 23.5, 1));
    order.addOrderLine(new OrderLine99("Harry Potter", 34.99, 2));
    order.setCreditCard(new CreditCard99("123412341234", "10/13", 234, "Visa"));
    order.setCustomer(new Customer99("James", "Rorrison", "j.rorri@me.com", "+44 1234 1234"));

    StringWriter writer = new StringWriter();
    JAXBContext context = JAXBContext.newInstance(Order99.class);
    Marshaller m = context.createMarshaller();
    m.marshal(order, writer);

    System.out.println(writer);

    assertEquals(orderXML, writer.toString());

  }

  @Test @Ignore
  public void shouldUnmarshallAnOrder() throws JAXBException {
    StringReader reader = new StringReader(orderXML);
    JAXBContext context = JAXBContext.newInstance(Order99.class);
    Unmarshaller u = context.createUnmarshaller();
    Order99 order = (Order99) u.unmarshal(reader);

    assertEquals((Object) 1234L, order.getId());
    assertEquals(2, order.getOrderLines().size());
    assertEquals("Rorrison", order.getCustomer().getLastName());
    assertEquals("123412341234", order.getCreditCard().getNumber());
  }
}