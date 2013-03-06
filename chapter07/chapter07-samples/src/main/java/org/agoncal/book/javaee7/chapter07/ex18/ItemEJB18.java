package org.agoncal.book.javaee7.chapter07.ex18;

import javax.annotation.Resource;
import javax.ejb.Stateless;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Stateless
public class ItemEJB18 {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Resource(name = "currencyEntry")
  private String currency;
  @Resource(name = "changeRateEntry")
  private Float changeRate;

  // ======================================
  // =           Public Methods           =
  // ======================================

  public Item18 convertPrice(Item18 item) {
    item.setPrice(item.getPrice() * changeRate);
    item.setCurrency(currency);
    return item;
  }

  public Item18 convertFixedPrice(Item18 item) {
    item.setPrice(item.getPrice() * 0.80F);
    item.setCurrency("Euros");
    return item;
  }
}