package org.agoncal.book.javaee7.chapter05.ex39;

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
public class Customer39IT extends AbstractPersistentTest {

  // ======================================
  // =              Unit tests            =
  // ======================================

  @Test
  public void shouldCreateACustomerWithOneAddress() throws Exception {

    Customer39 customer = new Customer39("John", "Smith", "jsmith@gmail.com", "1234565");
    Address39 address = new Address39("65B Ritherdon Rd", "At James place", "London", "LDN", "7QE554", "UK");
    customer.setAddress(address);
    tx.begin();
    em.persist(customer);
    em.persist(address);
    tx.commit();
    assertNotNull("ID should not be null", customer.getId());

    customer = em.find(Customer39.class, customer.getId());
    assertNotNull("Address should not be null", customer.getAddress());
  }
}