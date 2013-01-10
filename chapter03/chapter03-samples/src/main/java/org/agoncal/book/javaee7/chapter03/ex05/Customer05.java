package org.agoncal.book.javaee7.chapter03.ex05;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class Customer05 {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Email
  private String userId;
  @NotNull @Size(min = 4, max = 50, message = "Firstname should be between {min} and {max}")
  private String firstName;
  private String lastName;
  @Email(message = "Recovery email is not a valid email address")
  private String recoveryEmail;
  private String phoneNumber;
  private Date dateOfBirth;
  @Min(value = 18, message = "Customer is too young. Should be older that {value}")
  private Integer age;
  private Date creationDate;

  // ======================================
  // =            Constructors            =
  // ======================================

  public Customer05() {
  }

  public Customer05(String firstName, String lastName, String userId, String recoveryEmail, String phoneNumber, Date dateOfBirth, Date creationDate) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.userId = userId;
    this.recoveryEmail = recoveryEmail;
    this.phoneNumber = phoneNumber;
    this.dateOfBirth = dateOfBirth;
    this.creationDate = creationDate;
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

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public String getRecoveryEmail() {
    return recoveryEmail;
  }

  public void setRecoveryEmail(String recoveryEmail) {
    this.recoveryEmail = recoveryEmail;
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

  public Integer getAge() {
    return age;
  }

  public void setAge(Integer age) {
    this.age = age;
  }

  public Date getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(Date creationDate) {
    this.creationDate = creationDate;
  }
}