package org.agoncal.book.javaee7.chapter19.ex01;

import org.junit.Test;
import org.xml.sax.SAXException;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class SaxParsingWithValidationTest {

    @Test(expected = SAXException.class)
    public void shouldParseOutput() throws Exception {

        SaxParsingWithValidation saxParsing = new SaxParsingWithValidation();
        saxParsing.parseOrderXML();
    }
}
