package org.agoncal.book.javaee7.chapter02.ex23;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import java.util.Date;

import static javax.persistence.TemporalType.DATE;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Entity
public class Customer23 {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Id
  private Long id;
  private String firstName;
  private String lastName;
  private String email;
  private String phoneNumber;
  @Temporal(DATE)
  private Date dateOfBirth;

  // ======================================
  // =            Constructors            =
  // ======================================

  public Customer23() {
  }

  public Customer23(String firstName, String lastName, String email) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
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

  public Date getDateOfBirth() {
    return dateOfBirth;
  }

  public void setDateOfBirth(Date dateOfBirth) {
    this.dateOfBirth = dateOfBirth;
  }
}