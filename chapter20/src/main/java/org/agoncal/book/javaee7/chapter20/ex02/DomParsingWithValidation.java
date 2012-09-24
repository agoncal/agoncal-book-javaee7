package org.agoncal.book.javaee7.chapter20.ex02;

import org.agoncal.book.javaee7.chapter20.OrderLine;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class DomParsingWithValidation {

    public List<OrderLine> parseOrderLines() {

        List<OrderLine> orderLines = new ArrayList<>();

        try {
            File xmlDocument = Paths.get("src/main/resources/invalidOrder.xml").toFile();
            File xmlSchema = Paths.get("src/main/resources/order.xsd").toFile();
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            //Setting the Schema for validation
            SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = schemaFactory.newSchema(xmlSchema);
            factory.setSchema(schema);

            ErrorHandler handler = new DomParsingErrorHandler();
            builder.setErrorHandler(handler);

            Document document = builder.parse(xmlDocument);

            NodeList orderLinesNode = document.getElementsByTagName("order_line");

            for (int i = 0; i < orderLinesNode.getLength(); i++) {
                Element orderLineNode = (Element) orderLinesNode.item(i);
                OrderLine orderLine = new OrderLine();
                orderLine.setItem(orderLineNode.getAttribute("item"));
                orderLine.setQuantity(Integer.valueOf(orderLineNode.getAttribute("quantity")));

                Node unitPriceNode = orderLineNode.getChildNodes().item(1);
                orderLine.setUnitPrice(Double.valueOf(unitPriceNode.getFirstChild().getNodeValue()));

                orderLines.add(orderLine);
            }

        } catch (SAXException | IOException | ParserConfigurationException e) {
            e.printStackTrace();
        }
        return orderLines;
    }
}

class DomParsingErrorHandler implements ErrorHandler {
    public void warning(SAXParseException exception) {
        System.out.println("### Warning: " + exception.getMessage());
    }

    public void error(SAXParseException exception) {
        System.out.println("### Error: " + exception.getMessage());
    }

    public void fatalError(SAXParseException exception) {
        System.out.println("### Fatal Error: " + exception.getMessage());
    }
}

