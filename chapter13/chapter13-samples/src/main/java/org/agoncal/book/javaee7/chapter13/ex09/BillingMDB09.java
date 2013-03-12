package org.agoncal.book.javaee7.chapter13.ex09;

import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@MessageDriven(mappedName = "jms/javaee7/Topic")
public class BillingMDB09 implements MessageListener {

  // ======================================
  // =           Public Methods           =
  // ======================================

  public void onMessage(Message message) {
    try {
      System.out.println("Message received: " + message.getBody(String.class));
    } catch (JMSException e) {
      e.printStackTrace();
    }
  }
}