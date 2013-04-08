package org.agoncal.book.javaee7.chapter02.ex16;


import javax.inject.Inject;
import java.util.logging.Logger;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@ThirteenDigits16
public class IsbnGenerator16 implements NumberGenerator16 {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Inject
  Logger log;

  @Inject
  @ThirteenDigits16
  private String prefix;

  @Inject
  @ThirteenDigits16
  private int editorNumber;

  @Inject
  @Random16
  private double postfix;

  // ======================================
  // =          Business methods          =
  // ======================================

  public String generateNumber() {
    log.warning("Debug message with @Inject");
    return prefix + editorNumber + postfix;
  }
}