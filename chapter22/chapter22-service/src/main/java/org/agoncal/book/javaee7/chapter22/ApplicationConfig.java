package org.agoncal.book.javaee7.chapter22;

import org.agoncal.book.javaee7.chapter22.ex03.BookRestService03;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@ApplicationPath("rs")
public class ApplicationConfig extends Application {
    // ======================================
    // =          Business methods          =
    // ======================================
    private final Set<Class<?>> classes;

  public ApplicationConfig() {
    HashSet<Class<?>> c = new HashSet<Class<?>>();
    c.add(BookRestService03.class);
    classes = Collections.unmodifiableSet(c);
  }

  @Override
  public Set<Class<?>> getClasses() {
    return classes;
  }

}