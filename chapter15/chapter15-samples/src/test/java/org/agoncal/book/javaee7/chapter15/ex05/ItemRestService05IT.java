package org.agoncal.book.javaee7.chapter15.ex05;

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
public class ItemRestService05IT {

  // ======================================
  // =             Attributes             =
  // ======================================

  private static HttpServer server;
  private static URI uri = UriBuilder.fromUri("http://localhost/").port(8282).build();
  private static Client client = ClientBuilder.newClient();

  public static final String XML = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><book05><description>Science fiction comedy book</description><price>12.5</price><title>The Hitchhiker's Guide to the Galaxy</title><illustrations>false</illustrations><isbn>1-84023-742-2</isbn><nbOfPage>354</nbOfPage></book05>";

  // ======================================
  // =          Lifecycle Methods         =
  // ======================================

  @BeforeClass
  public static void init() throws IOException {
    // create a new server listening at port 8080
    server = HttpServer.create(new InetSocketAddress(uri.getPort()), 0);

    // create a handler wrapping the JAX-RS application
    HttpHandler handler = RuntimeDelegate.getInstance().createEndpoint(new ApplicationConfig05(), HttpHandler.class);

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
  public void shouldMarshallABook() throws JAXBException {
    // given
    Book05 book = new Book05("The Hitchhiker's Guide to the Galaxy", 12.5F, "Science fiction comedy book", "1-84023-742-2", 354, false);
    StringWriter writer = new StringWriter();
    JAXBContext context = JAXBContext.newInstance(Book05.class);
    Marshaller m = context.createMarshaller();
    m.marshal(book, writer);

    // then
    assertEquals(XML, writer.toString());
  }

  @Test
  public void shouldMarshallAListOfBooks() throws JAXBException {
    Items05 items05 = new Items05();
    items05.add(new Book05("The Hitchhiker's Guide to the Galaxy", 12.5F, "Science fiction comedy book", "1-84023-742-2", 354, false));
    items05.add(new Book05("The Hitchhiker's Guide to the Galaxy", 12.5F, "Science fiction comedy book", "1-84023-742-2", 354, false));
    StringWriter writer = new StringWriter();
    JAXBContext context = JAXBContext.newInstance(Items05.class);
    Marshaller m = context.createMarshaller();
    m.marshal(items05, writer);
  }

  @Test
  public void shouldCheckGetItemsURI() {
    Response response = client.target("http://localhost:8282/05/items").request().get();
    assertEquals(200, response.getStatus());
  }

  @Test
  public void shouldCheckGetBooksURI() {
    Response response = client.target("http://localhost:8282/05/items/books").request().get();
    assertEquals(200, response.getStatus());
  }

  @Test
  public void shouldCheckGetBookURIWithParam() {
    Response response = client.target("http://localhost:8282/05/items/book/123").request().get();
    assertEquals(200, response.getStatus());
  }

  @Test
  public void shouldCheckGetBookURIWithWrongParam() {
    Response response = client.target("http://localhost:8282/05/items/book/abc").request().get();
    assertEquals(200, response.getStatus());
  }

  @Test
  public void shouldCheckPostBookURI() {
    Response response = client.target("http://localhost:8282/05/items/book").request().post(Entity.entity(new Book05("The Hitchhiker's Guide to the Galaxy", 12.5F, "Science fiction comedy book", "1-84023-742-2", 354, false), MediaType.APPLICATION_XML));
    assertEquals(201, response.getStatus());
  }

  @Test
  public void shouldCheckDeleteBookURIWithParam() {
    Response response = client.target("http://localhost:8282/05/items/book/123").request().delete();
    assertEquals(204, response.getStatus());
  }

  @Test
  public void shouldCheckDeleteBookURIWithWrongParam() {
    Response response = client.target("http://localhost:8282/05/items/book/abc").request().delete();
    assertEquals(204, response.getStatus());
  }

  @Test
  public void shouldCheckDummyURI() {
    Response response = client.target("http://localhost:8282/05/items/dummy").request().get();
    assertEquals(404, response.getStatus());
  }
}