package org.agoncal.book.javaee7.chapter09.ex03;

import javax.annotation.Resource;
import javax.ejb.SessionContext;
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
public class InventoryEJB03 {

  // ======================================
  // =             Attributes             =
  // ======================================

  @PersistenceContext(unitName = "chapter09PU")
  private EntityManager em;

  @Resource
  private SessionContext ctx;

  // ======================================
  // =           Public Methods           =
  // ======================================

  public void oneItemSold(Item03 item) {
    item.decreaseAvailableStock();
    sendShippingMessage();

    if (inventoryLevel(item) == 0)
      ctx.setRollbackOnly();
  }

  private void sendShippingMessage() {
    // Send a message
  }

  private int inventoryLevel(Item03 item) {
    return 0;
  }
}