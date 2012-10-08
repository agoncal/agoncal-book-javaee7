package org.agoncal.book.javaee7.chapter21.ex16;

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
public class CardValidator16Test {

    @Test
    public void shouldCheckCreditCardValidity() {

        CreditCard16 creditCard = new CreditCard16();
        creditCard.setNumber("12341234");
        creditCard.setExpiryDate("10/10");
        creditCard.setType("VISA");
        creditCard.setControlNumber(1234);

        CardValidator16 cardValidator = new CardValidator16();
        assertFalse("Credit card should be valid", cardValidator.validate(creditCard));
        creditCard.setNumber("2");
        assertFalse("Credit card should be valid", cardValidator.validate(creditCard));

        creditCard.setNumber("12341233");
        assertTrue("Credit card should not be valid", cardValidator.validate(creditCard));
        creditCard.setNumber("1");
        assertTrue("Credit card should not be valid", cardValidator.validate(creditCard));
    }
}