package org.agoncal.book.javaee7.chapter02.ex02;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.Date;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class BookService02 {

  private NumberGenerator02 numberGenerator;

  public Book02 createBook(String title, Float price, String description) {
    Book02 book = new Book02(title, price, description);
    book.setIsbn(numberGenerator.generateNumber());
    return book;
  }
}
