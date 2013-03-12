package org.agoncal.book.javaee7.chapter13.ex08bis;

import javax.annotation.Resource;
import javax.inject.Inject;
import javax.jms.*;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class Producer08Bis {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Inject
  @JMSConnectionFactory("jms/javaee7/ConnectionFactory")
  @JMSSessionMode(JMSContext.AUTO_ACKNOWLEDGE)
  private JMSContext context;
  @Resource(lookup = "jms/javaee7/Queue")
  private Queue queue;
  @Resource(lookup = "jms/javaee7/Topic")
  private Topic topic;

  // ======================================
  // =           Public Methods           =
  // ======================================

  public void sendMessage() throws JMSException {
    Message message = null;

    // Filtering messages
    context.createTextMessage().setIntProperty("orderAmount", 1530);
    context.createTextMessage().setJMSPriority(5);

    // Setting Message Time-to-Live
    context.createProducer().setTimeToLive(1000).send(queue, message);
    context.createProducer().setTimeToLive(1000).setDeliveryMode(DeliveryMode.NON_PERSISTENT).send(queue, message);

    // Specifying Message Persistence
    context.createProducer().setDeliveryMode(DeliveryMode.NON_PERSISTENT).send(queue, message);

    // Controlling Acknowledgment
    message.acknowledge();
    context.createProducer().setDeliveryMode(DeliveryMode.NON_PERSISTENT).send(queue, message);

    // Creating Durable Consumers
    context.createDurableConsumer(topic, "javaee7DurableSubscription").receive();

    // Setting Priorities
    context.createProducer().setPriority(2).send(queue, message);

    // All together
    context.createProducer().setPriority(2).setTimeToLive(1000).setDeliveryMode(DeliveryMode.NON_PERSISTENT).send(queue, message);

  }
}