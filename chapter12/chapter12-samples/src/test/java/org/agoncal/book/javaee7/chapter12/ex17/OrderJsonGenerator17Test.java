package org.agoncal.book.javaee7.chapter12.ex17;

import org.agoncal.book.javaee7.chapter12.ex15.OrderJsonBuilder15;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class OrderJsonGenerator17Test {

  // ======================================
  // =             Attributes             =
  // ======================================

  public static final String orderJSon = "{\"id\":\"1234\",\"date\":\"05/06/2013\",\"customer\":{\"first_name\":\"James\",\"last_name\":\"Rorrison\",\"email\":\"j.rorri@me.com\",\"phoneNumber\":\"+44 1234 1234\"},\"content\":[{\"item\":\"H2G2\",\"unit_price\":\"23.5\",\"quantity\":\"1\"},{\"item\":\"Harry Potter\",\"unit_price\":\"34.99\",\"quantity\":\"2\"}],\"credit_card\":{\"number\":\"123412341234\",\"expiry_date\":\"10/13\",\"control_number\":\"234\",\"type\":\"Visa\"}}";

  // ======================================
  // =              Unit tests            =
  // ======================================

  @Test
  public void shouldGeneratePurchaseOrder() throws IOException {

    assertEquals(orderJSon, new OrderJsonGenerator17().generatePurchaseOrder().toString());

  }
}