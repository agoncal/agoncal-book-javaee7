package org.agoncal.book.javaee7.chapter21.ex10;

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
//@WebService
public class CardValidator10 {

  // ======================================
  // =           Public Methods           =
  // ======================================

  @WebMethod(operationName = "validateCreditCard")
  public boolean validate(CreditCard10 creditCard) {

    Character lastDigit = creditCard.getNumber().charAt(creditCard.getNumber().length() - 1);

    if (Integer.parseInt(lastDigit.toString()) % 2 != 0) {
      return true;
    } else {
      return false;
    }
  }

  @WebMethod(operationName = "validateCreditCardNumber")
  public void validate(String creditCardNumber) {
    // business logic
  }

  @WebMethod(exclude = true)
  public void validate(Long creditCardNumber) {
    // business logic
  }

  public static void main(String[] args) {
    Endpoint.publish("http://localhost:8080/cardValidator10", new CardValidator10());
  }
}