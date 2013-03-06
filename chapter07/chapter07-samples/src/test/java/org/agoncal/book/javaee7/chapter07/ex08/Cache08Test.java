package org.agoncal.book.javaee7.chapter07.ex08;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class Cache08Test {

  // ======================================
  // =              Unit tests            =
  // ======================================

  @Test
  public void shouldAddRemoveAndGetThingsFromTheCache() throws Exception {

    Cache08 cache = Cache08.getInstance();

    // Checks the cache is empty
    assertEquals("Cache should have no items", new Integer(0), cache.getNumberOfItems());

    // Adds one item to the cache
    cache.addToCache(1L, "First item in the cache");
    assertEquals("Cache should have one item", new Integer(1), cache.getNumberOfItems());
    assertEquals("First item in the cache", "First item in the cache", cache.getFromCache(1L));

    // Adds another item to the cache
    cache.addToCache(2L, "Second item in the cache");
    assertEquals("Cache should have two items", new Integer(2), cache.getNumberOfItems());
    assertEquals("Second item in the cache", "Second item in the cache", cache.getFromCache(2L));

    // Removes the first item from the cache
    cache.removeFromCache(1L);
    assertEquals("Cache should have one item", new Integer(1), cache.getNumberOfItems());
    assertEquals("Second item in the cache", "Second item in the cache", cache.getFromCache(2L));
  }
}