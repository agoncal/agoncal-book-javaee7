package org.agoncal.book.javaee7.chapter05.ex51;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Entity
@Table(name = "ex51_comment")
public class Comment51 {

  // ======================================
  // =             Attributes             =
  // ======================================
  @Id
  @GeneratedValue
  private Long id;
  private String nickname;
  private String content;
  private Integer note;

  // ======================================
  // =            Constructors            =
  // ======================================

  public Comment51() {
  }

  public Comment51(String nickname, String content, Integer note) {
    this.nickname = nickname;
    this.content = content;
    this.note = note;
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public Long getId() {
    return id;
  }

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public Integer getNote() {
    return note;
  }

  public void setNote(Integer note) {
    this.note = note;
  }
}