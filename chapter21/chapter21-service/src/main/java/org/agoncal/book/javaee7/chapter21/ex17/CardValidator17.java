package org.agoncal.book.javaee7.chapter21.ex17;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;

import static javax.jws.WebParam.Mode.IN;
import static javax.jws.soap.SOAPBinding.Style.RPC;
import static javax.jws.soap.SOAPBinding.Use.ENCODED;
import static javax.jws.soap.SOAPBinding.Use.LITERAL;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@WebService(portName = "CreditCardValidator17", serviceName = "ValidatorService17")
@SOAPBinding(style = RPC, use = LITERAL)
public class CardValidator17 {

  // ======================================
  // =           Public Methods           =
  // ======================================

  @WebResult(name = "IsValid")
  @WebMethod(operationName = "ValidateCreditCard")
  public boolean validate(@WebParam(name = "Credit-Card", mode = IN) CreditCard17 creditCard) {

    Character lastDigit = creditCard.getNumber().charAt(creditCard.getNumber().length() - 1);

    if (Integer.parseInt(lastDigit.toString()) % 2 == 0) {
      return true;
    } else {
      return false;
    }
  }

  @WebResult(name = "IsValid")
  @WebMethod(operationName = "ValidateCreditCardNumber")
  public void validate(@WebParam(name = "Credit-Card-Number") String creditCardNumber) {
    // business logic
  }

  @WebMethod(exclude = true)
  public void validate(Long creditCardNumber) {
    // business logic
  }

  public static void main(String[] args) {
    Endpoint.publish("http://localhost:8080/cardValidator17", new CardValidator17());
  }
}