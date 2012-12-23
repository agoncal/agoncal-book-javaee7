package org.agoncal.book.javaee7.chapter03.ex02;

import org.agoncal.book.javaee7.chapter03.ex01.Book01;
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

  // ======================================
  // =              Methods               =
  // ======================================

  @Test
  public void shouldRaiseNoConstraintViolation() {

    // Creates a book
    Book01 book = new Book01("H2G2", 12.5f, "Best IT Scifi Book", "1234-4566-9876", 247, false);

    // Validate the cd
    Set<ConstraintViolation<Book01>> constraints = validator.validate(book);
    assertEquals(0, constraints.size());
  }

  @Test
  public void shouldRaiseConstraintViolationCausePriceLow() {

    // Creates a book
    Book01 book = new Book01("H2G2", 0.5f, "Best IT Scifi Book", "1234-4566-9876", 247, false);

    // Validate the cd
    Set<ConstraintViolation<Book01>> constraints = validator.validate(book);
    displayContraintViolations(constraints);
    assertEquals(1, constraints.size());
  }

  @Test
  public void shouldRaiseConstraintsViolationCauseTitleAndPriceNull() {

    // Creates a book
    Book01 book = new Book01();

    // Validate the cd
    Set<ConstraintViolation<Book01>> constraints = validator.validate(book);
    displayContraintViolations(constraints);
    assertEquals(2, constraints.size());
  }

  private void displayContraintViolations(Set<ConstraintViolation<Book01>> constraintViolations) {
    for (ConstraintViolation constraintViolation : constraintViolations) {
      System.out.println("### " + constraintViolation.getRootBeanClass().getSimpleName() +
              "." + constraintViolation.getPropertyPath() + " - Invalid Value = " + constraintViolation.getInvalidValue() + " - Error Msg = " + constraintViolation.getMessage());

    }
  }
}