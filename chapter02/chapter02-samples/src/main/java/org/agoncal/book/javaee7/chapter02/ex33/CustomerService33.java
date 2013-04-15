package org.agoncal.book.javaee7.chapter02.ex33;

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
@Loggable33
public class CustomerService33 {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Inject
  private EntityManager em;

  // ======================================
  // =           Public Methods           =
  // ======================================

  @Auditable33
  public void createCustomer(Customer33 customer) {
    em.persist(customer);
  }

  public Customer33 findCustomerById(Long id) {
    return em.find(Customer33.class, id);
  }
}