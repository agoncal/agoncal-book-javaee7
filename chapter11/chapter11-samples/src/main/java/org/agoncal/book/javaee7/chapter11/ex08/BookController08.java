package org.agoncal.book.javaee7.chapter11.ex08;

import org.agoncal.book.javaee7.chapter11.Book;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
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
public class BookController08 {

  // ======================================
  // =             Attributes             =
  // ======================================

  private BookEJB bookEJB = new BookEJB();
  private Book book = new Book();

  // ======================================
  // =           Public Methods           =
  // ======================================

  public String doCreateBook() {
    FacesContext ctx = FacesContext.getCurrentInstance();

    if (book.getIsbn() == null || "".equals(book.getIsbn())) {
      ctx.addMessage("bookForm:isbn", new FacesMessage(FacesMessage.SEVERITY_WARN,
              "Wrong isbn", "You should enter an ISBN number"));
    }
    if (book.getTitle() == null || "".equals(book.getTitle())) {
      ctx.addMessage("bookForm:title", new FacesMessage(FacesMessage.SEVERITY_WARN,
              "Wrong title", "You should enter a title for the book"));
    }

    if (ctx.getMessageList().size() != 0)
      return null;

    try {
      book = bookEJB.createBook(book);
      ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Book created",
              "The book" + book.getTitle() + " has been created with id=" + book.getId()));
    } catch (Exception e) {
      ctx.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
              "Book hasn't been created", e.getMessage()));
    }
    return null;
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public Book getBook() {
    return book;
  }

  public void setBook(Book book) {
    this.book = book;
  }

  private class BookEJB {
    public Book createBook(Book book) {
      return null;
    }
  }
}
