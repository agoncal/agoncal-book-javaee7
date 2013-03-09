package org.agoncal.book.javaee7.chapter09.ex03;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Stateless
//@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class ItemEJB03 {

  // ======================================
  // =             Attributes             =
  // ======================================

  @PersistenceContext(unitName = "chapter09PU")
  private EntityManager em;
  @EJB
  private InventoryEJB03 inventory;

  // ======================================
  // =           Public Methods           =
  // ======================================

  public List<Book03> findBooks() {
    Query query = em.createNamedQuery("Book03.findAllBooks");
    return query.getResultList();
  }

  public List<CD03> findCDs() {
    Query query = em.createNamedQuery("CD03.findAllCDs");
    return query.getResultList();
  }

  public Book03 findBookById(Long id) {
    return em.find(Book03.class, id);
  }

  public CD03 findCDById(Long id) {
    return em.find(CD03.class, id);
  }

  //@TransactionAttribute(TransactionAttributeType.REQUIRED)
  public Book03 createBook(Book03 book) {
    em.persist(book);
    inventory.oneItemSold(book);
    return book;
  }

  public CD03 createCD(CD03 cd) {
    em.persist(cd);
    inventory.oneItemSold(cd);
    return cd;
  }

  public void deleteBook(Book03 book) {
    em.remove(em.merge(book));
  }

  public void deleteCD(CD03 cd) {
    em.remove(em.merge(cd));
  }

  public Book03 updateBook(Book03 book) {
    return em.merge(book);
  }

  public CD03 updateCD(CD03 cd) {
    return em.merge(cd);
  }
}