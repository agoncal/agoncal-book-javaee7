package org.agoncal.book.javaee7.chapter03.ex13;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.text.ParseException;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class ItemServerConnection13Test {

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

    ItemServerConnection13 itemServer = new ItemServerConnection13("http://www.cdbookstore.com/book/133", "http://www.cdbookstore.com/book/1334", "ftp://www.cdbookstore.com:21");

    Set<ConstraintViolation<ItemServerConnection13>> violations = validator.validate(itemServer);
    assertEquals(0, violations.size());
  }

  @Test
  public void shouldRaiseConstraintsViolationCauseInvalidResourceURL() {

    ItemServerConnection13 itemServer = new ItemServerConnection13("dummy", "http://www.cdbookstore.com/book/1334", "ftp://www.cdbookstore.com:21");

    Set<ConstraintViolation<ItemServerConnection13>> violations = validator.validate(itemServer);
    displayContraintViolations(violations);
    assertEquals(1, violations.size());
    assertEquals("dummy", violations.iterator().next().getInvalidValue());
    assertEquals("Malformed URL", violations.iterator().next().getMessage());
  }

  @Test
  public void shouldRaiseConstraintsViolationCauseInvalidProtocol() {

    ItemServerConnection13 itemServer = new ItemServerConnection13("http://www.cdbookstore.com/book/133", "ftp://www.cdbookstore.com/book/1334", "ftp://www.cdbookstore.com:21");

    Set<ConstraintViolation<ItemServerConnection13>> violations = validator.validate(itemServer);
    displayContraintViolations(violations);
    assertEquals(1, violations.size());
    assertEquals("ftp://www.cdbookstore.com/book/1334", violations.iterator().next().getInvalidValue());
    assertEquals("Invalid protocol", violations.iterator().next().getMessage());
  }

  @Test
  public void shouldRaiseConstraintsViolationCauseInvalidHost() {

    ItemServerConnection13 itemServer = new ItemServerConnection13("http://www.cdbookstore.com/book/133", "http://www.dummy.com/book/1334", "ftp://www.cdbookstore.com:21");

    Set<ConstraintViolation<ItemServerConnection13>> violations = validator.validate(itemServer);
    displayContraintViolations(violations);
    assertEquals(1, violations.size());
    assertEquals("http://www.dummy.com/book/1334", violations.iterator().next().getInvalidValue());
    assertEquals("Invalid host", violations.iterator().next().getMessage());
  }

  @Test
  public void shouldRaiseConstraintsViolationCauseInvalidPort() {

    ItemServerConnection13 itemServer = new ItemServerConnection13("http://www.cdbookstore.com/book/133", "http://www.cdbookstore.com/book/1334", "ftp://www.cdbookstore.com:22");

    Set<ConstraintViolation<ItemServerConnection13>> violations = validator.validate(itemServer);
    displayContraintViolations(violations);
    assertEquals(1, violations.size());
    assertEquals("ftp://www.cdbookstore.com:22", violations.iterator().next().getInvalidValue());
    assertEquals("Invalid port", violations.iterator().next().getMessage());
  }

  private void displayContraintViolations(Set<ConstraintViolation<ItemServerConnection13>> constraintViolations) {
    for (ConstraintViolation constraintViolation : constraintViolations) {
      System.out.println("### " + constraintViolation.getRootBeanClass().getSimpleName() +
              "." + constraintViolation.getPropertyPath() + " - Invalid Value = " + constraintViolation.getInvalidValue() + " - Error Msg = " + constraintViolation.getMessage());

    }
  }
}