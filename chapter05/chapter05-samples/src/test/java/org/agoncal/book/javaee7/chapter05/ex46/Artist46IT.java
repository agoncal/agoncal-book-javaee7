package org.agoncal.book.javaee7.chapter05.ex46;

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
public class Artist46IT extends AbstractPersistentTest {

  // ======================================
  // =              Unit tests            =
  // ======================================

  @Test
  public void shouldCreateThreeCDsAndFourArtists() throws Exception {

    Artist46 ringo = new Artist46("Ringo", "Starr");
    Artist46 john = new Artist46("John", "Lenon");
    Artist46 franck = new Artist46("Franck", "Zappa");
    Artist46 jimi = new Artist46("Jimi", "Hendrix");

    CD46 zoot = new CD46("Zoot Allures", 12.5F, "Released in October 1976, it is mostly a studio album");
    CD46 sgtpepper = new CD46("Sergent Pepper", 28.5F, "Best Beatles Album");
    CD46 heyjoe = new CD46("Hey Joe", 32F, "Hendrix live with friends");

    ringo.appearsOn(sgtpepper);
    john.appearsOn(sgtpepper);
    john.appearsOn(heyjoe);
    franck.appearsOn(zoot);
    franck.appearsOn(heyjoe);
    jimi.appearsOn(heyjoe);
    jimi.appearsOn(sgtpepper);

    zoot.createdBy(franck);
    sgtpepper.createdBy(ringo);
    sgtpepper.createdBy(john);
    heyjoe.createdBy(jimi);

    tx.begin();
    em.persist(ringo);
    em.persist(john);
    em.persist(franck);
    em.persist(jimi);
    em.persist(zoot);
    em.persist(sgtpepper);
    em.persist(heyjoe);
    tx.commit();
    assertNotNull("Ringo ID should not be null", ringo.getId());
    assertNotNull("John ID should not be null", john.getId());
    assertNotNull("Franck ID should not be null", franck.getId());
    assertNotNull("Zoot ID should not be null", zoot.getId());
    assertNotNull("Sgt Pepper ID should not be null", sgtpepper.getId());
    assertNotNull("Hey Joe ID should not be null", heyjoe.getId());
  }
}