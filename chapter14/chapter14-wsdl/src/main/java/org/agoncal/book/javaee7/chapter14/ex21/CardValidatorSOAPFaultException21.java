package org.agoncal.book.javaee7.chapter14.ex21;

import javax.xml.soap.SOAPFault;
import javax.xml.ws.WebFault;
import javax.xml.ws.soap.SOAPFaultException;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@WebFault
public class CardValidatorSOAPFaultException21 extends SOAPFaultException {

  /**
   * Constructor for SOAPFaultException
   *
   * @param fault <code>SOAPFault</code> representing the fault
   * @see javax.xml.soap.SOAPFactory#createFault
   */
  public CardValidatorSOAPFaultException21(SOAPFault fault) {
    super(fault);
  }
}
