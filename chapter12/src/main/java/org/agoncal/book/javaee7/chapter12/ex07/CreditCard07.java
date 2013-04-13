package org.agoncal.book.javaee7.chapter12.ex07;

import javax.xml.bind.annotation.*;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@XmlRootElement
public class CreditCard07 {

  // ======================================
  // =             Attributes             =
  // ======================================

  private String number;
  private String expiryDate;
  private Integer controlNumber;
  private String type;

  // ======================================
  // =            Constructors            =
  // ======================================

  public CreditCard07() {
  }

  public CreditCard07(String number, String expiryDate, Integer controlNumber, String type) {
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

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    CreditCard07 that = (CreditCard07) o;

    if (controlNumber != null ? !controlNumber.equals(that.controlNumber) : that.controlNumber != null)
      return false;
    if (expiryDate != null ? !expiryDate.equals(that.expiryDate) : that.expiryDate != null) return false;
    if (number != null ? !number.equals(that.number) : that.number != null) return false;
    if (type != null ? !type.equals(that.type) : that.type != null) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = number != null ? number.hashCode() : 0;
    result = 31 * result + (expiryDate != null ? expiryDate.hashCode() : 0);
    result = 31 * result + (controlNumber != null ? controlNumber.hashCode() : 0);
    result = 31 * result + (type != null ? type.hashCode() : 0);
    return result;
  }
}
