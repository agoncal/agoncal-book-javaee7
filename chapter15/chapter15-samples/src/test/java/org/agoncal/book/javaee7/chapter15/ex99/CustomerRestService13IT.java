package org.agoncal.book.javaee7.chapter15.ex99;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import org.agoncal.book.javaee7.chapter15.ex13.Customer13;
import org.agoncal.book.javaee7.chapter15.ex13.Customers13;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
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

import static org.junit.Assert.assertEquals;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class CustomerRestService13IT {

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
    HttpHandler handler = RuntimeDelegate.getInstance().createEndpoint(new ApplicationConfig13(), HttpHandler.class);

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
    Customer13 customer = new Customer13("John", "Smith", "jsmith@gmail.com", "1334565");
    StringWriter writer = new StringWriter();
    JAXBContext context = JAXBContext.newInstance(Customer13.class);
    Marshaller m = context.createMarshaller();
    m.marshal(customer, writer);
  }

  @Test
  public void shouldMarshallAListOfCustomers() throws JAXBException {
    Customers13 customers = new Customers13();
    customers.add(new Customer13("John", "Smith", "jsmith@gmail.com", "1334565"));
    customers.add(new Customer13("John", "Smith", "jsmith@gmail.com", "1334565"));
    StringWriter writer = new StringWriter();
    JAXBContext context = JAXBContext.newInstance(Customers13.class);
    Marshaller m = context.createMarshaller();
    m.marshal(customers, writer);
  }

  @Test
  public void shouldFailAsCustomerIDStartsWithCust() {
    Response response = client.target("http://localhost:8282/13/customer/doesNotStartWithCust").request().get();
    assertEquals(500, response.getStatus());
  }

  @Test
  public void shouldNotFindBecauseEntityManagerIsNull() {
    Response response = client.target("http://localhost:8282/13/customer/cust1334").request().get();
    assertEquals(404, response.getStatus());
  }

  @Test
  public void shouldCreateACustomerWithURIBuilderFromUri() {
    Response response = client.target("http://localhost:8282/13/customer/fromUri").request().post(Entity.entity(new Customer13("John", "Smith", "jsmith@gmail.com", "1334565"), MediaType.APPLICATION_XML));
    assertEquals(201, response.getStatus());
    assertEquals("http://localhost:8282/13/customer/1334", response.getLocation().toString());
  }

  @Test
  public void shouldCreateACustomerWithURIBuilderFromMethod() {
    Response response = client.target("http://localhost:8282/13/customer/fromMethod").request().post(Entity.entity(new Customer13("John", "Smith", "jsmith@gmail.com", "1334565"), MediaType.APPLICATION_XML));
    assertEquals(201, response.getStatus());
    assertEquals("fromMethod", response.getLocation().toString());
  }

  @Test
  public void shouldCreateACustomerWithURIBuilderFromResource() {
    Response response = client.target("http://localhost:8282/13/customer/fromResource").request().post(Entity.entity(new Customer13("John", "Smith", "jsmith@gmail.com", "1334565"), MediaType.APPLICATION_XML));
    assertEquals(201, response.getStatus());
    assertEquals("/13/customer/1334", response.getLocation().toString());
  }

  @Test
  public void shouldUpdateCustomer() {
    Response response = client.target("http://localhost:8282/13/customer/cust1334").request().put(Entity.entity(new Customer13("John", "Smith", "jsmith@gmail.com", "1334565"), MediaType.APPLICATION_XML));
    assertEquals(200, response.getStatus());
  }

  @Test
  public void shouldDeleteCustomer() {
    Response response = client.target("http://localhost:8282/13/customer/cust1334").request().delete();
    assertEquals(204, response.getStatus());
  }
}