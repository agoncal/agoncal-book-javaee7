package org.agoncal.book.javaee7.chapter20.ex02;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish 3
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 *         <p/>
 *         curl http://localhost:8080/chapter15-resource-2.0/rs/02/book
 */
@Path("/02/book")
public class BookResource02 {

    // ======================================
    // =           Public Methods           =
    // ======================================

    @GET
    @Produces("text/plain")
    public String getBookTitle() {
        return "H2G2";
    }
}