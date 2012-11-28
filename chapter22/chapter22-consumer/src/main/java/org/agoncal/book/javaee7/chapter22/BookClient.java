package org.agoncal.book.javaee7.chapter22;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientFactory;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class BookClient {

  public static void main(String[] args) {
    if (args.length == 0) {
      System.out.println("Usage : ");
      System.out.println("\tgetall [xml|json]");
      System.out.println("\tget <id> [xml|json]");
      System.out.println("\tpost");
      System.out.println("\tput <id>");
      System.out.println("\tdelete <id>");
      System.out.println("\tinfo");
    }

    switch (args[0]) {
      case "getall":
        getall();
        break;
      case "get":
        get(args[1], args[2]);
        break;
      case "post":
        post();
        break;
      case "put":
        put(args[1]);
        break;
      case "delete":
        put(args[1]);
        break;
      case "info":
        info();
        break;
    }

  }

  public static void getall() {
    System.out.println("-- Get All --");
  }

  public static void get(String id, String mediaType) {
    System.out.println("-- Get All (" + id + " - " + mediaType + ")--");
  }

  public static void post() {
    System.out.println("-- Post --");
  }

  public static void put(String id) {
    System.out.println("-- Put (" + id + ")--");
  }

  public static void delete(String id) {
    System.out.println("-- Delete (" + id + ")--");
  }

  private static void info() {
    System.out.println("-- Info --");
    Client client = ClientFactory.newClient();
    WebTarget target = client.target("http://localhost:8080/cdbookstore/rs/items/books");
//        WebTarget target = client.target("http://localhost:8080/cdbookstore/rs/items/book/1");
    System.out.println("------ WebTarget ------");
    System.out.println("getUri : " + target.getUri());
    Invocation.Builder builder = target.request();
//        Invocation.Builder builder = target.request(MediaType.TEXT_PLAIN_TYPE);
    Response res = builder.get();
//                .request("text/plain").get();
    System.out.println("------ Response ------");
    System.out.println("getEntity : " + res.getEntity());
    System.out.println("getEntityTag : " + res.getEntityTag());
    System.out.println("getStringHeaders : " + res.getStringHeaders());
    System.out.println("getMetadata : " + res.getMetadata());
    System.out.println("getHeaders : " + res.getHeaders());
    System.out.println("getLinks : " + res.getLinks());
    System.out.println("getLanguage : " + res.getLanguage());
    System.out.println("getCookies : " + res.getCookies());
    System.out.println("getAllowedMethods : " + res.getAllowedMethods());
    System.out.println("hasEntity : " + res.hasEntity());
    System.out.println("StatusInfo : " + res.getStatusInfo());
    System.out.println("Status : " + res.getStatus());
    System.out.println("Location : " + res.getLocation());
    System.out.println("Length : " + res.getLength());
    System.out.println("LastModified : " + res.getLastModified());
    System.out.println("Date : " + res.getDate());
    System.out.println("ToString : " + res.toString());
    System.out.println("------");
    System.out.println("readEntity : " + res.readEntity(String.class));
  }
}
