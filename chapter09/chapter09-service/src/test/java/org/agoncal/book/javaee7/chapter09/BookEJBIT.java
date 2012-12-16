package org.agoncal.book.javaee7.chapter09;

import org.junit.Test;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertNotNull;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class BookEJBIT {

  // ======================================
  // =              Unit tests            =
  // ======================================

  @Test
  public void shouldCreateABook() throws Exception {

    Map<String, Object> properties = new HashMap<>();
    properties.put(EJBContainer.MODULES, new File("target/classes"));

    try (EJBContainer ec = EJBContainer.createEJBContainer(properties)) {
      Context ctx = ec.getContext();


      // Check JNDI dependencies
      assertNotNull(ctx.lookup("java:global/classes/BookEJB!org.agoncal.book.javaee7.chapter09.BookEJBRemote"));
      assertNotNull(ctx.lookup("java:global/classes/BookEJB!org.agoncal.book.javaee7.chapter09.BookEJB"));

      // Looks up the EJB
      BookEJB bookEJB = (BookEJB) ctx.lookup("java:global/classes/BookEJB!org.agoncal.book.javaee7.chapter09.BookEJB");

      // Creates an instance of book
      Book book = new Book("The Hitchhiker's Guide to the Galaxy", 12.5F, "Science fiction comedy book", "1-84023-742-2", 354, true);

      // Persists the book to the database
      book = bookEJB.createBook(book);
      assertNotNull("ID should not be null", book.getId());

      // Retrieves all the books from the database
      List<Book> books = bookEJB.findBooks();
      assertNotNull(books);
    }
  }
}