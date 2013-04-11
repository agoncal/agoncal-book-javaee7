package org.agoncal.book.javaee7.chapter02.ex22;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Named
public class BookService22 {

  // ======================================
  // =             Attributes             =
  // ======================================

  private String title, description;
  private Float price;
  private Book22 book;

  @Inject
  @ThirteenDigits22
  private NumberGenerator22 numberGenerator;

  // ======================================
  // =          Business methods          =
  // ======================================

  public String createBook() {
    book = new Book22(title, price, description);
    book.setIsbn(numberGenerator.generateNumber());
    return "customer.xhtml";
  }
}
