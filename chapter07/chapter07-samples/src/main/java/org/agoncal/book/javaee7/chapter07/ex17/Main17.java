package org.agoncal.book.javaee7.chapter07.ex17;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import javax.naming.NamingException;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class Main17 {

  // ======================================
  // =                 Main               =
  // ======================================

  public static void main(String[] args) throws NamingException {

    // Sets the container classpath
    Map<String, Object> properties = new HashMap<>();
    properties.put(EJBContainer.MODULES, new File("target/classes"));

    // Creates an Embedded Container and get the JNDI context
    try (EJBContainer ec = EJBContainer.createEJBContainer(properties)) {

      Context ctx = ec.getContext();


      // Creates an instance of book
      Book17 book = new Book17();
      book.setTitle("The Hitchhiker's Guide to the Galaxy");
      book.setPrice(12.5F);
      book.setDescription("Science fiction comedy book");
      book.setIsbn("1-84173-742-2");
      book.setNbOfPage(354);
      book.setIllustrations(false);

      // Looks up the EJB with the no-interface view
      ItemEJB17 itemEJB = (ItemEJB17) ctx.lookup("java:global/classes/ItemEJB17!org.agoncal.book.javaee7.chapter07.ex17.ItemEJB17");

      // Persists the book to the database
      itemEJB.createBook(book);

      // Retrieves all the books from the database
      for (Book17 aBook : itemEJB.findBooks()) {
        System.out.println("#############" + aBook);
      }
    }
  }
}