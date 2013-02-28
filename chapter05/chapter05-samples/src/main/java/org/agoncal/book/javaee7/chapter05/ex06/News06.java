package org.agoncal.book.javaee7.chapter05.ex06;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Entity
@Table(name = "ex06_news")
@IdClass(NewsId06.class)
public class News06 {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Id
  private String title;
  @Id
  private String language;
  private String content;

  // ======================================
  // =            Constructors            =
  // ======================================

  public News06() {
  }

  public News06(String title, String language, String content) {
    this.title = title;
    this.language = language;
    this.content = content;
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

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }
}