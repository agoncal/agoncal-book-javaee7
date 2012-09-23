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

    public static final String ORDER_OUTPUT = "order{\tid=1234\tdate=05/06/2013\tcustomer{\t\tfirst_name=James\t\tlast_name=Rorrison\t\temail{\t\t}\t\tphoneNumber{\t\t}\t}\tcontent{\t\torder_line{\t\t\titem=H2G2\t\t\tquantity=1\t\t\tunit_price{\t\t\t}\t\t}\t\torder_line{\t\t\titem=Harry Potter\t\t\tquantity=2\t\t\tunit_price{\t\t\t}\t\t}\t}\tcredit_card{\t\tnumber=123412341234\t\texpiry_date=10/13\t\tcontrol_number=234\t\ttype=Visa\t}}";

    @Test
    public void shouldParseOutput() throws Exception {

        SaxParsing saxParsing = new SaxParsing();
        saxParsing.parseOrderXML();
        String orderOutput = saxParsing.getOutput();

        assertEquals(ORDER_OUTPUT, orderOutput);
    }

}
