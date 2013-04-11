package org.agoncal.book.javaee7.chapter02.ex27;

import javax.annotation.PostConstruct;
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
@Interceptors(ProfileInterceptor27.class)
public class CustomerService27 {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Inject
  private EntityManager em;

  // ======================================
  // =          Lifecycle methods         =
  // ======================================

  @PostConstruct
  public void init() {
    // ...
  }

  // ======================================
  // =           Public Methods           =
  // ======================================

  public void createCustomer(Customer27 customer) {
    em.persist(customer);
  }

  public Customer27 findCustomerById(Long id) {
    return em.find(Customer27.class, id);
  }
}