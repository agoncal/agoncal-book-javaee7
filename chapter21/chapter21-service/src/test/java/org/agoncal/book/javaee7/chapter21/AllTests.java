package org.agoncal.book.javaee7.chapter21;

import org.agoncal.book.javaee7.chapter21.ex06.CardValidator06Test;
import org.agoncal.book.javaee7.chapter21.ex16.CardValidator16Test;
import org.agoncal.book.javaee7.chapter21.ex23.CardValidator23Test;
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
        CardValidator06Test.class,
        CardValidator16Test.class,
        CardValidator23Test.class
})
public class AllTests {
}