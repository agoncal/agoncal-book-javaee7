package org.agoncal.book.javaee7.chapter02.ex02;

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
public class NumberGenerator02Test {

  // ======================================
  // =              Methods               =
  // ======================================

  @Test
  public void shouldCheckNumberIsThirteenDigits() {

    BookService02 bookService = new BookService02();

    Book02 book = bookService.createBook("H2G2", 12.5f, "Geeky scifi Book");

    assertTrue(book.getIsbn().startsWith("13"));
  }
}