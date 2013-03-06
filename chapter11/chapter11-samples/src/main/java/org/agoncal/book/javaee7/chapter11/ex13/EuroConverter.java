package org.agoncal.book.javaee7.chapter11.ex13;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import java.text.DecimalFormat;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@FacesConverter("euroConverter")
public class EuroConverter implements Converter {

  @Override
  public Object getAsObject(FacesContext context, UIComponent component, String value) {
    return value;
  }

  @Override
  public String getAsString(FacesContext ctx, UIComponent component, Object value) {
    float amountInDollars = Float.parseFloat(value.toString());
    double ammountInEuros = amountInDollars * 0.8;
    DecimalFormat df = new DecimalFormat("###,##0.##");
    return df.format(ammountInEuros);
  }
}