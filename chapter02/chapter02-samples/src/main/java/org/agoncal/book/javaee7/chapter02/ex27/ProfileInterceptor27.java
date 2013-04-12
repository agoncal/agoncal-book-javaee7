package org.agoncal.book.javaee7.chapter02.ex27;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import java.util.logging.Logger;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class ProfileInterceptor27 {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Inject
  private Logger logger;

  // ======================================
  // =          Lifecycle methods         =
  // ======================================

  @PostConstruct
  public void logMethod(InvocationContext ic) throws Exception {
    logger.fine(ic.getTarget().toString());
    logger.severe(">>>" + ic.getTarget().toString());
    try {
      ic.proceed();
    } finally {
      logger.severe("<<<" + ic.getTarget().toString());
      logger.fine(ic.getTarget().toString());
    }
  }

  // ======================================
  // =           Public Methods           =
  // ======================================

  @AroundInvoke
  public Object profile(InvocationContext ic) throws Exception {
    long initTime = System.currentTimeMillis();
    try {
      return ic.proceed();
    } finally {
      long diffTime = System.currentTimeMillis() - initTime;
      logger.severe("###" + ic.getMethod() + " took " + diffTime + " millis");
      logger.fine(ic.getMethod() + " took " + diffTime + " millis");
    }
  }
}
