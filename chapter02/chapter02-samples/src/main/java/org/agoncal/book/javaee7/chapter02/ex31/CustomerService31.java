package org.agoncal.book.javaee7.chapter02.ex31;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Transactional
@Loggable31
public class CustomerService31 {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Inject
  private EntityManager em;

  // ======================================
  // =           Public Methods           =
  // ======================================

  @Auditable31
  public void createCustomer(Customer31 customer) {
    em.persist(customer);
  }

  public Customer31 findCustomerById(Long id) {
    return em.find(Customer31.class, id);
  }
}