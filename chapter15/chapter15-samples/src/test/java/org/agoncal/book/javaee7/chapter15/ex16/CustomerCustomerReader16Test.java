package org.agoncal.book.javaee7.chapter15.ex16;

import org.junit.Test;

import java.io.*;

import static org.junit.Assert.assertEquals;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class CustomerCustomerReader16Test {

  public static final String CUSTOM = "1234/John/Smith";


  @Test
  public void shouldReadFrom() throws Exception {

    CustomCustomerReader16 reader = new CustomCustomerReader16();
    Customer16 customer = reader.readFrom(Customer16.class, null, null, null, null, toInputStream(CUSTOM));

    assertEquals("1234", customer.getId());
    assertEquals("John", customer.getFirstName());
    assertEquals("Smith", customer.getLastName());
  }

  private InputStream toInputStream(String str) throws IOException {

    // convert String into InputStream
    InputStream is = new ByteArrayInputStream(str.getBytes());

    // read it with BufferedReader
    BufferedReader br = new BufferedReader(new InputStreamReader(is));

    String line;
    while ((line = br.readLine()) != null) {
      System.out.println(line);
    }

    br.close();

    return is;
  }
}
