package org.agoncal.book.javaee7.chapter20.ex14;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.xml.bind.JAXBElement;
import java.net.URI;
import java.util.List;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Path("/14/books")
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Stateless
public class BookRestService14 {

    // ======================================
    // =             Attributes             =
    // ======================================

    @Inject
    private EntityManager em;
    @Context
    private UriInfo uriInfo;

    // ======================================
    // =           Public Methods           =
    // ======================================

    /**
     * curl -X POST --data-binary "{ \"title\":\"H2G2\", \"description\":\"Scifi IT book\", \"illustrations\":\"false\",\"isbn\":\"134-234\",\"nbOfPage\":\"241\",\"price\":\"24.0\" }" -H "Content-Type: application/json" http://localhost:8080/chapter20-service-1.0/rs/14/books -v
     */
    @POST
    public Response createNewBook(JAXBElement<Book14> bookJaxb) {
        Book14 book = bookJaxb.getValue();
        em.persist(book);
        URI bookUri = uriInfo.getAbsolutePathBuilder().path(book.getId().toString()).build();
        return Response.created(bookUri).build();
    }

    /**
     * JSON : curl -X GET -H "Accept: application/json" http://localhost:8080/chapter20-service-1.0/rs/14/books/4
     * XML  : curl -X GET -H "Accept: application/xml" http://localhost:8080/chapter20-service-1.0/rs/14/books/4
     */
    @GET
    @Path("{id}/")
    public Book14 getBookById(@PathParam("id") Long id) {
        Book14 book = em.find(Book14.class, id);
        return book;
    }

    /**
     * curl -X DELETE http://localhost:8080/chapter20-service-1.0/rs/14/books/4 -v
     */
    @DELETE
    @Path("{id}/")
    public void deleteBook(@PathParam("id") Long id) {
        Book14 book = em.find(Book14.class, id);
        em.remove(book);
    }

    @GET
    public List<Book14> getAllBooks() {
        Query query = em.createNamedQuery(Book14.FIND_ALL);
        List<Book14> books = query.getResultList();
        return books;
    }
}