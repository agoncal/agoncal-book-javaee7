package org.agoncal.book.javaee7.chapter14.ex09;

import javax.jws.WebMethod;
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
public class CardValidator09 {

  // ======================================
  // =           Public Methods           =
  // ======================================

  @WebMethod(operationName = "ValidateCreditCard")
  public boolean validate(CreditCard09 creditCard) {

    Character lastDigit = creditCard.getNumber().charAt(creditCard.getNumber().length() - 1);

    if (Integer.parseInt(lastDigit.toString()) % 2 == 0) {
      return true;
    } else {
      return false;
    }
  }

  @WebMethod(operationName = "ValidateCreditCardNumber")
  public void validate(String creditCardNumber) {
    // business logic
  }

  @WebMethod(exclude = true)
  public void validate(Long creditCardNumber) {
    // business logic
  }

  public static void main(String[] args) {
    Endpoint.publish("http://localhost:8080/cardValidator09", new CardValidator09());
  }
}