package org.agoncal.book.javaee7.chapter15.ex04;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@XmlRootElement
@XmlSeeAlso(Book04.class)
public class Books04 extends ArrayList<Book04> {

  // ======================================
  // =            Constructors            =
  // ======================================

  public Books04() {
    super();
  }

  public Books04(Collection<? extends Book04> c) {
    super(c);
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  @XmlElement(name = "book")
  public List<Book04> getBooks() {
    return this;
  }

  public void setBooks(List<Book04> books) {
    this.addAll(books);
  }
}