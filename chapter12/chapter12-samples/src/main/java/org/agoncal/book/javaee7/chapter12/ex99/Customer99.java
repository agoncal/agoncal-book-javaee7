package org.agoncal.book.javaee7.chapter12.ex99;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class Customer99 {

  // ======================================
  // =             Attributes             =
  // ======================================

  @XmlAttribute(name = "first_name")
  private String firstName;
  @XmlAttribute(name = "last_name")
  private String lastName;
  private String email;
  private String phoneNumber;

// ======================================
// =            Constructors            =
// ======================================

  public Customer99() {
  }

  public Customer99(String firstName, String lastName, String email, String phoneNumber) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.phoneNumber = phoneNumber;
  }

// ======================================
// =          Getters & Setters         =
// ======================================

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }
}