package org.agoncal.book.javaee7.chapter11.ex05;

import org.agoncal.book.javaee7.chapter11.Book;

import javax.enterprise.inject.Model;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Model
public class BookController05 {

  // ======================================
  // =             Attributes             =
  // ======================================

  private Book book = new Book();

  public String doCreateBook() {
    createBook(book);
    return "listBooks.xhtml";
  }

  private void createBook(Book book) {
  }

  // Constructors, getters, setters
}
