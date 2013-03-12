package org.agoncal.book.javaee7.chapter14.ex27;

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
public class CardValidator27 {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Resource
  private WebServiceContext context;


  // ======================================
  // =           Public Methods           =
  // ======================================

  public boolean validate(CreditCard27 creditCard) {

    if (!context.isUserInRole("Admin"))
      throw new SecurityException("Only Admins can validate cards");

    Character lastDigit = creditCard.getNumber().charAt(creditCard.getNumber().length() - 1);

    if (Integer.parseInt(lastDigit.toString()) % 2 == 0) {
      return true;
    } else {
      return false;
    }
  }

  public WebServiceContext getContext() {
    return context;
  }

  public void setContext(WebServiceContext context) {
    this.context = context;
  }

  public static void main(String[] args) {
    Endpoint.publish("http://localhost:8080/cardValidator27", new CardValidator27());
  }
}