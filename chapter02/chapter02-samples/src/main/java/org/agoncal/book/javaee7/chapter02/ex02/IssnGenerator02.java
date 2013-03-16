package org.agoncal.book.javaee7.chapter02.ex02;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.Random;
import java.util.logging.Logger;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class IssnGenerator02 implements NumberGenerator02 {

  public String generateNumber() {
    return "8-" + Math.abs(new Random().nextInt());
  }
}