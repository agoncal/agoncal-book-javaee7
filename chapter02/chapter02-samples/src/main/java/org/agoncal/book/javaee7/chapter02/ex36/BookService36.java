package org.agoncal.book.javaee7.chapter02.ex36;

import javax.enterprise.event.Event;
import javax.inject.Inject;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class BookService36 {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Inject
  private NumberGenerator36 numberGenerator;

  @Inject @Added
  private Event<Book36> bookAddedEvent;

  @Inject @Removed
  private Event<Book36> bookRemovedEvent;

  // ======================================
  // =          Business methods          =
  // ======================================

  public Book36 createBook(String title, Float price, String description) {
    Book36 book = new Book36(title, price, description);
    book.setIsbn(numberGenerator.generateNumber());
    bookAddedEvent.fire(book);
    return book;
  }

  public void deleteBook(Book36 book) {
    bookRemovedEvent.fire(book);
  }
}
