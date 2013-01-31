package org.agoncal.book.javaee7.chapter05.ex49;

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
@Table(name = "ex49_news")
public class News49 {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Id
  @GeneratedValue
  private Long id;
  @Column(nullable = false)
  private String content;
  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
  @OrderBy("postedDate DESC")
  private List<Comment49> comments;

  // ======================================
  // =            Constructors            =
  // ======================================

  public News49() {
  }

  public News49(String content) {
    this.content = content;
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public Long getId() {
    return id;
  }

  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

  public void addComment(Comment49 comment) {
    if (comments == null)
      comments = new ArrayList<Comment49>();
    comments.add(comment);
  }

  public List<Comment49> getComments() {
    return comments;
  }
}