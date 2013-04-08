package org.agoncal.book.javaee7.chapter02.ex14;


import javax.enterprise.inject.Alternative;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Alternative
public class MockGenerator14 implements NumberGenerator14 {

  // ======================================
  // =          Business methods          =
  // ======================================

  public String generateNumber() {
    return "MOCK";
  }
}