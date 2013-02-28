package org.agoncal.book.javaee7.chapter05.ex53;

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
public class Item53IT extends AbstractPersistentTest {

  // ======================================
  // =              Unit tests            =
  // ======================================
  @Test
  public void shouldCreateSeveralItems() throws Exception {

    Item53 item = new Item53("Junk", 52.50f, "A piece of junk");
    CD53 cd01 = new CD53("St Pepper", 12.80f, "Beatles master piece", "Apple", 1, 53.32f, "Pop/Rock");
    CD53 cd02 = new CD53("Love SUpreme", 20f, "John Coltrane love moment", "Blue Note", 2, 87.45f, "Jazz");
    Book53 book01 = new Book53("H2G2", 21f, "Best IT book", "123-456-789", "Pinguin", 321, false);
    Book53 book02 = new Book53("The Robots of Dawn", 37.5f, "Robots, again and again", "0-553-29949-2 ", "Foundation", 264, true);
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