package org.agoncal.book.javaee7.chapter02.ex34;

import javax.inject.Inject;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class BookService34 {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Inject
  private NumberGenerator34 numberGenerator;

  // ======================================
  // =          Business methods          =
  // ======================================

  public Book34 createBook(String title, Float price, String description) {
    Book34 book = new Book34(title, price, description);
    book.setIsbn(numberGenerator.generateNumber());
    return book;
  }
}
