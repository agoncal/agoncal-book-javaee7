package org.agoncal.book.javaee7.chapter14.ex12;

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
public class CardValidator12Test {

  @Test
  public void shouldCheckCreditCardValidity() {

    CreditCard12 creditCard = new CreditCard12("12341234", "12/12", 1234, "VISA");

    CardValidator12 cardValidator = new CardValidator12();
    assertTrue("Credit card should be valid", cardValidator.validate(creditCard));
    creditCard.setNumber("2");
    assertTrue("Credit card should be valid", cardValidator.validate(creditCard));

    creditCard.setNumber("12341233");
    assertFalse("Credit card should not be valid", cardValidator.validate(creditCard));
    creditCard.setNumber("1");
    assertFalse("Credit card should not be valid", cardValidator.validate(creditCard));
  }
}
