package org.agoncal.book.javaee7.chapter09;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */

@Singleton
@Startup
@DataSourceDefinition(
        className = "org.apache.derby.jdbc.EmbeddedDataSource",
        name = "java:global/jdbc/chapter09DS",
        user = "app",
        password = "app",
        databaseName = "chapter09DB",
        properties = {"connectionAttributes=;create=true"}
)
public class DatabasePopulator {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Inject
  private BookEJB bookEJB;

  private Book h2g2;
  private Book lord;

  // ======================================
  // =          Lifecycle Methods         =
  // ======================================

  @PostConstruct
  private void populateDB() {
    h2g2 = new Book("Beginning Java EE 7", 35F, "Best Java EE book ever", "1-8763-9125-7", 605, true);
    lord = new Book("The Lord of the Rings", 50.4f, "Science fiction comedy book", "1-84023-742-2", 1216, true);

    bookEJB.createBook(h2g2);
    bookEJB.createBook(lord);
  }

  @PreDestroy
  private void clearDB() {
    bookEJB.deleteBook(h2g2);
    bookEJB.deleteBook(lord);
  }
}
