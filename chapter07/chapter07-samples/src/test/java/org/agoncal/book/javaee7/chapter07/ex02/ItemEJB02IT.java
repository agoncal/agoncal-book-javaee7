package org.agoncal.book.javaee7.chapter07.ex02;

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
public class ItemEJB02IT {

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
    Book02 book = new Book02();
    book.setTitle("The Hitchhiker's Guide to the Galaxy");
    book.setPrice(12.5F);
    book.setDescription("Science fiction comedy book");
    book.setIsbn("1-84023-742-2");
    book.setNbOfPage(354);
    book.setIllustrations(false);

    // Check JNDI dependencies
    assertNotNull(ctx.lookup("java:global/classes/ItemEJB02!org.agoncal.book.javaee7.chapter07.ex02.ItemRemote02"));
    assertNotNull(ctx.lookup("java:global/classes/ItemEJB02!org.agoncal.book.javaee7.chapter07.ex02.ItemLocal02"));
    assertNotNull(ctx.lookup("java:global/classes/ItemEJB02!org.agoncal.book.javaee7.chapter07.ex02.ItemEJB02"));


    // Looks up the EJB with the no-interface view
    ItemEJB02 itemEJB = (ItemEJB02) ctx.lookup("java:global/classes/ItemEJB02!org.agoncal.book.javaee7.chapter07.ex02.ItemEJB02");

    // Persists the book to the database
    book = itemEJB.createBook(book);
    assertNotNull("Book should not be null", book);

    // Retrieves all the books from the database
    assertNotNull(itemEJB.findBooks());


    // Looks up the EJB with the local interface
    ItemLocal02 itemLocal = (ItemLocal02) ctx.lookup("java:global/classes/ItemEJB02!org.agoncal.book.javaee7.chapter07.ex02.ItemLocal02");

    // Retrieves all the books from the database
    assertNotNull(itemLocal.findBooks());


    // Looks up the EJB with the remote interface
    ItemRemote02 itemRemote = (ItemRemote02) ctx.lookup("java:global/classes/ItemEJB02!org.agoncal.book.javaee7.chapter07.ex02.ItemRemote02");

    // Persists the book to the database
    book.setId(null);
    book = itemRemote.createBook(book);
    assertNotNull("Book should not be null", book);

    // Retrieves all the books from the database
    assertNotNull(itemRemote.findBooks());
  }
}