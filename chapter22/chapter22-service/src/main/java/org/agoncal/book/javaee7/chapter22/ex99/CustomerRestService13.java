package org.agoncal.book.javaee7.chapter22.ex99;

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
@Path("/13/customer")
@Produces(MediaType.APPLICATION_XML)
@Consumes(MediaType.APPLICATION_XML)
public class CustomerRestService13 {

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

    Customer13 customer = null;//em.find(Customer13.class, customerId);
    if (customer == null) {
      return Response.status(Response.Status.NOT_FOUND).entity("Customer not found for id: " + customerId).build();
    }
    return Response.ok(new Customer13("John", "Smith", "jsmith@gmail.com", "1334565"), MediaType.APPLICATION_JSON).build();
  }

  @POST
  @Path("fromUri")
  public Response createCustomerFromUri(Customer13 customer) {
    URI bookUri = UriBuilder.fromUri("http://localhost:8282/13/customer/1334").build();
    return Response.created(bookUri).build();
  }

  @POST
  @Path("fromMethod")
  public Response createCustomerFromMethod(Customer13 customer) {
    URI bookUri = UriBuilder.fromMethod(CustomerRestService13.class, "createCustomerFromMethod").build();
    return Response.created(bookUri).build();
  }

  @POST
  @Path("fromResource")
  public Response createCustomerFromResource(Customer13 customer) {
    URI bookUri = UriBuilder.fromResource(CustomerRestService13.class).path("1334").build();
    return Response.created(bookUri).build();
  }

  @PUT
  @Path("{customerId}")
  public Response updateCustomer(@PathParam("customerId") String customerId, Customer13 customer) {
    return Response.ok().build();
  }

  @DELETE
  @Path("{customerId}")
  public Response deleteCustomer(@PathParam("customerId") String customerId) {
    return Response.noContent().build();
  }
}
