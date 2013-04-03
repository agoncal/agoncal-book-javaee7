package org.agoncal.book.javaee7.chapter02.ex10;

import javax.inject.Inject;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class BookOddService10 {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Inject
  @NumberOfDigits10(value = Digits.THIRTEEN, odd = true)
  private NumberGenerator10 numberGenerator;

  // ======================================
  // =          Business methods          =
  // ======================================

  public Book10 createBook(String title, Float price, String description) {
    Book10 book = new Book10(title, price, description);
    book.setIsbn(numberGenerator.generateNumber());
    return book;
  }
}
