package org.agoncal.book.javaee7.chapter09;

import org.agoncal.book.javaee7.chapter09.ex01.ItemEJB01IT;
import org.agoncal.book.javaee7.chapter09.ex03.ItemEJB03Test;
import org.agoncal.book.javaee7.chapter09.ex04.ItemEJB04Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        ItemEJB01IT.class,
        ItemEJB03Test.class,
        ItemEJB04Test.class
})
public class AllTests {
}