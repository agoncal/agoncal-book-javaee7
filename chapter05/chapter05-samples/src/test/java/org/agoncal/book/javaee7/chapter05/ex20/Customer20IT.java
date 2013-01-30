package org.agoncal.book.javaee7.chapter05.ex20;

import org.agoncal.book.javaee7.chapter05.AbstractPersistentTest;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class Customer20IT extends AbstractPersistentTest {

  // ======================================
  // =              Unit tests            =
  // ======================================

  @Test
  public void shouldCreateACustomer() throws Exception {

    Customer20 customer = new Customer20("John", "Smith", "jsmith@gmail.com", "1234565");
    tx.begin();
    em.persist(customer);
    tx.commit();
    assertNotNull("ID should not be null", customer.getId());
  }
}