package org.agoncal.book.javaee7.chapter12.ex05;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class DomParsing05Test {

  @Test
  public void shouldParseOrderLines() throws Exception {
    List<OrderLine05> parseOrderLines = new DomParsing05().parseOrderLines();
    assertEquals(2, parseOrderLines.size());
    OrderLine05 orderLine = parseOrderLines.get(0);
    assertEquals("H2G2", orderLine.getItem());
    assertEquals((Integer) 1, orderLine.getQuantity());
    assertEquals((Double) 23.5, orderLine.getUnitPrice());
    orderLine = parseOrderLines.get(1);
    assertEquals("Harry Potter", orderLine.getItem());
    assertEquals((Integer) 2, orderLine.getQuantity());
    assertEquals((Double) 34.99, orderLine.getUnitPrice());
  }
}
