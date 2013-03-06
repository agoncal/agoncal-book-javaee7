package org.agoncal.book.javaee7.chapter08;

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
        name = "java:global/jdbc/chapter08DS",
        user = "app",
        password = "app",
        databaseName = "chapter08DB",
        properties = {"connectionAttributes=;create=true"}
)
public class DatabasePopulator {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Inject
  private BookEJB bookEJB;

  private Book javaee7;
  private Book lord;

  // ======================================
  // =          Lifecycle Methods         =
  // ======================================

  @PostConstruct
  private void populateDB() {
    javaee7 = new Book("Beginning Java EE 7", 35F, "Best Java EE book ever", "1-8763-9125-7", 605, true);
    lord = new Book("The Lord of the Rings", 50.4f, "Science fiction comedy book", "1-84023-742-2", 1216, true);

    bookEJB.createBook(javaee7);
    bookEJB.createBook(lord);
  }

  @PreDestroy
  private void clearDB() {
    bookEJB.deleteBook(javaee7);
    bookEJB.deleteBook(lord);
  }
}
