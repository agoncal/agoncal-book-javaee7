package org.agoncal.book.javaee7.chapter12.ex04;

import org.junit.Test;
import org.xml.sax.SAXException;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class SaxParsingWithValidation04Test {

    @Test(expected = SAXException.class)
    public void shouldParseOutput() throws Exception {

        SaxParsingWithValidation04 saxParsing = new SaxParsingWithValidation04();
        saxParsing.parseOrderXML();
    }
}
