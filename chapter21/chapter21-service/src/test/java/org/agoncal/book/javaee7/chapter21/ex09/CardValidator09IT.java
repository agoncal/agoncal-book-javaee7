package org.agoncal.book.javaee7.chapter21.ex09;

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
public class CardValidator09IT {

  @Test
  public void shouldCheckCreditCardValidity() throws MalformedURLException {

    Endpoint endpoint = Endpoint.publish("http://localhost:8080/cardValidator", new CardValidator09());
    assertTrue(endpoint.isPublished());
    assertEquals("http://schemas.xmlsoap.org/wsdl/soap/http", endpoint.getBinding().getBindingID());

    String url = "http://localhost:8080/cardValidator?wsdl";
    String namespace = "http://ex09.chapter21.javaee7.book.agoncal.org/";
    QName serviceQN = new QName(namespace, "CardValidator09Service");
    Service service = Service.create(new URL(url), serviceQN);
    String portName = "CardValidator09Port";
    QName portQN = new QName(namespace, portName);

    Validator09 cardValidator = service.getPort(portQN, Validator09.class);

    CreditCard09 creditCard = new CreditCard09("12341234", "10/10", 1234, "VISA");
    assertFalse("Credit card should be valid", cardValidator.validate(creditCard));
    creditCard.setNumber("2");
    assertFalse("Credit card should be valid", cardValidator.validate(creditCard));

    creditCard.setNumber("12341233");
    assertTrue("Credit card should not be valid", cardValidator.validate(creditCard));
    creditCard.setNumber("1");
    assertTrue("Credit card should not be valid", cardValidator.validate(creditCard));

    endpoint.stop();
    assertFalse(endpoint.isPublished());
  }
}
