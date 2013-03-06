package org.agoncal.book.javaee7.chapter11;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import java.util.List;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Named
@Stateless
public class BookEJB {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Inject
  private EntityManager em;

  // ======================================
  // =          Business methods          =
  // ======================================

  public Book createBook(Book book) {
    em.persist(book);
    return book;
  }

  public List<Book> findAllBooks() {
    return em.createNamedQuery("findAllBooks", Book.class).getResultList();
  }

  public Book findBookById(Long id) {
    return em.find(Book.class, id);
  }
}
