package org.agoncal.book.javaee7.chapter15.ex12;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.*;
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

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class CustomerRestService12IT {

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
    HttpHandler handler = RuntimeDelegate.getInstance().createEndpoint(new ApplicationConfig12(), HttpHandler.class);

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
    Customer12 customer = new Customer12("John", "Smith", "jsmith@gmail.com", "1234565");
    StringWriter writer = new StringWriter();
    JAXBContext context = JAXBContext.newInstance(Customer12.class);
    Marshaller m = context.createMarshaller();
    m.marshal(customer, writer);
  }

  @Test
  public void shouldMarshallAListOfCustomers() throws JAXBException {
    Customers12 customers = new Customers12();
    customers.add(new Customer12("John", "Smith", "jsmith@gmail.com", "1234565"));
    customers.add(new Customer12("John", "Smith", "jsmith@gmail.com", "1234565"));
    StringWriter writer = new StringWriter();
    JAXBContext context = JAXBContext.newInstance(Customers12.class);
    Marshaller m = context.createMarshaller();
    m.marshal(customers, writer);
  }

  @Test
  public void shouldGetgetMaximumBonusAllowed() {
    Response response = client.target("http://localhost:8282/12/customer/max").request(MediaType.TEXT_PLAIN).get();
    assertEquals(200, response.getStatus());
    assertEquals((Object) 1234L, response.readEntity(Long.class));
  }

  @Test
  public void shouldGetAsPlainText() {
    Response response = client.target("http://localhost:8282/12/customer").request(MediaType.TEXT_PLAIN).get();
    assertEquals(200, response.getStatus());
    assertEquals("Customer11{id=null, firstName='John', lastName='Smith', email='jsmith@gmail.com', phoneNumber='1234565'}", response.readEntity(String.class));
  }

  @Test
  public void shouldGetStringAsXML() {
    Response response = client.target("http://localhost:8282/12/customer").request(MediaType.APPLICATION_XML).get();
    assertEquals(200, response.getStatus());
    assertEquals("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><customer12><email>jsmith@gmail.com</email><firstName>John</firstName><lastName>Smith</lastName><phoneNumber>1234565</phoneNumber></customer12>", response.readEntity(String.class));
  }

  @Test
  public void shouldGetAsJSon() {
    Response response = client.target("http://localhost:8282/12/customer").request(MediaType.APPLICATION_JSON).get();
    assertEquals(200, response.getStatus());
    assertEquals("{\"email\":\"jsmith@gmail.com\",\"firstName\":\"John\",\"lastName\":\"Smith\",\"phoneNumber\":\"1234565\"}", response.readEntity(String.class));
  }

  @Test
  public void shouldCheckResponse() {
    Response.ok().build();
    Response.ok().cookie(new NewCookie("SessionID", "5G79GDIFY09")).build();
    Response.ok("Plain Text").expires(new Date()).build();
    Response.ok(new Customer12("John", "Smith", "jsmith@gmail.com", "1234565"), MediaType.APPLICATION_JSON).build();
    Response.noContent().build();
    Response.accepted(new Customer12("John", "Smith", "jsmith@gmail.com", "1234565")).build();
    Response.notModified().header("User-Agent", "Mozilla").build();
  }
}