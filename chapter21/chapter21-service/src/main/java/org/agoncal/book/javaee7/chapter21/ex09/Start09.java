package org.agoncal.book.javaee7.chapter21.ex09;

import javax.xml.ws.Endpoint;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class Start09 {

  public static void main(String[] args) {

    CardValidator09 cardValidator = new CardValidator09();
    Endpoint.publish("http://localhost:8080/cardValidator", cardValidator);

    System.out.println("The end");
  }
}