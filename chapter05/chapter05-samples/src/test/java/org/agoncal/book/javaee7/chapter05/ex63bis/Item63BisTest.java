package org.agoncal.book.javaee7.chapter05.ex63bis;

import org.agoncal.book.javaee7.chapter05.AbstractPersistentTest;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class Item63BisTest extends AbstractPersistentTest {

  // ======================================
  // =              Unit tests            =
  // ======================================
  @Test
  public void shouldCreateABook() throws Exception {

    Book63Bis book = new Book63Bis("H2G2", 21f, "Best IT book", "123-456-789", "Pinguin", 321, false);
    tx.begin();
    em.persist(book);
    tx.commit();
    assertNotNull("Book ID should not be null", book.getId());
  }
}