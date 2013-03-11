package org.agoncal.book.javaee7.chapter13.ex05;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;
import java.util.Date;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Stateless
public class ProducerEJB05 {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Resource(lookup = "jms/javaee7/ConnectionFactory")
  private ConnectionFactory connectionFactory;
  @Resource(lookup = "jms/javaee7/Queue")
  private Queue queue;

  // ======================================
  // =           Public Methods           =
  // ======================================

  public void sendMessage() {

    try (JMSContext context = connectionFactory.createContext()) {
      // Sends a text message to the queue
      context.createProducer().send(queue, "JMS 2.0 - This is a text message sent at " + new Date());
      System.out.println("\nMessage sent !");
    }
  }
}