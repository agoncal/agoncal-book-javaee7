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
public class Sender {

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
            MessageProducer producer = session.createProducer(topic);

            // Sends a text message to the topic
            TextMessage message = session.createTextMessage();


            String body;
            for (int i = 0; i < 10; i++) {
                message.setIntProperty("orderAmount", i);
                body = "This is a text message with orderAmound" + i;
                System.out.println(body);
                message.setText(body);
                producer.send(message);
                message.acknowledge();
            }

            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.exit(0);
    }
}