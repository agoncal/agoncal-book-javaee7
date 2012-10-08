package org.agoncal.book.javaee7.chapter21.ex25;

import javax.xml.namespace.QName;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.soap.SOAPHandler;
import javax.xml.ws.handler.soap.SOAPMessageContext;
import java.util.Map;
import java.util.Set;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class DisplaySOAPMessageHandler implements SOAPHandler<SOAPMessageContext> {

  @Override
  public boolean handleMessage(SOAPMessageContext context) {
    System.out.println("Message Outbound Property : " + context.get(MessageContext.MESSAGE_OUTBOUND_PROPERTY));
    // System.out.println("HTTP Request Headers : " + (Map<String,List<String>>)
    //    context.get(MessageContext.HTTP_REQUEST_HEADERS));
    System.out.println("HTTP Request Method : " + context.get(MessageContext.HTTP_REQUEST_METHOD));
    System.out.println("Path Info : " + context.get(MessageContext.PATH_INFO));
    System.out.println("Query String : " + context.get(MessageContext.QUERY_STRING));
    // System.out.println("HTTP Response Headers : " + (Map<String,List<String>>)
    // context.get(MessageContext.HTTP_RESPONSE_HEADERS));
    System.out.println("HTTP Response Code : " + context
            .get(MessageContext.HTTP_RESPONSE_CODE));
    System.out.println("Reference Parameters : " + context
            .get(MessageContext.REFERENCE_PARAMETERS));
    System.out.println("WSDL Description : " + context.get(MessageContext.WSDL_DESCRIPTION));
    System.out.println("WSDL Interface : " + context.get(MessageContext.WSDL_INTERFACE));
    System.out.println("WSDL Operation : " + context.get(MessageContext.WSDL_OPERATION));
    System.out.println("WSDL Port : " + context.get(MessageContext.WSDL_PORT));
    System.out.println("WSDL Service : " + context.get(MessageContext.WSDL_SERVICE));
    // System.out.println("Servlet Context : " + ( )
    //    context.get(MessageContext.SERVLET_CONTEXT));
    // System.out.println("Servlet Request : " + ( )
    //    context.get(MessageContext.SERVLET_REQUEST));
    // System.out.println("Servlet Response : " + ( )
    //    context.get(MessageContext.SERVLET_RESPONSE));

    return true;
  }

  @Override
  public Set<QName> getHeaders() {
    return null;
  }

  @Override
  public boolean handleFault(SOAPMessageContext context) {
    return true;
  }

  @Override
  public void close(MessageContext context) {
  }

  private void printMessageContext(Map<String, Object> context) {
  }

}
