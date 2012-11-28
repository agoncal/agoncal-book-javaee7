package org.agoncal.book.javaee7.chapter22.ex03;

import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import org.agoncal.book.javaee7.chapter22.ApplicationConfig;
import org.glassfish.jersey.message.internal.MediaTypes;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientFactory;
import javax.ws.rs.client.WebTarget;
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
public class BookRestService03IT {

  // ======================================
  // =             Attributes             =
  // ======================================

  private static HttpServer server;
  private static URI uri = UriBuilder.fromUri("http://localhost/").port(8282).build();
  private static Client client = ClientFactory.newClient();

  // ======================================
  // =          Lifecycle Methods         =
  // ======================================

  @BeforeClass
  public static void init() throws IOException {
    // create a new server listening at port 8080
    server = HttpServer.create(new InetSocketAddress(uri.getPort()), 0);

    // create a handler wrapping the JAX-RS application
    HttpHandler handler = RuntimeDelegate.getInstance().createEndpoint(new ApplicationConfig03(), HttpHandler.class);

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
  public void shouldCheckForH2G2WithWebTarget() {
    WebTarget target = client.target(uri + "03/book");
    assertEquals("H2G2", target.request(MediaType.TEXT_PLAIN).get(String.class));
  }

  @Test
  public void shouldCheckForH2G2() {
    assertEquals("H2G2", client.target(uri).path("03/book").request(MediaType.TEXT_PLAIN).get(String.class));
  }

  @Test
  public void shouldCheckForH2G2WithSeveralPaths() {
    assertEquals("H2G2", client.target(uri).path("03").path("book").request(MediaType.TEXT_PLAIN).get(String.class));
  }

  @Test
  public void shouldCheckForH2G2WithResponse() {
    Response response = client.target(UriBuilder.fromUri(uri).path("03/book").build()).request("text/plain").get();
    assertEquals(200, response.getStatus());
    assertTrue(response.hasEntity());
    assertTrue("H2G2".equals(response.readEntity(String.class)));
  }

  @Test
  public void shouldCheckForApplicationWadl() {
    assertTrue(ClientFactory.newClient().target(uri).path("application.wadl").request(MediaTypes.WADL).get(String.class).length() > 0);
  }
}