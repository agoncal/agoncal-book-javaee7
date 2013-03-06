package org.agoncal.book.javaee7.chapter07.ex15;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class OrderEJB15IT {

  // ======================================
  // =             Attributes             =
  // ======================================

  private static EJBContainer ec;
  private static Context ctx;
  private static OrderEJB15 orderEJB;

  // ======================================
  // =          Lifecycle Methods         =
  // ======================================

  @BeforeClass
  public static void initContainer() throws Exception {
    Map<String, Object> properties = new HashMap<>();
    properties.put(EJBContainer.MODULES, new File("target/classes"));
    ec = EJBContainer.createEJBContainer(properties);
    ctx = ec.getContext();

    // Check JNDI dependencies
    assertNotNull(ctx.lookup("java:global/classes/OrderEJB15!org.agoncal.book.javaee7.chapter07.ex15.OrderEJB15"));
    assertNotNull(ctx.lookup("java:global/classes/OrderEJB15"));

    // Looks up the EJB
    orderEJB = (OrderEJB15) ctx.lookup("java:global/classes/OrderEJB15");

  }

  @AfterClass
  public static void closeContainer() throws Exception {
    if (ctx != null)
      ctx.close();
    if (ec != null)
      ec.close();
  }

  // ======================================
  // =              Unit tests            =
  // ======================================

  /**
   * Without the @Asynchronous annotation on the EJB, this tes would timeout and fail
   */
  @Test(timeout = 500)
  public void shouldSendEmailOrderCompleteAsynchronously() throws Exception {
    orderEJB.sendEmailOrderComplete(new Order15(), new Customer15());
  }

  /**
   * Without the @Asynchronous annotation on the EJB, this tes would timeout and fail
   */
  @Test(timeout = 500)
  public void shouldPrintOrderAsynchronously() throws Exception {
    orderEJB.printOrder(new Order15());
  }

  @Test
  public void shouldSendOrderToWorkflow() throws ExecutionException, InterruptedException {
    // when
    Future<Integer> status = orderEJB.sendOrderToWorkflow(new Order15());

    // then
    assertEquals((Object) 1, status.get());
  }
}