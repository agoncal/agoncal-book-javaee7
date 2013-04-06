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
    public String prefix13digits() {
        return "13-";
    }

    @Produces
    @EightDigits16
    public String prefix8digits() {
        return "8-";
    }

    @Produces
    @Random16
    public Double random() {
        return Double.valueOf(Math.abs(new Random().nextInt()));
    }
}
