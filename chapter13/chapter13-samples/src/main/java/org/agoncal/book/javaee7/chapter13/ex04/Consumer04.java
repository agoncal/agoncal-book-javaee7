package org.agoncal.book.javaee7.chapter13.ex04;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class Consumer04 {

  // ======================================
  // =           Public Methods           =
  // ======================================

  public static void main(String[] args) {

    try {
      // Gets the JNDI context
      Context jndiContext = new InitialContext();

      // Looks up the administered objects
      ConnectionFactory connectionFactory = (ConnectionFactory) jndiContext.lookup("jms/javaee7/ConnectionFactory");
      Destination queue = (Destination) jndiContext.lookup("jms/javaee7/Queue");

      // Loops to receive the messages
      System.out.println("\nInfinite loop. Waiting for a message...");
      try (JMSContext context = connectionFactory.createContext()) {
        while (true) {
          String message = context.createConsumer(queue).receiveBody(String.class);
          System.out.println("Message received: " + message);
        }
      }

    } catch (NamingException e) {
      e.printStackTrace();
    }
  }
}