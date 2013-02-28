package org.agoncal.book.javaee7.chapter05.ex11;

import org.agoncal.book.javaee7.chapter05.AbstractPersistentTest;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class Book11IT extends AbstractPersistentTest {

  // ======================================
  // =              Unit tests            =
  // ======================================
  @Test
  public void shouldCreateABook() throws Exception {

    Book11 book = new Book11("The Hitchhiker's Guide to the Galaxy", 12.5F, "The Hitchhiker's Guide to the Galaxy is a science fiction comedy series created by Douglas Adams.", "1-84023-742-2", 354, false);
    tx.begin();
    em.persist(book);
    tx.commit();
    assertNotNull("ID should not be null", book.getId());
  }

  @Test
  @Ignore("updatable = false does not work")
  public void titleShouldNotBeUpdatable() throws Exception {

    Book11 book = new Book11("The Hitchhiker's Guide to the Galaxy", 12.5F, "The Hitchhiker's Guide to the Galaxy is a science fiction comedy series created by Douglas Adams.", "1-84023-742-2", 354, false);
    tx.begin();
    em.persist(book);
    tx.commit();
    assertNotNull("ID should not be null", book.getId());
    assertEquals("Title should be The Hitchhiker's Guide to the Galaxy", "The Hitchhiker's Guide to the Galaxy", book.getTitle());

    tx.begin();
    book = em.find(Book11.class, book.getId());
    assertEquals("Title should be The Hitchhiker's Guide to the Galaxy", "The Hitchhiker's Guide to the Galaxy", book.getTitle());
    book.setTitle("H2G2");
    assertEquals("Title should be H2G2", "H2G2", book.getTitle());
    tx.commit();

    tx.begin();
    book = em.find(Book11.class, book.getId());
    assertEquals("Title should be The Hitchhiker's Guide to the Galaxy", "The Hitchhiker's Guide to the Galaxy", book.getTitle());
    tx.commit();
  }
}