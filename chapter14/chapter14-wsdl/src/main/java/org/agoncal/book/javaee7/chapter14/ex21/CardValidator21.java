package org.agoncal.book.javaee7.chapter14.ex21;

import javax.jws.WebService;
import javax.xml.namespace.QName;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPFactory;
import javax.xml.soap.SOAPFault;
import javax.xml.ws.Endpoint;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@WebService
public class CardValidator21 {

  // ======================================
  // =           Public Methods           =
  // ======================================

  public boolean validate(CreditCard21 creditCard) {

    Character lastDigit = creditCard.getNumber().charAt(creditCard.getNumber().length() - 1);

    if (Integer.parseInt(lastDigit.toString()) % 2 == 0) {
      return true;
    } else {
      return false;
    }
  }

  public boolean validateWithException(CreditCard21 creditCard) throws CardValidatorException21 {

    Character lastDigit = creditCard.getNumber().charAt(creditCard.getNumber().length() - 1);

    if (Integer.parseInt(lastDigit.toString()) % 2 == 0) {
      return true;
    } else {
      throw new CardValidatorException21();
    }
  }

 public boolean validateWithExceptionAndMessage(CreditCard21 creditCard) throws CardValidatorException21 {

    Character lastDigit = creditCard.getNumber().charAt(creditCard.getNumber().length() - 1);

    if (Integer.parseInt(lastDigit.toString()) % 2 == 0) {
      return true;
    } else {
      throw new CardValidatorException21("The credit card number is invalid");
    }
  }

  public boolean validateWithRTException(CreditCard21 creditCard) {

    Character lastDigit = creditCard.getNumber().charAt(creditCard.getNumber().length() - 1);

    if (Integer.parseInt(lastDigit.toString()) % 2 == 0) {
      return true;
    } else {
      throw new CardValidatorRTException21();
    }
  }

  public boolean validateWithRTExceptionAndMessage(CreditCard21 creditCard) {

    Character lastDigit = creditCard.getNumber().charAt(creditCard.getNumber().length() - 1);

    if (Integer.parseInt(lastDigit.toString()) % 2 == 0) {
      return true;
    } else {
      throw new CardValidatorRTException21("The credit card number is invalid");
    }
  }

  public boolean validateWithSOAPFaultException(CreditCard21 creditCard) throws SOAPException {

    Character lastDigit = creditCard.getNumber().charAt(creditCard.getNumber().length() - 1);

    if (Integer.parseInt(lastDigit.toString()) % 2 == 0) {
      return true;
    } else {
      SOAPFactory soapFactory = SOAPFactory.newInstance();
      SOAPFault fault = soapFactory.createFault("The credit card number is invalid", new QName("ValidationFault"));
      throw new CardValidatorSOAPFaultException21(fault);
    }
  }

  public static void main(String[] args) {
    Endpoint.publish("http://localhost:8080/cardValidator14", new CardValidator21());
  }
}