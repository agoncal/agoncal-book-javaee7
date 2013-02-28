package org.agoncal.book.javaee7.chapter05.ex61;

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
public class Item61IT extends AbstractPersistentTest {

  // ======================================
  // =              Unit tests            =
  // ======================================
  @Test
  public void shouldCreateSeveralItems() throws Exception {

    Item61 item = new Item61("Junk", 52.50f, "A piece of junk");
    CD61 cd01 = new CD61("St Pepper", 12.80f, "Beatles master piece", "Apple", 1, 53.32f, "Pop/Rock");
    CD61 cd02 = new CD61("Love SUpreme", 20f, "John Coltrane love moment", "Blue Note", 2, 87.45f, "Jazz");
    Book61 book01 = new Book61("H2G2", 21f, "Best IT book", "123-456-789", "Pinguin", 321, false);
    Book61 book02 = new Book61("The Robots of Dawn", 37.5f, "Robots, again and again", "0-553-29949-2 ", "Foundation", 264, true);
    tx.begin();
    em.persist(item);
    em.persist(cd01);
    em.persist(cd02);
    em.persist(book01);
    em.persist(book02);
    tx.commit();
    assertNotNull("Item ID should not be null", item.getId());
    assertNotNull("CD1 ID should not be null", cd01.getId());
    assertNotNull("CD2 ID should not be null", cd02.getId());
    assertNotNull("Book1 ID should not be null", book01.getId());
    assertNotNull("Book2 ID should not be null", book02.getId());
  }
}