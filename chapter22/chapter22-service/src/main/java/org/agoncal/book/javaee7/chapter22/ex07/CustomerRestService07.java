package org.agoncal.book.javaee7.chapter22.ex07;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.Date;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Path("/07/customer")
@Produces(MediaType.TEXT_PLAIN)
public class CustomerRestService07 {

  // ======================================
  // =           Public Methods           =
  // ======================================

  /**
   * curl http://localhost:8080/chapter22-service-1.0/rs/07/customers/agoncal
   */
  @GET
  @Path("{login: [a-zA-Z]*}")
  @Produces(MediaType.APPLICATION_XML)
  public Customer07 getCustomerByLogin(@PathParam("login") String login) {
    System.out.println("getCustomerByLogin : " + login);
    return new Customer07("John", "Smith", "jsmith@gmail.com", "1234565", new Date(), new Date());
  }

  /**
   * curl http://localhost:8080/chapter22-service-1.0/rs/07/customers/agoncal
   */
  @GET
  @Path("{customerId : \\d+}")
  @Produces(MediaType.APPLICATION_XML)
  public Customer07 getCustomerById(@PathParam("customerId") Long id) {
    System.out.println("getCustomerById : " + id);
    return new Customer07("John", "Smith", "jsmith@gmail.com", "1234565", new Date(), new Date());
  }

  @GET
  @Produces(MediaType.APPLICATION_XML)
  public Customer07 getCustomerByZipCode(@QueryParam("zip") Long zip) {
    System.out.println("getCustomerByZipCode : " + zip);
    return new Customer07("John", "Smith", "jsmith@gmail.com", "1234565", new Date(), new Date());
  }

  @GET
  @Path("search")
  @Produces(MediaType.APPLICATION_XML)
  public Customer07 getCustomerByFirstnameName(@MatrixParam("firstname") String firstname, @MatrixParam("surname") String surname) {
    System.out.println("getCustomerByFirstnameName : " + firstname + " - " + surname);
    return new Customer07("John", "Smith", "jsmith@gmail.com", "1234565", new Date(), new Date());
  }

    @GET
    @Path("cookie")
    @Produces(MediaType.APPLICATION_XML)
    public String echoCookie(@CookieParam("myCookie") String myCookie) {
        System.out.println("echoCookie : " + myCookie);
        return myCookie + " from the server";
    }

    @GET
    @Path("userAgent")
    public String echoUserAgent(@HeaderParam(value = "User-Agent") String userAgent) {
        System.out.println("echoUserAgent : " + userAgent);
        return userAgent + " from the server";
    }

    @GET
    @Path("userAgentRep")
    @Produces(MediaType.TEXT_PLAIN)
    public Response echoUserAgentWithReponse(@HeaderParam(value = "User-Agent") String userAgent) {
        System.out.println("echoUserAgentWithReponse : " + userAgent);
        return Response.ok(userAgent + " from the server", MediaType.TEXT_PLAIN).build();
    }
}