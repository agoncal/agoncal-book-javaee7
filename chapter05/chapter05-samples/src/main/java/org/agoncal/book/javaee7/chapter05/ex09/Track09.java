package org.agoncal.book.javaee7.chapter05.ex09;

import javax.persistence.*;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Entity
@Table(name = "ex09_track")
public class Track09 {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String title;
  private Float duration;
  @Basic(fetch = FetchType.LAZY)
  @Lob
  private byte[] wav;
  private String description;

  // ======================================
  // =            Constructors            =
  // ======================================

  public Track09() {
  }

  public Track09(String title, Float duration, String description) {
    this.title = title;
    this.duration = duration;
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

  public Float getDuration() {
    return duration;
  }

  public void setDuration(Float duration) {
    this.duration = duration;
  }

  public byte[] getWav() {
    return wav;
  }

  public void setWav(byte[] wav) {
    this.wav = wav;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
