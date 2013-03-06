package org.agoncal.book.javaee7.chapter07.ex15;

import javax.annotation.Resource;
import javax.ejb.AsyncResult;
import javax.ejb.Asynchronous;
import javax.ejb.SessionContext;
import javax.ejb.Stateless;
import java.util.concurrent.Future;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Stateless
public class OrderEJB15 {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Resource
  private SessionContext ctx;

  // ======================================
  // =           Public Methods           =
  // ======================================

  @Asynchronous
  public void sendEmailOrderComplete(Order15 order, Customer15 customer) {
    // Very Long task
    for (int i = 0; i < Integer.MAX_VALUE; i++) {
    }
  }

  @Asynchronous
  public void printOrder(Order15 order) {
    // Very Long task
    for (int i = 0; i < Integer.MAX_VALUE; i++) {
    }
  }

  @Asynchronous
  public Future<Integer> sendOrderToWorkflow(Order15 order) {
    Integer status = 0;
    // processing
    status = 1;
    if (ctx.wasCancelCalled()) {
      return new AsyncResult<>(2);
    }
    // processing
    return new AsyncResult<>(status);
  }
}