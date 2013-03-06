package org.agoncal.book.javaee7.chapter11;

import javax.annotation.PostConstruct;
import javax.annotation.sql.DataSourceDefinition;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;
import java.util.logging.Logger;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Singleton
@Startup
@DataSourceDefinition(name = "java:global/jdbc/lab11DS",
        className = "org.apache.derby.jdbc.EmbeddedDriver",
        url = "jdbc:derby:memory:lab11DB;create=true;user=app;password=app"
)
public class DBPopulator {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Inject
  private BookEJB bookEJB;

  private Logger logger = Logger.getLogger("org.agoncal.book.javaee7");

  // ======================================
  // =          Lifecycle methods         =
  // ======================================

  @PostConstruct
  private void createDummyData() {
    bookEJB.createBook(new Book("The Hitchhiker's Guide to the Galaxy", 23.99f, "Science fiction comedy book", 354, Boolean.TRUE));
    bookEJB.createBook(new Book("Harry Potter and the Goblet of Fire", 19.79f, "Science fiction (Book 4)", 734, Boolean.TRUE));
//    bookEJB.createBook(new Book("The Elements of Style", 6.64f, "A masterpiece in the art of clear and concise writing.", 105, Boolean.FALSE));
//    bookEJB.createBook(new Book("Harry Potter And The Order Of The Phoenix", 9.35f, "Science fiction (Book 1)", 870, Boolean.TRUE));
//    bookEJB.createBook(new Book("The Difference Between God and Larry Ellison", 11.99f, "God Doesn't Think He's Larry Ellison", 420, Boolean.FALSE));
//    bookEJB.createBook(new Book("The Children of Hurin", 17.16f, "The first complete book by J.R.R. Tolkien in three decades", 313, Boolean.TRUE));
//    bookEJB.createBook(new Book("The Da Vinci Code", 17.79f, "Thriller", 454, Boolean.FALSE));
//    bookEJB.createBook(new Book("La carte et le territoire", 24.99f, "Prix Goncourt 2010", 428, Boolean.FALSE));
//    bookEJB.createBook(new Book("Une forme de vie", 18.99f, "Amelie Nothomb", 168, Boolean.FALSE));
//    bookEJB.createBook(new Book("To Kill a Mockingbird", 5.99f, "American classic", 281, Boolean.FALSE));
//    bookEJB.createBook(new Book("Fahrenheit 451", 7.99f, "Science fiction", 208, Boolean.FALSE));
//    bookEJB.createBook(new Book("Lolita", 14.99f, "Nabovok masterpiece", 368, Boolean.TRUE));
//    bookEJB.createBook(new Book("A Midsummer Night's Dream", 14.99f, "Shakespeare masterpiece", 288, Boolean.TRUE));
//    bookEJB.createBook(new Book("I bastioni del coraggio", 18.99f, "Anno domini 1548. Una grande storia d'amore, ...", 457, Boolean.FALSE));
//    bookEJB.createBook(new Book("Harjunpaa ja pahan pappi", 32.49f, "Finns read crime novels", 300, Boolean.FALSE));
//    bookEJB.createBook(new Book("El ingenioso hidalgo don Quijote de la Mancha", 13.99f, "Classical Don Quijote", 108, Boolean.TRUE));
//    bookEJB.createBook(new Book("The Lord of the Rings", 50.4f, "Science fiction comedy book", 1216, Boolean.TRUE));
    bookEJB.createBook(new Book("Java EE 6 with GlassFish 3", 31.49f, "Just fantastic", 354, Boolean.TRUE));
//    bookEJB.createBook(new Book("Heidis Lehr- und Wanderjahre", 68f, "Inhalt: Die Heidi-Bucher erzahlen...", 160, Boolean.TRUE));
//    bookEJB.createBook(new Book("l Nome della Rosa", 34.99f, "Science fiction comedy book", 354, Boolean.FALSE));
    logger.info("&&&&&&&&&&&&&& Inserted " + bookEJB.findAllBooks().size() + " Books");
  }
}
