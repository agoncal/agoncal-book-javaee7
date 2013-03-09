package org.agoncal.book.javaee7.chapter09.ex04;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class ItemEJB04IT {

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
  public void shouldNotCreateABookBecauseOfException() throws Exception {

    // Creates an instance of book
    Book04 book = new Book04();
    book.setTitle("The Hitchhiker's Guide to the Galaxy");
    book.setPrice(12.5F);
    book.setDescription("Science fiction comedy book");
    book.setIsbn("1-84023-742-2");
    book.setNbOfPage(354);
    book.setIllustrations(false);

    // Looks up the EJB
    ItemEJB04 itemEJB = (ItemEJB04) ctx.lookup("java:global/classes/ItemEJB04!org.agoncal.book.javaee7.chapter09.ex04.ItemEJB04");

    // Persists the book to the database
    try {
      book = itemEJB.createBook(book);
      fail();
    } catch (InventoryLevelTooLowException04 e) {
    }
    assertNull("Book should not be found because the create has been rollbacked (exception thrown)", itemEJB.findBookById(book.getId()));

    // Retrieves all the books from the database
    List<Book04> books = itemEJB.findBooks();
    assertNotNull(books);
  }

  @Test
  public void shouldNotCreateACDBecauseOfException() throws Exception {

    // Creates an instance of CD01
    CD04 cd = new CD04();
    cd.setTitle("Zoot Allure");
    cd.setPrice(23f);
    cd.setDescription("Another Zappa's master piece");
    cd.setMusicCompany("Zappa Corp.");
    cd.setNumberOfCDs(1);
    cd.setTotalDuration(65f);
    cd.setGenre("Rock");

    // Looks up the EJB
    ItemEJB04 itemEJB = (ItemEJB04) ctx.lookup("java:global/classes/ItemEJB04!org.agoncal.book.javaee7.chapter09.ex04.ItemEJB04");

    // Persists the book to the database
    try {
      cd = itemEJB.createCD(cd);
      fail();
    } catch (InventoryLevelTooLowException04 e) {
    }
    assertNull("CD should not be found because the create has been rollbacked (setRollbackOnly in InventoryEJB)", itemEJB.findBookById(cd.getId()));

    // Retrieves all the books from the database
    List<CD04> cds = itemEJB.findCDs();
    assertNotNull(cds);
  }
}