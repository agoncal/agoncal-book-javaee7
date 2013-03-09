package org.agoncal.book.javaee7.chapter08.ex01;

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
public class CacheEJB01IT {

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
    assertNotNull(ctx.lookup("java:global/classes/CacheEJB01!org.agoncal.book.javaee7.chapter08.ex01.CacheEJB01"));
    assertNotNull(ctx.lookup("java:global/classes/CacheEJB01"));

    // Looks up the EJB
    CacheEJB01 cacheEJB = (CacheEJB01) ctx.lookup("java:global/classes/CacheEJB01");

    // Checks the content of the cache
    assertEquals("First item in the cache", "First item in the cache", cacheEJB.getFromCache(1L));
    assertEquals("Second item in the cache", "Second item in the cache", cacheEJB.getFromCache(2L));

    // Removes the first item from the cache
    cacheEJB.removeFromCache(1L);
    assertEquals("Cache should have one item", new Integer(1), cacheEJB.getNumberOfItems());
    assertEquals("Second item in the cache", "Second item in the cache", cacheEJB.getFromCache(2L));
  }
}