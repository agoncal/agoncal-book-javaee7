package org.agoncal.book.javaee7.chapter08.ex02;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashMap;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Entity
@NamedQuery(name = "CD09.findAllCDs", query = "SELECT c FROM CD09 c")
public class CD02 implements Serializable {

  // ======================================
  // =             Attributes             =
  // ======================================
  @Id
  @GeneratedValue
  private Long id;
  private String title;
  private Float price;
  @Column(length = 2000)
  private String description;
  @Lob
  private byte[] cover;
  private String musicCompany;
  private Integer numberOfCDs;
  private Float totalDuration;
  private String gender;

  // ======================================
  // =            Constructors            =
  // ======================================

  public CD02() {
  }

  public CD02(String title, Float price, String description, HashMap<Integer, String> tracks) {
    this.title = title;
    this.price = price;
    this.description = description;
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public Long getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public Float getPrice() {
    return price;
  }

  public void setPrice(Float price) {
    this.price = price;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public byte[] getCover() {
    return cover;
  }

  public void setCover(byte[] cover) {
    this.cover = cover;
  }

  public String getMusicCompany() {
    return musicCompany;
  }

  public void setMusicCompany(String musicCompany) {
    this.musicCompany = musicCompany;
  }

  public Integer getNumberOfCDs() {
    return numberOfCDs;
  }

  public void setNumberOfCDs(Integer numberOfCDs) {
    this.numberOfCDs = numberOfCDs;
  }

  public Float getTotalDuration() {
    return totalDuration;
  }

  public void setTotalDuration(Float totalDuration) {
    this.totalDuration = totalDuration;
  }

  public String getGender() {
    return gender;
  }

  public void setGender(String gender) {
    this.gender = gender;
  }
}