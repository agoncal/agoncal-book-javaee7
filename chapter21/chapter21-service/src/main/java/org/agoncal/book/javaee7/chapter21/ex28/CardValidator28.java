package org.agoncal.book.javaee7.chapter21.ex28;

import javax.annotation.Resource;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import javax.xml.ws.WebServiceContext;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@WebService
public class CardValidator28 {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Resource
  private WebServiceContext context;


  // ======================================
  // =           Public Methods           =
  // ======================================

  public boolean validate(CreditCard28 creditCard) {

    if (!context.isUserInRole("Admin"))
      throw new SecurityException("Only Admins can validate cards");

    Character lastDigit = creditCard.getNumber().charAt(creditCard.getNumber().length() - 1);

    if (Integer.parseInt(lastDigit.toString()) % 2 == 0) {
      return true;
    } else {
      return false;
    }
  }

  public static void main(String[] args) {
    Endpoint.publish("http://localhost:8080/cardValidator28", new CardValidator28());
  }
}