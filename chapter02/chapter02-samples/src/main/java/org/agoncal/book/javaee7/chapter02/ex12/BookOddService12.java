package org.agoncal.book.javaee7.chapter02.ex12;

import javax.inject.Inject;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class BookOddService12 {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Inject
  @ThirteenDigits12
  @Odd12
  private NumberGenerator12 numberGenerator;

  // ======================================
  // =          Business methods          =
  // ======================================

  public Book12 createBook(String title, Float price, String description) {
    Book12 book = new Book12(title, price, description);
    book.setIsbn(numberGenerator.generateNumber());
    return book;
  }
}
