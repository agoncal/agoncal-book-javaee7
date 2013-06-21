package org.agoncal.book.javaee7.chapter09.ex03;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;

import static org.agoncal.book.javaee7.chapter09.ex03.Book03.*;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Entity
@NamedQuery(name = FIND_ALL, query = "SELECT b FROM Book03 b")
public class Book03 extends Item03 {

  // ======================================
  // =             Constants              =
  // ======================================

  public static final String FIND_ALL = "Book03.findAllBooks";

  // ======================================
  // =             Attributes             =
  // ======================================

  private String isbn;
  private Integer nbOfPage;
  private Boolean illustrations;

  // ======================================
  // =            Constructors            =
  // ======================================

  public Book03() {
  }

  public Book03(String title, Float price, String description, String isbn, Integer nbOfPage, Boolean illustrations) {
    this.title = title;
    this.price = price;
    this.description = description;
    this.isbn = isbn;
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