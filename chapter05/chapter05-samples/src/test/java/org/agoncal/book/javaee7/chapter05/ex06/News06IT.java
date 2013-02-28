package org.agoncal.book.javaee7.chapter05.ex06;

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
public class News06IT extends AbstractPersistentTest {

  // ======================================
  // =              Unit tests            =
  // ======================================

  @Test
  public void shouldCreateANews() throws Exception {

    News06 news = new News06("Richard Wright has died", "EN", "The keyboard of Pink Floyd has died today");
    tx.begin();
    em.persist(news);
    tx.commit();
    assertNotNull("ID should not be null", news.getTitle());
  }
}