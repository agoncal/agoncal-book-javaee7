package org.agoncal.book.javaee7.chapter05.ex20;

import javax.persistence.*;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish 3
 *         http://www.apress.com
 *         http://www.antoniogoncalves.org
 *         --
 */
@Entity
@Table(name = "ex20_customer")
@Access(AccessType.FIELD)
public class Customer20 {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Id
  @GeneratedValue
  private Long id;
  @Column(name = "first_name", nullable = false, length = 50)
  private String firstName;
  @Column(name = "last_name", nullable = false, length = 50)
  private String lastName;
  private String email;
  @Column(name = "phone_number", length = 15)
  private String phoneNumber;

  // ======================================
  // =            Constructors            =
  // ======================================

  public Customer20() {
  }

  public Customer20(String firstName, String lastName, String email, String phoneNumber) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.email = email;
    this.phoneNumber = phoneNumber;
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

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

  @Access(AccessType.PROPERTY)
  @Column(name = "phone_number", length = 555)
  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

}