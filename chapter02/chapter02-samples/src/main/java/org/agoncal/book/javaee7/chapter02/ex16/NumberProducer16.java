package org.agoncal.book.javaee7.chapter02.ex16;

import javax.enterprise.inject.Produces;
import java.util.Random;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class NumberProducer16 {

  @Produces
  @ThirteenDigits16
  private String prefix13digits = "13-";

  @Produces
  @ThirteenDigits16
  private int editorNumber = 84356;

  @Produces
  @EightDigits16
  private String prefix8digits = "8-";

  @Produces
  @Random16
  public double random() {
    return Math.abs(new Random().nextInt());
  }
}
