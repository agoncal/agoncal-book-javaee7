package org.agoncal.book.javaee7.chapter12.ex03;

import org.agoncal.book.javaee7.chapter12.Book;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Named
@RequestScoped
public class BookController03 {

  // ======================================
  // =             Attributes             =
  // ======================================

  private Book book = new Book();

  // ======================================
  // =           Public Methods           =
  // ======================================

  public String doCreateBook() {
    createBook(book);
    return "listBooks.xhtml";
  }

  private void createBook(Book book) {
  }

  // Constructors, getters, setters
}
