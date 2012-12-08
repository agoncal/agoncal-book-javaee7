package org.agoncal.book.javaee7.chapter08.ex02;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Stateless
public class WorldEJB02 {

  @EJB
  private ItemEJB02 itemEJB;

  public String sayWorld() {
    itemEJB.findBooks();
    return "World !!!!!!!!!!!!!!!";
  }
}
