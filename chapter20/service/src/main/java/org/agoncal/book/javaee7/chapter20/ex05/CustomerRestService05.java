package org.agoncal.book.javaee7.chapter20.ex05;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.InputStream;
import java.util.List;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Path("/05/customers")
@Produces(MediaType.TEXT_PLAIN)
public class CustomerRestService05 {

    // ======================================
    // =           Public Methods           =
    // ======================================

    /**
     * curl http://localhost:8080/chapter20-service-1.0/rs/05/customers
     */
    @GET
    public String getAsPlainText() {
        System.out.println("getAsPlainText");
        return null;
    }

    /**
     * curl -H "Accept: text/html" http://localhost:8080/chapter20-service-1.0/rs/05/customers
     */
    @GET
    @Produces(MediaType.TEXT_HTML)
    public String getAsHtml() {
        System.out.println("getAsHtml");
        return null;
    }

    /**
     * curl -H "Accept: application/json" http://localhost:8080/chapter20-service-1.0/rs/05/customers
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer05> getAsJson() {
        System.out.println("getAsJson");
        return null;
    }

    @PUT
    @Consumes(MediaType.TEXT_PLAIN)
    public void putBasic(String customer) {
        System.out.println("putBasic");
    }

    @POST
    @Consumes(MediaType.APPLICATION_XML)
    public Response createCustomer(InputStream is) {
        System.out.println("createCustomer");
        return null;
    }
}