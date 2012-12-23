package org.agoncal.book.javaee7.chapter03.ex03;

import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.*;
import java.lang.reflect.Constructor;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * @author Antonio Goncalves
 */
public class Book03Test {

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
  public void shouldRaiseNoConstraintViolation() throws NoSuchMethodException {

    MethodValidator methodValidator = validator.forMethods();
    Constructor<Book03> constructor = Book03.class.getConstructor(String.class, Float.class, String.class, String.class, Integer.class, Boolean.class);
    Set<ConstraintViolation<Book03>> constraints = methodValidator.validateConstructorParameters(constructor, new Object[]{"H2G2", 12.5f, "Best IT Scifi Book", "1234-4566-9876", 247, false});
    assertEquals(0, constraints.size());
  }

  @Test
  public void shouldRaiseConstraintViolationCausePriceLow() throws NoSuchMethodException {

    MethodValidator methodValidator = validator.forMethods();
    Constructor<Book03> constructor = Book03.class.getConstructor(String.class, Float.class, String.class, String.class, Integer.class, Boolean.class);
    Set<ConstraintViolation<Book03>> constraints = methodValidator.validateConstructorParameters(constructor, new Object[]{"H2G2", 0.5f, "Best IT Scifi Book", "1234-4566-9876", 247, false});
    displayContraintViolations(constraints);
    assertEquals(1, constraints.size());
  }

  @Test
  public void shouldRaiseConstraintsViolationCauseTitleAndPriceNull() throws NoSuchMethodException {

    MethodValidator methodValidator = validator.forMethods();
    Constructor<Book03> constructor = Book03.class.getConstructor(String.class, Float.class, String.class, String.class, Integer.class, Boolean.class);
    Set<ConstraintViolation<Book03>> constraints = methodValidator.validateConstructorParameters(constructor, new Object[]{null, null, null, null, null, null});
    displayContraintViolations(constraints);
    assertEquals(2, constraints.size());
  }

  private void displayContraintViolations(Set<ConstraintViolation<Book03>> constraintViolations) {
    for (ConstraintViolation constraintViolation : constraintViolations) {
      System.out.println("### " + constraintViolation.getRootBeanClass().getSimpleName() +
              "." + constraintViolation.getPropertyPath() + " - Invalid Value = " + constraintViolation.getInvalidValue() + " - Error Msg = " + constraintViolation.getMessage());

    }
  }
}