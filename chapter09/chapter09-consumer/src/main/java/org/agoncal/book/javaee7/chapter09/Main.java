package org.agoncal.book.javaee7.chapter09;

import javax.ejb.EJB;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish 3
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class Main {

  // ======================================
  // =             Attributes             =
  // ======================================

  @EJB
  private static BookEJBRemote bookEJB;

  // ======================================
  // =           Public Methods           =
  // ======================================

  public static void main(String[] args) {

    // Creates an instance of book
    Book book = new Book();
    book.setTitle("The Hitchhiker's Guide to the Galaxy");
    book.setPrice(12.5F);
    book.setDescription("Science fiction comedy series created by Douglas Adams.");
    book.setIsbn("1-84023-742-2");
    book.setNbOfPage(354);
    book.setIllustrations(false);

    book = bookEJB.createBook(book);
    System.out.println("### Book created : " + book);

    book.setTitle("H2G2");
    book = bookEJB.updateBook(book);
    System.out.println("### Book updated : " + book);

    bookEJB.deleteBook(book);
    System.out.println("### Book deleted");
  }
}