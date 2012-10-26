package org.agoncal.book.javaee7.chapter21.ex22;

import javax.xml.ws.WebFault;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@WebFault(name="CardValidationFault", messageName = "totomessageName")
public class CardValidatorException22 extends Exception {

  public CardValidatorException22() {
  }

  public CardValidatorException22(Throwable cause) {
    super(cause);
  }
}
