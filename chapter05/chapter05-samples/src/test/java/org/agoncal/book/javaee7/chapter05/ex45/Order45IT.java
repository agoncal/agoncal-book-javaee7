package org.agoncal.book.javaee7.chapter05.ex45;

import org.agoncal.book.javaee7.chapter05.AbstractPersistentTest;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class Order45IT extends AbstractPersistentTest {

  // ======================================
  // =              Unit tests            =
  // ======================================
  @Test
  public void shouldCreateAnOrderWithTwoOrderLines() throws Exception {

    Order45 order = new Order45();
    OrderLine45 ol1 = new OrderLine45("H2G2", 12d, 1);
    OrderLine45 ol2 = new OrderLine45("The White Album", 14.5d, 2);
    List<OrderLine45> orderLines = new ArrayList<OrderLine45>();
    orderLines.add(ol1);
    orderLines.add(ol2);
    order.setOrderLines(orderLines);
    tx.begin();
    em.persist(order);
    em.persist(ol1);
    em.persist(ol2);
    tx.commit();
    assertNotNull("Order ID should not be null", order.getId());
    assertNotNull("OL1 ID should not be null", ol1.getId());
    assertNotNull("OL1 ID should not be null", ol2.getId());

    order = em.find(Order45.class, order.getId());
    assertNotNull("OrderLines should not be null", order.getOrderLines());
    assertEquals("Should have 2 order lines", order.getOrderLines().size(), 2);
  }
}