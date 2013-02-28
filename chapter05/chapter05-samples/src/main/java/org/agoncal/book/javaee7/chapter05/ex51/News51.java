package org.agoncal.book.javaee7.chapter05.ex51;

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
@Table(name = "ex51_news")
public class News51 {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Id
  @GeneratedValue
  private Long id;
  @Column(nullable = false)
  private String content;
  @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
  @OrderColumn(name = "publication_index")
  private List<Comment51> comments;

  // ======================================
  // =            Constructors            =
  // ======================================

  public News51() {
  }

  public News51(String content) {
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

  public void addComment(Comment51 comment) {
    if (comments == null)
      comments = new ArrayList<Comment51>();
    comments.add(comment);
  }

  public List<Comment51> getComments() {
    return comments;
  }
}