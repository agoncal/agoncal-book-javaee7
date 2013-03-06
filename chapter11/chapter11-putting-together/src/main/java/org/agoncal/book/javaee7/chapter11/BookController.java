package org.agoncal.book.javaee7.chapter11;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
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
public class BookController {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Inject
  private BookEJB bookEJB;
  private Book book = new Book();

  // ======================================
  // =           Public Methods           =
  // ======================================

  public String doCreateBook() {
    bookEJB.createBook(book);
    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Book created",
            "The book" + book.getTitle() + " has been created with id=" + book.getId()));
    return "newBook.xhtml";
  }

  public void doFindBookById() {
    book = bookEJB.findBookById(book.getId());
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
}