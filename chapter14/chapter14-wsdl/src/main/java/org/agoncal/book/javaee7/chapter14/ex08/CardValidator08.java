package org.agoncal.book.javaee7.chapter14.ex08;

import javax.jws.WebService;
import javax.xml.ws.Endpoint;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@WebService(portName = "CreditCardValidator08", serviceName = "ValidatorService08")
public class CardValidator08 {

  // ======================================
  // =           Public Methods           =
  // ======================================

  public boolean validate(CreditCard08 creditCard) {

    Character lastDigit = creditCard.getNumber().charAt(creditCard.getNumber().length() - 1);

    if (Integer.parseInt(lastDigit.toString()) % 2 == 0) {
      return true;
    } else {
      return false;
    }
  }

  public static void main(String[] args) {
    Endpoint.publish("http://localhost:8080/cardValidator08", new CardValidator08());
  }
}