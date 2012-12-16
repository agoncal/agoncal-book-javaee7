package org.agoncal.book.javaee7.chapter09;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

import static org.agoncal.book.javaee7.chapter09.Book.FIND_ALL;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Stateless
@LocalBean
public class BookEJB implements BookEJBRemote {

  // ======================================
  // =             Attributes             =
  // ======================================

  @PersistenceContext(unitName = "chapter09PU")
  private EntityManager em;

  // ======================================
  // =           Public Methods           =
  // ======================================

  public List<Book> findBooks() {
    TypedQuery<Book> query = em.createNamedQuery(FIND_ALL, Book.class);
    return query.getResultList();
  }

  public Book findBookById(Long id) {
    return em.find(Book.class, id);
  }

  public Book createBook(Book book) {
    em.persist(book);
    return book;
  }

  public void deleteBook(Book book) {
    em.remove(em.merge(book));
  }

  public Book updateBook(Book book) {
    return em.merge(book);
  }
}