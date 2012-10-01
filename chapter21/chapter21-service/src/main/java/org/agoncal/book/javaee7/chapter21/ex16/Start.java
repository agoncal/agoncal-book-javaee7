package org.agoncal.book.javaee7.chapter21.ex16;

import javax.xml.ws.Endpoint;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish 3
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class Start {

    public static void main(String[] args) {

        CardValidator16 cardValidator = new CardValidator16();
        Endpoint.publish("http://localhost:8080/ccv", cardValidator);
    }
}