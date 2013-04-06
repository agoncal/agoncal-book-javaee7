package org.agoncal.book.javaee7.chapter02.ex16;

import javax.inject.Inject;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class BookService16 {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Inject @ThirteenDigits16
  private NumberGenerator16 numberGenerator;

  // ======================================
  // =          Business methods          =
  // ======================================

  public Book16 createBook(String title, Float price, String description) {
    Book16 book = new Book16(title, price, description);
    book.setIsbn(numberGenerator.generateNumber());
    return book;
  }
}
