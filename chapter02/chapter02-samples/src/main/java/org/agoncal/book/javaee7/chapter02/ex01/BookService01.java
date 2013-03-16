package org.agoncal.book.javaee7.chapter02.ex01;

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
public class BookService01 {

  @Inject
  private NumberGenerator01 numberGenerator;

  Date instanciationDate;

  @PostConstruct
  private void initDate() {
    instanciationDate = new Date();
  }

  @Transactional
  public Book01 createBook(String title, Float price, String description) {
    Book01 book = new Book01(title, price, description);
    book.setIsbn(numberGenerator.generateNumber());
    book.setInstanciationDate(instanciationDate);
    return book;
  }
}
