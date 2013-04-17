package org.agoncal.book.javaee7.chapter12.ex16;

import org.junit.Test;

import java.io.FileNotFoundException;

import static org.junit.Assert.assertEquals;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class OrderJsonParser16Test {

  // ======================================
  // =              Unit tests            =
  // ======================================

  @Test
  public void shouldBuildPurchaseOrder() throws FileNotFoundException {

    assertEquals("j.rorri@me.com", new OrderJsonParser16().parsePurchaseOrderAndReturnEmail().toString());

  }
}