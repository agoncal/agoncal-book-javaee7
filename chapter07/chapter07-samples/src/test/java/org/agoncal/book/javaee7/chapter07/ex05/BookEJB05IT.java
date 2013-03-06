package org.agoncal.book.javaee7.chapter07.ex05;

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
public class BookEJB05IT {

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
  public void shouldCreateABook() throws Exception {

    // Creates an instance of book
    Book05 book = new Book05();
    book.setTitle("The Hitchhiker's Guide to the Galaxy");
    book.setPrice(12.5F);
    book.setDescription("Science fiction comedy book");
    book.setIsbn("1-84023-742-2");
    book.setNbOfPage(354);
    book.setIllustrations(false);

    // Check JNDI dependencies
    assertNotNull(ctx.lookup("java:global/classes/ItemEJB05!org.agoncal.book.javaee7.chapter07.ex05.ItemEJB05"));
    assertNotNull(ctx.lookup("java:global/classes/ItemEJB05"));

    // Looks up the EJB
    ItemEJB05 bookEJB = (ItemEJB05) ctx.lookup("java:global/classes/ItemEJB05!org.agoncal.book.javaee7.chapter07.ex05.ItemEJB05");

    // Persists the book to the database
    book = bookEJB.createBook(book);
    assertNotNull("ID should not be null", book.getId());

    // Retrieves all the books from the database
    assertNotNull(bookEJB.findBooks());
  }
}