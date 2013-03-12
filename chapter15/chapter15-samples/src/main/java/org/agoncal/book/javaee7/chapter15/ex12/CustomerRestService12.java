package org.agoncal.book.javaee7.chapter15.ex12;

import org.agoncal.book.javaee7.chapter15.ex11.Customer11;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Path("/12/customer")
public class CustomerRestService12 {

  // ======================================
  // =           Public Methods           =
  // ======================================

  @GET
  public String getAsPlainText() {
    return new Customer11("John", "Smith", "jsmith@gmail.com", "1234565").toString();
  }

  @GET
  @Path("max")
  public Long getMaximumBonusAllowed() {
    return 1234L;
  }

  @GET
  @Produces(MediaType.APPLICATION_XML)
  public Customer12 getAsXML() {
    return new Customer12("John", "Smith", "jsmith@gmail.com", "1234565");
  }

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public Response getAsJson() {
    return Response.ok(new Customer12("John", "Smith", "jsmith@gmail.com", "1234565"), MediaType.APPLICATION_JSON).build();
  }
}
