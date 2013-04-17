package org.agoncal.book.javaee7.chapter12.ex99;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonWriter;
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
public class JSonParsing99 {

  public static final String ORDER_JSON = "{\"id\":\"1234\",\"date\":\"19/09/2012\",\"total_amount\":\"93.48\",\"customer\":{\"first_name\":\"James\",\"last_name\":\"Rorrison\",\"email\":\"j.rorri@me.com\",\"phoneNumber\":\"+44 1234 1234\"},\"content\":[{\"item\":\"H2G2\",\"unit_price\":\"23.5\",\"quantity\":\"1\"},{\"item\":\"Harry Potter\",\"unit_price\":\"34.99\",\"quantity\":\"2\"}],\"credit_card\":{\"number\":\"123412341234\",\"expiry_date\":\"10/13\",\"control_number\":\"234\",\"type\":\"Visa\"}}";


  public static void main(String[] args) {

    StringWriter s = new StringWriter();
    JsonWriter writer = Json.createWriter(s);
    writer.writeObject(buildJSon());
    System.out.println(s);

  }


  //
  public static JsonObject buildJSon() {
    JsonObject value = Json.createObjectBuilder()
            .add("id", "1234")
            .add("date", "19/09/2012")
            .add("total_amount", "93.48")
            .add("customer", Json.createObjectBuilder()
                    .add("first_name", "James")
                    .add("last_name", "Rorrison")
                    .add("email", "j.rorri@me.com")
                    .add("phoneNumber", "+44 1234 1234")
            )
            .add("content", Json.createArrayBuilder().
                    add(Json.createObjectBuilder()
                            .add("item", "H2G2")
                            .add("unit_price", "23.5")
                            .add("quantity", "1")
                    ).
                    add(Json.createObjectBuilder()
                            .add("item", "Harry Potter")
                            .add("unit_price", "34.99")
                            .add("quantity", "2")
                    )
            )
            .add("credit_card", Json.createObjectBuilder()
                    .add("number", "123412341234")
                    .add("expiry_date", "10/13")
                    .add("control_number", "234")
                    .add("type", "Visa")
            )
            .build();
    return value;
  }

  public static JsonObject buildJSonWithArray() {
    JsonObject itemArrayH2G2 = Json.createObjectBuilder()
            .add("item", "H2G2")
            .add("unit_price", "23.5")
            .add("quantity", "1")
            .build();

    JsonObject itemArrayPotter = Json.createObjectBuilder()
            .add("item", "Harry Potter")
            .add("unit_price", "34.99")
            .add("quantity", "2")
            .build();

    JsonObject value = Json.createObjectBuilder()
            .add("id", "1234")
            .add("date", "19/09/2012")
            .add("total_amount", "93.48")
            .add("customer", Json.createObjectBuilder()
                    .add("first_name", "James")
                    .add("last_name", "Rorrison")
                    .add("email", "j.rorri@me.com")
                    .add("phoneNumber", "+44 1234 1234")
            )
            .add("content", Json.createArrayBuilder()
                    .add(itemArrayH2G2)
                    .add(itemArrayPotter)
            )
            .add("credit_card", Json.createObjectBuilder()
                    .add("number", "123412341234")
                    .add("expiry_date", "10/13")
                    .add("control_number", "234")
                    .add("type", "Visa")
            )
            .build();
    return value;
  }

  public static JsonObject buildJSonWithArraySeperate() {

    JsonObject customerJames = Json.createObjectBuilder()
            .add("first_name", "James")
            .add("last_name", "Rorrison")
            .add("email", "j.rorri@me.com")
            .add("phoneNumber", "+44 1234 1234")
            .build();

    JsonObject itemArrayH2G2 = Json.createObjectBuilder()
            .add("item", "H2G2")
            .add("unit_price", "23.5")
            .add("quantity", "1")
            .build();

    JsonObject itemArrayPotter = Json.createObjectBuilder()
            .add("item", "Harry Potter")
            .add("unit_price", "34.99")
            .add("quantity", "2")
            .build();

    JsonObject creditCard = Json.createObjectBuilder()
            .add("number", "123412341234")
            .add("expiry_date", "10/13")
            .add("control_number", "234")
            .add("type", "Visa")
            .build();


    JsonObject value = Json.createObjectBuilder()
            .add("id", "1234")
            .add("date", "19/09/2012")
            .add("total_amount", "93.48")
            .add("customer", customerJames)
            .add("content", Json.createArrayBuilder()
                    .add(itemArrayH2G2)
                    .add(itemArrayPotter)
            )
            .add("credit_card", creditCard)
            .build();
    return value;
  }
}
