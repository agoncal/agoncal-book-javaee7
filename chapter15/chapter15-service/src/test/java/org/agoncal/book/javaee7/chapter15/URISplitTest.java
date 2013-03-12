package org.agoncal.book.javaee7.chapter15;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class URISplitTest {

  @Test
  public void shouldGetTheLastPath() {

    String id = "http://localhost:8080/chapter15-service-1.0/rs/book/33".split("/")[6];
    assertEquals("33", id);
  }
}
