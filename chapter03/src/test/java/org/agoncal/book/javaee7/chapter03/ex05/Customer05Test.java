package org.agoncal.book.javaee7.chapter03.ex05;

import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Date;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class Customer05Test {

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
    Customer03 customer = new Customer03("John", "Smith", "jsmith@gmail.com", "1234565", new Date(), new Date());


    // Validate the cd
    Set<ConstraintViolation<Customer03>> constraints = validator.validate(customer);
    assertEquals(0, constraints.size());
  }

  @Test
  public void shouldRaiseConstraintsViolationCauseTooShort() {

    // Creates a book
    Customer03 customer = new Customer03("John", "Smith", "a@b.c", "1234565", new Date(), new Date());


    // Validate the cd
    Set<ConstraintViolation<Customer03>> constraints = validator.validate(customer);
    displayContraintViolations(constraints);
    assertEquals(1, constraints.size());
  }

  @Test
  public void shouldRaiseConstraintsViolationCauseEmailWithoutDot() {

    // Creates a book
    Customer03 customer = new Customer03("John", "Smith", "jsmith@gmailcom", "1234565", new Date(), new Date());


    // Validate the cd
    Set<ConstraintViolation<Customer03>> constraints = validator.validate(customer);
    displayContraintViolations(constraints);
    assertEquals(1, constraints.size());
  }

  @Test
  public void shouldRaiseConstraintsViolationCauseEmailWithoutAt() {

    // Creates a book
    Customer03 customer = new Customer03("John", "Smith", "jsmithgmail.com", "1234565", new Date(), new Date());

    // Validate the cd
    Set<ConstraintViolation<Customer03>> constraints = validator.validate(customer);
    displayContraintViolations(constraints);
    assertEquals(1, constraints.size());
  }

  @Test
  public void shouldRaiseConstraintsViolationCauseEmailNull() {

    // Creates a book
    Customer03 customer = new Customer03();

    // Validate the cd
    Set<ConstraintViolation<Customer03>> constraints = validator.validate(customer);
    displayContraintViolations(constraints);
    assertEquals(1, constraints.size());
  }

  private void displayContraintViolations(Set<ConstraintViolation<Customer03>> constraintViolations) {
    for (ConstraintViolation constraintViolation : constraintViolations) {
      System.out.println("### " + constraintViolation.getRootBeanClass().getSimpleName() +
              "." + constraintViolation.getPropertyPath() + " - Invalid Value = " + constraintViolation.getInvalidValue() + " - Error Msg = " + constraintViolation.getMessage());

    }
  }
}