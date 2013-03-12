package org.agoncal.book.javaee7.chapter14.ex27;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.xml.ws.WebServiceContext;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@RunWith(MockitoJUnitRunner.class)
public class CardValidator27Test {

  @Mock
  private WebServiceContext mockedContext;


  @Test
  public void shouldCheckCreditCardValidityForAdmins() {

    when(mockedContext.isUserInRole("Admin")).thenReturn(true);

    CreditCard27 creditCard = new CreditCard27("12341234", "10/10", 1234, "VISA");

    CardValidator27 cardValidator = new CardValidator27();
    cardValidator.setContext(mockedContext);

    assertTrue("Credit card should be valid", cardValidator.validate(creditCard));
    creditCard.setNumber("2");
    assertTrue("Credit card should be valid", cardValidator.validate(creditCard));

    creditCard.setNumber("12341233");
    assertFalse("Credit card should not be valid", cardValidator.validate(creditCard));
    creditCard.setNumber("1");
    assertFalse("Credit card should not be valid", cardValidator.validate(creditCard));
  }

  @Test(expected = SecurityException.class)
  public void shouldCheckCreditCardValidityForNonAdmins() {

    when(mockedContext.isUserInRole("Admin")).thenReturn(false);

    CreditCard27 creditCard = new CreditCard27("12341234", "10/10", 1234, "VISA");

    CardValidator27 cardValidator = new CardValidator27();
    cardValidator.setContext(mockedContext);

    assertTrue("Credit card should be valid", cardValidator.validate(creditCard));
    creditCard.setNumber("2");
    assertTrue("Credit card should be valid", cardValidator.validate(creditCard));

    creditCard.setNumber("12341233");
    assertFalse("Credit card should not be valid", cardValidator.validate(creditCard));
    creditCard.setNumber("1");
    assertFalse("Credit card should not be valid", cardValidator.validate(creditCard));
  }
}
