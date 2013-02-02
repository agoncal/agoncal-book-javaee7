package org.agoncal.book.javaee7.chapter05.ex56;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Entity
@DiscriminatorValue("C")
public class CD56 extends Item56 {

  // ======================================
  // =             Attributes             =
  // ======================================

  private String musicCompany;
  private Integer numberOfCDs;
  private Float totalDuration;
  private String genre;

  // ======================================
  // =            Constructors            =
  // ======================================

  public CD56() {
  }

  public CD56(String title, Float price, String description, String musicCompany, Integer numberOfCDs, Float totalDuration, String genre) {
    super(title, price, description);
    this.musicCompany = musicCompany;
    this.numberOfCDs = numberOfCDs;
    this.totalDuration = totalDuration;
    this.genre = genre;
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

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

  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }
}