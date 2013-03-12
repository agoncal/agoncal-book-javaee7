package org.agoncal.book.javaee7.chapter14.ex21;

import javax.xml.ws.WebFault;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@WebFault(name = "CardValidationFault")
public class CardValidatorRTException21 extends RuntimeException {

  public CardValidatorRTException21() {
    super();
  }

  public CardValidatorRTException21(String message) {
    super(message);
  }
}
