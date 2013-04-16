package org.agoncal.book.javaee7.chapter02.ex36;

import javax.enterprise.event.Observes;
import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class InventoryService36 {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Inject
  private Logger logger;
  List<Book36> inventory = new ArrayList<>();

  // ======================================
  // =          Business methods          =
  // ======================================

  public void addBook(@Observes @Added Book36 book) {
    logger.warning("#### Adding book " + book.getTitle() + " to inventory");
    inventory.add(book);
  }

  public void removeBook(@Observes @Removed Book36 book) {
    logger.warning("#### Removing book " + book.getTitle() + " to inventory");
    inventory.remove(book);
  }
}
