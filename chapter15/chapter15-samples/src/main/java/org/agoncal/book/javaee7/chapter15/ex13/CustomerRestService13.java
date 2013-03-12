package org.agoncal.book.javaee7.chapter15.ex13;

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
  // ======================================f

  @GET
  public Response getCustomers() {
    System.out.println("getCustomers");
    Customers13 customers = new Customers13();
    customers.add(new Customer13("John", "Smith", "jsmith@gmail.com", "1234565"));
    customers.add(new Customer13("John", "Smith", "jsmith@gmail.com", "1234565"));
    return Response.ok(customers).build();
  }

  @GET
  @Path("{customerId}")
  public Response getCustomer(@PathParam("customerId") String customerId) {
    System.out.println("getCustomer " + customerId);
    Customer13 customer = new Customer13("John", "Smith", "jsmith@gmail.com", "1334565");
    return Response.ok(customer).build();
  }

  @POST
  public Response createCustomer(Customer13 customer) {
    System.out.println("createCustomer " + customer);
    URI createdCustomerURI = UriBuilder.fromResource(CustomerRestService13.class).path("1334").build();
    return Response.created(createdCustomerURI).build();
  }

  @PUT
  public Response updateCustomer(Customer13 customer) {
    System.out.println("updateCustomer " + customer);
    customer = new Customer13("JohnUpdated", "Smith", "jsmith@gmail.com", "1334565");
    return Response.ok(customer).build();
  }

  @DELETE
  @Path("{customerId}")
  public Response deleteCustomer(@PathParam("customerId") String customerId) {
    System.out.println("getCustomer " + customerId);
    return Response.noContent().build();
  }
}
