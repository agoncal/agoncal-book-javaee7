package org.agoncal.book.javaee7.chapter13.ex06;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.JMSConnectionFactory;
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
public class Producer06 {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Inject
  @JMSConnectionFactory("jms/javaee7/ConnectionFactory")
  private JMSContext context;
  @Resource(lookup = "jms/javaee7/Queue")
  private Queue queue;

  // ======================================
  // =           Public Methods           =
  // ======================================

  public void sendMessage() {

    // Sends a text message to the queue
    context.createProducer().send(queue, "JMS 2.0 - This is a text message sent at " + new Date());
  }
}