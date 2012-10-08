package org.agoncal.book.javaee7.chapter21.ex25;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.WebServiceRef;
import javax.xml.ws.handler.Handler;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class Main25 {

  @WebServiceRef
  private static CardValidator25Service cardValidatorService;

  public static void main(String[] args) {

    System.out.println("Invoking web service with injection");

    CreditCard25 creditCard = new CreditCard25();
    creditCard.setNumber("12541254");
    creditCard.setExpiryDate("10/10");
    creditCard.setType("VISA");
    creditCard.setControlNumber(1254);

    // Add Client-side handlers
    DisplaySOAPMessageHandler handler = new DisplaySOAPMessageHandler();
    List<Handler> handlerChain = new ArrayList<Handler>();
    handlerChain.add(handler);
    ((BindingProvider) cardValidatorService).getBinding().setHandlerChain(handlerChain);

    // Add Purchase order total amount to message context
    ((BindingProvider) cardValidatorService).getRequestContext().put("TOTAL_AMOUNT", "200");


    CardValidator25 cardValidator = cardValidatorService.getCardValidator25Port();
    System.out.println(cardValidator.validate(creditCard));

    creditCard.setNumber("12541253");
    System.out.println(cardValidator.validate(creditCard));
  }
}