package org.agoncal.book.javaee7.chapter05.ex61;

import javax.persistence.*;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Entity
@Table(name = "ex61_book")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "book_id")),
        @AttributeOverride(name = "title", column = @Column(name = "book_title")),
        @AttributeOverride(name = "description", column = @Column(name = "book_description"))
})
public class Book61 extends Item61 {

  // ======================================
  // =             Attributes             =
  // ======================================

  private String isbn;
  private String publisher;
  private Integer nbOfPage;
  private Boolean illustrations;

  // ======================================
  // =            Constructors            =
  // ======================================

  public Book61() {
  }

  public Book61(String title, Float price, String description, String isbn, String publisher, Integer nbOfPage, Boolean illustrations) {
    super(title, price, description);
    this.isbn = isbn;
    this.publisher = publisher;
    this.nbOfPage = nbOfPage;
    this.illustrations = illustrations;
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public String getPublisher() {
    return publisher;
  }

  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }

  public Integer getNbOfPage() {
    return nbOfPage;
  }

  public void setNbOfPage(Integer nbOfPage) {
    this.nbOfPage = nbOfPage;
  }

  public Boolean getIllustrations() {
    return illustrations;
  }

  public void setIllustrations(Boolean illustrations) {
    this.illustrations = illustrations;
  }
}