package org.agoncal.book.javaee7.chapter21.ex22;

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
public class CardValidator22 {

  // ======================================
  // =           Public Methods           =
  // ======================================

  public boolean validate(CreditCard22 creditCard) {

    Character lastDigit = creditCard.getNumber().charAt(creditCard.getNumber().length() - 1);

    if (Integer.parseInt(lastDigit.toString()) % 2 == 0) {
      return true;
    } else {
      return false;
    }
  }

  public boolean validateWithException(CreditCard22 creditCard) throws CardValidatorException22 {

    Character lastDigit = creditCard.getNumber().charAt(creditCard.getNumber().length() - 1);

    if (Integer.parseInt(lastDigit.toString()) % 2 == 0) {
      return true;
    } else {
      throw new CardValidatorException22("toto");
    }
  }

  public boolean validateWithRTException(CreditCard22 creditCard) {

    Character lastDigit = creditCard.getNumber().charAt(creditCard.getNumber().length() - 1);

    if (Integer.parseInt(lastDigit.toString()) % 2 == 0) {
      return true;
    } else {
      throw new CardValidatorRTException22("toto");
    }
  }

  public boolean validateWithSOAPFaultException(CreditCard22 creditCard) throws SOAPException {

    Character lastDigit = creditCard.getNumber().charAt(creditCard.getNumber().length() - 1);

    if (Integer.parseInt(lastDigit.toString()) % 2 == 0) {
      return true;
    } else {
      SOAPFactory soapFactory = SOAPFactory.newInstance();
      SOAPFault fault = soapFactory.createFault("Reason Text", new QName("tututututututu"));
      throw new CardValidatorSOAPFaultException22(fault);
    }
  }

  public static void main(String[] args) {
    Endpoint.publish("http://localhost:8080/cardValidator22", new CardValidator22());
  }
}