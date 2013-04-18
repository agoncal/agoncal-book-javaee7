package org.agoncal.book.javaee7.chapter02;


import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import java.util.Random;
import java.util.logging.Logger;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Alternative
@ThirteenDigits
public class MockGenerator implements NumberGenerator {

    // ======================================
    // =             Attributes             =
    // ======================================

  @Inject
  private Logger logger;

    // ======================================
    // =          Business methods          =
    // ======================================

    @Loggable
    public String generateNumber() {
    String mock = "MOCK-" + Math.abs(new Random().nextInt());
    logger.info("Generated Mock : " + mock);
    return mock;
    }
}
