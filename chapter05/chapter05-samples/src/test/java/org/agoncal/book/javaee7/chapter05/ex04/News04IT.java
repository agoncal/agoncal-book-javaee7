package org.agoncal.book.javaee7.chapter05.ex04;

import org.agoncal.book.javaee7.chapter05.AbstractPersistentTest;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish 3
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 *         Test class that creates a News (using the EmbeddedId annotation)
 */
public class News04IT extends AbstractPersistentTest {

  // ======================================
  // =              Unit tests            =
  // ======================================

  @Test
  public void shouldCreateANews() throws Exception {

    News04 news = new News04(new NewsId04("Richard Wright has died", "EN"), "The keyboard of Pink Floyd has died today");
    tx.begin();
    em.persist(news);
    tx.commit();

    news = em.find(News04.class, new NewsId04("Richard Wright has died", "EN"));

    assertEquals("The keyboard of Pink Floyd has died today", news.getContent());
  }
}