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


//  @GET
//  public JsonArray getCustomerURIs() {
//
//    JsonBuilder builder = new JsonBuilder();
//    JsonArrayBuilder<JsonBuilder.JsonBuildable<JsonArray>> buidable;
//    buidable = builder.beginArray();
//
//    for (Customer15 customer : customerEJB.findAll()) {
//      UriBuilder ub = uriInfo.getAbsolutePathBuilder();
//      URI uri = UriBuilder.fromPath("http://www.myserver.com").path(customer.getId().toString()).build();
//      buidable.beginObject().add("uri", uri.toASCIIString()).endObject();
//    }
//
//    JsonArray array = buidable.endArray().build();
//    return array;
//  }
//
//  @GET
//  @Path("{id}")
//  @Produces(MediaType.TEXT_PLAIN)
//  public String getCustomerURI(@PathParam("id") String customerId) throws Exception {
//
//    JsonBuilder builder = new JsonBuilder();
//    JsonObject jsonObject;
//    JsonObjectBuilder<JsonBuilder.JsonBuildable<JsonObject>> buidable;
//
//    buidable = builder.beginObject();
//    buidable.add("id", customerId);
//    buidable.add("date", "19/09/2012");
//    buidable.add("total_amount", "93.48");
//
//    jsonObject = buidable.endObject().build();
//
//    StringWriter orderJSON = new StringWriter();
//    JsonWriter writer = new JsonWriter(orderJSON);
//    writer.writeObject(jsonObject);
//
//
//    return orderJSON.toString();
//  }
//
//  @GET
//  @Path("jsonString/{id}")
//  public String getCustomerJsonString(@PathParam("id") String customerId) throws Exception {
//
//    JsonObject jsonObject = new JsonBuilder().
//            beginObject().
//            add("id", customerId).
//            add("date", "19/09/2012").
//            add("total_amount", "93.48").
//            endObject().
//            build();
//
//    StringWriter orderJSON = new StringWriter();
//    JsonWriter writer = new JsonWriter(orderJSON);
//    writer.writeObject(jsonObject);
//
//    return orderJSON.toString();
//  }
//
//  @GET
//  @Path("jsonObject/{id}")
//  public JsonObject getCustomerJsonObject(@PathParam("id") String customerId) throws Exception {
//
//    JsonObject jsonObject = new JsonBuilder().
//            beginObject().
//            add("id", customerId).
//            add("date", "19/09/2012").
//            add("total_amount", "93.48").
//            endObject().
//            build();
//
//    return jsonObject;
//  }
//
//  private class CustomerEJB10 {
//    public List<Customer15> findAll() {
//      List<Customer15> customers = new ArrayList<>();
//      customers.add(new Customer15(1L, "John", "Smith", "jsmith@gmail.com", "1234565"));
//      customers.add(new Customer15(2L, "John", "Smith", "jsmith@gmail.com", "1234565"));
//      return customers;
//    }
//  }

}
