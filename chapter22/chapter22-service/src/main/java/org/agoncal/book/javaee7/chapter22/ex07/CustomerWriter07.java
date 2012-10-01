package org.agoncal.book.javaee7.chapter22.ex07;

import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyWriter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Provider
@Produces(MediaType.TEXT_PLAIN)
public class CustomerWriter07 implements MessageBodyWriter<Customer07> {
    @Override
    public boolean isWriteable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return Customer07.class.isAssignableFrom(type);
    }

    @Override
    public void writeTo(Customer07 customer, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, Object> httpHeaders, OutputStream outputStream) throws IOException, WebApplicationException {
        outputStream.write(customer.getId().byteValue());
        //
    }

    @Override
    public long getSize(Customer07 customer, Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return 0;
    }
}
