package org.agoncal.book.javaee7.chapter05.ex02;

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
public class CardValidator02Test {

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

    ValidatorFactory vf= Validation.buildDefaultValidatorFactory();
    Validator validator = vf.getValidator();

    Set<ConstraintViolation<Boolean>> constraints = validator.validate(new CardValidator02().validate(null));
    assertEquals(0, constraints.size());

  }

}