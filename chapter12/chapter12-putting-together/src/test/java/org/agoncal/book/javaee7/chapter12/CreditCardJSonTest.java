package org.agoncal.book.javaee7.chapter12;

import org.junit.Test;

import javax.json.Json;
import javax.json.stream.JsonGenerator;
import javax.xml.bind.JAXBException;
import java.io.StringWriter;

import static org.junit.Assert.assertEquals;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class CreditCardJSonTest {

  // ======================================
  // =             Attributes             =
  // ======================================

  public static final String creditCardJSon =
          "{\"creditCard\":" +
                  "{\"number\":\"12345678\"," +
                  "\"expiryDate\":\"10/14\"," +
                  "\"controlNumber\":566," +
                  "\"type\":\"Visa\"}" +
          "}";

  // ======================================
  // =              Unit tests            =
  // ======================================

  @Test
  public void shouldGenerateACreditCard() {

    CreditCard creditCard = new CreditCard("12345678", "10/14", 566, "Visa");

    StringWriter writer = new StringWriter();
    JsonGenerator generator = Json.createGenerator(writer);
    generator.writeStartObject()
            .writeStartObject("creditCard")
            .write("number", creditCard.getNumber())
            .write("expiryDate", creditCard.getExpiryDate())
            .write("controlNumber", creditCard.getControlNumber())
            .write("type", creditCard.getType())
            .writeEnd()
            .writeEnd()
            .close();

    System.out.println(writer);

    assertEquals(creditCardJSon, writer.toString().trim());

  }
}
