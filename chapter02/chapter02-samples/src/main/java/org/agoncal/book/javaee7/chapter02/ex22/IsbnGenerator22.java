package org.agoncal.book.javaee7.chapter02.ex22;


import java.util.Random;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@ThirteenDigits22
public class IsbnGenerator22 implements NumberGenerator22 {

  // ======================================
  // =          Business methods          =
  // ======================================

  public String generateNumber() {
    return "13-84356-" + Math.abs(new Random().nextInt());
  }
}