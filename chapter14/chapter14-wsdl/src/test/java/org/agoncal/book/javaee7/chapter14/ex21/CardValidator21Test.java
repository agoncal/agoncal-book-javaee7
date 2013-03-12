package org.agoncal.book.javaee7.chapter14.ex21;

import org.junit.Test;

import javax.xml.soap.SOAPException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class CardValidator21Test {

  @Test
  public void shouldCheckCreditCardValidity() {

    CreditCard21 creditCard = new CreditCard21("12341234", "10/10", 1234, "VISA");

    CardValidator21 cardValidator = new CardValidator21();
    assertTrue("Credit card should be valid", cardValidator.validate(creditCard));
    creditCard.setNumber("2");
    assertTrue("Credit card should be valid", cardValidator.validate(creditCard));

    creditCard.setNumber("12341233");
    assertFalse("Credit card should not be valid", cardValidator.validate(creditCard));
    creditCard.setNumber("1");
    assertFalse("Credit card should not be valid", cardValidator.validate(creditCard));
  }

  @Test(expected = NullPointerException.class)
  public void shouldThrowANumberFormatException() {

    new CardValidator21().validate(null);
  }

  @Test(expected = CardValidatorException21.class)
  public void shouldThrowACardValidatorException() throws Exception {

    CreditCard21 creditCard = new CreditCard21("12341234", "10/10", 1234, "VISA");

    CardValidator21 cardValidator = new CardValidator21();
    assertTrue("Credit card should be valid", cardValidator.validateWithException(creditCard));
    creditCard.setNumber("12341233");
    cardValidator.validateWithException(creditCard);
  }

  @Test(expected = CardValidatorException21.class)
  public void shouldThrowACardValidatorExceptionWithAMessage() throws Exception {
    CreditCard21 creditCard = new CreditCard21("12341234", "10/10", 1234, "VISA");

    CardValidator21 cardValidator = new CardValidator21();
    assertTrue("Credit card should be valid", cardValidator.validateWithException(creditCard));
    creditCard.setNumber("12341233");
    cardValidator.validateWithExceptionAndMessage(creditCard);
  }

  @Test(expected = CardValidatorRTException21.class)
  public void shouldThrowACardValidatorRTException() {

    CreditCard21 creditCard = new CreditCard21("12341234", "10/10", 1234, "VISA");

    CardValidator21 cardValidator = new CardValidator21();
    assertTrue("Credit card should be valid", cardValidator.validateWithRTException(creditCard));
    creditCard.setNumber("12341233");
    cardValidator.validateWithRTException(creditCard);
  }

  @Test(expected = CardValidatorRTException21.class)
  public void shouldThrowACardValidatorRTExceptionWithAMessage() {

    CreditCard21 creditCard = new CreditCard21("12341234", "10/10", 1234, "VISA");

    CardValidator21 cardValidator = new CardValidator21();
    assertTrue("Credit card should be valid", cardValidator.validateWithRTException(creditCard));
    creditCard.setNumber("12341233");
    cardValidator.validateWithRTExceptionAndMessage(creditCard);
  }

  @Test(expected = CardValidatorSOAPFaultException21.class)
  public void shouldThrowACardValidatorSOAPFaultException22() throws SOAPException {

    CreditCard21 creditCard = new CreditCard21("12341234", "10/10", 1234, "VISA");

    CardValidator21 cardValidator = new CardValidator21();
    assertTrue("Credit card should be valid", cardValidator.validateWithSOAPFaultException(creditCard));
    creditCard.setNumber("12341233");
    cardValidator.validateWithSOAPFaultException(creditCard);
  }
}