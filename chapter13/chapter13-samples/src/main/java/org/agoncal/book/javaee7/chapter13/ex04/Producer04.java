package org.agoncal.book.javaee7.chapter13.ex04;

import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Date;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class Producer04 {

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

      try (JMSContext context = connectionFactory.createContext()) {
        // Sends a text message to the queue
        context.createProducer().send(queue, "JMS 2.0 - This is a text message sent at " + new Date());
        System.out.println("\nMessage sent !");
      }

    } catch (NamingException e) {
      e.printStackTrace();
    }

    System.exit(0);
  }
}