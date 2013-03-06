package org.agoncal.book.javaee7.chapter07.ex17;

import javax.ejb.Local;
import java.util.List;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Local
public interface ItemLocal17 {

  // ======================================
  // =           Public Methods           =
  // ======================================

  List<Book17> findBooks();

}