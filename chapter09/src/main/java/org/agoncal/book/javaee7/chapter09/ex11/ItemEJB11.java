package org.agoncal.book.javaee7.chapter09.ex11;


import org.agoncal.book.javaee7.chapter09.ex07.CD07;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
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
public class ItemEJB11 {

  // ======================================
  // =             Attributes             =
  // ======================================

  @PersistenceContext(unitName = "chapter09PU")
  private EntityManager em;
  @Resource
  private SessionContext ctx;

  // ======================================
  // =           Public Methods           =
  // ======================================

  public List<Book11> findBooks() {
    Query query = em.createNamedQuery("findAllBooks");
    return query.getResultList();
  }

  public List<CD07> findCDs() {
    Query query = em.createNamedQuery("findAllCDs");
    return query.getResultList();
  }

  public Book11 findBookById(Long id) {
    return em.find(Book11.class, id);
  }

  public CD11 findCDById(Long id) {
    return em.find(CD11.class, id);
  }

  public Book11 createBook(Book11 book) {
    if (ctx.isCallerInRole("employee") && !ctx.isCallerInRole("admin")) {
      book.setCreatedBy("employee only");
    } else if (ctx.getCallerPrincipal().getName().equals("paul")) {
      book.setCreatedBy("special user");
    }
    em.persist(book);
    return book;
  }

  public CD11 createCD(CD11 cd) {
    em.persist(cd);
    return cd;
  }

  public void deleteBook(Book11 book) {
    if (!ctx.isCallerInRole("admin"))
      throw new SecurityException("Only admins are allowed");

    em.remove(em.merge(book));
  }

  public void deleteCD(CD11 cd) {
    em.remove(em.merge(cd));
  }

  public Book11 updateBook(Book11 book) {
    return em.merge(book);
  }

  public CD11 updateCD(CD11 cd) {
    return em.merge(cd);
  }
}