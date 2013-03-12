package org.agoncal.book.javaee7.chapter15.ex15;

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
public class CustomerRestService15IT {

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
    HttpHandler handler = RuntimeDelegate.getInstance().createEndpoint(new ApplicationConfig15(), HttpHandler.class);

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
//    assertEquals("ping", client.target("http://localhost:8282/15/customer/ping").request(MediaType.TEXT_PLAIN).get(String.class));
    assertEquals("ping", client.target("http://localhost:8080/chapter15-service-1.0/rs/15/customer/ping").request(MediaType.TEXT_PLAIN).get(String.class));
  }

  @Test
  public void getGetDefaultMediaType() {
//    Response response = client.target("http://localhost:8282/15/customer/locale").request().get();
    Response response = client.target("http://localhost:8080/chapter15-service-1.0/rs/15/customer/media").request().get();
    assertEquals(200, response.getStatus());
    assertTrue(response.hasEntity());
    assertEquals("text/html", response.readEntity(String.class));
  }

  @Test
  public void shouldCreateCustomer() {
//    Response response = client.target("http://localhost:8282/15/customer/locale").request().get();
    Response response = client.target("http://localhost:8080/chapter15-service-1.0/rs/15/customer").request().post(Entity.entity(new Customer15(1L, "John", "Smith", "jsmith@gmail.com", "1234565"), MediaType.APPLICATION_XML));
    assertEquals(201, response.getStatus());
    assertEquals("http://localhost:8080/chapter15-service-1.0/rs/15/customer/1",response.getLocation().toString());
  }
}