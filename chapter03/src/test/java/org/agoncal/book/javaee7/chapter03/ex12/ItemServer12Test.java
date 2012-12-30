package org.agoncal.book.javaee7.chapter03.ex12;

import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.text.ParseException;
import java.util.Iterator;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class ItemServer12Test {

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

  // ======================================
  // =              Methods               =
  // ======================================

  @Test
  public void shouldRaiseNoConstraintsViolation() {

    ItemServer12 itemServer = new ItemServer12("http://www.cdbookstore.com/book/123", "http://www.cdbookstore.com/book/1234", "ftp://www.cdbookstore.com:21");

    Set<ConstraintViolation<ItemServer12>> constraints = validator.validate(itemServer);
    assertEquals(0, constraints.size());
  }

  @Test
  public void shouldRaiseConstraintsViolationCauseInvalidResourceURL() {

    ItemServer12 itemServer = new ItemServer12("dummy", "http://www.cdbookstore.com/book/1234", "ftp://www.cdbookstore.com:21");

    Set<ConstraintViolation<ItemServer12>> constraints = validator.validate(itemServer);
    displayContraintViolations(constraints);
    assertEquals(1, constraints.size());
    assertEquals("dummy", constraints.iterator().next().getInvalidValue());
    assertEquals("Malformed URL", constraints.iterator().next().getMessage());
  }

  @Test
  public void shouldRaiseConstraintsViolationCauseInvalidItemURL() {

    ItemServer12 itemServer = new ItemServer12("http://www.cdbookstore.com/book/123", "dummy", "ftp://www.cdbookstore.com:21");

    Set<ConstraintViolation<ItemServer12>> constraints = validator.validate(itemServer);
    displayContraintViolations(constraints);
    assertEquals(1, constraints.size());
    assertEquals("dummy", constraints.iterator().next().getInvalidValue());
    assertEquals("Malformed URL", constraints.iterator().next().getMessage());
  }

  @Test
  public void shouldRaiseConstraintsViolationCauseInvalidFTPServerURL() {

    ItemServer12 itemServer = new ItemServer12("http://www.cdbookstore.com/book/123", "http://www.cdbookstore.com/book/1234", "dummy");

    Set<ConstraintViolation<ItemServer12>> constraints = validator.validate(itemServer);
    displayContraintViolations(constraints);
    assertEquals(1, constraints.size());
    assertEquals("dummy", constraints.iterator().next().getInvalidValue());
    assertEquals("Malformed URL", constraints.iterator().next().getMessage());
  }

  @Test
  public void shouldRaiseConstraintsViolationCauseInvalidURLs() {

    ItemServer12 itemServer = new ItemServer12("dummy1", "dummy2", "dummy3");

    Set<ConstraintViolation<ItemServer12>> constraints = validator.validate(itemServer);
    displayContraintViolations(constraints);
    assertEquals(3, constraints.size());
  }

  private void displayContraintViolations(Set<ConstraintViolation<ItemServer12>> constraintViolations) {
    for (ConstraintViolation constraintViolation : constraintViolations) {
      System.out.println("### " + constraintViolation.getRootBeanClass().getSimpleName() +
              "." + constraintViolation.getPropertyPath() + " - Invalid Value = " + constraintViolation.getInvalidValue() + " - Error Msg = " + constraintViolation.getMessage());

    }
  }
}