package org.agoncal.book.javaee7.chapter03.ex06;

import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.groups.Default;
import java.util.Set;

import static org.junit.Assert.assertEquals;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class Order06Test {

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
  public void shouldRaiseConstraintsViolationCauseIdIsNull() {

    Order06 order = new Order06();

    Set<ConstraintViolation<Order06>> constraints = validator.validate(order);
    displayContraintViolations(constraints);
    assertEquals(1, constraints.size());
  }

  @Test
  public void shouldRaiseConstraintsViolationCauseIdTotalAmoutCreationDateAreNull() {

    Order06 order = new Order06();

    Set<ConstraintViolation<Order06>> constraints = validator.validate(order, Default.class, Creation.class);
    displayContraintViolations(constraints);
    assertEquals(3, constraints.size());
  }

  @Test
  public void shouldRaiseConstraintsViolationCauseIdTotalAmoutCreationDatePaymentDateAreNull() {

    Order06 order = new Order06();

    Set<ConstraintViolation<Order06>> constraints = validator.validate(order, Default.class, Creation.class, Payment.class);
    displayContraintViolations(constraints);
    assertEquals(4, constraints.size());
  }

  @Test
  public void shouldRaiseConstraintsViolationCauseIdTotalAmoutCreationDatePaymentDateDeliveryDateAreNull() {

    Order06 order = new Order06();

    Set<ConstraintViolation<Order06>> constraints = validator.validate(order, Default.class, Creation.class, Payment.class, Delivery.class);
    displayContraintViolations(constraints);
    assertEquals(5, constraints.size());
  }

  private void displayContraintViolations(Set<ConstraintViolation<Order06>> constraintViolations) {
    for (ConstraintViolation constraintViolation : constraintViolations) {
      System.out.println("### " + constraintViolation.getRootBeanClass().getSimpleName() +
              "." + constraintViolation.getPropertyPath() + " - Invalid Value = " + constraintViolation.getInvalidValue() + " - Error Msg = " + constraintViolation.getMessage());

    }
  }
}