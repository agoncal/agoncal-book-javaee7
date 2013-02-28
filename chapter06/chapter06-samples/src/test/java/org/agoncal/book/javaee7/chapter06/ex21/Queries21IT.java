package org.agoncal.book.javaee7.chapter06.ex21;

import org.agoncal.book.javaee7.chapter06.AbstractPersistentTest;
import org.junit.Test;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class Queries21IT extends AbstractPersistentTest {

  // ======================================
  // =              Constants             =
  // ======================================

  private static final int ALL = 6;

  // ======================================
  // =              Unit tests            =
  // ======================================

  @Test
  public void shouldFindAllWithADynamicQuery() throws Exception {

    Customer21 customer01 = new Customer21("Antony", "Balla", "tballa@mail.com", 14);
    Address21 address01 = new Address21("Procession St", "Paris", "75015", "FR");
    customer01.setAddress(address01);

    Customer21 customer02 = new Customer21("Vincent", "Johnson", "vj@mail.com", 45);
    Address21 address02 = new Address21("Ritherdon Rd", "London", "8QE", "UK");
    customer02.setAddress(address02);

    Customer21 customer03 = new Customer21("Sebastian", "Twenty", "seb@yamail.com", 58);
    Address21 address03 = new Address21("Inacio Alfama", "Lisbon", "A54", "PT");
    customer03.setAddress(address03);

    Customer21 customer04 = new Customer21("Frederic", "Riou", "fred@carmail.com", 41);
    Address21 address04 = new Address21("Jardins", "Sao Paulo", "345678", "BR");
    customer04.setAddress(address04);

    Customer21 customer05 = new Customer21("Vincent", "Dubosc", "vd@yahoo.com", 14);
    Address21 address05 = new Address21("Coffey", "Perth", "654F543", "AU");
    customer05.setAddress(address05);

    Customer21 customer06 = new Customer21("David", "Chene", "dch@yahoo.com", 89);
    Address21 address06 = new Address21("Harbour Bridge", "Sydney", "JHG3", "AU");
    customer06.setAddress(address06);

    // Persist the object
    tx.begin();
    em.persist(customer01);
    em.persist(customer02);
    em.persist(customer03);
    em.persist(customer04);
    em.persist(customer05);
    em.persist(customer06);
    tx.commit();

    // Query
    Query query = em.createQuery("select c from Customer21 c");
    List<Customer21> customers = query.getResultList();
    assertEquals(ALL, customers.size());

    query = em.createQuery("select c from Customer21 c");
    query.setMaxResults(3);
    assertEquals(3, query.getResultList().size());

    boolean someCriteria = true;
    String jpqlQuery = "select c from Customer21 c";
    if (someCriteria)
      jpqlQuery += " where c.firstName = 'Vincent'";
    query = em.createQuery(jpqlQuery);
    assertEquals(2, query.getResultList().size());

    jpqlQuery = "select c from Customer21 c";
    if (someCriteria)
      jpqlQuery += " where c.firstName = :fname";
    query = em.createQuery(jpqlQuery);
    query.setParameter("fname", "Vincent");
    assertEquals(2, query.getResultList().size());

    jpqlQuery = "select c from Customer21 c";
    if (someCriteria)
      jpqlQuery += " where c.firstName = ?1";
    query = em.createQuery(jpqlQuery);
    query.setParameter(1, "Vincent");
    assertEquals(2, query.getResultList().size());

    query = em.createQuery("select c from Customer21 c  where c.firstName = :fname");
    query.setParameter("fname", "Vincent");
    query.setMaxResults(1);
    assertEquals(1, query.getResultList().size());

    query = em.createQuery("select c from Customer21 c  where c.firstName = :fname").setParameter("fname", "Vincent").setMaxResults(1);
    assertEquals(1, query.getResultList().size());

    // TypedQuery
    TypedQuery<Customer21> typedQuery = em.createQuery("select c from Customer21 c", Customer21.class);
    customers = typedQuery.getResultList();
    assertEquals(ALL, customers.size());

    typedQuery = em.createQuery("select c from Customer21 c", Customer21.class);
    typedQuery.setMaxResults(3);
    assertEquals(3, typedQuery.getResultList().size());

    jpqlQuery = "select c from Customer21 c";
    if (someCriteria)
      jpqlQuery += " where c.firstName = 'Vincent'";
    typedQuery = em.createQuery(jpqlQuery, Customer21.class);
    assertEquals(2, typedQuery.getResultList().size());

    jpqlQuery = "select c from Customer21 c";
    if (someCriteria)
      jpqlQuery += " where c.firstName = :fname";
    typedQuery = em.createQuery(jpqlQuery, Customer21.class);
    typedQuery.setParameter("fname", "Vincent");
    assertEquals(2, typedQuery.getResultList().size());

    jpqlQuery = "select c from Customer21 c";
    if (someCriteria)
      jpqlQuery += " where c.firstName = ?1";
    typedQuery = em.createQuery(jpqlQuery, Customer21.class);
    typedQuery.setParameter(1, "Vincent");
    assertEquals(2, typedQuery.getResultList().size());

    typedQuery = em.createQuery("select c from Customer21 c  where c.firstName = :fname", Customer21.class);
    typedQuery.setParameter("fname", "Vincent");
    typedQuery.setMaxResults(1);
    assertEquals(1, typedQuery.getResultList().size());

    typedQuery = em.createQuery("select c from Customer21 c  where c.firstName = :fname", Customer21.class).setParameter("fname", "Vincent").setMaxResults(1);
    assertEquals(1, typedQuery.getResultList().size());

    // Remove objects
    tx.begin();
    em.remove(customer01);
    em.remove(customer02);
    em.remove(customer03);
    em.remove(customer04);
    em.remove(customer05);
    em.remove(customer06);
    tx.commit();

  }

  @Test
  public void shouldFindAllWithANamedQueries() throws Exception {

    Customer21 customer01 = new Customer21("Antony", "Balla", "tballa@mail.com", 14);
    Address21 address01 = new Address21("Procession St", "Paris", "75015", "FR");
    customer01.setAddress(address01);

    Customer21 customer02 = new Customer21("Vincent", "Johnson", "vj@mail.com", 45);
    Address21 address02 = new Address21("Ritherdon Rd", "London", "8QE", "UK");
    customer02.setAddress(address02);

    Customer21 customer03 = new Customer21("Sebastian", "Twenty", "seb@yamail.com", 58);
    Address21 address03 = new Address21("Inacio Alfama", "Lisbon", "A54", "PT");
    customer03.setAddress(address03);

    Customer21 customer04 = new Customer21("Frederic", "Riou", "fred@carmail.com", 41);
    Address21 address04 = new Address21("Jardins", "Sao Paulo", "345678", "BR");
    customer04.setAddress(address04);

    Customer21 customer05 = new Customer21("Vincent", "Dubosc", "vd@yahoo.com", 14);
    Address21 address05 = new Address21("Coffey", "Perth", "654F543", "AU");
    customer05.setAddress(address05);

    Customer21 customer06 = new Customer21("David", "Chene", "dch@yahoo.com", 89);
    Address21 address06 = new Address21("Harbour Bridge", "Sydney", "JHG3", "AU");
    customer06.setAddress(address06);

    // Persist the object
    tx.begin();
    em.persist(customer01);
    em.persist(customer02);
    em.persist(customer03);
    em.persist(customer04);
    em.persist(customer05);
    em.persist(customer06);
    tx.commit();

    // Query
    Query query = em.createNamedQuery("findAll");
    List<Customer21> customers = query.getResultList();
    assertEquals(ALL, customers.size());

    query = em.createNamedQuery(Customer21.FIND_ALL);
    assertEquals(ALL, query.getResultList().size());

    query = em.createNamedQuery("findAll");
    query.setMaxResults(3);
    assertEquals(3, query.getResultList().size());

    query = em.createNamedQuery("findVincent");
    assertEquals(2, query.getResultList().size());

    query = em.createNamedQuery("findWithParam");
    query.setParameter("fname", "Vincent");
    assertEquals(2, query.getResultList().size());

    // TypedQuery
    TypedQuery<Customer21> typedQuery = em.createNamedQuery("findAll", Customer21.class);
    customers = typedQuery.getResultList();
    assertEquals(ALL, customers.size());

    typedQuery = em.createNamedQuery(Customer21.FIND_ALL, Customer21.class);
    assertEquals(ALL, typedQuery.getResultList().size());

    typedQuery = em.createNamedQuery("findAll", Customer21.class);
    typedQuery.setMaxResults(3);
    assertEquals(3, typedQuery.getResultList().size());

    typedQuery = em.createNamedQuery("findVincent", Customer21.class);
    assertEquals(2, typedQuery.getResultList().size());

    typedQuery = em.createNamedQuery("findWithParam", Customer21.class);
    typedQuery.setParameter("fname", "Vincent");
    assertEquals(2, typedQuery.getResultList().size());

    // Remove objects
    tx.begin();
    em.remove(customer01);
    em.remove(customer02);
    em.remove(customer03);
    em.remove(customer04);
    em.remove(customer05);
    em.remove(customer06);
    tx.commit();
  }

  @Test
  public void shouldFindAllWithANativeQueries() throws Exception {

    Customer21 customer01 = new Customer21("Antony", "Balla", "tballa@mail.com", 14);
    Address21 address01 = new Address21("Procession St", "Paris", "75015", "FR");
    customer01.setAddress(address01);

    Customer21 customer02 = new Customer21("Vincent", "Johnson", "vj@mail.com", 45);
    Address21 address02 = new Address21("Ritherdon Rd", "London", "8QE", "UK");
    customer02.setAddress(address02);

    Customer21 customer03 = new Customer21("Sebastian", "Twenty", "seb@yamail.com", 58);
    Address21 address03 = new Address21("Inacio Alfama", "Lisbon", "A54", "PT");
    customer03.setAddress(address03);

    Customer21 customer04 = new Customer21("Frederic", "Riou", "fred@carmail.com", 41);
    Address21 address04 = new Address21("Jardins", "Sao Paulo", "345678", "BR");
    customer04.setAddress(address04);

    Customer21 customer05 = new Customer21("Vincent", "Dubosc", "vd@yahoo.com", 14);
    Address21 address05 = new Address21("Coffey", "Perth", "654F543", "AU");
    customer05.setAddress(address05);

    Customer21 customer06 = new Customer21("David", "Chene", "dch@yahoo.com", 89);
    Address21 address06 = new Address21("Harbour Bridge", "Sydney", "JHG3", "AU");
    customer06.setAddress(address06);

    // Persist the object
    tx.begin();
    em.persist(customer01);
    em.persist(customer02);
    em.persist(customer03);
    em.persist(customer04);
    em.persist(customer05);
    em.persist(customer06);
    tx.commit();

    // Query
    Query query = em.createNativeQuery("select * from EX21_CUSTOMER", Customer21.class);
    List<Customer21> customers = query.getResultList();
    assertEquals(ALL, customers.size());

//        query = em.createNativeQuery("findAllNative");
//        customers = query.getResultList();
//        assertEquals(ALL, customers.size());
//
//        query = em.createNativeQuery("select lastname from JPQL_EX01_CUSTOMER", String.class);
//        List<String> customersNames = query.getResultList();
//        assertEquals(ALL, customersNames.size());

    // Remove objects
    tx.begin();
    em.remove(customer01);
    em.remove(customer02);
    em.remove(customer03);
    em.remove(customer04);
    em.remove(customer05);
    em.remove(customer06);
    tx.commit();
  }

  @Test
  public void shouldExecuteSeveralDynamicQueries() throws Exception {

    Customer21 customer01 = new Customer21("Antony", "Balla", "tballa@mail.com", 14);
    Address21 address01 = new Address21("Procession St", "Paris", "75015", "FR");
    customer01.setAddress(address01);

    Customer21 customer02 = new Customer21("Vincent", "Johnson", "vj@mail.com", 45);
    Address21 address02 = new Address21("Ritherdon Rd", "London", "8QE", "UK");
    customer02.setAddress(address02);

    Customer21 customer03 = new Customer21("Sebastian", "Twenty", "seb@yamail.com", 58);
    Address21 address03 = new Address21("Inacio Alfama", "Lisbon", "A54", "PT");
    customer03.setAddress(address03);

    Customer21 customer04 = new Customer21("Frederic", "Riou", "fred@carmail.com", 41);
    Address21 address04 = new Address21("Jardins", "Sao Paulo", "345678", "BR");
    customer04.setAddress(address04);

    Customer21 customer05 = new Customer21("Vincent", "Dubosc", "vd@yahoo.com", 14);
    Address21 address05 = new Address21("Coffey", "Perth", "654F543", "AU");
    customer05.setAddress(address05);

    Customer21 customer06 = new Customer21("David", "Chene", "dch@yahoo.com", 89);
    Address21 address06 = new Address21("Harbour Bridge", "Sydney", "JHG3", "AU");
    customer06.setAddress(address06);

    // Persist the object
    tx.begin();
    em.persist(customer01);
    em.persist(customer02);
    em.persist(customer03);
    em.persist(customer04);
    em.persist(customer05);
    em.persist(customer06);
    tx.commit();

    Query query = em.createQuery("select c from Customer21 c");
    assertEquals(ALL, query.getResultList().size());

    query = em.createQuery("select c.firstName from Customer21 c");
    assertEquals(ALL, query.getResultList().size());

    query = em.createQuery("select LOWER(c.firstName) from Customer21 c");
    assertEquals(ALL, query.getResultList().size());

    query = em.createQuery("select c.firstName, c.lastName  from Customer21 c");
    assertEquals(ALL, query.getResultList().size());

    query = em.createQuery("select distinct c.firstName from Customer21 c");
    assertEquals(ALL - 1, query.getResultList().size());

    query = em.createQuery("select c from Customer21 c where c.firstName = 'Vincent'");
    assertEquals(2, query.getResultList().size());

    query = em.createQuery("select c.address from Customer21 c where c.firstName = 'Vincent'");
    assertEquals(2, query.getResultList().size());

    query = em.createQuery("select c from Customer21 c where c.address.country = 'AU'");
    assertEquals(2, query.getResultList().size());

    query = em.createQuery("select new org.agoncal.book.javaee7.chapter06.ex21.CustomerDTO21(c.firstName, c.lastName, c.address.country) from Customer21 c where c.firstName = 'Vincent'");
    assertEquals(2, query.getResultList().size());

    query = em.createQuery("select count(c) from Customer21 c where c.firstName = 'Vincent'");
    assertEquals(2L, query.getSingleResult());

    query = em.createQuery("select c from Customer21 c where c.age > 40");
    assertEquals(4, query.getResultList().size());

    query = em.createQuery("select c from Customer21 c where c.age between 40 and 50");
    assertEquals(2, query.getResultList().size());

    query = em.createQuery("select c from Customer21 c where c.age not between 40 and 50");
    assertEquals(4, query.getResultList().size());

    query = em.createQuery("select c from Customer21 c where c.address.country in ('UK', 'FR')");
    assertEquals(2, query.getResultList().size());

    query = em.createQuery("select c from Customer21 c where c.email like '%mail.com'");
    assertEquals(4, query.getResultList().size());

    query = em.createQuery("select min(c.age) from Customer21 c");
    assertEquals(14, query.getSingleResult());

    query = em.createQuery("select c.address.country, count(c) from Customer21 c group by c.address.country");
    assertEquals(5, query.getResultList().size());

    query = em.createQuery("select c.address.country, count(c) from Customer21 c group by c.address.country having c.address.country <> 'UK'");
    assertEquals(4, query.getResultList().size());

    query = em.createQuery("select c from Customer21 c where c.age = (select min(cust.age) from Customer21 cust)");
    assertEquals(2, query.getResultList().size());

    tx.begin();
    query = em.createQuery("update Customer21 c set c.firstName = 'TOO YOUNG' where c.age < 18");
    assertEquals(2, query.executeUpdate());
    tx.commit();

    tx.begin();
    query = em.createQuery("delete from Customer21 c where c.age < 18");
    assertEquals(2, query.executeUpdate());
    tx.commit();

    // Remove objects
    tx.begin();
    em.remove(customer01);
    em.remove(customer02);
    em.remove(customer03);
    em.remove(customer04);
    em.remove(customer05);
    em.remove(customer06);
    tx.commit();
  }

  @Test
  public void shouldExecuteCaseQueries() throws Exception {

    Book21 book01 = new Book21("The Hitchhiker's Guide to the Galaxy", 12F, "The Hitchhiker's Guide to the Galaxy is a science fiction comedy series created by Douglas Adams.", "1-84023-742-2", 354, false, "Apress");
    Book21 book02 = new Book21("Java EE 6", 50F, "Learn about EE 6", "2-84023-742-2", 450, true, "Apress");
    Book21 book03 = new Book21("Narcisse and Golmund", 10F, "One of the best Herman Hesse book", "3-84023-742-2", 153, false, "Pinguin");

    // Persist the object
    tx.begin();
    em.persist(book01);
    em.persist(book02);
    em.persist(book03);
    tx.commit();

    Query query = em.createQuery("select b.price from Book21 b order by b.isbn");
    List<Float> prices = query.getResultList();
    assertEquals(3, prices.size());
    assertEquals(new Float(12F), prices.get(0));
    assertEquals(new Float(50F), prices.get(1));
    assertEquals(new Float(10F), prices.get(2));

    query = em.createQuery("SELECT CASE WHEN b.editor ='Apress' THEN b.price * 0.5 ELSE b.price * 0.8 END FROM Book21 b ORDER BY b.isbn ASC");
    prices = query.getResultList();
    assertEquals(3, prices.size());
    assertEquals("12 * 0.5 = 6", new Double(6), prices.get(0));
    assertEquals("50 * 0.5 = 25", new Double(25), prices.get(1));
    assertEquals("10 * 0.8 = 8", new Double(8), prices.get(2));

    // Remove objects
    tx.begin();
    em.remove(book01);
    em.remove(book02);
    em.remove(book03);
    tx.commit();
  }
}

