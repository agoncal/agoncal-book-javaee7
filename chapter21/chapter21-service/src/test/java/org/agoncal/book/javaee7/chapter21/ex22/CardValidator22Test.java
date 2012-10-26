package org.agoncal.book.javaee7.chapter21.ex22;

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
public class CardValidator22Test {

  @Test
  public void shouldCheckCreditCardValidity() {

    CreditCard22 creditCard = new CreditCard22();
    creditCard.setNumber("12341234");
    creditCard.setExpiryDate("10/10");
    creditCard.setType("VISA");
    creditCard.setControlNumber(1234);

    CardValidator22 cardValidator = new CardValidator22();
    assertFalse("Credit card should be valid", cardValidator.validate(creditCard));
    creditCard.setNumber("2");
    assertFalse("Credit card should be valid", cardValidator.validate(creditCard));

    creditCard.setNumber("12341233");
    assertTrue("Credit card should not be valid", cardValidator.validate(creditCard));
    creditCard.setNumber("1");
    assertTrue("Credit card should not be valid", cardValidator.validate(creditCard));
  }
}