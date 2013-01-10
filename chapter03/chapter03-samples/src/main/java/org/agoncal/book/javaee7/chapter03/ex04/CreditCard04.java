package org.agoncal.book.javaee7.chapter03.ex04;

import javax.validation.constraints.NotNull;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class CreditCard04 {

  // ======================================
  // =             Attributes             =
  // ======================================

  @NotNull
  private String number;
  @NotNull
  private String expiryDate;
  @NotNull
  private Integer controlNumber;
  private String type;

  // ======================================
  // =            Constructors            =
  // ======================================

  public CreditCard04() {
  }

  public CreditCard04(String number, String expiryDate, Integer controlNumber, String type) {
    this.number = number;
    this.expiryDate = expiryDate;
    this.controlNumber = controlNumber;
    this.type = type;
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public String getNumber() {
    return number;
  }

  public void setNumber(String number) {
    this.number = number;
  }

  public String getExpiryDate() {
    return expiryDate;
  }

  public void setExpiryDate(String expiryDate) {
    this.expiryDate = expiryDate;
  }

  public Integer getControlNumber() {
    return controlNumber;
  }

  public void setControlNumber(Integer controlNumber) {
    this.controlNumber = controlNumber;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }
}