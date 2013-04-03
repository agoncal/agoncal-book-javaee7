package org.agoncal.book.javaee7.chapter02.ex01;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.Vetoed;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Date;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Vetoed
public class BookService01 {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Inject
  private NumberGenerator01 numberGenerator;
  @Inject
  private EntityManager em;

  Date instanciationDate;

  // ======================================
  // =         Lifecycle methods          =
  // ======================================

  @PostConstruct
  private void initDate() {
    instanciationDate = new Date();
  }

  // ======================================
  // =          Business methods          =
  // ======================================

  @Transactional
  public Book01 createBook(String title, Float price, String description) {
    Book01 book = new Book01(title, price, description);
    book.setIsbn(numberGenerator.generateNumber());
    book.setInstanciationDate(instanciationDate);
    em.persist(book);
    return book;
  }
}
