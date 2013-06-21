package org.agoncal.book.javaee7.chapter09.ex04;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import java.util.HashMap;

import static org.agoncal.book.javaee7.chapter09.ex04.CD04.*;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Entity
@NamedQuery(name = FIND_ALL, query = "SELECT c FROM CD04 c")
public class CD04 extends Item04 {

  // ======================================
  // =             Constants              =
  // ======================================

  public static final String FIND_ALL = "CD04.findAllCDs";

  // ======================================
  // =             Attributes             =
  // ======================================

  @Lob
  private byte[] cover;
  private String musicCompany;
  private Integer numberOfCDs;
  private Float totalDuration;
  private String genre;

  // ======================================
  // =            Constructors            =
  // ======================================

  public CD04() {
  }

  public CD04(String title, Float price, String description, HashMap<Integer, String> tracks) {
    this.title = title;
    this.price = price;
    this.description = description;
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

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

  public String getGenre() {
    return genre;
  }

  public void setGenre(String genre) {
    this.genre = genre;
  }
}