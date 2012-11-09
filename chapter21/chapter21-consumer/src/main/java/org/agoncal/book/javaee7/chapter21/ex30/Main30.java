package org.agoncal.book.javaee7.chapter21.ex30;

import org.agoncal.book.javaee7.chapter21.CardValidator;
import org.agoncal.book.javaee7.chapter21.CardValidatorService;
import org.agoncal.book.javaee7.chapter21.CreditCard;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class Main30 {


  public static void main(String[] args) {

    System.out.println("Invoking web service programmatically");

    CreditCard creditCard = new CreditCard();
    creditCard.setNumber("12341234");
    creditCard.setExpiryDate("10/10");
    creditCard.setType("VISA");
    creditCard.setControlNumber(1234);

    CardValidator cardValidator = new CardValidatorService().getCardValidatorPort();
    System.out.println(cardValidator.validate(creditCard));

    creditCard.setNumber("12341233");
    System.out.println(cardValidator.validate(creditCard));
  }
}
