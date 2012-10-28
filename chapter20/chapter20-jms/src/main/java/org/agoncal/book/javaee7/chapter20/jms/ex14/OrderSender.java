package org.agoncal.book.javaee6.chapter13.jms.ex14;

import org.agoncal.book.javaee6.chapter13.OrderDTO;

import javax.annotation.Resource;
import javax.jms.*;
import java.util.Date;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish 3
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class OrderSender {

    // ======================================
    // =             Attributes             =
    // ======================================

    @Resource(lookup = "jms/javaee6/ConnectionFactory")
    private static ConnectionFactory connectionFactory;
    @Resource(lookup = "jms/javaee6/Queue")
    private static Queue queue;

    // ======================================
    // =           Public Methods           =
    // ======================================

    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("usage : enter an amount");
            System.exit(0);
        }

        System.out.println("Sending message with amount = " + args[0]);

        // Creates an orderDto with a total amount parameter
        Float totalAmount = Float.valueOf(args[0]);
        OrderDTO order = new OrderDTO(1234l, new Date(), "Serge Gainsbourg", totalAmount);

        try {
            // Creates the needed artifacts to connect to the queue
            Connection connection = connectionFactory.createConnection();
            Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer producer = session.createProducer(queue);

            // Sends an object message to the queue
            ObjectMessage message = session.createObjectMessage();
            message.setObject(order);
            message.setFloatProperty("orderAmount", totalAmount);
            producer.send(message);
            System.out.println("\nMessage sent : " + order.toString());

            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.exit(0);
    }
}