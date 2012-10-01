package org.agoncal.book.javaee7.chapter21;

import org.agoncal.book.javaee7.chapter21.ex01.CardValidator01Test;
import org.agoncal.book.javaee7.chapter21.ex16.CardValidator16Test;
import org.agoncal.book.javaee7.chapter21.ex23.CardValidator23Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish 3
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({
        CardValidator01Test.class,
        CardValidator16Test.class,
        CardValidator23Test.class
})
public class AllTests {
}