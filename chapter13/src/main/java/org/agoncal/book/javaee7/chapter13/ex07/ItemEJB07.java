package org.agoncal.book.javaee7.chapter13.ex07;

import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Stateless
@RolesAllowed({"user", "employee", "admin"})
public class ItemEJB07 {

    // ======================================
    // =             Attributes             =
    // ======================================

    @PersistenceContext(unitName = "chapter13PU")
    private EntityManager em;

    // ======================================
    // =           Public Methods           =
    // ======================================

    public List<Book07> findBooks() {
        Query query = em.createNamedQuery("findAllBooks");
        return query.getResultList();
    }

    public List<CD07> findCDs() {
        Query query = em.createNamedQuery("findAllCDs");
        return query.getResultList();
    }

    @PermitAll
    public Book07 findBookById(Long id) {
        return em.find(Book07.class, id);
    }

    public CD07 findCDById(Long id) {
        return em.find(CD07.class, id);
    }

    @RolesAllowed({"admin", "employee"})
    public Book07 createBook(Book07 book) {
        em.persist(book);
        return book;
    }

    public CD07 createCD(CD07 cd) {
        em.persist(cd);
        return cd;
    }

    @RolesAllowed("employee")
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

    @DenyAll
    public Book07 findConfidentialBook(Long secureId) {
        return em.find(Book07.class, secureId);
    }

}