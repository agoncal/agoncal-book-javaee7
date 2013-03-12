package org.agoncal.book.javaee7.chapter15.ex16;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
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
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.URI;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class CustomerRestService16IT {

  // ======================================
  // =             Attributes             =
  // ======================================

  private static HttpServer server;
  private static URI uri = UriBuilder.fromUri("http://localhost/").port(8282).build();
  private static Client client = ClientBuilder.newClient();

  public static final String XML = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><customer16><firstName>John</firstName><id>1234</id><lastName>Smith</lastName></customer16>";
  public static final String CUSTOM = "1234/John/Smith";

  // ======================================
  // =          Lifecycle Methods         =
  // ======================================

  @BeforeClass
  public static void init() throws IOException {
    // create a new server listening at port 8080
    server = HttpServer.create(new InetSocketAddress(uri.getPort()), 0);

    // create a handler wrapping the JAX-RS application
    HttpHandler handler = RuntimeDelegate.getInstance().createEndpoint(new ApplicationConfig16(), HttpHandler.class);

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
  public void shouldPing() {
    assertEquals("ping", client.target("http://localhost:8282/16/customer/ping").request(MediaType.TEXT_PLAIN).get(String.class));
  }

  @Test
  public void shouldGetCustomerAsXML() {
    Response response = client.target("http://localhost:8282/16/customer/1234").request(MediaType.APPLICATION_XML).get();
    assertEquals(200, response.getStatus());
    assertEquals(XML, response.readEntity(String.class));
  }

  @Test
  public void shouldCreateCustomerXML() {
    Response response = client.target("http://localhost:8282/16/customer").request().post(Entity.xml(new Customer16("1234", "John", "Smith")));
    assertEquals(201, response.getStatus());
    assertEquals("/16/customer/1234", response.getLocation().toString());
  }

  @Test
  public void shouldGetCustomerAsCustom() {
    Response response = client.target("http://localhost:8282/16/customer/1234").request("custom/format").get();
    assertEquals(200, response.getStatus());
    assertEquals(CUSTOM, response.readEntity(String.class));
  }


  @Test
  public void shouldCreateCustomerCustom() {
    Response response = client.target("http://localhost:8282/16/customer").request().post(Entity.entity(new Customer16("5678", "John", "Smith"), "custom/format"));
    assertEquals(201, response.getStatus());
    assertEquals("/16/customer/5678", response.getLocation().toString());
  }
}