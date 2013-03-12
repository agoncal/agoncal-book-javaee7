package org.agoncal.book.javaee7.chapter15.ex16;

import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;
import java.io.*;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.StringTokenizer;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Provider
@Consumes("custom/format")
public class CustomCustomerReader16 implements MessageBodyReader<Customer16> {

  // ======================================
  // =           Public Methods           =
  // ======================================

  @Override
  public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
    return Customer16.class.isAssignableFrom(type);
  }

  @Override
  public Customer16 readFrom(Class<Customer16> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, String> httpHeaders, InputStream inputStream) throws IOException, WebApplicationException {

    String str = convertStreamToString(inputStream);
    StringTokenizer s = new StringTokenizer(str, "/");

    Customer16 customer16 = new Customer16();
    customer16.setId(s.nextToken());
    customer16.setFirstName(s.nextToken());
    customer16.setLastName(s.nextToken());

    return customer16;
  }

  public String convertStreamToString(InputStream is)
          throws IOException {

    return "1234/John/Smith";
    //
//    if (is != null) {
//      Writer writer = new StringWriter();
//
//      char[] buffer = new char[1024];
//      try {
//        Reader reader = new BufferedReader(
//                new InputStreamReader(is, "UTF-8"));
//        int n;
//        while ((n = reader.read(buffer)) != -1) {
//          writer.write(buffer, 0, n);
//        }
//      } finally {
//        is.close();
//      }
//      return writer.toString();
//    } else {
//      return "";
//    }
  }
}
