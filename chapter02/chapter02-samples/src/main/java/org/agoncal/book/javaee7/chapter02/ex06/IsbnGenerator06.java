package org.agoncal.book.javaee7.chapter02.ex06;


import javax.enterprise.inject.Default;
import java.util.Random;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Default
public class IsbnGenerator06 implements NumberGenerator06 {

  // ======================================
  // =          Business methods          =
  // ======================================

  public String generateNumber() {
    return "13-84356-" + Math.abs(new Random().nextInt());
  }
}