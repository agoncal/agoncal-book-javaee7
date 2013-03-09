package org.agoncal.book.javaee7.chapter09.ex01;

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
//@TransactionAttribute(TransactionAttributeType.SUPPORTS)
public class ItemEJB01 {

  // ======================================
  // =             Attributes             =
  // ======================================

  @PersistenceContext(unitName = "chapter09PU")
  private EntityManager em;
  @EJB
  private InventoryEJB01 inventory;

  // ======================================
  // =           Public Methods           =
  // ======================================

  public List<Book01> findBooks() {
    TypedQuery<Book01> query = em.createNamedQuery(Book01.FIND_ALL, Book01.class);
    return query.getResultList();
  }

  public List<CD01> findCDs() {
    TypedQuery<CD01> query = em.createNamedQuery(CD01.FIND_ALL, CD01.class);
    return query.getResultList();
  }

  public Book01 findBookById(Long id) {
    return em.find(Book01.class, id);
  }

  public CD01 findCDById(Long id) {
    return em.find(CD01.class, id);
  }

  //@TransactionAttribute(TransactionAttributeType.REQUIRED)
  public Book01 createBook(Book01 book) {
    em.persist(book);
    inventory.addItem(book);
    return book;
  }

  public CD01 createCD(CD01 cd) {
    em.persist(cd);
    inventory.addItem(cd);
    return cd;
  }

  public void deleteBook(Book01 book) {
    em.remove(em.merge(book));
  }

  public void deleteCD(CD01 cd) {
    em.remove(em.merge(cd));
  }

  public Book01 updateBook(Book01 book) {
    return em.merge(book);
  }

  public CD01 updateCD(CD01 cd) {
    return em.merge(cd);
  }
}