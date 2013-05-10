package org.agoncal.book.javaee7.chapter09.ex07;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Transactional
public class ItemService07 {

  // ======================================
  // =             Attributes             =
  // ======================================

  @PersistenceContext(unitName = "chapter09PU")
  private EntityManager em;
  @Inject
  private InventoryService07 inventory;

  // ======================================
  // =           Public Methods           =
  // ======================================

  public List<Book07> findBooks() {
    TypedQuery<Book07> query = em.createNamedQuery(Book07.FIND_ALL, Book07.class);
    return query.getResultList();
  }

  public List<CD07> findCDs() {
    TypedQuery<CD07> query = em.createNamedQuery(CD07.FIND_ALL, CD07.class);
    return query.getResultList();
  }

  public Book07 findBookById(Long id) {
    return em.find(Book07.class, id);
  }

  public CD07 findCDById(Long id) {
    return em.find(CD07.class, id);
  }

  //@TransactionAttribute(TransactionAttributeType.REQUIRED)
  public Book07 createBook(Book07 book) {
    em.persist(book);
    inventory.addItem(book);
    return book;
  }

  public CD07 createCD(CD07 cd) {
    em.persist(cd);
    inventory.addItem(cd);
    return cd;
  }

  public void deleteBook(Book07 book) {
    em.remove(em.merge(book));
  }

  public void deleteCD(CD07 cd) {
    em.remove(em.merge(cd));
  }

  public Book07 updateBook(Book07 book) {
    return em.merge(book);
  }

  public CD07 updateCD(CD07 cd) {
    return em.merge(cd);
  }
}