package org.agoncal.book.javaee7.chapter15;

import org.glassfish.jersey.message.internal.MediaTypes;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
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
public class BookClient {

  // ======================================
  // =             Attributes             =
  // ======================================

  private static URI uri = UriBuilder.fromUri("http://localhost/chapter15-service-1.0/rs").port(8080).build();
  private static Client client = ClientBuilder.newClient();
  private static Response response;

  // ======================================
  // =           Public Methods           =
  // ======================================

  public static void main(String[] args) {
    if (args.length == 0) {
      System.out.println("Usage : ");
      System.out.println("\tgetall [xml|json]");
      System.out.println("\tget <id> [xml|json]");
      System.out.println("\tpost [null]");
      System.out.println("\tput <id>");
      System.out.println("\tdelete <id>");
      System.out.println("\tinfo");
      System.out.println("\twadl");
      System.out.println("\tall");
    }

    switch (args[0]) {
      case "getall":
        getall(args[1]);
        break;
      case "get":
        get(args[1], args[2]);
        break;
      case "post":
        post(args.length > 1 ? args[1] : null);
        break;
      case "put":
        put(args[1]);
        break;
      case "delete":
        delete(args[1]);
        break;
      case "info":
        info();
        break;
      case "wadl":
        wadl();
        break;
      case "all":
        all();
        break;
    }
  }

  public static void getall(String mediaType) {
    System.out.println("-- Get All (" + mediaType + ")--");
    System.out.println("--------------------------");
    response = client.target(uri).path("book").request("application/" + mediaType).get();
    System.out.println("\tStatus : " + response.getStatus());
    System.out.println("\tEntity : " + response.readEntity(String.class));
  }

  public static void get(String id, String mediaType) {
    System.out.println("-- Get (" + id + " - " + mediaType + ")--");
    System.out.println("--------------------------");
    response = client.target(uri).path("book").path(id).request("application/" + mediaType).get();
    System.out.println("\tStatus : " + response.getStatus());
    System.out.println("\tEntity : " + response.readEntity(String.class));
  }

  public static void post(String bookNull) {
    System.out.println("-- Post --");
    System.out.println("--------------------------");
    Book book = null;
    if (bookNull == null)
      book = new Book("The Hitchhiker's Guide to the Galaxy", 12.5F, "Science fiction comedy book", "1-84023-742-2", 354, false);
    response = client.target(uri).path("book").request().post(Entity.entity(book, MediaType.APPLICATION_XML));
    System.out.println("\tStatus : " + response.getStatus());
    System.out.println("\tLocation : " + response.getLocation());
  }

  public static void put(String id) {
    System.out.println("-- Put (" + id + ")--");
    System.out.println("--------------------------");
    Book book = new Book(id, "Updated Title", 12.5F, "Updated Desc", "Updated ISBN", 354, false);
//    response = client.target(uri).path("book").path(id).request().put(Entity.entity(book, MediaType.APPLICATION_XML));
    response = client.target(uri).path("book").request().put(Entity.entity(book, MediaType.APPLICATION_XML));
    System.out.println("\tStatus : " + response.getStatus());
  }

  public static void delete(String id) {
    System.out.println("-- Delete (" + id + ")--");
    System.out.println("--------------------------");
    response = client.target(uri).path("book").path(id).request().delete();
    System.out.println("\tStatus : " + response.getStatus());
    System.out.println("\tEntity : " + response.readEntity(String.class));
  }

  private static void info() {
    System.out.println("-- Info --");
    System.out.println("--------------------------");
    response = client.target(uri).path("book").request().get();
    System.out.println("getEntity : " + response.getEntity());
    System.out.println("getEntityTag : " + response.getEntityTag());
    System.out.println("getStringHeaders : " + response.getStringHeaders());
    System.out.println("getMetadata : " + response.getMetadata());
    System.out.println("getHeaders : " + response.getHeaders());
    System.out.println("getLinks : " + response.getLinks());
    System.out.println("getLanguage : " + response.getLanguage());
    System.out.println("getCookies : " + response.getCookies());
    System.out.println("getAllowedMethods : " + response.getAllowedMethods());
    System.out.println("hasEntity : " + response.hasEntity());
    System.out.println("StatusInfo : " + response.getStatusInfo());
    System.out.println("Status : " + response.getStatus());
    System.out.println("Location : " + response.getLocation());
    System.out.println("Length : " + response.getLength());
    System.out.println("LastModified : " + response.getLastModified());
    System.out.println("Date : " + response.getDate());
    System.out.println("ToString : " + response.toString());
  }

  private static void wadl() {
    System.out.println("-- WADL --");
    System.out.println("--------------------------");
    response = client.target(uri).path("application.wadl").request(MediaTypes.WADL).get();
    System.out.println("\tStatus : " + response.getStatus());
    System.out.println("\tEntity : " + response.readEntity(String.class));
  }

  private static void all() {
    System.out.println("-- ALL --");
    System.out.println("--------------------------");

    URI rootURI = UriBuilder.fromUri("http://localhost/chapter15-service-1.0/rs/book").port(8080).build();
    Client client = ClientBuilder.newClient();
    Response response;

    System.out.println("--- GET all books in XML");
    response = client.target(rootURI).request(MediaType.APPLICATION_XML).get();
    System.out.println("\tStatus : " + response.getStatus());
    System.out.println(response.readEntity(String.class));

    System.out.println("--- POST new book");
    Book book = new Book("The Hitchhiker's Guide to the Galaxy", 12.5F, "Science fiction comedy book", "1-84023-742-2", 354, false);
    response = client.target(rootURI).request().post(Entity.entity(book, MediaType.APPLICATION_XML));
    System.out.println("\tStatus : " + response.getStatus());
    URI bookURI = response.getLocation();
    System.out.println("\tLocation : " + bookURI);
    book.setId(response.getLocation().toString().split("/")[6]);

    System.out.println("--- GET the created book in JSon");
    System.out.println(client.target(bookURI).request(MediaType.APPLICATION_JSON).get(String.class));

    System.out.println("-- PUT updated book");
    System.out.println("--------------------------");
    book.setTitle("Updated title");
    response = client.target(rootURI).request().put(Entity.entity(book, MediaType.APPLICATION_XML));
    System.out.println("\tStatus : " + response.getStatus());

    System.out.println("--- GET the created book in XML");
    System.out.println(client.target(bookURI).request(MediaType.APPLICATION_XML).get(String.class));

    System.out.println("--- DELETE the book");
    response = client.target(rootURI).path(book.getId()).request().delete();
    System.out.println("\tStatus : " + response.getStatus());

    System.out.println("--- GET the deted book (404-Not Found)");
    response = client.target(bookURI).request(MediaType.APPLICATION_XML).get();
    System.out.println("\tStatus : " + response.getStatus());
  }
}
