package org.agoncal.book.javaee7.chapter21.ex04;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish 3
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class Main {

    public static void main(String[] args) throws JAXBException {

        CreditCard creditCard = new CreditCard("1234", "12/09", 6398, "Visa");
        StringWriter writer = new StringWriter();

        JAXBContext context = JAXBContext.newInstance(CreditCard.class);
        Marshaller m = context.createMarshaller();
        m.marshal(creditCard, writer);

        System.out.println(writer.toString());
    }
}
