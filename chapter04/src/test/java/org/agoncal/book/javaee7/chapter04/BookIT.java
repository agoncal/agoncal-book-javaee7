package org.agoncal.book.javaee7.chapter04;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.validation.ConstraintViolationException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class BookIT {

  // ======================================
  // =             Attributes             =
  // ======================================

  private static EntityManagerFactory emf;
  private static EntityManager em;
  private static EntityTransaction tx;

  // ======================================
  // =          Lifecycle Methods         =
  // ======================================

  @BeforeClass
  public static void initEntityManager() throws Exception {
    emf = Persistence.createEntityManagerFactory("chapter04TestPU");
    em = emf.createEntityManager();
  }

  @AfterClass
  public static void closeEntityManager() throws Exception {
    if (em != null) em.close();
    if (emf != null) emf.close();
  }

  @Before
  public void initTransaction() {
    tx = em.getTransaction();
  }

  // ======================================
  // =              Unit tests            =
  // ======================================

  @Test
  public void shouldFindJavaEE7Book() throws Exception {
    Book book = em.find(Book.class, 1001L);
    assertEquals("Beginning Java EE 7", book.getTitle());
  }

  @Test
  public void shouldCreateH2G2Book() throws Exception {

    // Creates an instance of book
    Book book = new Book("H2G2", "The Hitchhiker's Guide to the Galaxy", 12.5F, "1-84023-742-2", 354, false);

    // Persists the book to the database
    tx.begin();
    em.persist(book);
    tx.commit();
    assertNotNull("ID should not be null", book.getId());

    // Retrieves all the books from the database
//    List<Book> books = em.createNamedQuery("findBookH2G2", Book.class).getResultList();
//    assertEquals(2, books.size());
    book = em.createNamedQuery("findBookH2G2", Book.class).getSingleResult();
    assertEquals("The Hitchhiker's Guide to the Galaxy", book.getDescription());
  }

  @Test(expected = ConstraintViolationException.class)
  public void shouldRaiseConstraintViolationCauseNullTitle() {

    Book book = new Book(null, "Null title, should fail", 12.5F, "1-84023-742-2", 354, false);
    em.persist(book);
  }
}
