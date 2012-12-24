package org.agoncal.book.javaee7.chapter03.ex09;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.groups.Default;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
public class Order09Test {

  // ======================================
  // =             Attributes             =
  // ======================================

  protected static ValidatorFactory vf;
  protected static Validator validator;

  private static Date creationDate ;
  private static Date paymentDate;
  private static Date deliveryDate;


  // ======================================
  // =          Lifecycle Methods         =
  // ======================================

  @BeforeClass
  public static void init() throws ParseException {
    vf = Validation.buildDefaultValidatorFactory();
    validator = vf.getValidator();

    SimpleDateFormat dateFormat = new SimpleDateFormat("DD/MM/YYYY");

    creationDate = dateFormat.parse("01/01/2010");
    paymentDate = dateFormat.parse("02/01/2010");
    deliveryDate = dateFormat.parse("03/01/2010");
  }

  // ======================================
  // =              Methods               =
  // ======================================

  @Test
  public void shouldRaiseNoConstraintsViolation() {

    Order09 order = new Order09();
    order.setId(1234L);
    order.setTotalAmount(1234.5);

    order.setCreationDate(creationDate);

    Set<ConstraintViolation<Order09>> constraints = validator.validate(order, FromCreation.class);
    displayContraintViolations(constraints);
    assertEquals(0, constraints.size());

    order.setPaymentDate(paymentDate);

    constraints = validator.validate(order, FromPayment.class);
    assertEquals(0, constraints.size());

    order.setDeliveryDate(deliveryDate);

    constraints = validator.validate(order, FromDelivery.class);
    assertEquals(0, constraints.size());
  }

  @Test @Ignore
  public void shouldRaiseConstraintsViolationCauseCreationDateIsThenSetToNull() {

    Order09 order = new Order09();
    order.setId(1234L);
    order.setTotalAmount(1234.5);

    order.setCreationDate(creationDate);

    Set<ConstraintViolation<Order09>> constraints = validator.validate(order, FromCreation.class);
    assertEquals(0, constraints.size());

    order.setPaymentDate(paymentDate);

    constraints = validator.validate(order, FromPayment.class);
    assertEquals(0, constraints.size());

    order.setCreationDate(null);
    order.setDeliveryDate(deliveryDate);

    constraints = validator.validate(order, FromDelivery.class);
    assertEquals(1, constraints.size());
  }

  @Test @Ignore
  public void shouldRaiseConstraintsViolationCauseCreationDatePaymentDateAreThenSetToNull() {

    Order09 order = new Order09();
    order.setId(1234L);
    order.setTotalAmount(1234.5);

    order.setCreationDate(creationDate);

    Set<ConstraintViolation<Order09>> constraints = validator.validate(order, FromCreation.class);
    assertEquals(0, constraints.size());

    order.setPaymentDate(paymentDate);

    constraints = validator.validate(order, FromPayment.class);
    assertEquals(0, constraints.size());

    order.setCreationDate(null);
    order.setPaymentDate(null);
    order.setDeliveryDate(deliveryDate);

    constraints = validator.validate(order, FromDelivery.class);
    assertEquals(2, constraints.size());
  }

  @Test  @Ignore
  public void shouldRaiseConstraintsViolationCauseIdTotalAmoutCreationDateAreNull() {

    Order09 order = new Order09();

    Set<ConstraintViolation<Order09>> constraints = validator.validate(order, FromCreation.class);
    displayContraintViolations(constraints);
    assertEquals(3, constraints.size());
  }

  @Test  @Ignore
  public void shouldRaiseConstraintsViolationCauseIdTotalAmoutCreationDatePaymentDateAreNull() {

    Order09 order = new Order09();

    Set<ConstraintViolation<Order09>> constraints = validator.validate(order, Default.class, FromCreation.class, FromPayment.class);
    displayContraintViolations(constraints);
    assertEquals(4, constraints.size());
  }

  @Test @Ignore
  public void shouldRaiseConstraintsViolationCauseIdTotalAmoutCreationDatePaymentDateDeliveryDateAreNull() {

    Order09 order = new Order09();

    Set<ConstraintViolation<Order09>> constraints = validator.validate(order, Default.class, FromCreation.class, FromPayment.class, FromDelivery.class);
    displayContraintViolations(constraints);
    assertEquals(5, constraints.size());
  }

  private void displayContraintViolations(Set<ConstraintViolation<Order09>> constraintViolations) {
    for (ConstraintViolation constraintViolation : constraintViolations) {
      System.out.println("### " + constraintViolation.getRootBeanClass().getSimpleName() +
              "." + constraintViolation.getPropertyPath() + " - Invalid Value = " + constraintViolation.getInvalidValue() + " - Error Msg = " + constraintViolation.getMessage());

    }
  }
}