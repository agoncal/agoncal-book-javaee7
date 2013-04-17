package org.agoncal.book.javaee7.chapter12.ex16;

import javax.json.Json;
import javax.json.stream.JsonParser;
import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class OrderJsonParser16 {
  public static void main(String[] args) throws FileNotFoundException {
    System.out.println(new OrderJsonParser16().parsePurchaseOrderAndReturnEmail());
  }

  public String parsePurchaseOrderAndReturnEmail() throws FileNotFoundException {
    String email = null;

    JsonParser parser = Json.createParser(new FileReader("src/main/resources/order.json"));
    while (parser.hasNext()) {
      JsonParser.Event event = parser.next();
      while (parser.hasNext() && !(event.equals(JsonParser.Event.KEY_NAME) && parser.getString().matches("email"))) {
        event = parser.next();
      }

      if (event.equals(JsonParser.Event.KEY_NAME) && parser.getString().matches("email")) {
        parser.next();
        email = parser.getString();
      }
    }
    return email;
  }
}
