package org.agoncal.book.javaee7.chapter12.ex99;

import javax.xml.bind.annotation.adapters.XmlAdapter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Antonio Goncalves
 */
public class DateAdapter99 extends XmlAdapter<String, Date> {

  DateFormat df = new SimpleDateFormat("dd/MM/yyyy");

  public Date unmarshal(String date) throws Exception {
    return df.parse(date);
  }

  public String marshal(Date date) throws Exception {
    return df.format(date);
  }
}