package org.agoncal.book.javaee7.chapter05.ex29;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Embeddable
@Access(AccessType.PROPERTY)
public class Address29 {

  // ======================================
  // =             Attributes             =
  // ======================================

  private String street1;
  private String street2;
  private String city;
  private String state;
  private String zipcode;
  private String country;

  // ======================================
  // =            Constructors            =
  // ======================================

  public Address29() {
  }

  public Address29(String street1, String street2, String city, String state, String zipcode, String country) {
    this.street1 = street1;
    this.street2 = street2;
    this.city = city;
    this.state = state;
    this.zipcode = zipcode;
    this.country = country;
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  @Column(nullable = false)
  public String getStreet1() {
    return street1;
  }

  public void setStreet1(String street1) {
    this.street1 = street1;
  }

  public String getStreet2() {
    return street2;
  }

  public void setStreet2(String street2) {
    this.street2 = street2;
  }

  @Column(nullable = false, length = 50)
  public String getCity() {
    return city;
  }

  public void setCity(String city) {
    this.city = city;
  }

  @Column(length = 3)
  public String getState() {
    return state;
  }

  public void setState(String state) {
    this.state = state;
  }

  @Column(name = "zip_code", length = 10)
  public String getZipcode() {
    return zipcode;
  }

  public void setZipcode(String zipcode) {
    this.zipcode = zipcode;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }
}