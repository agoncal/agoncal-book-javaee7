package org.agoncal.book.javaee7.chapter21.ex10;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@WebService(endpointInterface = "org.agoncal.book.javaee7.chapter21.ex06.Validator06")
public class CardValidator10 {

  // ======================================
  // =           Public Methods           =
  // ======================================

  public boolean validate(CreditCard10 creditCard) {

    Character lastDigit = creditCard.getNumber().charAt(creditCard.getNumber().length() - 1);

    if (Integer.parseInt(lastDigit.toString()) % 2 != 0) {
      return true;
    } else {
      return false;
    }
  }

  public static void main(String[] args) {
    Endpoint.publish("http://localhost:8080/cardValidator06", new CardValidator10());
  }
}