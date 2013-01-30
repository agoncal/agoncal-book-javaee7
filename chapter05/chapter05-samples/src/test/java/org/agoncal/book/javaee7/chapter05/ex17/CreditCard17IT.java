package org.agoncal.book.javaee7.chapter05.ex17;

import org.agoncal.book.javaee7.chapter05.AbstractPersistentTest;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class CreditCard17IT extends AbstractPersistentTest {

  // ======================================
  // =              Unit tests            =
  // ======================================
  @Test
  public void shouldCreateACreditCard() throws Exception {

    CreditCard17 creditCard = new CreditCard17("123412341234", "12/12", 1253, CreditCardType17.AMERICAN_EXPRESS);
    tx.begin();
    em.persist(creditCard);
    tx.commit();
    assertNotNull("ID should not be null", creditCard.getNumber());
  }
}