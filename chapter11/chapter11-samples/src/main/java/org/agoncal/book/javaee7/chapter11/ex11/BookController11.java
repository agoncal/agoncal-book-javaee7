package org.agoncal.book.javaee7.chapter11.ex11;

import org.agoncal.book.javaee7.chapter11.Book;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Named
@RequestScoped
public class BookController11 {

  // ======================================
  // =             Attributes             =
  // ======================================

  //  @Inject
  private BookEJB bookEJB;

  private Book book = new Book();

  private List<Book> bookList = new ArrayList<>();

  // ======================================
  // =           Public Methods           =
  // ======================================

  public String doCreateBook() {
    book = bookEJB.createBook(book);
    bookList = bookEJB.findBooks();
    return "success";
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

  @PostConstruct
  private void initBookList() {
    bookEJB = new BookEJB();
  }

  private class BookEJB {
    public Book createBook(Book book) {
      return null;
    }

    public List<Book> findBooks() {
      List<Book> bookList = new ArrayList<>();
      bookList.add(new Book("The Hitchhiker's Guide to the Galaxy", 23.99f, "Science fiction comedy book", 352, Boolean.TRUE));
      bookList.add(new Book("Harry Potter and the Goblet of Fire", 19.79f, "Kids best seller (Book 4)", 734, Boolean.TRUE));
//      bookList.add(new Book("The Elements of Style", 6.64f, "A masterpiece in the art of clear and concise writing.", 105, Boolean.FALSE));
//      bookList.add(new Book("Harry Potter And The Order Of The Phoenix", 9.35f, "Science fiction (Book 1)", 870, Boolean.TRUE));
//      bookList.add(new Book("The Difference Between God and Larry Ellison", 11.99f, "God Doesn't Think He's Larry Ellison", 420, Boolean.FALSE));
//      bookList.add(new Book("The Children of Hurin", 17.16f, "The first complete book by J.R.R. Tolkien in three decades", 313, Boolean.TRUE));
//      bookList.add(new Book("The Da Vinci Code", 17.79f, "Thriller", 454, Boolean.FALSE));
//      bookList.add(new Book("La carte et le territoire", 24.99f, "Prix Goncourt 2010", 428, Boolean.FALSE));
//      bookList.add(new Book("Une forme de vie", 18.99f, "Amelie Nothomb", 168, Boolean.FALSE));
//      bookList.add(new Book("To Kill a Mockingbird", 5.99f, "American classic", 281, Boolean.FALSE));
//      bookList.add(new Book("Fahrenheit 451", 7.99f, "Science fiction", 208, Boolean.FALSE));
//      bookList.add(new Book("Lolita", 14.99f, "Nabovok masterpiece", 368, Boolean.TRUE));
//      bookList.add(new Book("A Midsummer Night's Dream", 14.99f, "Shakespeare masterpiece", 288, Boolean.TRUE));
//      bookList.add(new Book("I bastioni del coraggio", 18.99f, "Anno domini 1548. Una grande storia d'amore, ...", 457, Boolean.FALSE));
//      bookList.add(new Book("Harjunpaa ja pahan pappi", 32.49f, "Finns read crime novels", 300, Boolean.FALSE));
//      bookList.add(new Book("El ingenioso hidalgo don Quijote de la Mancha", 13.99f, "Classical Don Quijote", 108, Boolean.TRUE));
//      bookList.add(new Book("The Lord of the Rings", 50.4f, "Science fiction comedy book", 1216, Boolean.TRUE));
      bookList.add(new Book("Java EE 6 with GlassFish 3", 31.49f, "Just amazing", 458, Boolean.TRUE));
//      bookList.add(new Book("Heidis Lehr- und Wanderjahre", 68f, "Inhalt: Die Heidi-Bucher erzahlen...", 160, Boolean.TRUE));
//      bookList.add(new Book("l Nome della Rosa", 34.99f, "Science fiction comedy book", 354, Boolean.FALSE));
      return bookList;
    }
  }
}