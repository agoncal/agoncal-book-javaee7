package org.agoncal.book.javaee7.chapter14;

import javax.enterprise.inject.Produces;
import javax.xml.ws.WebServiceRef;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class WebServiceProducer {

  @Produces @CardValidatorWebService
  @WebServiceRef
  private CardValidatorService cardValidatorService;

}
