package org.agoncal.book.javaee7.chapter05.ex46;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Entity
@Table(name = "ex46_cd")
public class CD46 {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Id
  @GeneratedValue
  private Long id;
  private String title;
  private Float price;
  private String description;
  @ManyToMany(mappedBy = "appearsOnCDs")
  private List<Artist46> createdByArtists;

  // ======================================
  // =            Constructors            =
  // ======================================

  public CD46() {
  }

  public CD46(String title, Float price, String description) {
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

  public List<Artist46> getCreatedByArtists() {
    return createdByArtists;
  }

  public void setCreatedByArtists(List<Artist46> createdByArtists) {
    this.createdByArtists = createdByArtists;
  }

  public void createdBy(Artist46 artist) {
    if (createdByArtists == null)
      createdByArtists = new ArrayList<Artist46>();
    createdByArtists.add(artist);
  }
}