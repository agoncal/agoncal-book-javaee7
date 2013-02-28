package org.agoncal.book.javaee7.chapter06.ex34;

import org.agoncal.book.javaee7.chapter06.AbstractPersistentTest;
import org.junit.Test;

import javax.persistence.Cache;

import static org.junit.Assert.*;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class Caching34IT extends AbstractPersistentTest {

  // ======================================
  // =              Unit tests            =
  // ======================================

  @Test
  public void shouldCheckThatAddressIsCacheableEqualsFalse() throws Exception {

    Address34 address = new Address34("Ritherdon Rd", "London", "8QE", "UK");

    // Persist the object
    tx.begin();
    em.persist(address);
    tx.commit();

    assertNotNull(address.getId());

    Cache cache = emf.getCache();

    // Address should not be in the cache
    assertFalse(cache.contains(Address34.class, address.getId()));
  }

  @Test
  public void shouldCheckThatCustomerIsCacheableEqualsTrue() throws Exception {

    Customer34 customer = new Customer34("Antony", "Balla", "tballa@mail.com");

    // Persist the object
    tx.begin();
    em.persist(customer);
    tx.commit();

    assertNotNull(customer.getId());

    Cache cache = emf.getCache();

    // Customer should be in the cache
    assertTrue(cache.contains(Customer34.class, customer.getId()));

    cache.evict(Customer34.class);

    // After clearing the cache Customer should not be in the cache
    assertFalse(cache.contains(Customer34.class, customer.getId()));
  }

  @Test
  public void shouldCheckThatBookIsNotCacheableByDefault() throws Exception {

    Book34 book = new Book34(getRandomId(), "The Hitchhiker's Guide to the Galaxy", 12.5F, "The Hitchhiker's Guide to the Galaxy is a science fiction comedy series created by Douglas Adams.", "1-84023-742-2", 354, false);

    // Persist the object
    tx.begin();
    em.persist(book);
    tx.commit();

    assertNotNull(book.getId());

    Cache cache = emf.getCache();

    // Customer should not be in the cache by default
    assertFalse(cache.contains(Customer34.class, book.getId()));
  }
}