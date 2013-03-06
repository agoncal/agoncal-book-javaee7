package org.agoncal.book.javaee7.chapter07.ex02;

import javax.ejb.*;
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
@LocalBean
//@Local(ItemLocal02.class)
//@Remote(ItemRemote02.class)
public class ItemEJB02 implements ItemLocal02, ItemRemote02 {

  // ======================================
  // =             Attributes             =
  // ======================================

  @PersistenceContext(unitName = "chapter07PU")
  private EntityManager em;

  // ======================================
  // =           Public Methods           =
  // ======================================

  public List<Book02> findBooks() {
    TypedQuery<Book02> query = em.createNamedQuery(Book02.FIND_ALL, Book02.class);
    return query.getResultList();
  }

  public List<CD02> findCDs() {
    TypedQuery<CD02> query = em.createNamedQuery(CD02.FIND_ALL, CD02.class);
    return query.getResultList();
  }

  public Book02 createBook(Book02 book) {
    em.persist(book);
    return book;
  }

  public CD02 createCD(CD02 cd) {
    em.persist(cd);
    return cd;
  }
}