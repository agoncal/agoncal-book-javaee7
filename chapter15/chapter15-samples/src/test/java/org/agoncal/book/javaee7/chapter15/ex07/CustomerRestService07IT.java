package org.agoncal.book.javaee7.chapter15.ex07;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.Cookie;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.ext.RuntimeDelegate;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.StringWriter;
import java.net.InetSocketAddress;
import java.net.URI;
import java.util.Date;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class CustomerRestService07IT {

  // ======================================
  // =             Attributes             =
  // ======================================

  private static HttpServer server;
  private static URI uri = UriBuilder.fromUri("http://localhost/").port(8282).build();
  private static Client client = ClientBuilder.newClient();

  // ======================================
  // =          Lifecycle Methods         =
  // ======================================

  @BeforeClass
  public static void init() throws IOException {
    // create a new server listening at port 8080
    server = HttpServer.create(new InetSocketAddress(uri.getPort()), 0);

    // create a handler wrapping the JAX-RS application
    HttpHandler handler = RuntimeDelegate.getInstance().createEndpoint(new ApplicationConfig07(), HttpHandler.class);

    // map JAX-RS handler to the server root
    server.createContext(uri.getPath(), handler);

    // start the server
    server.start();
  }

  @AfterClass
  public static void stop() {
    server.stop(0);
  }

  // ======================================
  // =              Unit tests            =
  // ======================================

  @Test
  public void shouldMarshallACustomer() throws JAXBException {
    Customer07 customer = new Customer07("John", "Smith", "jsmith@gmail.com", "1234565", new Date(), new Date());
    StringWriter writer = new StringWriter();
    JAXBContext context = JAXBContext.newInstance(Customer07.class);
    Marshaller m = context.createMarshaller();
    m.marshal(customer, writer);
  }

  @Test
  public void shouldMarshallAListOfCustomers() throws JAXBException {
    Customers07 customers = new Customers07();
    customers.add(new Customer07("John", "Smith", "jsmith@gmail.com", "1234565", new Date(), new Date()));
    customers.add(new Customer07("John", "Smith", "jsmith@gmail.com", "1234565", new Date(), new Date()));
    StringWriter writer = new StringWriter();
    JAXBContext context = JAXBContext.newInstance(Customers07.class);
    Marshaller m = context.createMarshaller();
    m.marshal(customers, writer);
  }

  @Test
  public void shouldCheckSearchCustomerURI() {
    Response response = client.target("http://localhost:8282/07/customer/search/agoncal").request().get();
    assertEquals(200, response.getStatus());
  }

  @Test
  public void shouldCheckGetCustomerByLoginURI() {
    Response response = client.target("http://localhost:8282/07/customer/agoncal").request().get();
    assertEquals(200, response.getStatus());
  }

  @Test
  public void shouldCheckGetCustomerByIdURI() {
    Response response = client.target("http://localhost:8282/07/customer/1234").request().get();
    assertEquals(200, response.getStatus());
  }

  @Test
  public void shouldCheckGetCustomerByZipCodeCityURI() {
    Response response = client.target("http://localhost:8282/07/customer?zip=75012&city=Paris").request().get();
    assertEquals(200, response.getStatus());
  }

  @Test
  public void shouldCheckGetCustomerByZipCodeURI() {
    Response response = client.target("http://localhost:8282/07/customer?zip=75001").request().get();
    assertEquals(200, response.getStatus());
  }

  @Test
  public void shouldCheckGetCustomerByZipCodeWithParamURI() {
    Response response = client.target("http://localhost:8282/07/customer").queryParam("zip", 75011L).request().get();
    assertEquals(200, response.getStatus());
  }

  @Test
  public void shouldCheckGetCustomerByFirstnameNameURI() {
    Response response = client.target("http://localhost:8282/07/customer/search;firstname=Antonio;surname=Goncalves").request().get();
    assertEquals(200, response.getStatus());
  }

  @Test
  public void shouldCheckGetCustomerByFirstnameURI() {
    Response response = client.target("http://localhost:8282/07/customer/search;firstname=AntonioNull").request().get();
    assertEquals(200, response.getStatus());
  }

  @Test
  public void shouldCheckGetCustomerByFirstnameNameWithParamURI() {
    Response response = client.target("http://localhost:8282/07/customer/search").matrixParam("firstname", "Antonio2").matrixParam("surname", "Goncalves2").request().get();
    assertEquals(200, response.getStatus());
  }

  @Test
  public void shouldCheckGetCustomerWithCookieParamURI() {
    Cookie myCookie = new Cookie("sessionID", "This is my cookie");
    String response = client.target("http://localhost:8282/07/customer/cookie").request().cookie(myCookie).get(String.class);
    assertEquals("This is my cookie from the server", response);
  }

  @Test
  public void shouldEchoUserAgentValue() {
    String response = client.target("http://localhost:8282/07/customer/userAgent").request().get(String.class);
    assertTrue(response.startsWith("Jersey/2.0"));
  }

  @Test
  public void shouldEchoUserAgentWithReponse() {
    Response response = client.target("http://localhost:8282/07/customer/userAgentRep").request().get();
    assertEquals(200, response.getStatus());
    assertTrue(response.readEntity(String.class).startsWith("Jersey/2.0"));
  }
}
