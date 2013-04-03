package org.agoncal.book.javaee7.chapter02.ex04;

import javax.inject.Inject;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class BookService04 {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Inject
  private NumberGenerator04 numberGenerator;

  // ======================================
  // =          Business methods          =
  // ======================================

  public Book04 createBook(String title, Float price, String description) {
    Book04 book = new Book04(title, price, description);
    book.setIsbn(numberGenerator.generateNumber());
    return book;
  }
}
