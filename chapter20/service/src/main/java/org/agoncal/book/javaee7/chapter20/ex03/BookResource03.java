package org.agoncal.book.javaee7.chapter20.ex03;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
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
 *         <p/>
 *         GET the books in XML : curl http://localhost:8080/chapter15-resource-2.0/rs/03/books
 *         GET the books in JSon : curl -H "Accept: application/json" http://localhost:8080/chapter15-resource-2.0/rs/03/books
 *         <p/>
 *         POST a new book : curl -X POST --data-binary "{ \"title\":\"H2G2\", \"description\":\"Scifi IT book\", \"illustrations\":\"false\",\"isbn\":\"
 *         134-234\",\"nbOfPage\":\"241\",\"price\":\"24.0\" }" -H "Content-Type: application/json" http://localhost:8080/chapter15-resource-2.0/rs/03/books -v
 */
@Path("/03/books")
@Stateless
@Produces({"application/xml", "application/json"})
@Consumes({"application/xml", "application/json"})
public class BookResource03 {

    // ======================================
    // =             Attributes             =
    // ======================================

    @Context
    private UriInfo uriInfo;
    @PersistenceContext(unitName = "chapter15PU")
    private EntityManager em;

    // ======================================
    // =           Public Methods           =
    // ======================================

    @GET
    public List<Book03> getAllBooks() {
        Query query = em.createNamedQuery(Book03.FIND_ALL);
        List<Book03> books = query.getResultList();
        return books;
    }

    @POST
    public Response createNewBook(JAXBElement<Book03> bookJaxb) {
        Book03 book = bookJaxb.getValue();
        em.persist(book);
        URI bookUri = uriInfo.getAbsolutePathBuilder().path(book.getId().toString()).build();
        return Response.created(bookUri).build();
    }
}
