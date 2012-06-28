package org.agoncal.book.javaee7.chapter20.ex02;

import javax.ws.rs.client.Client;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ClientFactory;

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
        Response res = client.target("http://example.org/hello")
                .request("text/plain").get();
    }
}
