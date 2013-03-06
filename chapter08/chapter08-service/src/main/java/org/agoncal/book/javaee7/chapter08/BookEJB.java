package org.agoncal.book.javaee7.chapter08;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.validation.constraints.NotNull;
import java.util.List;

import static org.agoncal.book.javaee7.chapter08.Book.FIND_ALL;

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

  @Inject
  private EntityManager em;

  // ======================================
  // =           Public Methods           =
  // ======================================

  public List<Book> findBooks() {
    TypedQuery<Book> query = em.createNamedQuery(FIND_ALL, Book.class);
    return query.getResultList();
  }

  public
  @NotNull
  Book createBook(@NotNull Book book) {
    em.persist(book);
    return book;
  }

  public
  @NotNull
  Book updateBook(@NotNull Book book) {
    return em.merge(book);
  }

  public void deleteBook(@NotNull Book book) {
    em.remove(em.merge(book));
  }
}