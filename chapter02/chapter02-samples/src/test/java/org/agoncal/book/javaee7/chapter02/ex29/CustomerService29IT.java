package org.agoncal.book.javaee7.chapter02.ex29;

import org.agoncal.book.javaee7.chapter02.ex29.Customer29;
import org.agoncal.book.javaee7.chapter02.ex29.CustomerService29;
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
public class CustomerService29IT {

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
    CustomerService29 customerService = container.instance().select(CustomerService29.class).get();
    customerService.createCustomer(new Customer29());
  }
}