package org.agoncal.book.javaee7.chapter03.ex10;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
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
public class CD10Test {

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

    // Creates a CD with null title
    CD10 cd = new CD10("title", 12.80f, "Beatles master piece", "Apple", 1, 53.32f, "Pop");

    // Validate the cd
    Set<ConstraintViolation<CD10>> violations = validator.validate(cd);
    assertEquals(0, violations.size());
  }

  @Test
  public void shouldRaiseConstraintsViolation() {

    // Creates a CD with null title
    CD10 cd = new CD10();

    // Validate the cd
    Set<ConstraintViolation<CD10>> violations = validator.validate(cd);
    displayContraintViolations(violations);
    assertEquals(1, violations.size());
  }

  @Test
  public void shouldRaiseWrongMusicCompany() throws Exception {

    // Creates a cd
    CD10 cd = new CD10("St Pepper", 12.80f, "Beatles master piece", "apple", 1, 53.32f, "Pop");

    // Validate the cd
    Set<ConstraintViolation<CD10>> violations = validator.validate(cd);
    displayContraintViolations(violations);
    assertEquals(1, violations.size());
  }

  @Test
  public void shouldRaiseTooManyCDs() throws Exception {

    // Creates a cd
    CD10 cd = new CD10("St Pepper", 12.80f, "Beatles master piece", "Apple", 11, 53.32f, "Pop");

    // Validate the cd
    Set<ConstraintViolation<CD10>> violations = validator.validate(cd);
    displayContraintViolations(violations);
    assertEquals(1, violations.size());
  }

  @Test
  public void shouldRaiseMusicGenreLowerCase() throws Exception {

    // Creates a cd
    CD10 cd = new CD10("St Pepper", 12.80f, "Beatles master piece", "Apple", 11, 53.32f, "pop");

    // Validate the cd
    Set<ConstraintViolation<CD10>> violations = validator.validate(cd);
    displayContraintViolations(violations);
    assertEquals(2, violations.size());
  }

  @Test
  public void shouldRaiseMusicGenreTooShort() {

    // Creates a cd
    CD10 cd = new CD10("St Pepper", 12.80f, "Beatles master piece", "Apple", 11, 53.32f, "P");

    // Validate the cd
    Set<ConstraintViolation<CD10>> violations = validator.validate(cd);
    displayContraintViolations(violations);
    assertEquals(2, violations.size());
  }

  @Test
  public void shouldRaiseMusicGenreTooLong() {

    // Creates a cd
    CD10 cd = new CD10("St Pepper", 12.80f, "Beatles master piece", "Apple", 11, 53.32f, "Poooooooooooooooooooooooooooooooooooooooooooooooooooooop");

    // Validate the cd
    Set<ConstraintViolation<CD10>> violations = validator.validate(cd);
    displayContraintViolations(violations);
    assertEquals(2, violations.size());
  }


  @Test
  public void shouldRaiseNoConstraintViolationOnCalculateVAT() throws NoSuchMethodException {

    CD10 cd = new CD10("title", 12.80f, "Beatles master piece", "Apple", 1, 53.32f, "Pop");

    ExecutableValidator methodValidator = validator.forExecutables();
    Method method = CD10.class.getMethod("calculateVAT");
    Set<ConstraintViolation<CD10>> violations = methodValidator.validateReturnValue(cd, method, new Float(10.0));
    assertEquals(0, violations.size());
  }

  @Test
  public void shouldRaiseAnExceptionCauseOverriddenMethodCannotHaveConstraintParameters() throws NoSuchMethodException {

    CD10 cd = new CD10("title", 12.80f, "Beatles master piece", "Apple", 1, 53.32f, "Pop");

    ExecutableValidator methodValidator = validator.forExecutables();
    Method method = CD10.class.getMethod("calculatePrice", Float.class);
    Set<ConstraintViolation<CD10>> violations = methodValidator.validateParameters(cd, method, new Object[]{new Float(4.5)});
  }

  private void displayContraintViolations(Set<ConstraintViolation<CD10>> constraintViolations) {
    for (ConstraintViolation constraintViolation : constraintViolations) {
      System.out.println("### " + constraintViolation.getRootBeanClass().getSimpleName() +
          "." + constraintViolation.getPropertyPath() + " - Invalid Value = " + constraintViolation.getInvalidValue() + " - Error Msg = " + constraintViolation.getMessage());

    }
  }
}
