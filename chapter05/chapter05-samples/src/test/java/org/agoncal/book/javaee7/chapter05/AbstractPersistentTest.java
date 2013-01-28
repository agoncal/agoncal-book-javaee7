package org.agoncal.book.javaee7.chapter05;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.sql.SQLException;
import java.util.Random;

import static org.agoncal.book.javaee7.chapter05.Constants.PERSISTENCE_UNIT_NAME;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public abstract class AbstractPersistentTest {

  // ======================================
  // =             Attributes             =
  // ======================================

  protected static EntityManagerFactory emf;
  protected static EntityManager em;
  protected static EntityTransaction tx;

  // ======================================
  // =          Lifecycle Methods         =
  // ======================================

  @BeforeClass
  public static void initEntityManager() throws Exception {
    emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
    em = emf.createEntityManager();
  }

  @AfterClass
  public static void closeEntityManager() throws SQLException {
    if (em != null) em.close();
    if (emf != null) emf.close();
  }

  @Before
  public void initTransaction() {
    tx = em.getTransaction();
  }

  protected Long getRandomId() {
    return Math.abs(new Random().nextLong());
  }
}