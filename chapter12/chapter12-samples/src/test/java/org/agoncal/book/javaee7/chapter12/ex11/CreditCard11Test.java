package org.agoncal.book.javaee7.chapter12.ex11;

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
public class CreditCard11Test {

  // ======================================
  // =             Attributes             =
  // ======================================

  private static Date creationDate;
  public static final String creditCardXML = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><creditCard11 number=\"12345678\"><expiry-date>10/14</expiry-date><type>Visa</type><control-number>566</control-number></creditCard11>";

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

  @Test
  public void shouldMarshallACreditCard() throws JAXBException {

    CreditCard11 creditCard = new CreditCard11("12345678", "10/14", 566, "Visa");

    StringWriter writer = new StringWriter();
    JAXBContext context = JAXBContext.newInstance(CreditCard11.class);
    Marshaller m = context.createMarshaller();
    m.marshal(creditCard, writer);

    System.out.println(writer);

    assertEquals(creditCardXML, writer.toString());

  }

  @Test
  public void shouldUnmarshallACreditCard() throws JAXBException {
    StringReader reader = new StringReader(creditCardXML);
    JAXBContext context = JAXBContext.newInstance(CreditCard11.class);
    Unmarshaller u = context.createUnmarshaller();
    CreditCard11 creditCard = (CreditCard11) u.unmarshal(reader);

    assertEquals("12345678", creditCard.getNumber());
    assertEquals("10/14", creditCard.getExpiryDate());
    assertEquals((Object) 566, creditCard.getControlNumber());
    assertEquals("Visa", creditCard.getType());
  }
}