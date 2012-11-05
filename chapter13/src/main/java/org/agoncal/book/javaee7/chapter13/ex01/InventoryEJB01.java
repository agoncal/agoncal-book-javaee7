package org.agoncal.book.javaee7.chapter13.ex01;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Antonio Goncalves
 *         APress Book07 - Beginning Java EE 6 with Glassfish
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Stateless
public class InventoryEJB01 {

    // ======================================
    // =             Attributes             =
    // ======================================

    @PersistenceContext(unitName = "chapter13PU")
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