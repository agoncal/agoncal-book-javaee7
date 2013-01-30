package org.agoncal.book.javaee7.chapter05.ex29;

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
public class Customer29IT extends AbstractPersistentTest {

  // ======================================
  // =              Unit tests            =
  // ======================================

  @Test
  public void shouldCreateACustomerWithAnEmbeddedAddress() throws Exception {

    Customer29 customer = new Customer29("John", "Smith", "jsmith@gmail.com", "1234565");
    Address29 address = new Address29("65B Ritherdon Rd", "At James place", "London", "LDN", "7QE554", "UK");
    customer.setAddress(address);
    tx.begin();
    em.persist(customer);
    tx.commit();
    assertNotNull("ID should not be null", customer.getId());
  }
}