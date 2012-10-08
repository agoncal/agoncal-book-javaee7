package org.agoncal.book.javaee7.chapter21.ex16;

import javax.xml.ws.WebServiceRef;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class Main16 {

    @WebServiceRef
    private static CardValidator16Service cardValidatorService;

    public static void main(String[] args) {

        System.out.println("Invoking web service with injection");

        CreditCard16 creditCard = new CreditCard16();
        creditCard.setNumber("12341234");
        creditCard.setExpiryDate("10/10");
        creditCard.setType("VISA");
        creditCard.setControlNumber(1234);

        CardValidator16 cardValidator = cardValidatorService.getValidatorPort();
        System.out.println(cardValidator.validateCreditCard(creditCard));

        creditCard.setNumber("12341233");
        System.out.println(cardValidator.validateCreditCard(creditCard));
    }

}