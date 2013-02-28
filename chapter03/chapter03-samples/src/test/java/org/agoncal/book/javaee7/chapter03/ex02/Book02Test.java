package org.agoncal.book.javaee7.chapter03.ex02;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class Book02Test {

  // ======================================
  // =             Attributes             =
  // ======================================

  protected static ValidatorFactory vf;
  protected static Validator validator;

  // ======================================
  // =          Lifecycle Methods         =
  // ======================================

  @BeforeClass
  public static void init() {
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
  public void shouldRaiseNoConstraintViolation() {

    Book02 book = new Book02("H2G2", 12.5f, "Best IT Scifi Book", "1234-4566-9876", 247, false);

    Set<ConstraintViolation<Book02>> constraints = validator.validate(book);
    assertEquals(0, constraints.size());
  }

  @Test
  public void shouldRaiseConstraintViolationCausePriceLow() {

    Book02 book = new Book02("H2G2", 0.5f, "Best IT Scifi Book", "1234-4566-9876", 247, false);

    Set<ConstraintViolation<Book02>> constraints = validator.validate(book);
    displayContraintViolations(constraints);
    assertEquals(1, constraints.size());
  }

  @Test
  public void shouldRaiseConstraintsViolationCauseTitleAndPriceNull() {

    Book02 book = new Book02();

    Set<ConstraintViolation<Book02>> constraints = validator.validate(book);
    displayContraintViolations(constraints);
    assertEquals(2, constraints.size());
  }

  private void displayContraintViolations(Set<ConstraintViolation<Book02>> constraintViolations) {
    for (ConstraintViolation constraintViolation : constraintViolations) {
      System.out.println("### " + constraintViolation.getRootBeanClass().getSimpleName() +
              "." + constraintViolation.getPropertyPath() + " - Invalid Value = " + constraintViolation.getInvalidValue() + " - Error Msg = " + constraintViolation.getMessage());

    }
  }
}