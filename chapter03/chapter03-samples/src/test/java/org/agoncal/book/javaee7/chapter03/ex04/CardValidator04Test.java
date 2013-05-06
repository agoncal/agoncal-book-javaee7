package org.agoncal.book.javaee7.chapter03.ex04;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import javax.validation.*;
import javax.validation.executable.ExecutableValidator;
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
public class CardValidator04Test {

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
  public void shouldRaiseNoConstraintViolation() throws NoSuchMethodException {

    CreditCard04 creditCard = new CreditCard04("12341234", "10/10", 1234, "VISA");
    CardValidator04 cardValidator = new CardValidator04();

    ExecutableValidator methodValidator = validator.forExecutables();
    Method method = CardValidator04.class.getMethod("validate", CreditCard04.class);
    Set<ConstraintViolation<CardValidator04>> violations = methodValidator.validateParameters(cardValidator, method, new Object[]{creditCard});
    assertEquals(0, violations.size());

    violations = methodValidator.validateReturnValue(cardValidator, method, Boolean.TRUE);
    assertEquals(0, violations.size());
  }

  @Test
  public void shouldRaiseConstraintViolationCauseCreditCardIsNull() throws NoSuchMethodException {

    CardValidator04 cardValidator = new CardValidator04();

    ExecutableValidator methodValidator = validator.forExecutables();
    Method method = CardValidator04.class.getMethod("validate", CreditCard04.class);
    Set<ConstraintViolation<CardValidator04>> violations = methodValidator.validateParameters(cardValidator, method, new Object[]{null});
    displayContraintViolations(violations);
    assertEquals(1, violations.size());
  }

  @Test
  public void shouldRaiseConstraintViolationCauseCreditCardParametersAreNull() throws NoSuchMethodException {

    CreditCard04 creditCard = new CreditCard04(null, null, null, null);
    CardValidator04 cardValidator = new CardValidator04();

    ExecutableValidator methodValidator = validator.forExecutables();
    Method method = CardValidator04.class.getMethod("validate", CreditCard04.class);
    Set<ConstraintViolation<CardValidator04>> violations = methodValidator.validateParameters(cardValidator, method, new Object[]{creditCard});
    displayContraintViolations(violations);
    assertEquals(3, violations.size());
  }

  private void displayContraintViolations(Set<ConstraintViolation<CardValidator04>> constraintViolations) {
    for (ConstraintViolation constraintViolation : constraintViolations) {
      System.out.println("### " + constraintViolation.getRootBeanClass().getSimpleName() +
              "." + constraintViolation.getPropertyPath() + " - Invalid Value = " + constraintViolation.getInvalidValue() + " - Error Msg = " + constraintViolation.getMessage());

    }
  }
}
