package org.agoncal.book.javaee7.chapter15.ex16;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import java.net.URI;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Path("/16/customer")
public class CustomerRestService16 {

  // ======================================
  // =           Public Methods           =
  // ======================================

  @GET
  @Path("ping")
  @Produces(MediaType.TEXT_PLAIN)
  public String ping() {
    return "ping";
  }

  @GET
  @Path("{customerId}")
  @Produces(MediaType.APPLICATION_XML)
  public Customer16 getCustomerXML(@PathParam("customerId") String id) {
    return new Customer16(id, "John", "Smith");
  }

  @POST
  @Consumes(MediaType.APPLICATION_XML)
  public Response createCustomerXML(Customer16 customer) {
    URI customerURI = UriBuilder.fromResource(CustomerRestService16.class).path(customer.getId()).build();
    return Response.created(customerURI).build();
  }

  @GET
  @Path("{customerId}")
  @Produces("custom/format")
  public Customer16 getCustomerCustom(@PathParam("customerId") String id) {
    return new Customer16(id, "John", "Smith");
  }

  @POST
  @Consumes("custom/format")
  public Response createCustomerCustom(Customer16 customer) {
    URI customerURI = UriBuilder.fromResource(CustomerRestService16.class).path(customer.getId()).build();
    return Response.created(customerURI).build();
  }
}