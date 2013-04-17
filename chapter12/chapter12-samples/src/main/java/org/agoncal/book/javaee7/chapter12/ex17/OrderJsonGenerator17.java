package org.agoncal.book.javaee7.chapter12.ex17;

import org.agoncal.book.javaee7.chapter12.ex05.CreditCard05;

import javax.json.Json;
import javax.json.stream.JsonGenerator;
import java.io.IOException;
import java.io.StringWriter;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class OrderJsonGenerator17 {
  public static void main(String[] args) throws IOException {
//    System.out.println(new OrderJsonGenerator17().generateCreditCard());
    System.out.println(new OrderJsonGenerator17().generatePurchaseOrder());
  }

  public StringWriter generateCreditCard() throws IOException {
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
    return writer;
  }

  public StringWriter generatePurchaseOrder() throws IOException {
    StringWriter writer = new StringWriter();
    JsonGenerator generator = Json.createGenerator(writer);
    generator.writeStartObject()
            .write("id", "1234")
            .write("date", "05/06/2013")
            .writeStartObject("customer")
            .write("first_name", "James")
            .write("last_name", "Rorrison")
            .write("email", "j.rorri@me.com")
            .write("phoneNumber", "+44 1234 1234")
            .writeEnd()
            .writeStartArray("content")
            .writeStartObject()
            .write("item", "H2G2")
            .write("unit_price", "23.5")
            .write("quantity", "1")
            .writeEnd()
            .writeStartObject()
            .write("item", "Harry Potter")
            .write("unit_price", "34.99")
            .write("quantity", "2")
            .writeEnd()
            .writeEnd()
            .writeStartObject("credit_card")
            .write("number", "123412341234")
            .write("expiry_date", "10/13")
            .write("control_number", "234")
            .write("type", "Visa")
            .writeEnd()
            .writeEnd()
            .close();
    return writer;
  }
}
