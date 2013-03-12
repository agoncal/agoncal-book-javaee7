package org.agoncal.book.javaee7.chapter13;

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
public class OrderConsumer {

  // ======================================
  // =           Public Methods           =
  // ======================================

  public static void main(String[] args) throws NamingException {

    // Gets the JNDI context
    Context jndiContext = new InitialContext();

    // Looks up the administered objects
    ConnectionFactory connectionFactory = (ConnectionFactory) jndiContext.lookup("jms/javaee7/ConnectionFactory");
    Destination topic = (Destination) jndiContext.lookup("jms/javaee7/Topic");

    // Loops to receive the messages
    System.out.println("\nInfinite loop. Waiting for a message...");
    try (JMSContext jmsContext = connectionFactory.createContext()) {
      while (true) {
        OrderDTO order = jmsContext.createConsumer(topic).receiveBody(OrderDTO.class);
        System.out.println("Order received: " + order);
      }
    }
  }
}