package org.agoncal.book.javaee7.chapter07.ex01;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

import static org.agoncal.book.javaee7.chapter07.ex01.Book01.*;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Stateless
public class BookEJB01 {

  // ======================================
  // =             Attributes             =
  // ======================================

  @PersistenceContext(unitName = "chapter07PU")
  private EntityManager em;

  // ======================================
  // =           Public Methods           =
  // ======================================

  public List<Book01> findBooks() {
    TypedQuery<Book01> query = em.createNamedQuery(FIND_ALL, Book01.class);
    return query.getResultList();
  }

  public Book01 findBookById(Long id) {
    return em.find(Book01.class, id);
  }

  public Book01 createBook(Book01 book) {
    em.persist(book);
    return book;
  }

  public void deleteBook(Book01 book) {
    em.remove(em.merge(book));
  }

  public Book01 updateBook(Book01 book) {
    return em.merge(book);
  }
}