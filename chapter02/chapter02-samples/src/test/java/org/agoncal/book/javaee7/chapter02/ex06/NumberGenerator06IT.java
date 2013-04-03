package org.agoncal.book.javaee7.chapter02.ex06;

import org.agoncal.book.javaee7.chapter02.ex06.Book06;
import org.agoncal.book.javaee7.chapter02.ex06.BookService06;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class NumberGenerator06IT {

  // ======================================
  // =             Attributes             =
  // ======================================

  protected static Weld weld;
  protected static WeldContainer container;

  // ======================================
  // =          Lifecycle Methods         =
  // ======================================

  @BeforeClass
  public static void init() {
    weld = new Weld();
    container = weld.initialize();
  }

  @AfterClass
  public static void close() {
    weld.shutdown();
  }

  // ======================================
  // =              Methods               =
  // ======================================

  @Test
  public void shouldCheckNumberIsThirteenDigits() {
    BookService06 bookService = container.instance().select(BookService06.class).get();
    Book06 book = bookService.createBook("H2G2", 12.5f, "Geeky scifi Book");
    assertTrue(book.getIsbn().startsWith("13"));
  }
}