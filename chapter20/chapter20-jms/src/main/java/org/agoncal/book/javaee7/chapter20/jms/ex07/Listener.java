package org.agoncal.book.javaee6.chapter13.jms.ex07;

import javax.annotation.Resource;
import javax.jms.*;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish 3
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class Listener implements MessageListener {

    // ======================================
    // =             Attributes             =
    // ======================================

    @Resource(lookup = "jms/javaee6/ConnectionFactory")
    private static ConnectionFactory connectionFactory;
    @Resource(lookup = "jms/javaee6/Topic")
    private static Topic topic;

    // ======================================
    // =           Public Methods           =
    // ======================================

    public static void main(String[] args) {

        String selector = "orderAmount between 3 and 5";

        System.out.println("\nStarting listener with " + selector + "....");

        try {
            // Creates the needed artifacts to connect to the queue
            Connection connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageConsumer consumer = session.createConsumer(topic, selector);
            consumer.setMessageListener(new Listener());
            connection.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void onMessage(Message message) {
        try {
            System.out.println("Message received: " + ((TextMessage) message).getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}