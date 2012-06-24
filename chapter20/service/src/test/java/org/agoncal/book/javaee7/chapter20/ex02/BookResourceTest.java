package org.agoncal.book.javaee7.chapter20.ex02;

import org.agoncal.book.javaee7.chapter20.ex03.Book03;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;
import java.util.Map;

import static org.custommonkey.xmlunit.XMLAssert.assertXMLEqual;

/*
import org.sun.grizzly.http.SelectorThread;
import org.sun.jersey.api.client.Client;
import org.sun.jersey.api.client.WebResource;
import org.sun.jersey.api.container.grizzly.GrizzlyWebContainerFactory;
import org.sun.jersey.core.header.MediaTypes;
*/

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class BookResourceTest {

    // ======================================
    // =             Attributes             =
    // ======================================
//    private static SelectorThread threadSelector;
//    private static WebResource r;
    public static final String URI = "http://localhost:9998/";

    public static final String XML = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?><book03><description>IT scifi book</description><illustrations>true</illustrations><isbn>12345678</isbn><nbOfPage>152</nbOfPage><price>12.0</price><title>H2G2</title></book03>";

    // ======================================
    // =          Lifecycle Methods         =
    // ======================================

    @BeforeClass
    public static void init() throws IOException {
        Map<String, String> initParams = new HashMap<String, String>();

        initParams.put("com.sun.jersey.config.property.packages", "com.apress.javaee6.chapter15.ex02");

        System.out.println("Starting grizzly...");
//        threadSelector = GrizzlyWebContainerFactory.create(URI, initParams);
//
//        Client c = Client.create();
//        r = c.resource(URI);
    }

    @AfterClass
    public static void stop() {
//        threadSelector.stopEndpoint();
    }

    // ======================================
    // =              Unit tests            =
    // ======================================

    /**
     * Test to see if the XML is well formatted.
     */
    @Test
    public void testXML() throws Exception {
        Book03 book = new Book03("H2G2", 12f, "IT scifi book", "12345678", 152, true);
        StringWriter writer = new StringWriter();
        JAXBContext jaxbContext = JAXBContext.newInstance(Book03.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.marshal(book, writer);

        assertXMLEqual(XML, writer.toString());
    }

    /**
     * Test to see that the message "Hello World" is sent in the response.
     */
    @Test
    @Ignore
    public void testHelloWorld() throws Exception {
//        String responseMsg = r.path("books/12345678").get(String.class);
//        assertEquals("Hello World", responseMsg);
//        assertXMLEqual(XML, responseMsg);
    }

    /**
     * Test if a WADL document is available at the relative path
     * "application.wadl".
     */
    public void testApplicationWadl() {
//        String serviceWadl = r.path("application.wadl").accept(MediaTypes.WADL).get(String.class);
//        assertTrue(serviceWadl.length() > 0);
    }
}