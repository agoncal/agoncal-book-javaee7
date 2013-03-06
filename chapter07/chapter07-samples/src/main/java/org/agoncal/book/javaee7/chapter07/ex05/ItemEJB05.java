package org.agoncal.book.javaee7.chapter07.ex05;

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
public class ItemEJB05 {

  // ======================================
  // =             Attributes             =
  // ======================================

  @PersistenceContext(unitName = "chapter07PU")
  private EntityManager em;

  // ======================================
  // =           Public Methods           =
  // ======================================

  public List<Book05> findBooks() {
    TypedQuery<Book05> query = em.createNamedQuery(Book05.FIND_ALL, Book05.class);
    return query.getResultList();
  }

  public List<CD05> findCDs() {
    TypedQuery<CD05> query = em.createNamedQuery(CD05.FIND_ALL, CD05.class);
    return query.getResultList();
  }

  public Book05 createBook(Book05 book) {
    em.persist(book);
    return book;
  }

  public CD05 createCD(CD05 cd) {
    em.persist(cd);
    return cd;
  }
}