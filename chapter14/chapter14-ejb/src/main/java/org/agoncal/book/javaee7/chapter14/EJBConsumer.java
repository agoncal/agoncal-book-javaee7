package org.agoncal.book.javaee7.chapter14;

import javax.ejb.Stateless;
import javax.xml.ws.WebServiceRef;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Stateless
public class EJBConsumer {

  @WebServiceRef
  private CardValidatorService cardValidatorService;

  public boolean validate(CreditCard creditCard) {

    CardValidator cardValidator = cardValidatorService.getCardValidatorPort();
    return cardValidator.validate(creditCard);
  }
}
