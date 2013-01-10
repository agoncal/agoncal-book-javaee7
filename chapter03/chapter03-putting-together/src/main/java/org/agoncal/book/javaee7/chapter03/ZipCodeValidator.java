package org.agoncal.book.javaee7.chapter03;

import javax.inject.Inject;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class ZipCodeValidator implements ConstraintValidator<ZipCode, String> {

  @Inject
  @USA
  private ZipCodeChecker checker = new ZipCodeChecker();
  private Pattern zipPattern = Pattern.compile("\\d{5}(-\\d{5})?");

  @Override
  public void initialize(ZipCode zipCode) {
  }

  @Override
  public boolean isValid(String value, ConstraintValidatorContext context) {
    if (value == null)
      return true;

    Matcher m = zipPattern.matcher(value);
    if (!m.matches())
      return false;
    return checker.isZipCodeValid(value);
  }
}
