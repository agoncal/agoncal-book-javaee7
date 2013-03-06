package org.agoncal.book.javaee7.chapter08.ex05;

import javax.annotation.security.DeclareRoles;
import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
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
@DeclareRoles({"HR", "salesDpt"})
@RolesAllowed({"user", "employee", "admin"})
public class ItemEJB05 {

  // ======================================
  // =             Attributes             =
  // ======================================

  @PersistenceContext(unitName = "chapter08PU")
  private EntityManager em;

  // ======================================
  // =           Public Methods           =
  // ======================================

  public List<Book05> findBooks() {
    TypedQuery<Book05> query = em.createNamedQuery("findAllBooks", Book05.class);
    return query.getResultList();
  }

  public List<CD05> findCDs() {
    TypedQuery<CD05> query = em.createNamedQuery("findAllCDs", CD05.class);
    return query.getResultList();
  }

  @PermitAll
  public Book05 findBookById(Long id) {
    return em.find(Book05.class, id);
  }

  public CD05 findCDById(Long id) {
    return em.find(CD05.class, id);
  }

  @RolesAllowed({"admin", "employee"})
  public Book05 createBook(Book05 book) {
    em.persist(book);
    return book;
  }

  public CD05 createCD(CD05 cd) {
    em.persist(cd);
    return cd;
  }

  @RolesAllowed("admin")
  public void deleteBook(Book05 book) {
    em.remove(em.merge(book));
  }

  public void deleteCD(CD05 cd) {
    em.remove(em.merge(cd));
  }

  public Book05 updateBook(Book05 book) {
    return em.merge(book);
  }

  public CD05 updateCD(CD05 cd) {
    return em.merge(cd);
  }

  @DenyAll
  public Book05 findConfidentialBook(Long secureId) {
    return em.find(Book05.class, secureId);
  }
}