package org.agoncal.book.javaee7.chapter02.ex12;

import org.agoncal.book.javaee7.chapter02.ex10.Book10;
import org.agoncal.book.javaee7.chapter02.ex10.BookEvenService10;
import org.agoncal.book.javaee7.chapter02.ex10.BookOddService10;
import org.agoncal.book.javaee7.chapter02.ex10.LegacyBookService10;
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
public class NumberGenerator12IT {

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
  public void shouldCheckNumberIsThirteenDigitsOdd() {
    BookOddService10 bookService = container.instance().select(BookOddService10.class).get();
    Book10 book = bookService.createBook("H2G2", 12.5f, "Geeky scifi Book");
    assertTrue(book.getIsbn().startsWith("131"));
  }

  @Test
  public void shouldCheckNumberIsThirteenDigitsEven() {
    BookEvenService10 bookService = container.instance().select(BookEvenService10.class).get();
    Book10 book = bookService.createBook("H2G2", 12.5f, "Geeky scifi Book");
    assertTrue(book.getIsbn().startsWith("132"));
  }

  @Test
  public void shouldCheckNumberIsEightDigits() {
    LegacyBookService10 bookService = container.instance().select(LegacyBookService10.class).get();
    Book10 book = bookService.createBook("H2G2", 12.5f, "Geeky scifi Book");
    assertTrue(book.getIsbn().startsWith("8"));
  }
}