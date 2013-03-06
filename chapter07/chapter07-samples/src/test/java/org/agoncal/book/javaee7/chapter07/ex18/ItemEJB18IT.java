package org.agoncal.book.javaee7.chapter07.ex18;

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
public class ItemEJB18IT {

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
    Map<String, Object> properties = new HashMap<String, Object>();
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
  public void shouldConvertTheFixedPriceOfAnItem() throws Exception {

    // Creates an instance of an item
    Item18 item = new Item18();
    item.setTitle("The Hitchhiker's Guide to the Galaxy");
    item.setPrice(12.5F);
    item.setIsbn("1-84023-742-2");
    item.setNbOfPage(354);
    item.setIllustrations(false);

    // Check JNDI dependencies
    assertNotNull(ctx.lookup("java:global/classes/ItemEJB18!org.agoncal.book.javaee7.chapter07.ex18.ItemEJB18"));
    assertNotNull(ctx.lookup("java:global/classes/ItemEJB18"));

    // Looks up the EJB with the no-interface view
    ItemEJB18 itemEJB = (ItemEJB18) ctx.lookup("java:global/classes/ItemEJB18");

    // Persists the book to the database
    item = itemEJB.convertFixedPrice(item);
    assertEquals("The currency should be euros", "Euros", item.getCurrency());
    assertEquals("Price should be 12.5 * 0.8", new Float(10), item.getPrice());
  }

  @Test
  public void shouldConvertThePriceOfAnItem() throws Exception {

    // Creates an instance of an item
    Item18 item = new Item18();
    item.setTitle("The Hitchhiker's Guide to the Galaxy");
    item.setPrice(12.5F);
    item.setIsbn("1-84023-742-2");
    item.setNbOfPage(354);
    item.setIllustrations(false);

    // Check JNDI dependencies
    assertNotNull(ctx.lookup("java:global/classes/ItemEJB18!org.agoncal.book.javaee7.chapter07.ex18.ItemEJB18"));
    assertNotNull(ctx.lookup("java:global/classes/ItemEJB18"));

    // Looks up the EJB with the no-interface view
    ItemEJB18 itemEJB = (ItemEJB18) ctx.lookup("java:global/classes/ItemEJB18");

    // Persists the book to the database
    item = itemEJB.convertPrice(item);
    assertEquals("The currency should be dollars from the ejb-jar.xml", "Dollars", item.getCurrency());
    assertEquals("Price should be 12.5 * 0.9", new Float(11.25), item.getPrice());
  }
}