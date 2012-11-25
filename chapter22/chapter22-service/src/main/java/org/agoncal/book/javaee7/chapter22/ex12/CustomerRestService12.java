package org.agoncal.book.javaee7.chapter22.ex12;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
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
@Path("/12/customer")
@Produces(MediaType.APPLICATION_XML)
@Consumes(MediaType.APPLICATION_XML)
public class CustomerRestService12 {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Context
  private UriInfo uriInfo;

  // ======================================
  // =           Public Methods           =
  // ======================================

  @GET
  public Response getListOfCustomers() {
    List<Customer12> customers = new ArrayList<>();
    customers.add(new Customer12("John", "Smith", "jsmith@gmail.com", "1234565"));
    customers.add(new Customer12("John", "Smith", "jsmith@gmail.com", "1234565"));
    return Response.ok(customers).build();
  }

  @GET
  @Path("{customerId}")
  public Response getCustomer(@PathParam("customerId") String customerId) {
    return Response.ok(new Customer12("John", "Smith", "jsmith@gmail.com", "1234565")).build();
  }

  @POST
  public Response createCustomer(Customer12 customer) {
    URI bookUri = uriInfo.getAbsolutePathBuilder().path(customer.getId().toString()).build();
    return Response.created(bookUri).build();
  }

  @PUT
  @Path("{customerId}")
  public Response updateCustomer(@PathParam("customerId") String customerId, Customer12 customer) {
    return Response.ok().build();
  }

  @DELETE
  @Path("{customerId}")
  public Response deleteCustomer(@PathParam("customerId") String customerId) {
    return Response.noContent().build();
  }
}
