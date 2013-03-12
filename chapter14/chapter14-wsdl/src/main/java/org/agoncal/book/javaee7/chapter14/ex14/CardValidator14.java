package org.agoncal.book.javaee7.chapter14.ex14;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;

import static javax.jws.soap.SOAPBinding.Style.RPC;
import static javax.jws.soap.SOAPBinding.Use.ENCODED;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@WebService
@SOAPBinding(style = RPC, use = ENCODED)
public class CardValidator14 {

  // ======================================
  // =           Public Methods           =
  // ======================================

  public boolean validate(CreditCard14 creditCard) {

    Character lastDigit = creditCard.getNumber().charAt(creditCard.getNumber().length() - 1);

    if (Integer.parseInt(lastDigit.toString()) % 2 == 0) {
      return true;
    } else {
      return false;
    }
  }

  public static void main(String[] args) {
    Endpoint.publish("http://localhost:8080/cardValidator14", new CardValidator14());
  }
}