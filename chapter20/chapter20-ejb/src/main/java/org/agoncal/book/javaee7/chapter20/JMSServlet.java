package org.agoncal.book.javaee7.chapter20;

import javax.annotation.Resource;
import javax.ejb.EJB;
import javax.inject.Inject;
import javax.jms.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

//@JMSDestinationDefinition(
//        name = "java:global/jms/chapter20Queue",
//        className = "javax.jms.Queue",
//        destinationName = "chapter20Queue")
//
//@JMSConnectionFactoryDefinition(
//        name = "java:global/jms/chapter20ConnectionFactory",
//        className = "javax.jms.ConnectionFactory"
//)
@JMSDestinationDefinition(
        name = "java:global/jms/chapter20Queue",
        description = "Queue to use in demonstration",
        className = "javax.jms.Queue",
        resourceAdapterName = "jmsra",
        destinationName = "demoQueue")

@JMSConnectionFactoryDefinition(
        name = "java:global/jms/chapter20ConnectionFactory",
        className = "javax.jms.ConnectionFactory",
        description = "ConnectionFactory to use in demonstration"
)

@WebServlet(urlPatterns = {"/JMSServlet"})
public class JMSServlet extends HttpServlet {

  @EJB
  private JavaEESenderOld javaEESenderOld;
  @EJB
  private JavaEESenderNew javaEESenderNew;
  @EJB
  private JavaEESenderNewCDI javaEESenderNewCDI;

  @EJB
  private JavaEESenderOldWithProperties javaEESenderOldWithProperties;
  @EJB
  private JavaEESenderNewCDIWithProperties javaEESenderNewCDIWithProperties;

  @EJB
  private JavaEESyncReceiverOld javaEESyncReceiverOld;
  @EJB
  private JavaEESyncReceiverNew javaEESyncReceiverNew;
  @EJB
  private JavaEESyncReceiverNewCDI javaEESyncReceiverNewCDI;
  @EJB
  private JavaEESyncReceiverNewCDIWithProperties javaEESyncReceiverNewCDIWithProperties;

  // Inject a JMSContext to use - this will use the platform default connection factory
  @Inject
  JMSContext context;

