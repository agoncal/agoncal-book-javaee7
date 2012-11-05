package org.agoncal.book.javaee7.chapter13;

import org.agoncal.book.javaee7.chapter13.ex01.ItemEJB01Test;
import org.agoncal.book.javaee7.chapter13.ex03.ItemEJB03Test;
import org.agoncal.book.javaee7.chapter13.ex04.ItemEJB04Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        ItemEJB01Test.class,
        ItemEJB03Test.class,
        ItemEJB04Test.class
})
public class AllTests {
}