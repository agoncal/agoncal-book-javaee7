package org.agoncal.book.javaee7.chapter12;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Logger;

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
  private List<Book> bookList = new ArrayList<Book>();
  private String tags;

  private Logger logger = Logger.getLogger("org.agoncal.book.javaee7");

  // ======================================
  // =          Lifecycle methods         =
  // ======================================

  @PostConstruct
  private void initList() {
    logger.fine("ItemController.initList()");
    bookList = bookEJB.findAllBooks();
  }

  // ======================================
  // =           Public Methods           =
  // ======================================

  public String doCreateBook() {
    logger.fine("ItemController.doCreateBook():" + book);
    book.setTags(transformToList(tags));
    bookEJB.createBook(book);
    bookList = bookEJB.findAllBooks();
    book = new Book();
    return "newBook.xhtml";
  }

  // ======================================
  // =           Private methods          =
  // ======================================

  private List<String> transformToList(String tagsRequestParameter) {
    logger.finer("ItemController.transformToList():" + tagsRequestParameter);
    if (tagsRequestParameter == null)
      return null;
    List<String> listOfTags = new ArrayList<>();
    StringTokenizer tokens = new StringTokenizer(tagsRequestParameter, ",");
    while (tokens.hasMoreElements()) {
      listOfTags.add(((String) tokens.nextElement()).trim());
    }
    return listOfTags;
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

  public List<Book> getBookList() {
    return bookList;
  }

  public void setBookList(List<Book> bookList) {
    this.bookList = bookList;
  }

  public String getTags() {
    return tags;
  }

  public void setTags(String tags) {
    this.tags = tags;
  }

  public Language[] getLanguages() {
    return Language.values();
  }
}