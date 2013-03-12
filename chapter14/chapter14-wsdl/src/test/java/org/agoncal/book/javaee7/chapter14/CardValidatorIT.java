package org.agoncal.book.javaee7.chapter14;

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

    // Publishes the SOAP Web Service
    Endpoint endpoint = Endpoint.publish("http://localhost:8080/cardValidator", new CardValidator());
    assertTrue(endpoint.isPublished());
    assertEquals("http://schemas.xmlsoap.org/wsdl/soap/http", endpoint.getBinding().getBindingID());

    // Data to access the web service
    URL wsdlDocumentLocation = new URL("http://localhost:8080/cardValidator?wsdl");
    String namespaceURI = "http://chapter14.javaee7.book.agoncal.org/";
    String servicePart = "CardValidatorService";
    String portName = "CardValidatorPort";
    QName serviceQN = new QName(namespaceURI, servicePart);
    QName portQN = new QName(namespaceURI, portName);

    // Creates a service instance
    Service service = Service.create(wsdlDocumentLocation, serviceQN);
    Validator cardValidator = service.getPort(portQN, Validator.class);

    // Invokes the web service
    CreditCard creditCard = new CreditCard("12341234", "10/10", 1234, "VISA");

    assertTrue("Credit card should be valid", cardValidator.validate(creditCard));
    creditCard.setNumber("12341233");
    assertFalse("Credit card should not be valid", cardValidator.validate(creditCard));

    // Unpublishes the SOAP Web Service
    endpoint.stop();
    assertFalse(endpoint.isPublished());
  }
}
