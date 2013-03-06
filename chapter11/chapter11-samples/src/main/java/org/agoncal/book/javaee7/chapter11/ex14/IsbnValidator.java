package org.agoncal.book.javaee7.chapter11.ex14;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;
import java.text.MessageFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@FacesValidator("isbnValidator")
public class IsbnValidator implements Validator {

  private Pattern pattern;
  private Matcher matcher;

  @Override
  public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {

    String componentValue = value.toString();

    pattern = Pattern.compile("(?=[-0-9xX]{13}$)");
    matcher = pattern.matcher(componentValue);

    if (!matcher.find()) {
      String msg = MessageFormat.format("{0} not a valid isbn format", componentValue);
      FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_ERROR, msg, msg);
      throw new ValidatorException(facesMessage);
    }
  }
}