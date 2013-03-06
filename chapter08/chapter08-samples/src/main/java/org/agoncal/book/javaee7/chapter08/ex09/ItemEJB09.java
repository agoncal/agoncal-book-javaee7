package org.agoncal.book.javaee7.chapter08.ex09;


import javax.annotation.Resource;
import javax.ejb.SessionContext;
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
public class ItemEJB09 {

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

  public List<Book09> findBooks() {
    TypedQuery<Book09> query = em.createNamedQuery("findAllBooks", Book09.class);
    return query.getResultList();
  }

  public List<CD09> findCDs() {
    TypedQuery<CD09> query = em.createNamedQuery("findAllCDs", CD09.class);
    return query.getResultList();
  }

  public Book09 findBookById(Long id) {
    return em.find(Book09.class, id);
  }

  public CD09 findCDById(Long id) {
    return em.find(CD09.class, id);
  }

  public Book09 createBook(Book09 book) {
    if (ctx.isCallerInRole("employee") && !ctx.isCallerInRole("admin")) {
      book.setCreatedBy("employee only");
    } else if (ctx.getCallerPrincipal().getName().equals("paul")) {
      book.setCreatedBy("special user");
    }
    em.persist(book);
    return book;
  }

  public CD09 createCD(CD09 cd) {
    em.persist(cd);
    return cd;
  }

  public void deleteBook(Book09 book) {
    if (!ctx.isCallerInRole("admin"))
      throw new SecurityException("Only admins are allowed");

    em.remove(em.merge(book));
  }

  public void deleteCD(CD09 cd) {
    em.remove(em.merge(cd));
  }

  public Book09 updateBook(Book09 book) {
    return em.merge(book);
  }

  public CD09 updateCD(CD09 cd) {
    return em.merge(cd);
  }
}