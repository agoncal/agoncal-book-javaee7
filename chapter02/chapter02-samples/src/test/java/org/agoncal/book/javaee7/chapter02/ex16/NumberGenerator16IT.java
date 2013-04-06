package org.agoncal.book.javaee7.chapter02.ex16;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class NumberGenerator16IT {

    // ======================================
    // =             Attributes             =
    // ======================================

    protected static Weld weld;
    protected static WeldContainer container;

    // ======================================
    // =          Lifecycle Methods         =
    // ======================================

    @BeforeClass
    public static void init() {
        weld = new Weld();
        container = weld.initialize();
    }

    @AfterClass
    public static void close() {
        weld.shutdown();
    }

    // ======================================
    // =              Methods               =
    // ======================================

    @Test
    public void shouldCheckNumberIsThirteenDigits() {
        BookService16 bookService = container.instance().select(BookService16.class).get();
        Book16 book = bookService.createBook("H2G2", 12.5f, "Geeky scifi Book");
        System.out.println("########### " + book.getIsbn());
        assertTrue(book.getIsbn().startsWith("13"));
    }
}