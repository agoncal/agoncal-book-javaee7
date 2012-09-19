package org.agoncal.book.javaee7.chapter20.ex05;

import javax.json.JsonBuilder;
import javax.json.JsonObject;
import javax.json.JsonWriter;
import java.io.StringWriter;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class JSonParsing {

    public static void main(String[] args) {
        JsonObject value = new JsonBuilder()
                .beginObject()
                .add("id", "1234")
                .add("date", "19/09/2012")
                .add("total_amount", "93.48")
                .beginObject("customer")
                .add("first_name", "James")
                .add("last_name", "Rorrison")
                .add("email", "j.rorri@me.com")
                .add("phoneNumber", "+44 1234 1234")
                .endObject()
                .beginArray("content")
                .beginObject()
                .add("item", "H2G2")
                .add("unit_price", "23.5")
                .add("quantity", "1")
                .endObject()
                .beginObject()
                .add("item", "Harry Potter")
                .add("unit_price", "34.99")
                .add("quantity", "2")
                .endObject()
                .endArray()
                .beginObject("credit_card")
                .add("number", "123412341234")
                .add("expiry_date", "10/13")
                .add("control_number", "234")
                .add("type", "Visa")
                .endObject()
                .endObject()
                .build();

        StringWriter s = new StringWriter();
        JsonWriter writer = new JsonWriter(s);
        writer.writeObject(value);
        System.out.println(s);

    }
}
