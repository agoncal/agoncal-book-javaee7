package org.agoncal.book.javaee7.chapter12;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.File;

/**
 * @author Antonio Goncalves
 * APress Book - Beginning Java EE 7 with Glassfish 4
 * http://www.apress.com/
 * http://www.antoniogoncalves.org
 * --
 */
public class CreditCard_JAXBTest {
    public static void main(String[] args)
    {
        CreditCard creditCard1 = null;
        CreditCard creditCard2 = null;
        File file = new File("creditCard.xml");

        try {
            JAXBContext context = JAXBContext.newInstance(CreditCard.class);
            Marshaller m = context.createMarshaller();
            creditCard1 = new CreditCard("1234", "12/09", 6398, "Visa");
            m.marshal(creditCard1, file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        try {
            JAXBContext context = JAXBContext.newInstance(CreditCard.class);
            Unmarshaller um = context.createUnmarshaller();
            creditCard2 = (CreditCard) um.unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        System.out.println("Successful marshalling and unmarshalling: " + creditCard1.equals(creditCard2));
    }
}
