package org.agoncal.book.javaee7.chapter15;

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
 */
@Path("/book")
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Stateless
public class BookRestService {

  // ======================================
  // =             Attributes             =
  // ======================================

  @PersistenceContext(unitName = "chapter15PU")
  private EntityManager em;
  @Context
  private UriInfo uriInfo;

  // ======================================
  // =           Public Methods           =
  // ======================================

  /**
   * curl -X POST --data-binary "<book><description>Science fiction comedy book</description><illustrations>false</illustrations><isbn>1-84023-742-2</isbn><nbOfPage>354</nbOfPage><price>12.5</price><title>The Hitchhiker's Guide to the Galaxy</title></book>" -H "Content-Type: application/xml" http://localhost:8080/chapter15-service-1.0/rs/book -v
   * curl -X POST --data-binary "{\"description\":\"Science fiction comedy book\",\"illustrations\":false,\"isbn\":\"1-84023-742-2\",\"nbOfPage\":354,\"price\":12.5,\"title\":\"The Hitchhiker's Guide to the Galaxy\"}" -H "Content-Type: application/json" http://localhost:8080/chapter15-service-1.0/rs/book -v
   */
  @POST
  public Response createBook(Book book) {
    if (book == null)
      throw new BadRequestException();

    em.persist(book);
    URI bookUri = uriInfo.getAbsolutePathBuilder().path(book.getId()).build();
    return Response.created(bookUri).build();
  }

  @PUT
  public Response updateBook(Book book) {
    if (book == null)
      throw new BadRequestException();

    em.merge(book);
    return Response.ok().build();
  }

  /**
   * JSON : curl -X GET -H "Accept: application/json" http://localhost:8080/chapter15-service-1.0/rs/book/1 -v
   * XML  : curl -X GET -H "Accept: application/xml" http://localhost:8080/chapter15-service-1.0/rs/book/1 -v
   */
  @GET
  @Path("{id}")
  public Response getBook(@PathParam("id") String id) {
    Book book = em.find(Book.class, id);

    if (book == null)
      throw new NotFoundException();

    return Response.ok(book).build();
  }

  /**
   * curl -X DELETE http://localhost:8080/chapter15-service-1.0/rs/book/1 -v
   */
  @DELETE
  @Path("{id}")
  public Response deleteBook(@PathParam("id") String id) {
    Book book = em.find(Book.class, id);

    if (book == null)
      throw new NotFoundException();

    em.remove(book);

    return Response.noContent().build();
  }

  /**
   * JSON : curl -X GET -H "Accept: application/json" http://localhost:8080/chapter15-service-1.0/rs/book -v
   * XML  : curl -X GET -H "Accept: application/xml" http://localhost:8080/chapter15-service-1.0/rs/book -v
   */
  @GET
  public Response getAllBooks() {
    TypedQuery<Book> query = em.createNamedQuery(Book.FIND_ALL, Book.class);
    Books books = new Books(query.getResultList());
    return Response.ok(books).build();
  }
}