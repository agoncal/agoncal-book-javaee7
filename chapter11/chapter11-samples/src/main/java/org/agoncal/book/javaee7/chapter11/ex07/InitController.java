package org.agoncal.book.javaee7.chapter11.ex07;

import org.agoncal.book.javaee7.chapter11.Book;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Named
@ApplicationScoped
public class InitController {

  // ======================================
  // =             Attributes             =
  // ======================================

  private Book defaultBook;

  // ======================================
  // =          Lifecycle methods         =
  // ======================================

  @PostConstruct
  private void init() {
    defaultBook = new Book("default title", 0F, "default descritpion", "0000-000", 100, true);
  }

  // Constructors, getters, setters
}
