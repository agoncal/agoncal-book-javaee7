package org.agoncal.book.javaee7.chapter02.ex33;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class CustomerService31IT {

  // ======================================
  // =             Attributes             =
  // ======================================

  protected static Weld weld;
  protected static WeldContainer container;

  // ======================================
  // =          Lifecycle Methods         =
  // ======================================

  @BeforeClass
  public static void init() {
    weld = new Weld();
    container = weld.initialize();
  }

  @AfterClass
  public static void close() {
    weld.shutdown();
  }

  // ======================================
  // =              Methods               =
  // ======================================

  @Test
  public void shouldSeeInterceptor() throws Exception {
    CustomerService33 customerService = container.instance().select(CustomerService33.class).get();
    customerService.createCustomer(new Customer33());
    customerService.findCustomerById(1L);
  }
}