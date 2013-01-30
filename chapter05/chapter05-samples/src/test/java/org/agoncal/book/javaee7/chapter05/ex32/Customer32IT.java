package org.agoncal.book.javaee7.chapter05.ex32;

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
public class Customer32IT extends AbstractPersistentTest {

  // ======================================
  // =              Unit tests            =
  // ======================================
  @Test
  public void shouldCreateACustomerWithAnEmbeddedAddress() throws Exception {

    Customer32 customer = new Customer32("John", "Smith", "jsmith@gmail.com", "1234565");
    Address32 address = new Address32("65B Ritherdon Rd", "At James place", "London", "LDN", "7QE554", "UK");
    customer.setAddress(address);
    tx.begin();
    em.persist(customer);
    tx.commit();
    assertNotNull("ID should not be null", customer.getId());
  }
}