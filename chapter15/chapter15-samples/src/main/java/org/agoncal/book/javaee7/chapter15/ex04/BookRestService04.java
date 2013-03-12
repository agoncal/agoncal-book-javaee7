package org.agoncal.book.javaee7.chapter15.ex04;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 *         <p/>
 *         GET the books in XML : curl http://localhost:8080/chapter15-service-1.0/rs/04/books
 *         GET the books in JSon : curl -H "Accept: application/json" http://localhost:8080/chapter15-service-1.0/rs/04/books
 *         <p/>
 *         POST a book with title : curl -X POST --data-binary "H2G2" -H "Content-Type: text/plain" http://localhost:8080/chapter15-service-1.0/rs/04/books -v
 *         <p/>
 *         POST a new book : curl -X POST --data-binary "{ \"title\":\"H2G2\", \"description\":\"Scifi IT book\", \"illustrations\":\"false\",\"isbn\":\"134-234\",\"nbOfPage\":\"241\",\"price\":\"24.0\" }" -H "Content-Type: application/json" http://localhost:8080/chapter15-service-1.0/rs/04/books -v
 *         POST a new book : curl -X POST --data-binary "<book04><description>Science fiction comedy book</description><illustrations>false</illustrations><isbn>1-84023-742-2</isbn><nbOfPage>354</nbOfPage><price>12.5</price><title>The Hitchhiker's Guide to the Galaxy</title></book04>" -H "Content-Type: application/xml" http://localhost:8080/chapter15-service-1.0/rs/04/books -v
 *         <p/>
 *         DELETE a book : curl -X DELETE -H "Content-Type: text/plain" http://localhost:8080/chapter15-service-1.0/rs/04/books/2 -v
 */
@Path("/04/books")
@Stateless
public class BookRestService04 {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Context
  private UriInfo uriInfo;
  //  @Inject
  @PersistenceContext(unitName = "chapter15PU")
  private EntityManager em;

  // ======================================
  // =           Public Methods           =
  // ======================================

  @GET
  @Produces(MediaType.APPLICATION_XML)
  public Books04 getAllBooks() {
    TypedQuery<Book04> query = em.createNamedQuery(Book04.FIND_ALL, Book04.class);
    Books04 books = new Books04(query.getResultList());
    return books;
  }

  @GET
  @Path("{id}")
  @Produces(MediaType.APPLICATION_XML)
  public Book04 getBook(@PathParam("id") Long bookId) {
    return em.find(Book04.class, bookId);
  }

  @POST
  @Consumes(MediaType.APPLICATION_XML)
  public Response createBook(Book04 book) {
    em.persist(book);
    URI bookUri = uriInfo.getAbsolutePathBuilder().path(book.getId().toString()).build();
    return Response.created(bookUri).build();
  }

  @POST
  @Consumes(MediaType.TEXT_PLAIN)
  public Response createBookWithTitle(String title) {
    Book04 book = new Book04();
    book.setTitle(title);
    em.persist(book);
    URI bookUri = uriInfo.getAbsolutePathBuilder().path(book.getId().toString()).build();
    return Response.created(bookUri).build();
  }

  @DELETE
  @Path("{id}")
  public Response deleteBook(@PathParam("id") Long bookId) {
    em.remove(em.find(Book04.class, bookId));
    return Response.noContent().build();
  }
}
