package org.agoncal.book.javaee7.chapter22.ex12;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.ws.rs.*;
import javax.ws.rs.core.*;
import java.net.URI;

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
  // =           Public Methods           =
  // ======================================

  @GET
  @Path("{customerId}")
  public Response getCustomer(@PathParam("customerId") String customerId) {
    System.out.println("getCustomer " + customerId);

    if (!customerId.startsWith("cust")) {
      return Response.serverError().entity("Customer Id must start with 'cust'").build();
    }

    Customer12 customer = null;//em.find(Customer12.class, customerId);
    if (customer == null) {
      return Response.status(Response.Status.NOT_FOUND).entity("Customer not found for id: " + customerId).build();
    }
    return Response.ok(new Customer12("John", "Smith", "jsmith@gmail.com", "1234565"), MediaType.APPLICATION_JSON).build();
  }

  @POST
  @Path("fromUri")
  public Response createCustomerFromUri(Customer12 customer) {
    URI bookUri = UriBuilder.fromUri("http://localhost:8282/12/customer/1234").build();
    return Response.created(bookUri).build();
  }

  @POST
  @Path("fromMethod")
  public Response createCustomerFromMethod(Customer12 customer) {
    URI bookUri = UriBuilder.fromMethod(CustomerRestService12.class, "createCustomerFromMethod").build();
    return Response.created(bookUri).build();
  }

  @POST
  @Path("fromResource")
  public Response createCustomerFromResource(Customer12 customer) {
    URI bookUri = UriBuilder.fromResource(CustomerRestService12.class).path("1234").build();
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
