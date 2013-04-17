package org.agoncal.book.javaee7.chapter12.ex15;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class OrderJsonBuilder15Test {

  // ======================================
  // =             Attributes             =
  // ======================================

  public static final String orderJSon = "{\"order\":{\"@id\":\"1234\",\"@date\":\"05/06/2013\",\"customer\":{\"@first_name\":\"James\",\"@last_name\":\"Rorrison\",\"email\":\"j.rorri@me.com\",\"phoneNumber\":\"+44 1234 1234\"},\"content\":{\"order_line\":[{\"@item\":\"H2G2\",\"@quantity\":\"1\",\"unit_price\":\"23.5\"},{\"@item\":\"Harry Potter\",\"@quantity\":\"2\",\"unit_price\":\"34.99\"}]},\"credit_card\":{\"@number\":\"1357\",\"@expiry_date\":\"10/13\",\"@control_number\":\"234\",\"@type\":\"Visa\"}}}";

  // ======================================
  // =              Unit tests            =
  // ======================================

  @Test
  public void shouldBuildPurchaseOrder() {

    assertEquals(orderJSon, new OrderJsonBuilder15().buildPurchaseOrder().toString());

  }
}