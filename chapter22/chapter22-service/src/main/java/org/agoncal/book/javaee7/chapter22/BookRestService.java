package org.agoncal.book.javaee7.chapter22;

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

  //    @Inject
  @PersistenceContext(unitName = "chapter22PU")
  private EntityManager em;
  @Context
  private UriInfo uriInfo;

  // ======================================
  // =           Public Methods           =
  // ======================================

  /**
   * curl -X POST --data-binary "{ \"title\":\"H2G2\", \"description\":\"Scifi IT book\", \"illustrations\":\"false\",\"isbn\":\"134-234\",\"nbOfPage\":\"241\",\"price\":\"24.0\" }" -H "Content-Type: application/json" http://localhost:8080/chapter22-service-1.0/rs//books -v
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
   * JSON : curl -X GET -H "Accept: application/json" http://localhost:8080/chapter22-service-1.0/rs//books/4
   * XML  : curl -X GET -H "Accept: application/xml" http://localhost:8080/chapter22-service-1.0/rs//books/4
   */
  @GET
  @Path("{id}/")
  public Book getBookById(@PathParam("id") String id) {
    Book book = em.find(Book.class, id);

    if (book == null)
      throw new NotFoundException();

    return book;
  }

  /**
   * curl -X DELETE http://localhost:8080/chapter22-service-1.0/rs//books/4 -v
   */
  @DELETE
  @Path("{id}/")
  public void deleteBook(@PathParam("id") String id) {
    Book book = em.find(Book.class, id);

    if (book == null)
      throw new NotFoundException();

    em.remove(book);
  }

  @GET
  public Books getAllBooks() {
    TypedQuery<Book> query = em.createNamedQuery(Book.FIND_ALL, Book.class);
    return new Books(query.getResultList());
  }
}