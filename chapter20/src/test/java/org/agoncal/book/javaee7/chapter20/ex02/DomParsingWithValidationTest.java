package org.agoncal.book.javaee7.chapter20.ex02;

import org.agoncal.book.javaee7.chapter20.OrderLine;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class DomParsingWithValidationTest {

    @Test
    public void shouldParseOrderLines() throws Exception {
        List<OrderLine> parseOrderLines = new DomParsingWithValidation().parseOrderLines();
        assertEquals(2, parseOrderLines.size());
        OrderLine orderLine = parseOrderLines.get(0);
        assertEquals("H2G2", orderLine.getItem());
        assertEquals((Integer) 1, orderLine.getQuantity());
        assertEquals((Double) 23.5, orderLine.getUnitPrice());
    }
}
