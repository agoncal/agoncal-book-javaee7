package org.agoncal.book.javaee7.chapter03.ex21;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import javax.validation.*;
import javax.validation.executable.ExecutableValidator;
import javax.validation.groups.Default;
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

    Set<ConstraintViolation<CD21>> violations = validator.validate(cd);
    assertEquals(0, violations.size());
  }

  @Test
  public void shouldRaiseConstraintViolationCauseTitleAndPriceAreNull() {

    CD21 cd = new CD21();

    Set<ConstraintViolation<CD21>> violations = validator.validate(cd);
    displayContraintViolations(violations);
    assertEquals(2, violations.size());
  }

  @Test
  public void shouldRaiseNoConstraintViolationValidatingNumberOfCDsProperty() {

    CD21 cd = new CD21();
    cd.setNumberOfCDs(2);

    Set<ConstraintViolation<CD21>> violations = validator.validateProperty(cd, "numberOfCDs");
    assertEquals(0, violations.size());
  }

  @Test //@Ignore("Make sure your local is EN, if not use the following JVM parameters : -Duser.language=en -Duser.country=EN")
  public void shouldRaiseConstraintViolationValidatingNumberOfCDsProperty() {

    CD21 cd = new CD21();
    cd.setNumberOfCDs(7);

    Set<ConstraintViolation<CD21>> violations = validator.validateProperty(cd, "numberOfCDs");
    displayContraintViolations(violations);
    assertEquals(1, violations.size());
    assertEquals("must be less than or equal to 5", violations.iterator().next().getMessage());
    assertEquals(7, violations.iterator().next().getInvalidValue());
    assertEquals("{javax.validation.constraints.Max.message}", violations.iterator().next().getMessageTemplate());
  }

  @Test
  public void shouldRaiseNoConstraintViolationValidatingNumberOfCDsPropertyValue() {

    Set<ConstraintViolation<CD21>> violations = validator.validateValue(CD21.class, "numberOfCDs", 2);
    displayContraintViolations(violations);
    assertEquals(0, violations.size());
  }

  @Test
  public void shouldRaiseConstraintViolationValidatingNumberOfCDsPropertyValue() {

    Set<ConstraintViolation<CD21>> violations = validator.validateValue(CD21.class, "numberOfCDs", 7);
    displayContraintViolations(violations);
    assertEquals(1, violations.size());
  }

  @Test
  public void shouldRaiseNoMethodParameterConstraintViolation() throws NoSuchMethodException {

    CD21 cd = new CD21("Kind of Blue", 12.5f);

    ExecutableValidator methodValidator = validator.forExecutables();
    Method method = CD21.class.getMethod("calculatePrice", Float.class);
    Set<ConstraintViolation<CD21>> violations = methodValidator.validateParameters(cd, method, new Object[]{new Float(2.2)});
    assertEquals(0, violations.size());
  }

  @Test //@Ignore("Make sure your local is EN, if not use the following JVM parameters : -Duser.language=en -Duser.country=EN")
  public void shouldRaiseMethodParameterConstraintViolationCauseRateIsLow() throws NoSuchMethodException {

    CD21 cd = new CD21("Kind of Blue", 12.5f);

    ExecutableValidator methodValidator = validator.forExecutables();
    Method method = CD21.class.getMethod("calculatePrice", Float.class);
    Set<ConstraintViolation<CD21>> violations = methodValidator.validateParameters(cd, method, new Object[]{new Float(1.2)});
    displayContraintViolations(violations);
    assertEquals(1, violations.size());
    assertEquals("must be greater than or equal to 1.4", violations.iterator().next().getMessage());
    assertEquals(new Float(1.2), violations.iterator().next().getInvalidValue());
    assertEquals("{javax.validation.constraints.DecimalMin.message}", violations.iterator().next().getMessageTemplate());
  }

  @Test
  public void shouldRaiseNoConstraintViolationWithGroup() {

    CD21 cd = new CD21("Kind of Blue", 12.5f);
    cd.setDescription("Best Jazz CD ever");

    Set<ConstraintViolation<CD21>> violations = validator.validate(cd, PrintingCatalog.class);
    assertEquals(0, violations.size());
  }

  @Test
  public void shouldRaiseNoConstraintViolationWithGroupEvenWithNullTitleAndPrice() {

    CD21 cd = new CD21();
    cd.setDescription("Best Jazz CD ever");

    Set<ConstraintViolation<CD21>> violations = validator.validate(cd, PrintingCatalog.class);
    assertEquals(0, violations.size());
  }

  @Test
  public void shouldRaiseConstraintViolationWithTwoGroupsCauseNullTitleAndPrice() {

    CD21 cd = new CD21();
    cd.setDescription("Best Jazz CD ever");

    Set<ConstraintViolation<CD21>> violations = validator.validate(cd, Default.class, PrintingCatalog.class);
    assertEquals(2, violations.size());
  }

  @Test
  public void shouldRaiseConstraintViolationWithNoGroupsCauseNullTitleAndPrice() {

    CD21 cd = new CD21();
    cd.setDescription("Best Jazz CD ever");

    Set<ConstraintViolation<CD21>> violations = validator.validate(cd);
    assertEquals(2, violations.size());
  }

  @Test
  public void shouldRaiseConstraintViolationWithDefaultGroupCauseNullTitleAndPrice() {

    CD21 cd = new CD21();
    cd.setDescription("Best Jazz CD ever");

    Set<ConstraintViolation<CD21>> violations = validator.validate(cd, Default.class);
    assertEquals(2, violations.size());
  }

  @Test
  public void shouldRaiseConstraintViolationWithTwoGroupsCauseNullTitlePriceAndSize() {

    CD21 cd = new CD21();
    cd.setDescription("Jazz");

    Set<ConstraintViolation<CD21>> violations = validator.validate(cd, Default.class, PrintingCatalog.class);
    assertEquals(3, violations.size());
  }

  @Test
  public void shouldRaiseConstraintViolationWithOneGroupCauseSize() {

    CD21 cd = new CD21();
    cd.setDescription("Too short");

    Set<ConstraintViolation<CD21>> violations = validator.validate(cd, PrintingCatalog.class);
    assertEquals(1, violations.size());
  }

  @Test
  public void shouldRaiseConstraintViolationWithGroupCauseSizeIsShort() {

    CD21 cd = new CD21("Kind of Blue", 12.5f);
    cd.setDescription("Jazz");

    Set<ConstraintViolation<CD21>> violations = validator.validate(cd, PrintingCatalog.class);
    assertEquals(1, violations.size());
  }


  private void displayContraintViolations(Set<ConstraintViolation<CD21>> constraintViolations) {
    for (ConstraintViolation constraintViolation : constraintViolations) {
      System.out.println("### " + constraintViolation.getRootBeanClass().getSimpleName() +
              "." + constraintViolation.getPropertyPath() + " - Invalid Value = " + constraintViolation.getInvalidValue() + " - Error Msg = " + constraintViolation.getMessage());

    }
  }
}
