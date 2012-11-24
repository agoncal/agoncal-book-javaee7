package org.agoncal.book.javaee7.chapter19.ex05;

import org.junit.Test;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonValue;
import javax.json.JsonWriter;
import javax.json.stream.JsonParser;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.Iterator;
import java.util.Map;

import static javax.json.stream.JsonParser.Event;
import static javax.json.stream.JsonParser.Event.*;
import static org.junit.Assert.assertEquals;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class JSonParsingTest {

  public static final String ORDER_JSON = "{\"id\":\"1234\",\"date\":\"19/09/2012\",\"total_amount\":\"93.48\",\"customer\":{\"first_name\":\"James\",\"last_name\":\"Rorrison\",\"email\":\"j.rorri@me.com\",\"phoneNumber\":\"+44 1234 1234\"},\"content\":[{\"item\":\"H2G2\",\"unit_price\":\"23.5\",\"quantity\":\"1\"},{\"item\":\"Harry Potter\",\"unit_price\":\"34.99\",\"quantity\":\"2\"}],\"credit_card\":{\"number\":\"123412341234\",\"expiry_date\":\"10/13\",\"control_number\":\"234\",\"type\":\"Visa\"}}";

  @Test
  public void shouldBuild() throws Exception {

    JsonObject jsonObject = JSonParsing.buildJSon();
    Map<String, JsonValue> values = jsonObject.getValues();
    assertEquals(JsonValue.JsonValueType.STRING, values.get("id").getValueType());

    StringWriter orderJSON = new StringWriter();
    JsonWriter writer = new JsonWriter(orderJSON);
    writer.writeObject(jsonObject);

    assertEquals(ORDER_JSON, orderJSON.toString());
  }

  @Test
  public void shouldBuildWithArray() throws Exception {

    JsonObject jsonObject = JSonParsing.buildJSonWithArray();
    StringWriter orderJSON = new StringWriter();
    JsonWriter writer = new JsonWriter(orderJSON);
    writer.writeObject(jsonObject);

    assertEquals(ORDER_JSON, orderJSON.toString().trim());
  }

  @Test
  public void shouldGenerateOrder() throws Exception {
    assertEquals(ORDER_JSON, JSonParsing.generateJSon());
  }

  @Test
  public void shouldParseJSon() {
    StringReader s = new StringReader(ORDER_JSON);
    JsonParser parser = Json.createParser(s);
    Iterator<JsonParser.Event> it = parser.iterator();
    Event event = it.next();

    assertEquals(START_OBJECT, event);

    event = it.next();
    assertEquals(KEY_NAME, event);
    assertEquals("id", parser.getString());

    event = it.next();
    assertEquals(VALUE_STRING, event);
    assertEquals("1234", parser.getString());

    event = it.next();
    assertEquals(KEY_NAME, event);
    assertEquals("date", parser.getString());

    event = it.next();
    assertEquals(VALUE_STRING, event);
    assertEquals("19/09/2012", parser.getString());

    it.next();
    it.next();
    it.next();
    event = it.next();

    assertEquals(START_OBJECT, event);

    event = it.next();
    assertEquals(KEY_NAME, event);
    assertEquals("first_name", parser.getString());
  }
}
