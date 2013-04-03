package org.agoncal.book.javaee7.chapter02.ex03;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class NumberGenerator03Test {

  // ======================================
  // =              Methods               =
  // ======================================

  @Test
  public void shouldCheckNumberIsThirteenDigits() {
    BookService03 bookService = new BookService03(new IsbnGenerator03());
    Book03 book = bookService.createBook("H2G2", 12.5f, "Geeky scifi Book");
    assertTrue(book.getIsbn().startsWith("13"));
  }

  @Test
  public void shouldCheckNumberIsEightDigits() {
    BookService03 bookService = new BookService03(new IssnGenerator03());
    Book03 book = bookService.createBook("H2G2", 12.5f, "Geeky scifi Book");
    assertTrue(book.getIsbn().startsWith("8"));
  }
}