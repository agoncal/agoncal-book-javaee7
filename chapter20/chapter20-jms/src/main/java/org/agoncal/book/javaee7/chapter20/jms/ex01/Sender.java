package org.agoncal.book.javaee6.chapter13.jms.ex01;

import javax.jms.*;
import javax.naming.Context;
import javax.naming.InitialContext;
import java.util.Date;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish 3
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class Sender {

    // ======================================
    // =           Public Methods           =
    // ======================================

    public static void main(String[] args) {

        try {
            // Gets the JNDI context
            Context jndiContext = new InitialContext();

            // Looks up the administered objects
            ConnectionFactory connectionFactory = (ConnectionFactory) jndiContext.lookup("jms/javaee6/ConnectionFactory");
            Queue queue = (Queue) jndiContext.lookup("jms/javaee6/Queue");

            // Creates the needed artifacts to connect to the queue
            Connection connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer producer = session.createProducer(queue);

            // Sends a text message to the queue
            TextMessage message = session.createTextMessage();
            message.setText("This is a text message sent at " + new Date());
            producer.send(message);
            System.out.println("\nMessage sent !");

            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.exit(0);
    }
}