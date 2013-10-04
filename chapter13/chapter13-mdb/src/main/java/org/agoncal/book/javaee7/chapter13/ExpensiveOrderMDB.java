package org.agoncal.book.javaee7.chapter13;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.*;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@MessageDriven(mappedName = "jms/javaee7/Topic", activationConfig = {
        @ActivationConfigProperty(propertyName = "acknowledgeMode", propertyValue = "Auto-acknowledge"),
        @ActivationConfigProperty(propertyName = "messageSelector", propertyValue = "orderAmount > 1000")
})
@JMSConnectionFactoryDefinition(name = "jms/javaee7/ConnectionFactory",
        className = "javax.jms.ConnectionFactory")
@JMSDestinationDefinition(name = "jms/javaee7/Topic",
        className = "javax.jms.Topic", interfaceName = "javax.jms.Topic")
public class ExpensiveOrderMDB implements MessageListener {

  // ======================================
  // =           Public Methods           =
  // ======================================

  public void onMessage(Message message) {
    try {
      OrderDTO order = message.getBody(OrderDTO.class);
      System.out.println("Expensive order received: " + order.toString());
    } catch (JMSException e) {
      e.printStackTrace();
    }
  }
}