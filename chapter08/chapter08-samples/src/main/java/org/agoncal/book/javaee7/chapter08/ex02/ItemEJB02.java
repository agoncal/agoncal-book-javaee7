package org.agoncal.book.javaee7.chapter08.ex02;

import javax.annotation.Resource;
import javax.ejb.*;
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
@LocalBean
@Local(ItemLocal02.class)
@Remote(ItemRemote02.class)
public class ItemEJB02 implements ItemLocal02, ItemRemote02 {

  // ======================================
  // =             Attributes             =
  // ======================================

  @PersistenceContext(unitName = "chapter08PU")
  private EntityManager em;

  @Resource
  private SessionContext ctx;

  // ======================================
  // =           Public Methods           =
  // ======================================

  public String sayHello() {
// OK        WorldEJB09 worldEJB = (WorldEJB09) ctx.lookup("java:global/chapter07-2.0/WorldEJB09!org.agoncal.book.javaee6.chapter07.ex09.WorldEJB09");
// OK        WorldEJB09 worldEJB = (WorldEJB09) ctx.lookup("java:global/chapter07-2.0/WorldEJB09");
// OK        WorldEJB09 worldEJB = (WorldEJB09) ctx.lookup("java:app/chapter07-2.0/WorldEJB09!org.agoncal.book.javaee6.chapter07.ex09.WorldEJB09");
// OK        WorldEJB09 worldEJB = (WorldEJB09) ctx.lookup("java:app/chapter07-2.0/WorldEJB09");
// OK        WorldEJB09 worldEJB = (WorldEJB09) ctx.lookup("java:module/WorldEJB09!org.agoncal.book.javaee6.chapter07.ex09.WorldEJB09");

    WorldEJB02 worldEJB = (WorldEJB02) ctx.lookup("java:module/WorldEJB09");
    return "Hello " + worldEJB.sayWorld();
  }

  public List<Book02> findBooks() {
    Query query = em.createNamedQuery("Book09.findAllBooks");
    return query.getResultList();
  }

  public List<CD02> findCDs() {
    Query query = em.createNamedQuery("CD09.findAllCDs");
    return query.getResultList();
  }

  public Book02 findBookById(Long id) {
    return em.find(Book02.class, id);
  }

  public CD02 findCDById(Long id) {
    return em.find(CD02.class, id);
  }

  public Book02 createBook(Book02 book) {
    em.persist(book);
    return book;
  }

  public CD02 createCD(CD02 cd) {
    em.persist(cd);
    return cd;
  }

  public void deleteBook(Book02 book) {
    em.remove(em.merge(book));
  }

  public void deleteCD(CD02 cd) {
    em.remove(em.merge(cd));
  }

  public Book02 updateBook(Book02 book) {
    return em.merge(book);
  }

  public CD02 updateCD(CD02 cd) {
    return em.merge(cd);
  }
}