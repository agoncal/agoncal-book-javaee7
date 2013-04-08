package org.agoncal.book.javaee7.chapter02.ex16;

import javax.inject.Inject;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@EightDigits16
public class IssnGenerator16 implements NumberGenerator16 {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Inject
  @EightDigits16
  private String prefix;

  @Inject
  @Random16
  private double postfix;

  // ======================================
  // =          Business methods          =
  // ======================================

  public String generateNumber() {
    return prefix + postfix;
  }
}