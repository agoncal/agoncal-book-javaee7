package org.agoncal.book.javaee7.chapter20.ex01;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class SaxParsingTest {

    public static final String ORDER_OUTPUT = "order{\tcustomer{\t\temail{\t\t}\t\tphoneNumber{\t\t}\t}\tcontent{\t\torder_line{\t\t\tunit_price{\t\t\t}\t\t}\t\torder_line{\t\t\tunit_price{\t\t\t}\t\t}\t}\tcredit_card{\t}}";

    @Test
    public void shouldParseOutput() throws Exception {

        SaxParsing saxParsing = new SaxParsing();
        saxParsing.parseOrderXML();
        String orderOutput = saxParsing.getOutput().toString();

        assertEquals(ORDER_OUTPUT, orderOutput);
    }

}
