package org.agoncal.book.javaee7.chapter08.ex02;

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
public interface ItemRemote02 {

  // ======================================
  // =           Public Methods           =
  // ======================================
  String sayHello();

  List<Book02> findBooks();

  List<CD02> findCDs();

  Book02 findBookById(Long id);

  CD02 findCDById(Long id);

  Book02 createBook(Book02 book);

  CD02 createCD(CD02 cd);

  void deleteBook(Book02 book);

  void deleteCD(CD02 cd);

  Book02 updateBook(Book02 book);

  CD02 updateCD(CD02 cd);
}