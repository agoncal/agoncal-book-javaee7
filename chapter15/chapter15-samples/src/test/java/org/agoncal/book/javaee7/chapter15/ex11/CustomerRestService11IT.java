package org.agoncal.book.javaee7.chapter15.ex11;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
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
public class CustomerRestService11IT {

  // ======================================
  // =             Attributes             =
  // ======================================

  private static HttpServer server;
  private static URI uri = UriBuilder.fromUri("http://localhost/").port(8282).build();
  private static Client client = ClientBuilder.newClient();

  public static final String CUSTOMER_TEXT = "Customer11{id=null, firstName='John', lastName='Smith', email='jsmith@gmail.com', phoneNumber='1234565'}";
  public static final String CUSTOMER_HTML = "<h1>Customer</h1><p>Customer11{id=null, firstName='John', lastName='Smith', email='jsmith@gmail.com', phoneNumber='1234565'}</p><hr/>";
  public static final String CUSTOMER_XML = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><customer11><email>jsmith@gmail.com</email><firstName>John</firstName><lastName>Smith</lastName><phoneNumber>1234565</phoneNumber></customer11>";
  public static final String CUSTOMER_JSON = "{\"email\":\"jsmith@gmail.com\",\"firstName\":\"John\",\"lastName\":\"Smith\",\"phoneNumber\":\"1234565\"}";

  // ======================================
  // =          Lifecycle Methods         =
  // ======================================

  @BeforeClass
  public static void init() throws IOException {
    // create a new server listening at port 8080
    server = HttpServer.create(new InetSocketAddress(uri.getPort()), 0);

    // create a handler wrapping the JAX-RS application
    HttpHandler handler = RuntimeDelegate.getInstance().createEndpoint(new ApplicationConfig11(), HttpHandler.class);

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
    Customer11 customer = new Customer11("John", "Smith", "jsmith@gmail.com", "1234565");
    StringWriter writer = new StringWriter();
    JAXBContext context = JAXBContext.newInstance(Customer11.class);
    Marshaller m = context.createMarshaller();
    m.marshal(customer, writer);
  }

  @Test
  public void shouldGetCustomerAsPlainText() {
    Response response = client.target("http://localhost:8282/11/customer").request(MediaType.TEXT_PLAIN).get();
    assertEquals(200, response.getStatus());
    assertEquals(CUSTOMER_TEXT, response.readEntity(String.class));
  }

  @Test
  public void shouldGetCustomerAsHTML() {
    Response response = client.target("http://localhost:8282/11/customer").request(MediaType.TEXT_HTML).get();
    assertEquals(200, response.getStatus());
    assertEquals(CUSTOMER_HTML, response.readEntity(String.class));
  }

  @Test
  public void shouldGetCustomerAsXML() {
    Response response = client.target("http://localhost:8282/11/customer").request(MediaType.APPLICATION_XML).get();
    assertEquals(200, response.getStatus());
    assertEquals(CUSTOMER_XML, response.readEntity(String.class));
  }

  @Test
  public void shouldGetCustomerAsJSON() {
    Response response = client.target("http://localhost:8282/11/customer").request(MediaType.APPLICATION_JSON).get();
    assertEquals(200, response.getStatus());
    assertEquals(CUSTOMER_JSON, response.readEntity(String.class));
  }
}