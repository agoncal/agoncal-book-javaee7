package org.agoncal.book.javaee7.chapter02.ex29;

import javax.inject.Inject;
import javax.interceptor.Interceptors;
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
@Loggable29
public class CustomerService29 {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Inject
  private EntityManager em;

  // ======================================
  // =           Public Methods           =
  // ======================================

  public void createCustomer(Customer29 customer) {
    em.persist(customer);
  }

  public Customer29 findCustomerById(Long id) {
    return em.find(Customer29.class, id);
  }
}