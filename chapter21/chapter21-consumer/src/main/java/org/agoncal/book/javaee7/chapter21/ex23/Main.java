package org.agoncal.book.javaee7.chapter21.ex23;

import org.agoncal.book.javaee7.chapter21.CardValidator;
import org.agoncal.book.javaee7.chapter21.CardValidatorService;
import org.agoncal.book.javaee7.chapter21.CreditCard;

import javax.xml.ws.WebServiceRef;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish 3
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class Main {

    @WebServiceRef
    private static CardValidatorService cardValidatorService;

    public static void main(String[] args) {

        System.out.println("Invoking web service with injection");

        CreditCard creditCard = new CreditCard();
        creditCard.setNumber("12341234");
        creditCard.setExpiryDate("10/10");
        creditCard.setType("VISA");
        creditCard.setControlNumber(1234);

        CardValidator cardValidator = cardValidatorService.getCardValidatorPort();
        System.out.println(cardValidator.validate(creditCard));

        creditCard.setNumber("12341233");
        System.out.println(cardValidator.validate(creditCard));
    }
}