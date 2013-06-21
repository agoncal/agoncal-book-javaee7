package org.agoncal.book.javaee7.chapter09.ex06;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class InventoryEJB06 {

  // ======================================
  // =             Attributes             =
  // ======================================

  @PersistenceContext(unitName = "chapter09PU")
  private EntityManager em;

  @Resource
  private UserTransaction ut;

  // ======================================
  // =           Public Methods           =
  // ======================================

  public void oneItemSold(Item06 item) {
    try {
      ut.begin();

      em.persist(item); // Get rid of this line in the book
      item.decreaseAvailableStock();
      sendShippingMessage();

      if (inventoryLevel(item) == 0)
        ut.rollback();
      else
        ut.commit();

    } catch (Exception e) {
      try {
        ut.rollback();
      } catch (SystemException e1) {
        e1.printStackTrace();
      }
    }
  }

  private void sendShippingMessage() {
    // Send a message
  }

  private int inventoryLevel(Item06 item) {
    return 0;
  }
}