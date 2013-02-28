package org.agoncal.book.javaee7.chapter09;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */

public class DatabaseProducer {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Produces
  @PersistenceContext(unitName = "chapter09PU")
  private EntityManager em;
}
