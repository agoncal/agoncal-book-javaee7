package org.agoncal.book.javaee7.chapter14.ex12;

import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;

import static javax.jws.WebParam.Mode.IN;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@WebService
public class CardValidator12 {

  // ======================================
  // =           Public Methods           =
  // ======================================

  public boolean validate(@WebParam(name = "Credit-Card", mode = IN) CreditCard12 creditCard) {

    Character lastDigit = creditCard.getNumber().charAt(creditCard.getNumber().length() - 1);

    if (Integer.parseInt(lastDigit.toString()) % 2 == 0) {
      return true;
    } else {
      return false;
    }
  }

  public static void main(String[] args) {
    Endpoint.publish("http://localhost:8080/cardValidator12", new CardValidator12());
  }
}