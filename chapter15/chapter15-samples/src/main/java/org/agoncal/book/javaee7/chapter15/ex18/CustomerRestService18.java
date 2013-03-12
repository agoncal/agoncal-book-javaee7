package org.agoncal.book.javaee7.chapter15.ex18;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Path("/18/customer")
public class CustomerRestService18 {

  // ======================================
  // =             Attributes             =
  // ======================================

  //@Inject
  private CustomerEJB18 customerEJB = new CustomerEJB18();

  // ======================================
  // =           Public Methods           =
  // ======================================

  @GET
  @Path("ping")
  @Produces(MediaType.TEXT_PLAIN)
  public String ping() {
    return "ping";
  }

  @Path("{customerId}")
  public Customer18 getCustomer(@PathParam("customerId") Long customerId) {
    if (customerId < 1000)
      throw new IllegalArgumentException("Id must be greater than 1000!");

    Customer18 customer = customerEJB.find(customerId);
    if (customer == null)
      throw new WebApplicationException(Response.Status.NOT_FOUND);
    return customer;
  }

  private class CustomerEJB18 {
    public Customer18 find(Long customerId) {
      return null;//new Customer18(customerId, "John", "Smith", "jsmith@gmail.com", "1234565");
    }
  }

}