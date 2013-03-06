package org.agoncal.book.javaee7.chapter10.ex06;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Stateless
public class BookEJB {

  // ======================================
  // =             Attributes             =
  // ======================================

  @PersistenceContext(unitName = "chapter10PU")
  private EntityManager em;

  // ======================================
  // =           Public Methods           =
  // ======================================

  public List<Book> findBooks() {
    TypedQuery<Book> query = em.createNamedQuery("findAllBooks", Book.class);
    return query.getResultList();
  }

  public Book createBook(Book book) {
    em.persist(book);
    return book;
  }
}