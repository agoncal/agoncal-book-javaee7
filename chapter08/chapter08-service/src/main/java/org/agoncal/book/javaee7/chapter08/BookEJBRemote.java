package org.agoncal.book.javaee7.chapter08;

import javax.ejb.Remote;
import javax.validation.constraints.NotNull;
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

  @NotNull Book createBook(@NotNull Book book);

  void deleteBook(@NotNull Book book);

  @NotNull Book updateBook(@NotNull Book book);
}