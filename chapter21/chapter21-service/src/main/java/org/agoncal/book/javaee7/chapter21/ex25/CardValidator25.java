package org.agoncal.book.javaee7.chapter21.ex25;

import javax.jws.WebService;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@WebService
public class CardValidator25 {

  // ======================================
  // =           Public Methods           =
  // ======================================

  public boolean validate(CreditCard25 creditCard) {

    String lastDigit = creditCard.getNumber().substring(creditCard.getNumber().length() - 1, creditCard.getNumber().length());

    return Integer.parseInt(lastDigit) % 2 != 0;
  }
}