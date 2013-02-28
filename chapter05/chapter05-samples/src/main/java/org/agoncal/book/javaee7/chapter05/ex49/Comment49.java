package org.agoncal.book.javaee7.chapter05.ex49;

import javax.persistence.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Entity
@Table(name = "ex49_comment")
public class Comment49 {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Id
  @GeneratedValue
  private Long id;
  private String nickname;
  private String content;
  private Integer note;
  @Column(name = "posted_date")
  @Temporal(TemporalType.TIMESTAMP)
  private Date postedDate;

  // ======================================
  // =            Constructors            =
  // ======================================

  public Comment49() {
  }

  public Comment49(String nickname, String content, Integer note, String postedDate) {
    this.nickname = nickname;
    this.content = content;
    this.note = note;

    try {
      DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
      this.postedDate = df.parse(postedDate);
    } catch (ParseException e) {
      e.printStackTrace();
    }
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