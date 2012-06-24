package org.agoncal.book.javaee7.chapter20.ex04;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import java.util.List;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Path("/04/items")
public class ItemResource04 {

    // ======================================
    // =           Public Methods           =
    // ======================================

    /**
     * curl http://localhost:8080/chapter15-resource-2.0/rs/04/items
     */
    @GET
    public List<Item04> getListOfItems() {
        System.out.println("getListOfItems");
        return null;
    }

    /**
     * curl http://localhost:8080/chapter15-resource-2.0/rs/04/items/1234
     */
    @GET
    @Path("{itemid}")
    public Item04 getItem(@PathParam("itemid") String itemid) {
        System.out.println("getItem : " + itemid);
        return null;
    }

    /**
     * curl -X DELETE http://localhost:8080/chapter15-resource-2.0/rs/04/items/1234
     */
    @DELETE
    @Path("{itemid}")
    public void deleteItem(@PathParam("itemid") String itemid) {
        System.out.println("deleteItem : " + itemid);
    }

    /**
     * curl http://localhost:8080/chapter15-resource-2.0/rs/04/items/books
     */
    @GET
    @Path("/books/")
    public List<Book04> getListOfBooks() {
        System.out.println("getListOfBooks");
        return null;
    }

    /**
     * curl http://localhost:8080/chapter15-resource-2.0/rs/04/items/books/1234
     */
    @GET
    @Path("/books/{bookid}")
    public Book04 getBook(@PathParam("bookid") String bookid) {
        System.out.println("getBook : " + bookid);
        return null;
    }
}
