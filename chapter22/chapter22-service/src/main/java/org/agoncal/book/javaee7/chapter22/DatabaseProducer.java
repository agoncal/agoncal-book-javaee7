package org.agoncal.book.javaee7.chapter22;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Antonio Goncalves
 *         http://www.antoniogoncalves.org
 *         --
 */

public class DatabaseProducer {

    // ======================================
    // =             Attributes             =
    // ======================================

    @Produces
    @PersistenceContext(unitName = "chapter22PU")
    private EntityManager em;
}
