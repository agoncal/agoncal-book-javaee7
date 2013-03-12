package org.agoncal.book.javaee7.chapter15.ex04;

import com.sun.net.httpserver.HttpServer;
import org.junit.Test;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
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
public class BookRestService04IT {

  // ======================================
  // =             Attributes             =
  // ======================================

  private static HttpServer server;
  private static URI uri = UriBuilder.fromUri("http://localhost/chapter15-service-1.0/rs").port(8080).build();
  private static Client client = ClientBuilder.newClient();

  private static final String XML = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><book04><description>Science fiction comedy book</description><illustrations>false</illustrations><isbn>1-84023-742-2</isbn><nbOfPage>354</nbOfPage><price>12.5</price><title>The Hitchhiker's Guide to the Galaxy</title></book04>";

  // ======================================
  // =              Unit tests            =
  // ======================================


  @Test
  public void shouldMarshallABook() throws JAXBException {
    // given
    Book04 book = new Book04("The Hitchhiker's Guide to the Galaxy", 12.5F, "Science fiction comedy book", "1-84023-742-2", 354, false);
    StringWriter writer = new StringWriter();
    JAXBContext context = JAXBContext.newInstance(Book04.class);
    Marshaller m = context.createMarshaller();
    m.marshal(book, writer);

    // then
    assertEquals(XML, writer.toString());
  }

  @Test
  public void shouldMarshallAListOfBooks() throws JAXBException {
    Books04 books = new Books04();
    books.add(new Book04("The Hitchhiker's Guide to the Galaxy", 12.5F, "Science fiction comedy book", "1-84023-742-2", 354, false));
    books.add(new Book04("The Hitchhiker's Guide to the Galaxy", 12.5F, "Science fiction comedy book", "1-84023-742-2", 354, false));
    StringWriter writer = new StringWriter();
    JAXBContext context = JAXBContext.newInstance(Books04.class);
    Marshaller m = context.createMarshaller();
    m.marshal(books, writer);
  }


  @Test
  public void shouldCreateABook() throws JAXBException {
    // given
    Book04 book = new Book04("The Hitchhiker's Guide to the Galaxy", 12.5F, "Science fiction comedy book", "1-84023-742-2", 354, false);
    StringWriter writer = new StringWriter();
    JAXBContext context = JAXBContext.newInstance(Book04.class);
    Marshaller m = context.createMarshaller();
    m.marshal(book, writer);

    // when
    Response response = client.target(uri).path("/04/books").request().post(Entity.entity(book, "application/xml"));

    // then
    assertEquals(201, response.getStatus());
    assertTrue(response.getLocation().toString().startsWith("http://localhost:8080/chapter15-service-1.0/rs/04/books"));

    // when
    response = client.target(response.getLocation()).request(MediaType.APPLICATION_XML).get();

    // then
    assertEquals(200, response.getStatus());
    assertTrue(response.hasEntity());

    System.out.println("########## " + response.getEntity());

    book = response.readEntity(Book04.class);
    assertEquals("The Hitchhiker's Guide to the Galaxy", book.getTitle());
    assertEquals("Science fiction comedy book", book.getDescription());
  }
}