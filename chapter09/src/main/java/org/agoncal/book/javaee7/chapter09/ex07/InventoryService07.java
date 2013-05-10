package org.agoncal.book.javaee7.chapter09.ex07;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Transactional
public class InventoryService07 {

  // ======================================
  // =             Attributes             =
  // ======================================

  @PersistenceContext(unitName = "chapter09PU")
  private EntityManager em;

  // ======================================
  // =           Public Methods           =
  // ======================================

  public void addItem(Item07 item) {
    em.merge(item);
    item.increaseAvailableStock();
    sendShippingMessage();
  }

  private void sendShippingMessage() {
    // Send a message
  }
}