package org.agoncal.book.javaee7.chapter07.ex17;

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
public interface ItemRemote17 {

  // ======================================
  // =           Public Methods           =
  // ======================================

  List<Book17> findBooks();

  Book17 createBook(Book17 book);
}