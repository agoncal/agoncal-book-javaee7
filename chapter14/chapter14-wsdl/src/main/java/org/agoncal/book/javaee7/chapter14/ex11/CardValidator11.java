package org.agoncal.book.javaee7.chapter14.ex11;

import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@WebService
public class CardValidator11 {

  // ======================================
  // =           Public Methods           =
  // ======================================

  @WebResult(name = "IsValid")
  public boolean validate(CreditCard11 creditCard) {

    Character lastDigit = creditCard.getNumber().charAt(creditCard.getNumber().length() - 1);

    if (Integer.parseInt(lastDigit.toString()) % 2 == 0) {
      return true;
    } else {
      return false;
    }
  }

  public static void main(String[] args) {
    Endpoint.publish("http://localhost:8080/cardValidator11", new CardValidator11());
  }
}