package org.agoncal.book.javaee7.chapter22.ex09;

import javax.ws.rs.Consumes;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.io.InputStream;
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
@Consumes(MediaType.APPLICATION_XML)
public class CustomerReader07 implements MessageBodyReader<Customer07> {

    @Override
    public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return Customer07.class.isAssignableFrom(type);
    }

    @Override
    public Customer07 readFrom(Class<Customer07> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, String> httpHeaders, InputStream inputStream) throws IOException, WebApplicationException {
        /*Document doc = getParser().parse(inputStream.read());
        Element node = doc.getDocumentElement();
        if (node.getLocalName().equals("customer")) {
            // Parse the XML stream
            return customer;
        } else {
            throw new IOException("Unexpected payload!");
        }
        */
        return null;
    }
}
