package org.agoncal.book.javaee7.chapter08;

import javax.ejb.Remote;
import java.util.List;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Remote
public interface BookEJBRemote {

  // ======================================
  // =           Public Methods           =
  // ======================================

  List<Book> findBooks();

  Book createBook(Book book);

  void deleteBook(Book book);

  Book updateBook(Book book);
}