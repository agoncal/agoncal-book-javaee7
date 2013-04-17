package org.agoncal.book.javaee7.chapter12.ex05;

import org.agoncal.book.javaee7.chapter12.ex99.JSonParsing99;
import org.junit.Test;

import javax.json.*;
import java.io.StringWriter;

import static org.junit.Assert.assertEquals;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class JSonParsing05Test {

    public static final String ORDER_JSON = "{\"id\":\"1234\",\"date\":\"19/09/2012\",\"total_amount\":\"93.48\",\"customer\":{\"first_name\":\"James\",\"last_name\":\"Rorrison\",\"email\":\"j.rorri@me.com\",\"phoneNumber\":\"+44 1234 1234\"},\"content\":[{\"item\":\"H2G2\",\"unit_price\":\"23.5\",\"quantity\":\"1\"},{\"item\":\"Harry Potter\",\"unit_price\":\"34.99\",\"quantity\":\"2\"}],\"credit_card\":{\"number\":\"123412341234\",\"expiry_date\":\"10/13\",\"control_number\":\"234\",\"type\":\"Visa\"}}";

//  @Test
//  public void shouldGenerateJSon() throws Exception {
//    assertEquals(ORDER_JSON, JSonParsing.generateJSon());
//  }

    @Test
    public void shouldBuildJSon() throws Exception {

        JsonObject jsonObject = JSonParsing99.buildJSon();
        JsonValue value = jsonObject.get("id");
        assertEquals(JsonValue.ValueType.STRING, value.getValueType());
        assertEquals("1234", value.toString());

        StringWriter orderJSON = new StringWriter();
        JsonWriter writer = Json.createWriter(orderJSON);
        writer.writeObject(jsonObject);

        assertEquals(ORDER_JSON, orderJSON.toString());
    }

    @Test
    public void shouldBuildJSonWithArray() throws Exception {

        JsonObject jsonObject = JSonParsing99.buildJSonWithArray();
        StringWriter orderJSON = new StringWriter();
        JsonWriter writer = Json.createWriter(orderJSON);
        writer.writeObject(jsonObject);

        assertEquals(ORDER_JSON, orderJSON.toString().trim());
    }

    @Test
    public void shouldBuildJSonWithArraySeperate() throws Exception {

        JsonObject jsonObject = JSonParsing99.buildJSonWithArraySeperate();
        StringWriter orderJSON = new StringWriter();
        JsonWriter writer = Json.createWriter(orderJSON);
        writer.writeObject(jsonObject);

        assertEquals(ORDER_JSON, orderJSON.toString().trim());
    }

    @Test
    public void shouldBuildAJsonArray() {
        JsonArray value = Json.createArrayBuilder()
                .add(Json.createObjectBuilder()
                        .add("type", "home")
                        .add("number", "212 555-1234"))
                .add(Json.createObjectBuilder()
                        .add("type", "fax")
                        .add("number", "646 555-4567"))
                .build();

        assertEquals("[{\"type\":\"home\",\"number\":\"212 555-1234\"},{\"type\":\"fax\",\"number\":\"646 555-4567\"}]", value.toString());
    }

    @Test
    public void shouldBuildAJsonObject() throws Exception {

        JsonObject value = Json.createObjectBuilder().add("id", "1234").add("date", "19/09/2012").add("total_amount", "93.48").build();

        assertEquals("{\"id\":\"1234\",\"date\":\"19/09/2012\",\"total_amount\":\"93.48\"}", value.toString().trim());
    }

//  @Test
//  public void shouldParseJSon() {
//    StringReader s = new StringReader(ORDER_JSON);
//    JsonParser parser = Json.createParser(s);
//    Iterator<JsonParser.Event> it = parser.iterator();
//    Event event = it.next();
//
//    assertEquals(START_OBJECT, event);
//
//    event = it.next();
//    assertEquals(KEY_NAME, event);
//    assertEquals("id", parser.getString());
//
//    event = it.next();
//    assertEquals(VALUE_STRING, event);
//    assertEquals("1234", parser.getString());
//
//    event = it.next();
//    assertEquals(KEY_NAME, event);
//    assertEquals("date", parser.getString());
//
//    event = it.next();
//    assertEquals(VALUE_STRING, event);
//    assertEquals("19/09/2012", parser.getString());
//
//    it.next();
//    it.next();
//    it.next();
//    event = it.next();
//
//    assertEquals(START_OBJECT, event);
//
//    event = it.next();
//    assertEquals(KEY_NAME, event);
//    assertEquals("first_name", parser.getString());
//  }
}
