package org.agoncal.book.javaee7.chapter15;

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

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class BookRestServiceIT {

  // ======================================
  // =             Attributes             =
  // ======================================

  private static URI uri = UriBuilder.fromUri("http://localhost/chapter15-service-1.0/rs/book").port(8080).build();
  private static Client client = ClientBuilder.newClient();

  private static final String XML = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><book><description>Science fiction comedy book</description><illustrations>false</illustrations><isbn>1-84023-742-2</isbn><nbOfPage>354</nbOfPage><price>12.5</price><title>The Hitchhiker's Guide to the Galaxy</title></book>";

  // ======================================
  // =              Unit tests            =
  // ======================================


  @Test
  public void shouldMarshallABook() throws JAXBException {
    // given
    Book book = new Book("The Hitchhiker's Guide to the Galaxy", 12.5F, "Science fiction comedy book", "1-84023-742-2", 354, false);
    StringWriter writer = new StringWriter();
    JAXBContext context = JAXBContext.newInstance(Book.class);
    Marshaller m = context.createMarshaller();
    m.marshal(book, writer);

    // then
    assertEquals(XML, writer.toString());
  }

  @Test
  public void shouldMarshallAListOfBooks() throws JAXBException {
    Books books = new Books();
    books.add(new Book("The Hitchhiker's Guide to the Galaxy", 12.5F, "Science fiction comedy book", "1-84023-742-2", 354, false));
    books.add(new Book("The Hitchhiker's Guide to the Galaxy", 12.5F, "Science fiction comedy book", "1-84023-742-2", 354, false));
    StringWriter writer = new StringWriter();
    JAXBContext context = JAXBContext.newInstance(Books.class);
    Marshaller m = context.createMarshaller();
    m.marshal(books, writer);
  }


  @Test
  public void shouldCreateAndDeleteABook() throws JAXBException {

    Book book = new Book("The Hitchhiker's Guide to the Galaxy", 12.5F, "Science fiction comedy book", "1-84023-742-2", 354, false);

    // POSTs a Book
    Response response = client.target(uri).request().post(Entity.entity(book, MediaType.APPLICATION_XML));
    assertEquals(Response.Status.CREATED, response.getStatusInfo());
    URI bookURI = response.getLocation();

    // With the location, GETs the Book
    response = client.target(bookURI).request().get();
    book = response.readEntity(Book.class);
    assertEquals(Response.Status.OK, response.getStatusInfo());
    assertEquals("The Hitchhiker's Guide to the Galaxy", book.getTitle());

    // Gets the book id and DELETEs it
    String bookId = bookURI.toString().split("/")[6];
    response = client.target(uri).path(bookId).request().delete();
    assertEquals(Response.Status.NO_CONTENT, response.getStatusInfo());

    // GETs the Book and checks it has been deleted
    response = client.target(bookURI).request().get();
    assertEquals(Response.Status.NOT_FOUND, response.getStatusInfo());

  }

  @Test
  public void shouldNotCreateANullBook() throws JAXBException {

    // POSTs a Null Book
    Response response = client.target(uri).request().post(Entity.entity(null, MediaType.APPLICATION_XML));
    assertEquals(Response.Status.BAD_REQUEST, response.getStatusInfo());
  }

  @Test
  public void shouldNotFindTheBookID() throws JAXBException {

    // GETs a Book with an unknown ID
    Response response = client.target(uri).path("invalidID").request().get();
    assertEquals(Response.Status.NOT_FOUND, response.getStatusInfo());
  }
}