package org.agoncal.book.javaee7.chapter03.ex21;

import javax.validation.constraints.*;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class CD21 {

  // ======================================
  // =             Attributes             =
  // ======================================

  @NotNull
  @Size(min = 4, max = 50)
  private String title;
  @NotNull
  private Float price;
  @NotNull(groups = PrintingCatalog.class)
  @Size(min = 10, max = 5000, groups = PrintingCatalog.class)
  private String description;
  @Pattern(regexp = "[A-Z][a-z]{1,}")
  private String musicCompany;
  @Max(value = 5)
  private Integer numberOfCDs;
  private Float totalDuration;

  // ======================================
  // =            Constructors            =
  // ======================================

  public CD21() {
  }

  public CD21(String title, Float price) {
    this.title = title;
    this.price = price;
  }

  // ======================================
  // =           Public Methods           =
  // ======================================

  @NotNull
  @DecimalMin("5.8")
  public Float calculatePrice(@DecimalMin("1.4") Float rate) {
    return price * rate;
  }

  @DecimalMin("9.99")
  public Float calculateVAT() {
    return price * 0.196f;
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
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

  // ======================================
  // =         hash, equals, toString     =
  // ======================================

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("CD");
    sb.append(", title='").append(title).append('\'');
    sb.append(", price=").append(price);
    sb.append(", description='").append(description).append('\'');
    sb.append(", musicCompany='").append(musicCompany).append('\'');
    sb.append(", numberOfCDs=").append(numberOfCDs);
    sb.append(", totalDuration=").append(totalDuration);
    sb.append('}');
    return sb.toString();
  }
}