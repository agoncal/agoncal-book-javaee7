package org.agoncal.book.javaee7.chapter03.ex20;

import javax.validation.constraints.NotNull;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class CardValidator02 {

  // ======================================
  // =           Public Methods           =
  // ======================================

  public boolean validate(@NotNull CreditCard02 creditCard) {

    Character lastDigit = creditCard.getNumber().charAt(creditCard.getNumber().length() - 1);

    if (Integer.parseInt(lastDigit.toString()) % 2 == 0) {
      return true;
    } else {
      return false;
    }
  }
}