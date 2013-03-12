package org.agoncal.book.javaee7.chapter15.ex14;

import org.junit.Test;

import javax.ws.rs.core.UriBuilder;
import java.net.URI;

import static org.junit.Assert.assertEquals;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class URIBuilder14Test {

  // ======================================
  // =              Unit tests            =
  // ======================================

  @Test
  public void shouldBuildURIs() {
    URI uri = UriBuilder.fromUri("http://www.myserver.com").path("book").path("1234").build();
    assertEquals("http://www.myserver.com/book/1234", uri.toString());

    uri = UriBuilder.fromUri("http://www.myserver.com").path("book").queryParam("author", "Goncalves").build();
    assertEquals("http://www.myserver.com/book?author=Goncalves", uri.toString());

    uri = UriBuilder.fromUri("http://www.myserver.com").path("book").matrixParam("author", "Goncalves").build();
    assertEquals("http://www.myserver.com/book;author=Goncalves", uri.toString());

    uri = UriBuilder.fromUri("http://www.myserver.com")
            .path("{path}").queryParam("author", "{value}")
            .build("book", "Goncalves");
    assertEquals("http://www.myserver.com/book?author=Goncalves", uri.toString());

     uri = UriBuilder.fromResource(BookRestService14.class).path("1234").build();
    assertEquals("/14/book/1234", uri.toString());

     uri = UriBuilder.fromResource(BookRestService14.class).host("www.myserver.com").path("book").path("1234").build();
    assertEquals("//www.myserver.com/14/book/book/1234", uri.toString());

     uri = UriBuilder.fromResource(BookRestService14.class).host("www.myserver.com").port(8282).path("book").path("1234").build();
    assertEquals("//www.myserver.com:8282/14/book/book/1234", uri.toString());

    uri = UriBuilder.fromUri("http://www.myserver.com").fragment("book").build();
    assertEquals("http://www.myserver.com/#book", uri.toString());

  }
}