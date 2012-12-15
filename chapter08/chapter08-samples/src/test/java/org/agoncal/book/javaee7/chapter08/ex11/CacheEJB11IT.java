package org.agoncal.book.javaee7.chapter08.ex11;

import org.agoncal.book.javaee7.chapter08.ex11.CacheEJB11;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class CacheEJB11IT {

  // ======================================
  // =             Attributes             =
  // ======================================

  private static EJBContainer ec;
  private static Context ctx;

  // ======================================
  // =          Lifecycle Methods         =
  // ======================================

  @BeforeClass
  public static void initContainer() throws Exception {
    Map<String, Object> properties = new HashMap<>();
    properties.put(EJBContainer.MODULES, new File("target/classes"));
    ec = EJBContainer.createEJBContainer(properties);
    ctx = ec.getContext();
  }

  @AfterClass
  public static void closeContainer() throws Exception {
    if (ctx != null)
      ctx.close();
    if (ec != null)
      ec.close();
  }

  // ======================================
  // =              Unit tests            =
  // ======================================

  @Test
  public void shouldAddRemoveAndGetThingsFromTheCache() throws Exception {

    // Check JNDI dependencies
    assertNotNull(ctx.lookup("java:global/classes/CacheEJB11!org.agoncal.book.javaee7.chapter08.ex11.CacheEJB11"));
    assertNotNull(ctx.lookup("java:global/classes/CacheEJB11"));

    // Looks up the EJB
    CacheEJB11 cacheEJB = (CacheEJB11) ctx.lookup("java:global/classes/CacheEJB11!org.agoncal.book.javaee7.chapter08.ex11.CacheEJB11");

    // Checks the cache is empty
    assertEquals("Cache should have no items", new Integer(0), cacheEJB.getNumberOfItems());

    // Adds one item to the cache
    cacheEJB.addToCache(1L, "First item in the cache");
    assertEquals("Cache should have one item", new Integer(1), cacheEJB.getNumberOfItems());
    assertEquals("First item in the cache", "First item in the cache", cacheEJB.getFromCache(1L));

    // Adds another item to the cache
    cacheEJB.addToCache(2L, "Second item in the cache");
    assertEquals("Cache should have two items", new Integer(2), cacheEJB.getNumberOfItems());
    assertEquals("Second item in the cache", "Second item in the cache", cacheEJB.getFromCache(2L));

    // Removes the first item from the cache
    cacheEJB.removeFromCache(1L);
    assertEquals("Cache should have one item", new Integer(1), cacheEJB.getNumberOfItems());
    assertEquals("Second item in the cache", "Second item in the cache", cacheEJB.getFromCache(2L));
  }
}