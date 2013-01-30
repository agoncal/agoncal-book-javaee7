package org.agoncal.book.javaee7.chapter05.ex14;

import org.agoncal.book.javaee7.chapter05.AbstractPersistentTest;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertNotNull;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class Customer14IT extends AbstractPersistentTest {

  // ======================================
  // =              Unit tests            =
  // ======================================
  @Test
  public void shoulCreateACustomer() throws Exception {

    Customer14 customer = new Customer14("John", "Smith", "jsmith@gmail.com", "1234565", new Date(), new Date());
    tx.begin();
    em.persist(customer);
    tx.commit();
    assertNotNull("ID should not be null", customer.getId());
  }
}