package org.agoncal.book.javaee7.chapter21.ex23;

import javax.xml.ws.WebServiceRef;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class Main23 {

    @WebServiceRef
    private static CardValidator23Service cardValidatorService;

    public static void main(String[] args) {

        System.out.println("Invoking web service with injection");

        CreditCard23 creditCard = new CreditCard23();
        creditCard.setNumber("12341234");
        creditCard.setExpiryDate("10/10");
        creditCard.setType("VISA");
        creditCard.setControlNumber(1234);

        CardValidator23 cardValidator = cardValidatorService.getCardValidatorPort();
        System.out.println(cardValidator.validate(creditCard));

        creditCard.setNumber("12341233");
        System.out.println(cardValidator.validate(creditCard));
    }
}