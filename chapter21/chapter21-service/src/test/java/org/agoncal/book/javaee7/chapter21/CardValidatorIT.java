package org.agoncal.book.javaee7.chapter21;

import org.junit.Test;

import javax.xml.namespace.QName;
import javax.xml.ws.Endpoint;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.*;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class CardValidatorIT {

  @Test
  public void shouldCheckCreditCardValidity() throws MalformedURLException {

    Endpoint endpoint = Endpoint.publish("http://localhost:8080/cardValidator", new CardValidator());
    assertTrue(endpoint.isPublished());
    assertEquals("http://schemas.xmlsoap.org/wsdl/soap/http", endpoint.getBinding().getBindingID());

    String url = "http://localhost:8080/cardValidator?wsdl";
    String namespace = "http://chapter21.javaee7.book.agoncal.org/";
    QName serviceQN = new QName(namespace, "CardValidatorService");
    Service service = Service.create(new URL(url), serviceQN);
    String portName = "CardValidatorPort";
    QName portQN = new QName(namespace, portName);

    Validator cardValidator = service.getPort(portQN, Validator.class);

    CreditCard creditCard = new CreditCard("12341234", "10/10", 1234, "VISA");

    assertFalse("Credit card should be valid", cardValidator.validate(creditCard));
    creditCard.setNumber("12341233");
    assertTrue("Credit card should not be valid", cardValidator.validate(creditCard));

    endpoint.stop();
    assertFalse(endpoint.isPublished());
  }
}
