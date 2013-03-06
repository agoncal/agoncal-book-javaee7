package org.agoncal.book.javaee7.chapter08.ex03;

import javax.ejb.Schedule;
import javax.ejb.Schedules;
import javax.ejb.Stateless;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Stateless
public class StatisticsEJB03 {

  // ======================================
  // =           Public Methods           =
  // ======================================

  @Schedule(dayOfMonth = "1", hour = "5", minute = "30")
  public void statisticsItemsSold() {
    // ...
  }

  @Schedules({
          @Schedule(hour = "2"),
          @Schedule(hour = "14", dayOfWeek = "Wed")
  })
  public void generateReport() {
    // ...
  }

  @Schedule(minute = "*/10", hour = "*", persistent = false)
  public void refreshCache() {
    // ...
  }
}