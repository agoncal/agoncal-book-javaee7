package org.agoncal.book.javaee7.chapter09.ex01;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Stateless
public class InventoryEJB01 {

  // ======================================
  // =             Attributes             =
  // ======================================

  @PersistenceContext(unitName = "chapter09PU")
  private EntityManager em;

  // ======================================
  // =           Public Methods           =
  // ======================================

  public void addItem(Item01 item) {
    em.merge(item);
    item.increaseAvailableStock();
    sendShippingMessage();
  }

  private void sendShippingMessage() {
    // Send a message
  }
}