package org.agoncal.book.javaee7.chapter12;

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
public class DBProducer {

  @Produces
  @PersistenceContext(unitName = "chapter12PU")
  private EntityManager em;
}
