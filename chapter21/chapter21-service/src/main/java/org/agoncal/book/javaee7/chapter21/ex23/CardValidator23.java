package org.agoncal.book.javaee7.chapter21.ex23;

import javax.jws.WebService;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish 3
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@WebService
public class CardValidator23 {

  // ======================================
  // =           Public Methods           =
  // ======================================

  public boolean validate(CreditCard23 creditCard) {

    String lastDigit = creditCard.getNumber().substring(creditCard.getNumber().length() - 1, creditCard.getNumber().length());

    return Integer.parseInt(lastDigit) % 2 != 0;
  }
}