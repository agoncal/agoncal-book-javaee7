package org.agoncal.book.javaee7.chapter10.ex07;


import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish 3
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Named
@RequestScoped
public class HtmlComponentController {

  // ======================================
  // =             Attributes             =
  // ======================================

  List<Book07> bookList;
  String title;

  // ======================================
  // =          Lifecycle Methods         =
  // ======================================

  @PostConstruct
  private void init() {
    bookList = new ArrayList<>();
    bookList.add(new Book07("H2G2", 12f, "Scifi IT book", "1234-234", 241, true));
    bookList.add(new Book07("Robots", 18.5f, "Best seller", "564-694", 317, true));
    bookList.add(new Book07("Dune", 23.25f, "The trilogy", "256-6-56", 529, true));
  }

  // ======================================
  // =           Public Methods           =
  // ======================================

  public String doNext() {
    return null;
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public List<Book07> getBookList() {
    return bookList;
  }

  public void setBookList(List<Book07> bookList) {
    this.bookList = bookList;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }
}