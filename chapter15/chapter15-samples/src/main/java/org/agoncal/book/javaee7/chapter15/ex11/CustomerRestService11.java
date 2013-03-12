package org.agoncal.book.javaee7.chapter15.ex11;

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
@Path("/11/customer")
public class CustomerRestService11 {

  // ======================================
  // =           Public Methods           =
  // ======================================

  @GET
  @Produces(MediaType.TEXT_PLAIN)
  public Response getAsPlainText() {
    return Response.ok(new Customer11("John", "Smith", "jsmith@gmail.com", "1234565").toString()).build();
  }

  @GET
  @Produces(MediaType.TEXT_HTML)
  public Response getAsHtml() {
    final StringBuilder sb = new StringBuilder();
    sb.append("<h1>Customer</h1><p>");
    sb.append(new Customer11("John", "Smith", "jsmith@gmail.com", "1234565").toString());
    sb.append("</p><hr/>");
    return Response.ok(sb.toString()).build();
  }

  @GET
  @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
  public Response getAsJsonAndXML() {
    return Response.ok(new Customer11("John", "Smith", "jsmith@gmail.com", "1234565")).build();
  }

  @PUT
  @Consumes(MediaType.TEXT_PLAIN)
  public void putName(String customer) {
    // ...
  }
}