package org.agoncal.book.javaee7.chapter07.ex17;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertNotNull;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class ItemEJB17IT {

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
  public void shouldCreateAnItem() throws Exception {

    // Creates an instance of book
    Book17 book = new Book17();
    book.setTitle("The Hitchhiker's Guide to the Galaxy");
    book.setPrice(12.5F);
    book.setDescription("Science fiction comedy book");
    book.setIsbn("1-84173-742-2");
    book.setNbOfPage(354);
    book.setIllustrations(false);

    // Check JNDI dependencies
    assertNotNull(ctx.lookup("java:global/classes/ItemEJB17!org.agoncal.book.javaee7.chapter07.ex17.ItemEJB17"));
    assertNotNull(ctx.lookup("java:global/classes/ItemEJB17!org.agoncal.book.javaee7.chapter07.ex17.ItemRemote17"));
    assertNotNull(ctx.lookup("java:global/classes/ItemEJB17!org.agoncal.book.javaee7.chapter07.ex17.ItemLocal17"));

    // Looks up the EJB with the no-interface view
    ItemEJB17 itemEJB = (ItemEJB17) ctx.lookup("java:global/classes/ItemEJB17!org.agoncal.book.javaee7.chapter07.ex17.ItemEJB17");

    // Persists the book to the database
    book = itemEJB.createBook(book);
    assertNotNull("Book should not be null", book);

    // Retrieves all the books from the database
    assertNotNull(itemEJB.findBooks());
  }
}