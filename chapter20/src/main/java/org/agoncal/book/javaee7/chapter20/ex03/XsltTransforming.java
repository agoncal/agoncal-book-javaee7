package org.agoncal.book.javaee7.chapter20.ex03;

import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class XsltTransforming {

    public static void main(String[] args) {
        Transformer transformer;
        TransformerFactory factory = TransformerFactory.newInstance();

        String stylesheet = "src/main/resources/order.xsl";
        String xmlDocument = "src/main/resources/order.xml";

        try {
            transformer = factory.newTransformer(new StreamSource(stylesheet));
            transformer.transform(new StreamSource(xmlDocument), new StreamResult(System.out));
        } catch (TransformerException e) {
            e.printStackTrace();
        }

    }
}
