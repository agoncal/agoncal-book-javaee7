package org.agoncal.book.javaee7.chapter21.ex01;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class CardValidator01Test {

    @Test
    public void shouldCheckCreditCardValidity() {

        CreditCard01 creditCard = new CreditCard01();
        creditCard.setNumber("12341234");
        creditCard.setExpiryDate("10/10");
        creditCard.setType("VISA");
        creditCard.setControlNumber(1234);

        CardValidator01 cardValidator = new CardValidator01();
        assertFalse("Credit card should be valid", cardValidator.validate(creditCard));
        creditCard.setNumber("2");
        assertFalse("Credit card should be valid", cardValidator.validate(creditCard));

        creditCard.setNumber("12341233");
        assertTrue("Credit card should not be valid", cardValidator.validate(creditCard));
        creditCard.setNumber("1");
        assertTrue("Credit card should not be valid", cardValidator.validate(creditCard));
    }
}
