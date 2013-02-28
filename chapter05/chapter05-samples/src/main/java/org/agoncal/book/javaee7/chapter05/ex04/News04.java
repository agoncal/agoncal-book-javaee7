package org.agoncal.book.javaee7.chapter05.ex04;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Entity
@Table(name = "ex05_news")
public class News04 {

  // ======================================
  // =             Attributes             =
  // ======================================

  @EmbeddedId
  private NewsId04 id;
  private String content;

  // ======================================
  // =            Constructors            =
  // ======================================

  public News04() {
  }

  public News04(NewsId04 id, String content) {
    this.id = id;
    this.content = content;
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public NewsId04 getId() {
    return id;
  }

  public void setId(NewsId04 id) {
    this.id = id;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }
}