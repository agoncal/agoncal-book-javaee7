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

    public static final String ORDER_OUTPUT = "order{\n" +
            "\tid=1234\n" +
            "\tdate=05/06/2013\n" +
            "\tcustomer{\n" +
            "\t\tfirst_name=James\n" +
            "\t\tlast_name=Rorrison\n" +
            "\t\temail{\n" +
            "\t\t}\n" +
            "\t\tphoneNumber{\n" +
            "\t\t}\n" +
            "\t}\n" +
            "\tcontent{\n" +
            "\t\torder_line{\n" +
            "\t\t\titem=H2G2\n" +
            "\t\t\tquantity=1\n" +
            "\t\t\tunit_price{\n" +
            "\t\t\t}\n" +
            "\t\t}\n" +
            "\t\torder_line{\n" +
            "\t\t\titem=Harry Potter\n" +
            "\t\t\tquantity=2\n" +
            "\t\t\tunit_price{\n" +
            "\t\t\t}\n" +
            "\t\t}\n" +
            "\t}\n" +
            "\tcredit_card{\n" +
            "\t\tnumber=123412341234\n" +
            "\t\texpiry_date=10/13\n" +
            "\t\tcontrol_number=234\n" +
            "\t\ttype=Visa\n" +
            "\t}\n" +
            "}\n";

    @Test
    public void shouldParseOutput() throws Exception {

        SaxParsing saxParsing = new SaxParsing();
        saxParsing.parseOrderXML();
        String orderOutput = saxParsing.getOutput();

        assertEquals(ORDER_OUTPUT, orderOutput);
    }

}
