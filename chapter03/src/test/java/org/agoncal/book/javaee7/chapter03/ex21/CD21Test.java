package org.agoncal.book.javaee7.chapter03.ex21;

import org.junit.AfterClass;
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
public class CD21Test {

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

    CD21 cd = new CD21("Kind of Blue", 12.5f);

    Set<ConstraintViolation<CD21>> constraints = validator.validate(cd);
    assertEquals(0, constraints.size());
  }

  @Test
  public void shouldRaiseConstraintViolationCauseTitleAndPriceAreNull() {

    CD21 cd = new CD21();

    Set<ConstraintViolation<CD21>> constraints = validator.validate(cd);
    displayContraintViolations(constraints);
    assertEquals(2, constraints.size());
  }

  @Test
  public void shouldRaiseNoConstraintViolationValidatingNumberOfCDsProperty() {

    CD21 cd = new CD21();
    cd.setNumberOfCDs(2);

    Set<ConstraintViolation<CD21>> constraints = validator.validateProperty(cd, "numberOfCDs");
    assertEquals(0, constraints.size());
  }

  @Test
  public void shouldRaiseConstraintViolationValidatingNumberOfCDsProperty() {

    CD21 cd = new CD21();
    cd.setNumberOfCDs(7);

    Set<ConstraintViolation<CD21>> constraints = validator.validateProperty(cd, "numberOfCDs");
    displayContraintViolations(constraints);
    assertEquals(1, constraints.size());
  }

  @Test
  public void shouldRaiseNoConstraintViolationValidatingNumberOfCDsPropertyValue() {

    Set<ConstraintViolation<CD21>> constraints = validator.validateValue(CD21.class, "numberOfCDs", 2);
    displayContraintViolations(constraints);
    assertEquals(0, constraints.size());
  }

  @Test
  public void shouldRaiseConstraintViolationValidatingNumberOfCDsPropertyValue() {

    Set<ConstraintViolation<CD21>> constraints = validator.validateValue(CD21.class, "numberOfCDs", 7);
    displayContraintViolations(constraints);
    assertEquals(1, constraints.size());
  }

  @Test
  public void shouldRaiseNoMethodParameterConstraintViolation() throws NoSuchMethodException {

    CD21 cd = new CD21("Kind of Blue", 12.5f);

    MethodValidator methodValidator = validator.forMethods();
    Method method = CD21.class.getMethod("calculatePrice", Float.class);
    Set<ConstraintViolation<CD21>> constraints = methodValidator.validateParameters(cd, method, new Object[]{new Float(2.2)});
    assertEquals(0, constraints.size());
  }

  @Test
  public void shouldRaiseMethodParameterConstraintViolationCauseRateIsLow() throws NoSuchMethodException {

    CD21 cd = new CD21("Kind of Blue", 12.5f);

    MethodValidator methodValidator = validator.forMethods();
    Method method = CD21.class.getMethod("calculatePrice", Float.class);
    Set<ConstraintViolation<CD21>> constraints = methodValidator.validateParameters(cd, method, new Object[]{new Float(1.2)});
    displayContraintViolations(constraints);
    assertEquals(1, constraints.size());
  }

  private void displayContraintViolations(Set<ConstraintViolation<CD21>> constraintViolations) {
    for (ConstraintViolation constraintViolation : constraintViolations) {
      System.out.println("### " + constraintViolation.getRootBeanClass().getSimpleName() +
              "." + constraintViolation.getPropertyPath() + " - Invalid Value = " + constraintViolation.getInvalidValue() + " - Error Msg = " + constraintViolation.getMessage());

    }
  }
}