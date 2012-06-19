package org.agoncal.book.javaee7.chapter20.ex01;

//import org.sun.grizzly.http.SelectorThread;
//import org.sun.jersey.api.client.Client;
//import org.sun.jersey.api.client.WebResource;
//import org.sun.jersey.api.container.grizzly.GrizzlyWebContainerFactory;
//import org.sun.jersey.core.header.MediaTypes;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish 3
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class HelloWorldResourceTest {

    // ======================================
    // =             Attributes             =
    // ======================================
//    private SelectorThread threadSelector;
//    private WebResource r;
    public static final String URI = "http://localhost:9998/";

    // ======================================
    // =          Lifecycle Methods         =
    // ======================================

    @Before
    public void init() throws IOException {
        Map<String, String> initParams = new HashMap<String, String>();

        initParams.put("com.sun.jersey.config.property.packages", "com.apress.javaee6.chapter15.ex01");

        System.out.println("Starting grizzly...");
//        threadSelector = GrizzlyWebContainerFactory.create(URI, initParams);
//
//        Client c = Client.create();
//        r = c.resource(URI);
    }

    @After
    public void stop() {
//        threadSelector.stopEndpoint();
    }

    // ======================================
    // =              Unit tests            =
    // ======================================

    /**
     * Test to see that the message "Hello World" is sent in the response.
     */
    @Test
    public void testHelloWorld() {
//        String responseMsg = r.path("helloworld").get(String.class);
//        assertEquals("Hello World", responseMsg);
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