  // Inject a Queue object to use
  @Resource(lookup = "java:global/jms/chapter20Queue")
  Queue chapter20Queue;

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    response.setContentType("text/html;charset=UTF-8");
    PrintWriter out = response.getWriter();
    try {
      out.println("<html>");
      out.println("<head>");
      out.println("<title>JMS Servlet</title>");
      out.println("</head>");
      out.println("<body>");

      String option = request.getParameter("option");
      out.println("<h1>Invoking " + option + "</h1>");
      handle(option, out);
    } catch (Exception e) {
      e.printStackTrace(out);
    } finally {
      out.println("</body>");
      out.println("</html>");
      out.close();
    }
  }

  private void handle(String option, PrintWriter out) throws Exception {
    String result = "";
    switch (option) {
      case "JavaEESenderOld":
        out.println("<h1>Using the JMS 1.1-style API<br> to send a message (JavaEESenderOld)</h1>");
        out.println("<p>Number of messages on queue before: " + getQueueDepth() + "<br/>");
        javaEESenderOld.sendMessageOld("JavaEESenderOld");
        out.println("Message successfully sent using JavaEESenderOld<br/>");
        out.println("Number of messages on queue after: " + getQueueDepth() + "<br/>");
        break;
      case "JavaEESenderNew":
        out.println("<h1>Using the JMS 2.0 simplified API<br> to send a message (JavaEESenderNew)</h1>");
        out.println("Number of messages on queue before: " + getQueueDepth() + "<br/>");
        javaEESenderNew.sendMessageNew("JavaEESenderNew");
        out.println("Message successfully sent<br/>");
        out.println("Number of messages on queue after: " + getQueueDepth() + "<br/>");
        break;
      case "JavaEESenderNewCDI":
        out.println("<h1>Using the JMS 2.0 simplified API and injection<br> to send a message (JavaEESenderNewCDI)</h1>");
        out.println("<p>Number of messages on queue before: " + getQueueDepth() + "<br/>");
        javaEESenderNewCDI.sendMessageNewCDI("JavaEESenderNewCDI");
        out.println("Message successfully sent<br/>");
        out.println("Number of messages on queue after: " + getQueueDepth() + "<br/>");
        break;
      case "JavaEESenderOldWithProperties":
        out.println("<h1>Using the JMS 1.1-style API<br> to send a message,<br>setting delivery options and message properties (JavaEESenderOldWithProperties)</h1>");
        out.println("<p>Number of messages on queue before: " + getQueueDepth() + "<br/>");
        javaEESenderOldWithProperties.sendMessageOldWithProperties("JavaEESenderOldWithProperties");
        out.println("Message successfully sent<br/>");
        out.println("Number of messages on queue after: " + getQueueDepth() + "<br/>");
        break;
      case "JavaEESenderNewCDIWithProperties":
        out.println("<h1>Using the JMS 2.0 simplified API with injection<br> to send a message,<br>setting delivery options and message properties (JavaEESenderNewCDIWithProperties)</h1>");
        out.println("<p>Number of messages on queue before: " + getQueueDepth() + "<br/>");
        javaEESenderNewCDIWithProperties.sendMessageNewCDIWithProperties("JavaEESenderNewCDIWithProperties");
        out.println("Message sent<br/>");
        out.println("Number of messages on queue after: " + getQueueDepth() + "<br/>");
        break;
      case "JavaEESyncReceiverOld":
        out.println("<h1>Using the JMS 1.1-style API<br> to receive a message (JavaEESyncReceiverOld)</h1>");
        out.println("<p>Number of messages on queue before: " + getQueueDepth() + "<br/>");
        result = javaEESyncReceiverOld.receiveMessageOld();
        out.println("Message received: " + result + "<br/>");
        out.println("Number of messages on queue after: " + getQueueDepth() + "<br/>");
        break;
      case "JavaEESyncReceiverNew":
        out.println("<h1>Using the JMS 2.0 simplified API<br> to receive a message (JavaEESyncReceiverNew)</h1>");
        out.println("<p>Number of messages on queue before: " + getQueueDepth() + "<br/>");
        result = javaEESyncReceiverNew.receiveMessageNew();
        out.println("Message received: " + result + "<br/>");
        out.println("Number of messages on queue after: " + getQueueDepth() + "<br/>");
        break;
      case "JavaEESyncReceiverNewCDI":
        out.println("<h1>Using the JMS 2.0 simplified API and injection<br> to receive a message (JavaEESyncReceiverNewCDI)</h1>");
        out.println("<p>Number of messages on queue before: " + getQueueDepth() + "<br/>");
        result = javaEESyncReceiverNewCDI.receiveMessageNewCDI();
        out.println("Message received: " + result + "<br/>");
        out.println("Number of messages on queue after: " + getQueueDepth() + "<br/>");
        break;
      case "JavaEESyncReceiverNewCDIWithProperties":
        out.println("<h1>Using the JMS 2.0 simplified API and injection<br> to receive a message,<br>displaying message properties (JavaEESyncReceiverNewCDIWithProperties)</h1>");
        out.println("<p>Number of messages on queue before: " + getQueueDepth() + "<br/>");
        result = javaEESyncReceiverNewCDIWithProperties.receiveMessageNewCDIWithProperties();
        out.println("Message received: " + result + "<br/>");
        out.println("Number of messages on queue after: " + getQueueDepth() + "<br/>");
        break;
      default:
        throw new Exception("Unexpected option " + option);
    }
    out.println("<br/><br/><a href='index.html'>Back</a>");
  }

  String getQueueDepth() throws JMSException {
//    int numMessages = 0;
//    for (Enumeration queueEnumeration = context.createBrowser(chapter20Queue).getEnumeration(); queueEnumeration.hasMoreElements(); ) {
//      queueEnumeration.nextElement();
//      numMessages++;
//    }
//    return "<b>" + numMessages + "</b>";
    return "<b>toto</b>";

  }
}
