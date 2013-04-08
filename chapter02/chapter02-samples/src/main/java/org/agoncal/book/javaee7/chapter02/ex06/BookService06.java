package org.agoncal.book.javaee7.chapter02.ex06;

import javax.enterprise.inject.Default;
import javax.inject.Inject;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class BookService06 {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Inject
  @Default
  private NumberGenerator06 numberGenerator;

  // ======================================
  // =          Business methods          =
  // ======================================

  public Book06 createBook(String title, Float price, String description) {
    Book06 book = new Book06(title, price, description);
    book.setIsbn(numberGenerator.generateNumber());
    return book;
  }
}
