package org.agoncal.book.javaee7.chapter05.ex17;

import javax.persistence.*;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com
 *         http://www.antoniogoncalves.org
 *         --
 */
@Entity
@Table(name = "ex17_credit_card")
public class CreditCard17 {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Id
  private String number;
  private String expiryDate;
  private Integer controlNumber;
  @Enumerated(EnumType.STRING)
  private CreditCardType17 creditCardType;

  // ======================================
  // =            Constructors            =
  // ======================================

  public CreditCard17() {
  }

  public CreditCard17(String number, String expiryDate, Integer controlNumber, CreditCardType17 creditCardType) {
    this.number = number;
    this.expiryDate = expiryDate;
    this.controlNumber = controlNumber;
    this.creditCardType = creditCardType;
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

  public CreditCardType17 getType() {
    return creditCardType;
  }

  public void setType(CreditCardType17 creditCardType) {
    this.creditCardType = creditCardType;
  }
}
