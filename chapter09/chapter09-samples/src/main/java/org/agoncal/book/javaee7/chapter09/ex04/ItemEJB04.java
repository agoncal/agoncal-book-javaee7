package org.agoncal.book.javaee7.chapter09.ex04;

import javax.ejb.EJB;
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
public class ItemEJB04 {

  // ======================================
  // =             Attributes             =
  // ======================================

  @PersistenceContext(unitName = "chapter09PU")
  private EntityManager em;
  @EJB
  private InventoryEJB04 inventory;

  // ======================================
  // =           Public Methods           =
  // ======================================

  public List<Book04> findBooks() {
    TypedQuery<Book04> query = em.createNamedQuery(Book04.FIND_ALL, Book04.class);
    return query.getResultList();
  }

  public List<CD04> findCDs() {
    TypedQuery<CD04> query = em.createNamedQuery(CD04.FIND_ALL, CD04.class);
    return query.getResultList();
  }

  public Book04 findBookById(Long id) {
    return em.find(Book04.class, id);
  }

  public CD04 findCDById(Long id) {
    return em.find(CD04.class, id);
  }

  public Book04 createBook(Book04 book) throws InventoryLevelTooLowException04 {
    em.persist(book);
    inventory.oneItemSold(book);
    return book;
  }

  public CD04 createCD(CD04 cd) throws InventoryLevelTooLowException04 {
    em.persist(cd);
    inventory.oneItemSold(cd);
    return cd;
  }

  public void deleteBook(Book04 book) {
    em.remove(em.merge(book));
  }

  public void deleteCD(CD04 cd) {
    em.remove(em.merge(cd));
  }

  public Book04 updateBook(Book04 book) {
    return em.merge(book);
  }

  public CD04 updateCD(CD04 cd) {
    return em.merge(cd);
  }
}