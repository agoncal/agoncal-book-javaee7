package org.agoncal.book.javaee7.chapter09.ex04;

import javax.ejb.ApplicationException;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@ApplicationException(rollback = true)
public class InventoryLevelTooLowException04 extends Exception {

  public InventoryLevelTooLowException04() {
  }

  public InventoryLevelTooLowException04(String message) {
    super(message);
  }
}