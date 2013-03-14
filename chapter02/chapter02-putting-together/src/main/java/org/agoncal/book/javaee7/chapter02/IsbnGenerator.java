package org.agoncal.book.javaee7.chapter02;


import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.Random;
import java.util.logging.Logger;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 */
@ThirteenDigits
public class IsbnGenerator implements NumberGenerator {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Inject
  private Logger logger;

  private Random suffix;

  // ======================================
  // =          Lifecycle methods         =
  // ======================================

  @PostConstruct
  private void init() {
    suffix = new Random();
    logger.info("Generated suffix = "+ suffix.nextInt());
  }

  // ======================================
  // =          Business methods          =
  // ======================================

  @Loggable
  public String generateNumber() {
    return "13-84356-" + Math.abs(suffix.nextInt());
  }
}