package org.agoncal.book.javaee7.chapter15.ex05;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Path("/05/items")
public class ItemRestService05 {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Context
  private UriInfo uriInfo;

  // ======================================
  // =           Public Methods           =
  // ======================================

  /**
   * curl http://localhost:8080/chapter15-service-1.0/rs/05/items
   */
  @GET
  public Items05 getItems() {
    System.out.println("getItems");
    Items05 items = new Items05();
    items.add(new Book05("The Hitchhiker's Guide to the Galaxy", 12.5F, "Science fiction comedy book", "1-84023-742-2", 354, false));
    items.add(new Book05("The Hitchhiker's Guide to the Galaxy", 12.5F, "Science fiction comedy book", "1-84023-742-2", 354, false));
    return items;
  }

  /**
   * curl http://localhost:8080/chapter15-service-1.0/rs/05/items/books
   */
  @GET
  @Path("/books")
  public List<Book05> getBooks() {
    System.out.println("getBooks");
    List<Book05> books = new ArrayList<>();
    books.add(new Book05("The Hitchhiker's Guide to the Galaxy", 12.5F, "Science fiction comedy book", "1-84023-742-2", 354, false));
    books.add(new Book05("The Hitchhiker's Guide to the Galaxy", 12.5F, "Science fiction comedy book", "1-84023-742-2", 354, false));
    return books;
  }

  /**
   * curl http://localhost:8080/chapter15-service-1.0/rs/05/items/books/1234
   */
  @GET
  @Path("/book/{bookid}")
  public Book05 getBook(@PathParam("bookid") String id) {
    System.out.println("getBook : " + id);
    return new Book05("The Hitchhiker's Guide to the Galaxy", 12.5F, "Science fiction comedy book", "1-84023-742-2", 354, false);
  }

  /**
   * curl -X POST http://localhost:8080/chapter15-service-1.0/rs/05/items/books
   */
  @POST
  @Path("/book")
  public Response createBook(Book05 book) {
    System.out.println("createBook");
    book.setId(123L);
    URI bookUri = uriInfo.getAbsolutePathBuilder().path(book.getId().toString()).build();
    return Response.created(bookUri).build();
  }

  /**
   * curl -X DELETE http://localhost:8080/chapter15-service-1.0/rs/05/items/1234
   */
  @DELETE
  @Path("/book/{bookid : \\d+}")
  public Response deleteBook(@PathParam("bookid") String id) {
    System.out.println("deleteBook : " + id);
    return Response.noContent().build();
  }
}
