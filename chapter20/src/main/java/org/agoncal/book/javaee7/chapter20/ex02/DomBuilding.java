package org.agoncal.book.javaee7.chapter20.ex02;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class DomBuilding {

    public static void main(String[] args) {

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.newDocument();

            Element order = document.createElement("order");
            order.setAttribute("id", "1234");
            order.setAttribute("date", "05/06/2013");
            document.appendChild(order);

            Element customer = document.createElement("customer");
            customer.setAttribute("first_name", "James");
            customer.setAttribute("last_name", "Rorrison");
            order.appendChild(customer);

            Element email = document.createElement("email");
            email.appendChild(document.createTextNode("j.rorri@me.com"));
            customer.appendChild(email);
            Element phoneNumber = document.createElement("phoneNumber");
            phoneNumber.appendChild(document.createTextNode("+44 1234 1234"));
            customer.appendChild(phoneNumber);

            XMLSerializer ser = new XMLSerializer(System.out, new OutputFormat("xml", "UTF-8", true));
            ser.serialize(document);
        } catch (IOException | ParserConfigurationException e) {
            e.printStackTrace();
        }
    }
}
