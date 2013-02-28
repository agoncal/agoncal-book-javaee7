package org.agoncal.book.javaee7.chapter03.ex12;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.*;
import java.text.ParseException;
import java.util.Date;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class ItemServerConnection12Test {

  // ======================================
  // =             Attributes             =
  // ======================================

  protected static ValidatorFactory vf;
  protected static Validator validator;


  // ======================================
  // =          Lifecycle Methods         =
  // ======================================

  @BeforeClass
  public static void init() throws ParseException {
    vf = Validation.buildDefaultValidatorFactory();
    validator = vf.getValidator();
  }

  @AfterClass
  public static void close() {
    vf.close();
  }

  // ======================================
  // =              Methods               =
  // ======================================

  @Test
  public void shouldRaiseNoConstraintsViolation() {

    ItemServerConnection12 itemServer = new ItemServerConnection12("http://www.cdbookstore.com/book/123", "http://www.cdbookstore.com/book/1234", "ftp://www.cdbookstore.com:21");

    Set<ConstraintViolation<ItemServerConnection12>> constraints = validator.validate(itemServer);
    assertEquals(0, constraints.size());
  }

  @Test
  public void shouldRaiseConstraintsViolationCauseInvalidResourceURL() {

    ItemServerConnection12 itemServer = new ItemServerConnection12("dummy", "http://www.cdbookstore.com/book/1234", "ftp://www.cdbookstore.com:21");

    Set<ConstraintViolation<ItemServerConnection12>> constraints = validator.validate(itemServer);
    displayContraintViolations(constraints);
    assertEquals(1, constraints.size());
    assertEquals("dummy", constraints.iterator().next().getInvalidValue());
    assertEquals("Malformed URL", constraints.iterator().next().getMessage());
  }

  @Test
  public void shouldRaiseConstraintsViolationCauseInvalidItemURL() {

    ItemServerConnection12 itemServer = new ItemServerConnection12("http://www.cdbookstore.com/book/123", "dummy", "ftp://www.cdbookstore.com:21");

    Set<ConstraintViolation<ItemServerConnection12>> constraints = validator.validate(itemServer);
    displayContraintViolations(constraints);
    assertEquals(1, constraints.size());
    assertEquals("dummy", constraints.iterator().next().getInvalidValue());
    assertEquals("Malformed URL", constraints.iterator().next().getMessage());
  }

  @Test
  public void shouldRaiseConstraintsViolationCauseInvalidFTPServerURL() {

    ItemServerConnection12 itemServer = new ItemServerConnection12("http://www.cdbookstore.com/book/123", "http://www.cdbookstore.com/book/1234", "dummy");

    Set<ConstraintViolation<ItemServerConnection12>> constraints = validator.validate(itemServer);
    displayContraintViolations(constraints);
    assertEquals(1, constraints.size());
    assertEquals("dummy", constraints.iterator().next().getInvalidValue());
    assertEquals("Malformed URL", constraints.iterator().next().getMessage());
  }

  @Test
  public void shouldRaiseConstraintsViolationCauseInvalidURLs() {

    ItemServerConnection12 itemServer = new ItemServerConnection12("dummy1", "dummy2", "dummy3");

    Set<ConstraintViolation<ItemServerConnection12>> constraints = validator.validate(itemServer);
    displayContraintViolations(constraints);
    assertEquals(3, constraints.size());
  }

  @Test(expected = UnexpectedTypeException.class)
  public void shouldRaiseExceptionAsDateIsNotAURL() {

    ItemServerConnection12 itemServer = new ItemServerConnection12("http://www.cdbookstore.com/book/123", "http://www.cdbookstore.com/book/1234", "ftp://www.cdbookstore.com:21");
    itemServer.setLastConnectionDate(new Date());

    validator.validate(itemServer, Error.class);
  }

  private void displayContraintViolations(Set<ConstraintViolation<ItemServerConnection12>> constraintViolations) {
    for (ConstraintViolation constraintViolation : constraintViolations) {
      System.out.println("### " + constraintViolation.getRootBeanClass().getSimpleName() +
              "." + constraintViolation.getPropertyPath() + " - Invalid Value = " + constraintViolation.getInvalidValue() + " - Error Msg = " + constraintViolation.getMessage());

    }
  }
}