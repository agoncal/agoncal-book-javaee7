package org.agoncal.book.javaee6.chapter13.jms.ex05;

import javax.annotation.Resource;
import javax.jms.*;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish 3
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class Receiver {

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
        try {
            // Creates the needed artifacts to connect to the queue
            Connection connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageConsumer consumer = session.createConsumer(topic);
            connection.start();

            // Loops to receive the messages
            System.out.println("\nInfinite loop. Waiting for a message...");
            while (true) {
                TextMessage message = (TextMessage) consumer.receive();
                System.out.println("Message received: " + message.getText());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}