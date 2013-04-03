package org.agoncal.book.javaee7.chapter02.ex10;


import java.util.Random;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@NumberOfDigits10(value = Digits.THIRTEEN, odd = true)
public class IsbnOddGenerator10 implements NumberGenerator10 {

  // ======================================
  // =          Business methods          =
  // ======================================

  public String generateNumber() {
    return "131-84356-" + Math.abs(new Random().nextInt());
  }
}