package org.agoncal.book.javaee7.chapter08.ex04;

import java.io.Serializable;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class Customer04 implements Serializable {

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public String getBirthMonth() {
    return "12";
  }

  public String getBirthDay() {
    return "12";
  }
}