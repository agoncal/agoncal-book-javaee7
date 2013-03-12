package org.agoncal.book.javaee7.chapter15.ex07;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Path("/07/customer")
@Produces(MediaType.APPLICATION_XML)
public class CustomerRestService07 {

  // ======================================
  // =           Public Methods           =
  // ======================================

  /**
   * curl http://localhost:8080/chapter15-service-1.0/rs/07/customers/agoncal
   */
  @GET
  @Path("search/{text}")
  public List<Customer07> searchCustomers(@PathParam("text") String textToSearch) {
    System.out.println("searchCustomer : " + textToSearch);
    Customers07 customers = new Customers07();
    customers.add(new Customer07("John", "Smith", "jsmith@gmail.com", "1234565", new Date(), new Date()));
    customers.add(new Customer07("John", "Smith", "jsmith@gmail.com", "1234565", new Date(), new Date()));
    return customers;
  }

  /**
   * curl http://localhost:8080/chapter15-service-1.0/rs/07/customers/agoncal
   */
  @GET
  @Path("{login: [a-zA-Z]*}")
  public Customer07 getCustomerByLogin(@PathParam("login") String login) {
    System.out.println("getCustomerByLogin : " + login);
    return new Customer07("John", "Smith", "jsmith@gmail.com", "1234565", new Date(), new Date());
  }

  /**
   * curl http://localhost:8080/chapter15-service-1.0/rs/07/customers/agoncal
   */
  @GET
  @Path("{customerId : \\d+}")
  public Customer07 getCustomerById(@PathParam("customerId") Long id) {
    System.out.println("getCustomerById : " + id);
    return new Customer07("John", "Smith", "jsmith@gmail.com", "1234565", new Date(), new Date());
  }

  @GET
  public List<Customer07> getCustomersByZipCodeCity(@QueryParam("zip") Long zip, @DefaultValue("Paris") @QueryParam("city") String city) {
    System.out.println("getCustomerByZipCodeCity : " + zip + " - " + city);
    List<Customer07> customers = new ArrayList<>();
    customers.add(new Customer07("John", "Smith", "jsmith@gmail.com", "1234565", new Date(), new Date()));
    customers.add(new Customer07("John", "Smith", "jsmith@gmail.com", "1234565", new Date(), new Date()));
    return customers;
  }

  @GET
  @Path("search")
  public List<Customer07> getCustomersByFirstnameName(@MatrixParam("firstname") String firstname, @DefaultValue("Smith") @MatrixParam("surname") String surname) {
    System.out.println("getCustomerByFirstnameName : " + firstname + " - " + surname);
    List<Customer07> customers = new ArrayList<>();
    customers.add(new Customer07("John", "Smith", "jsmith@gmail.com", "1234565", new Date(), new Date()));
    customers.add(new Customer07("John", "Smith", "jsmith@gmail.com", "1234565", new Date(), new Date()));
    return customers;
  }

  @GET
  @Path("cookie")
  @Produces(MediaType.TEXT_PLAIN)
  public String extractSessionID(@CookieParam("sessionID") String sessionID) {
    System.out.println("extractSessionID : " + sessionID);
    return sessionID + " from the server";
  }

  @GET
  @Path("userAgent")
  @Produces(MediaType.TEXT_PLAIN)
  public String extractUserAgent(@HeaderParam("User-Agent") String userAgent) {
    System.out.println("echoUserAgent : " + userAgent);
    return userAgent + " from the server";
  }

  @GET
  @Path("userAgentRep")
  @Produces(MediaType.TEXT_PLAIN)
  public Response echoUserAgentWithReponse(@HeaderParam("User-Agent") String userAgent) {
    System.out.println("echoUserAgentWithReponse : " + userAgent);
    return Response.ok(userAgent + " from the server", MediaType.TEXT_PLAIN).build();
  }
}