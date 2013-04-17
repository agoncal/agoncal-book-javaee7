package org.agoncal.book.javaee7.chapter12;

import org.agoncal.book.javaee7.chapter12.ex05.CreditCard05;

import javax.json.Json;
import javax.json.stream.JsonGenerator;
import java.io.StringWriter;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class JSONGenerator05 {
  public static void main(String[] args) {
    CreditCard05 creditCard = new CreditCard05("1234", "12/09", 6398, "Visa");
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
    System.out.println(writer.toString());
  }
}
