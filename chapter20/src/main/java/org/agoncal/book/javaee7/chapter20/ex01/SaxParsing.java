package org.agoncal.book.javaee7.chapter20.ex01;

import org.agoncal.book.javaee7.chapter20.OrderLine;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
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
public class SaxParsing extends DefaultHandler {

    private List<OrderLine> orderLines = new ArrayList<>();
    private OrderLine orderLine;
    private Boolean dealingWithUnitPrice = false;
    private StringBuffer unitPriceBuffer;

    public List<OrderLine> parseOrderLines() {

        try {
            File xmlDocument = Paths.get("src/main/resources/order.xml").toFile();
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            saxParser.parse(xmlDocument, this);
        } catch (SAXException | IOException | ParserConfigurationException e) {
            e.printStackTrace();
        }
        return orderLines;
    }

    public void startElement(String namespaceURI, String localName, String qualifiedName, Attributes attrs) throws SAXException {

        switch (qualifiedName) {
            case "order_line":
                orderLine = new OrderLine();
                for (int i = 0; i < attrs.getLength(); i++) {
                    switch (attrs.getLocalName(i)) {
                        case "item":
                            orderLine.setItem(attrs.getValue(i));
                            break;
                        case "quantity":
                            orderLine.setQuantity(Integer.valueOf(attrs.getValue(i)));
                            break;
                    }
                }
                break;
            case "unit_price":
                dealingWithUnitPrice = true;
                unitPriceBuffer = new StringBuffer();
                break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (dealingWithUnitPrice)
            unitPriceBuffer.append(ch, start, length);
    }

    public void endElement(String namespaceURI, String localName, String qualifiedName) throws SAXException {

        switch (qualifiedName) {
            case "order_line":
                orderLines.add(orderLine);
                break;
            case "unit_price":
                orderLine.setUnitPrice(Double.valueOf(unitPriceBuffer.toString()));
                dealingWithUnitPrice = false;
                break;
        }
    }
}
