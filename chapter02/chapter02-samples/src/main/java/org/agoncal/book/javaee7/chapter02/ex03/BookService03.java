package org.agoncal.book.javaee7.chapter02.ex03;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class BookService03 {

  // ======================================
  // =             Attributes             =
  // ======================================

  private NumberGenerator03 numberGenerator;

  // ======================================
  // =            Constructors            =
  // ======================================

  public BookService03(NumberGenerator03 numberGenerator) {
    this.numberGenerator = numberGenerator;
  }

  // ======================================
  // =          Business methods          =
  // ======================================

  public Book03 createBook(String title, Float price, String description) {
    Book03 book = new Book03(title, price, description);
    book.setIsbn(numberGenerator.generateNumber());
    return book;
  }
}
