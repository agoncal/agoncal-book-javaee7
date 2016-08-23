package org.agoncal.book.javaee7.chapter02;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class BookServiceIT {

  // ======================================
  // =              Methods               =
  // ======================================

  @Test
  public void shouldCheckNumberIsMock() {

    Weld weld = new Weld();
    // with 2.2 weld treats the two beans.xml files a two separate archives. To have test alternative override that
    // we need to switch off this feature
    System.setProperty(Weld.ARCHIVE_ISOLATION_SYSTEM_PROPERTY, "false");
    WeldContainer container = weld.initialize();

    BookService bookService = container.instance().select(BookService.class).get();

    Book book = bookService.createBook("H2G2", 12.5f, "Geeky scifi Book");

    assertTrue(book.getNumber().startsWith("MOCK"));

    weld.shutdown();
  }
}