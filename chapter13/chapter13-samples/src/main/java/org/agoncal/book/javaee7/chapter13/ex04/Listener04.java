package org.agoncal.book.javaee7.chapter13.ex04;

import javax.jms.*;
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
public class Listener04 implements MessageListener {

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

      System.out.println("\nStarting listener....");

      try (JMSContext context = connectionFactory.createContext()) {
        context.createConsumer(queue).setMessageListener(new Listener04());
      }

    } catch (NamingException e) {
      e.printStackTrace();
    }
  }

  public void onMessage(Message message) {
    try {
      System.out.println("Async Message received: " + message.getBody(String.class));
    } catch (JMSException e) {
      e.printStackTrace();
    }
  }
}