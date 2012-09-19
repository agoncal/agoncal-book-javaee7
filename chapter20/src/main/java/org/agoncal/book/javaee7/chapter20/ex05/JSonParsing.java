package org.agoncal.book.javaee7.chapter20.ex05;

import javax.json.JsonBuilder;
import javax.json.JsonObject;

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
                .add("firstName", "John")
                .add("lastName", "Smith")
                .add("age", 25)
                .beginObject("address")
                .add("streetAddress", "21 2nd Street")
                .add("city", "New York")
                .add("state", "NY")
                .add("postalCode", "10021")
                .endObject()
                .beginArray("phoneNumber")
                .beginObject()
                .add("type", "home")
                .add("number", "212 555-1234")
                .endObject()
                .beginObject()
                .add("type", "home")
                .add("number", "646 555-4567")
                .endObject()
                .endArray()
                .endObject()
                .build();

        System.out.println(value.getNames());
    }
}
