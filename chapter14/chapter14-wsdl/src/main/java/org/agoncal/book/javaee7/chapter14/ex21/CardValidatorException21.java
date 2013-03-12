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
public class CardValidatorException21 extends Exception {

  public CardValidatorException21() {
    super();
  }

  public CardValidatorException21(String message) {
    super(message);
  }
}
