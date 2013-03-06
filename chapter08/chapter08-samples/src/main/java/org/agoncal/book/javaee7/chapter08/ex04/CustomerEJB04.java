package org.agoncal.book.javaee7.chapter08.ex04;

import javax.annotation.Resource;
import javax.ejb.*;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Stateless
public class CustomerEJB04 {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Resource
  TimerService timerService;

  @PersistenceContext(unitName = "chapter08PU")
  private EntityManager em;

  // ======================================
  // =           Public Methods           =
  // ======================================

  public void createCustomer(Customer04 customer) {
    em.persist(customer);
    ScheduleExpression birthDay = new ScheduleExpression().dayOfMonth(customer.getBirthDay()).month(customer.getBirthMonth());
    timerService.createCalendarTimer(birthDay, new TimerConfig(customer, true));
  }

  @Timeout
  public void sendBirthdayEmail(Timer timer) {
    Customer04 customer = (Customer04) timer.getInfo();
    // ...
  }
}