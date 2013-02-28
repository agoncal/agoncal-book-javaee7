package org.agoncal.book.javaee7.chapter05.ex04;

import javax.persistence.Embeddable;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Embeddable
public class NewsId04 {

  // ======================================
  // =             Attributes             =
  // ======================================

  private String title;
  private String language;

  // ======================================
  // =            Constructors            =
  // ======================================

  public NewsId04() {
  }

  public NewsId04(String title, String language) {
    this.title = title;
    this.language = language;
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getLanguage() {
    return language;
  }

  public void setLanguage(String language) {
    this.language = language;
  }

  // ======================================
  // =         hash, equals, toString     =
  // ======================================

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    NewsId04 newsId = (NewsId04) o;

    if (!language.equals(newsId.language)) return false;
    if (!title.equals(newsId.title)) return false;

    return true;
  }

  @Override
  public int hashCode() {
    int result = title.hashCode();
    result = 31 * result + language.hashCode();
    return result;
  }
}