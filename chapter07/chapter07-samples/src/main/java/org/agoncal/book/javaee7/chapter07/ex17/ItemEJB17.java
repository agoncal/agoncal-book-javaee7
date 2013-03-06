package org.agoncal.book.javaee7.chapter07.ex17;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

import static org.agoncal.book.javaee7.chapter07.ex17.Book17.FIND_ALL;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Stateless
@LocalBean
public class ItemEJB17 implements ItemLocal17, ItemRemote17 {

  // ======================================
  // =             Attributes             =
  // ======================================

  @PersistenceContext(unitName = "chapter07PU")
  private EntityManager em;

  // ======================================
  // =           Public Methods           =
  // ======================================

  public List<Book17> findBooks() {
    TypedQuery<Book17> query = em.createNamedQuery(FIND_ALL, Book17.class);
    return query.getResultList();
  }

  public Book17 createBook(Book17 book) {
    em.persist(book);
    return book;
  }
}