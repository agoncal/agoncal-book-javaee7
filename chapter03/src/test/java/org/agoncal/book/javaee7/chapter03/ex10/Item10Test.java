package org.agoncal.book.javaee7.chapter03.ex10;

import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.*;
import java.lang.reflect.Method;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class Item10Test {

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
    Item10 book = new Item10("H2G2", 12.5f, "Best IT Scifi Book");

    // Validate the cd
    Set<ConstraintViolation<Item10>> constraints = validator.validate(book);
    assertEquals(0, constraints.size());
  }

  @Test
  public void shouldRaiseConstraintsViolation() {

    // Creates a book
    Item10 book = new Item10();

    // Validate the cd
    Set<ConstraintViolation<Item10>> constraints = validator.validate(book);
    displayContraintViolations(constraints);
    assertEquals(1, constraints.size());
  }

  @Test
  public void shouldRaiseNoConstraintViolationOnCalculateVAT() throws NoSuchMethodException {

    Item10 item = new Item10("H2G2", 12.5f, "Best IT Scifi Book");

    MethodValidator methodValidator = validator.forMethods();
    Method method = Item10.class.getMethod("calculateVAT");
    Set<ConstraintViolation<Item10>> constraints = methodValidator.validateParameters(item, method, null);
    assertEquals(0, constraints.size());
  }

  @Test
  public void shouldRaiseNoConstraintViolationOnCalculatePrice() throws NoSuchMethodException {

    Item10 item = new Item10("H2G2", 12.5f, "Best IT Scifi Book");

    MethodValidator methodValidator = validator.forMethods();
    Method method = Item10.class.getMethod("calculatePrice", Float.class);
    Set<ConstraintViolation<Item10>> constraints = methodValidator.validateParameters(item, method, new Object[]{new Float(4.5)});
    assertEquals(0, constraints.size());
  }

  @Test
  public void shouldRaiseConstraintViolationOnCalculatePriceCauseRateIsTooLow() throws NoSuchMethodException {

    Item10 item = new Item10("H2G2", 12.5f, "Best IT Scifi Book");

    MethodValidator methodValidator = validator.forMethods();
    Method method = Item10.class.getMethod("calculatePrice", Float.class);
    Set<ConstraintViolation<Item10>> constraints = methodValidator.validateParameters(item, method, new Object[]{new Float(0.5)});
    displayContraintViolations(constraints);
    assertEquals(1, constraints.size());
  }

  private void displayContraintViolations(Set<ConstraintViolation<Item10>> constraintViolations) {
    for (ConstraintViolation constraintViolation : constraintViolations) {
      System.out.println("### " + constraintViolation.getRootBeanClass().getSimpleName() +
              "." + constraintViolation.getPropertyPath() + " - Invalid Value = " + constraintViolation.getInvalidValue() + " - Error Msg = " + constraintViolation.getMessage());

    }
  }
}