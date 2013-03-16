package org.agoncal.book.javaee7.chapter02;


import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.inject.Alternative;
import java.util.Random;
import java.util.logging.Logger;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Alternative @ThirteenDigits
public class MockGenerator implements NumberGenerator {

    // ======================================
    // =             Attributes             =
    // ======================================

    private Logger logger = Logger.getLogger(MockGenerator.class.getName());

    // ======================================
    // =          Lifecycle methods         =
    // ======================================

    @PostConstruct
    private void init() {
        logger.info("=> IsbnGenerator PostConstruct");
        logger.info("================");
    }

    @PreDestroy
    private void release() {
        logger.info("================");
        logger.info("=> IsbnGenerator PreDestroy");
    }

    // ======================================
    // =          Business methods          =
    // ======================================

    @Loggable
    public String generateNumber() {
        return "MOCK" + Math.abs(new Random().nextInt());
    }
}