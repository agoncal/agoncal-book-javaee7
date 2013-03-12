package org.agoncal.book.javaee7.chapter15.ex03;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 *         <p/>
 *         curl http://localhost:8080/chapter15-service-1.0/rs/02/book
 */
@Path("/03/book")
public class BookRestService03 {

    // ======================================
    // =           Public Methods           =
    // ======================================

    @GET
    @Produces("text/plain")
    public String getBookTitle() {
        return "H2G2";
    }
}