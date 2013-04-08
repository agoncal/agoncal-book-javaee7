package org.agoncal.book.javaee7.chapter02.ex14;

import javax.inject.Inject;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class BookService14 {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Inject
  private NumberGenerator14 numberGenerator;

  // ======================================
  // =          Business methods          =
  // ======================================

  public Book14 createBook(String title, Float price, String description) {
    Book14 book = new Book14(title, price, description);
    book.setIsbn(numberGenerator.generateNumber());
    return book;
  }
}
