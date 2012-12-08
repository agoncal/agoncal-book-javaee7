package org.agoncal.book.javaee7.chapter08.ex02;

import java.util.List;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
//@Local
public interface ItemLocal02 {

  // ======================================
  // =           Public Methods           =
  // ======================================
  List<Book02> findBooks();

  List<CD02> findCDs();

  Book02 findBookById(Long id);

  CD02 findCDById(Long id);
}