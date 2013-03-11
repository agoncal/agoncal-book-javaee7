package org.agoncal.book.javaee7.chapter13.ex05;

import javax.annotation.Resource;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class Consumer05 {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Resource(lookup = "jms/javaee7/ConnectionFactory")
  private static ConnectionFactory connectionFactory;
  @Resource(lookup = "jms/javaee7/Queue")
  private static Queue queue;

  // ======================================
  // =           Public Methods           =
  // ======================================

  public static void main(String[] args) {

    // Loops to receive the messages
    System.out.println("\nInfinite loop. Waiting for a message...");
    try (JMSContext context = connectionFactory.createContext()) {
      while (true) {
        String message = context.createConsumer(queue).receiveBody(String.class);
        System.out.println("Message received: " + message);
      }
    }
  }
}