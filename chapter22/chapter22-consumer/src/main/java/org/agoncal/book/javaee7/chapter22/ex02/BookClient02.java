package org.agoncal.book.javaee7.chapter22.ex02;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.Response;
import javax.ws.rs.client.ClientFactory;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class BookClient02 {

    public static void main(String[] args) {
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
