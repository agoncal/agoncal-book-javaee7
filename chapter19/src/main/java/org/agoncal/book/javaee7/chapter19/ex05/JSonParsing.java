package org.agoncal.book.javaee7.chapter19.ex05;

import javax.json.*;
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
public class JSonParsing {

  public static final String ORDER_JSON = "{\"id\":\"1234\",\"date\":\"19/09/2012\",\"total_amount\":\"93.48\",\"customer\":{\"first_name\":\"James\",\"last_name\":\"Rorrison\",\"email\":\"j.rorri@me.com\",\"phoneNumber\":\"+44 1234 1234\"},\"content\":[{\"item\":\"H2G2\",\"unit_price\":\"23.5\",\"quantity\":\"1\"},{\"item\":\"Harry Potter\",\"unit_price\":\"34.99\",\"quantity\":\"2\"}],\"credit_card\":{\"number\":\"123412341234\",\"expiry_date\":\"10/13\",\"control_number\":\"234\",\"type\":\"Visa\"}}";


  public static void main(String[] args) {

    StringWriter s = new StringWriter();
    JsonWriter writer = new JsonWriter(s);
    writer.writeObject(buildJSon());
    System.out.println(s);

  }

  public static String generateJSon() throws IOException {
    StringWriter s = new StringWriter();
    JsonGenerator generator = Json.createGenerator(s);
    generator.beginObject()
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
            .close();
    return s.toString();
  }

  public static JsonObject buildJSon() {
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
    return value;
  }

  public static JsonObject buildJSonWithArray() {
    JsonObject itemH2G2 = new JsonBuilder()
    .beginObject()
            .add("item", "H2G2")
            .add("unit_price", "23.5")
            .add("quantity", "1")
            .endObject()
            .build();
    JsonObject itemarrayPotter = new JsonBuilder()
            .beginObject()
            .add("item", "Harry Potter")
            .add("unit_price", "34.99")
            .add("quantity", "2")
            .endObject()
            .build();

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
                .add(itemH2G2)
                .add(itemarrayPotter)
              .endArray()
              .beginObject("credit_card")
                .add("number", "123412341234")
                .add("expiry_date", "10/13")
                .add("control_number", "234")
                .add("type", "Visa")
              .endObject()
            .endObject()
            .build();
    return value;
  }
}
