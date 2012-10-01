package org.agoncal.book.javaee7.chapter21.ex23;

import org.agoncal.book.javaee7.chapter21.CardValidator;
import org.agoncal.book.javaee7.chapter21.CreditCard;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish 3
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class CardValidator23Test {

    @Test
    public void shouldCheckCreditCardValidity() {

        CreditCard creditCard = new CreditCard();
        creditCard.setNumber("12341234");
        creditCard.setExpiryDate("10/10");
        creditCard.setType("VISA");
        creditCard.setControlNumber(1234);

        CardValidator cardValidator = new CardValidator();
        assertFalse("Credit card should be valid", cardValidator.validate(creditCard));
        creditCard.setNumber("2");
        assertFalse("Credit card should be valid", cardValidator.validate(creditCard));

        creditCard.setNumber("12341233");
        assertTrue("Credit card should not be valid", cardValidator.validate(creditCard));
        creditCard.setNumber("1");
        assertTrue("Credit card should not be valid", cardValidator.validate(creditCard));
    }
}