package org.agoncal.book.javaee7.chapter22.ex16;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.util.Scanner;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Provider
@Consumes("custom/format")
@Produces("custom/format")
public class CustomerProvider16 implements MessageBodyReader<Customer16>, MessageBodyWriter<Customer16> {

  // ======================================
  // =               Reader               =
  // ======================================

  @Override
  public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
    return Customer16.class.isAssignableFrom(type);
  }

  @Override
  public Customer16 readFrom(Class<Customer16> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, String> httpHeaders, InputStream inputStream) throws IOException, WebApplicationException {

    Customer16 customer16 = new Customer16();
    Scanner s = new java.util.Scanner(inputStream).useDelimiter("/");
    customer16.setId(s.next());
    customer16.setFirstName(s.next());
    customer16.setLastName(s.next());

    return customer16;
  }

  // ======================================
  // =               Writer               =
  // ======================================

  @Override
  public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
    return Customer16.class.isAssignableFrom(type);
  }

  @Override
  public void writeTo(Customer16 customer, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, Object> httpHeaders, OutputStream outputStream) throws IOException, WebApplicationException {
    outputStream.write(customer.getId().getBytes());
    outputStream.write('/');
    outputStream.write(customer.getFirstName().getBytes());
    outputStream.write('/');
    outputStream.write(customer.getLastName().getBytes());
  }

  @Override
  public long getSize(Customer16 customer, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
    return customer.getId().length() + 1 + customer.getFirstName().length() + 1 + customer.getLastName().length();
  }

}
