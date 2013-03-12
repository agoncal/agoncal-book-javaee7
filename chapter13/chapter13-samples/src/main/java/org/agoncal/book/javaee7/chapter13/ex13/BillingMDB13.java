package org.agoncal.book.javaee7.chapter13.ex13;

import javax.annotation.Resource;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.inject.Inject;
import javax.jms.*;
import java.util.Date;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@MessageDriven(mappedName = "jms/javaee7/Topic", activationConfig = {
        @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
        @ActivationConfigProperty(propertyName = "messageSelector", propertyValue = "orderAmount BETWEEN 3 AND 7")
})
public class BillingMDB13 implements MessageListener {

  @Inject
  @JMSConnectionFactory("jms/javaee7/ConnectionFactory")
  @JMSSessionMode(JMSContext.AUTO_ACKNOWLEDGE)
  private JMSContext context;
  @Resource(lookup = "jms/javaee7/Queue")
  private Destination printingQueue;

  // ======================================
  // =           Public Methods           =
  // ======================================

  public void onMessage(Message message) {
    try {
      System.out.println("Message received: " + message.getBody(String.class));
      sendPrintingMessage();
    } catch (JMSException e) {
      e.printStackTrace();
    }
  }

  private void sendPrintingMessage() throws JMSException {
    context.createProducer().send(printingQueue, "This message has been received and sent again at " + new Date());
  }
}