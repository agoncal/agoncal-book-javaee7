package org.agoncal.book.javaee7.chapter12.ex11;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class Main11 {

  public static void main(String[] args) throws JAXBException {

    CreditCard11 creditCard = new CreditCard11("1234", "12/09", 6398, "Visa");
    StringWriter writer = new StringWriter();

    JAXBContext context = JAXBContext.newInstance(CreditCard11.class);
    Marshaller m = context.createMarshaller();
    m.marshal(creditCard, writer);

    System.out.println(writer.toString());
  }
}
