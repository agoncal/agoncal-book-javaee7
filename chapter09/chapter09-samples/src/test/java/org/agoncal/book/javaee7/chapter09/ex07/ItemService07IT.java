package org.agoncal.book.javaee7.chapter09.ex07;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import java.io.File;
import java.util.HashMap;
import java.util.List;
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
public class ItemService07IT {

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
    Book07 book = new Book07();
    book.setTitle("The Hitchhiker's Guide to the Galaxy");
    book.setPrice(12.5F);
    book.setDescription("Science fiction comedy book");
    book.setIsbn("1-84023-742-2");
    book.setNbOfPage(354);
    book.setIllustrations(false);

    // Looks up the EJB
    ItemService07 itemService = (ItemService07) ctx.lookup("java:global/classes/ItemService07!org.agoncal.book.javaee7.chapter09.ex07.ItemService07");

    // Persists the book to the database
    book = itemService.createBook(book);
    assertNotNull("ID should not be null", book.getId());
    assertNotNull("Book should have been found", itemService.findBookById(book.getId()));
    assertEquals("Item in stock should be one", new Integer(1), book.getAvailableInStock());

    // Retrieves all the books from the database
    List<Book07> books = itemService.findBooks();
    assertNotNull(books);
  }

  @Test
  public void shouldCreateACD() throws Exception {

    // Creates an instance of CD07
    CD07 cd = new CD07();
    cd.setTitle("Zoot Allure");
    cd.setPrice(23f);
    cd.setDescription("Another Zappa's master piece");
    cd.setMusicCompany("Zappa Corp.");
    cd.setNumberOfCDs(1);
    cd.setTotalDuration(65f);
    cd.setGenre("Rock");

    // Looks up the Service
    ItemService07 itemService = (ItemService07) ctx.lookup("java:global/classes/ItemService07!org.agoncal.book.javaee7.chapter09.ex07.ItemService07");

    // Persists the book to the database
    cd = itemService.createCD(cd);
    assertNotNull("ID should not be null", cd.getId());
    assertNotNull("CD should have been found", itemService.findCDById(cd.getId()));
    assertEquals("Item in stock should be one", new Integer(1), cd.getAvailableInStock());

    // Retrieves all the books from the database
    List<CD07> cds = itemService.findCDs();
    assertNotNull(cds);
  }
}