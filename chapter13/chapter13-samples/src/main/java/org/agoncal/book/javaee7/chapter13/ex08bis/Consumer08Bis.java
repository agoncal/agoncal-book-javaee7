package org.agoncal.book.javaee7.chapter13.ex08bis;

import javax.annotation.Resource;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Message;
import javax.jms.Queue;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class Consumer08Bis {

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

    try (JMSContext context = connectionFactory.createContext()) {

      // Filtering messages
      Message message = context.createConsumer(queue, "JMSPriority < 6").receive();
      message = context.createConsumer(queue, "JMSPriority < 6 AND orderAmount < 200").receive();
      message = context.createConsumer(queue, "orderAmount BETWEEN 1000 AND 2000").receive();
    }
  }
}