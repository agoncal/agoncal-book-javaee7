package org.agoncal.book.javaee7.chapter13;

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
public class OrderProducer {

  // ======================================
  // =           Public Methods           =
  // ======================================

  public static void main(String[] args) throws NamingException {

    if (args.length != 1) {
      System.out.println("usage : enter an amount");
      System.exit(0);
    }

    System.out.println("Sending message with amount = " + args[0]);

    // Creates an orderDto with a total amount parameter
    Float totalAmount = Float.valueOf(args[0]);
    OrderDTO order = new OrderDTO(1234l, new Date(), "Serge Gainsbourg", totalAmount);

    // Gets the JNDI context
    Context jndiContext = new InitialContext();

    // Looks up the administered objects
    ConnectionFactory connectionFactory = (ConnectionFactory) jndiContext.lookup("jms/javaee7/ConnectionFactory");
    Destination topic = (Destination) jndiContext.lookup("jms/javaee7/Topic");

    try (JMSContext jmsContext = connectionFactory.createContext()) {
      // Sends an object message to the topic
      jmsContext.createProducer().setProperty("orderAmount", totalAmount).send(topic, order);
      System.out.println("\nOrder sent : " + order.toString());
    }
  }
}