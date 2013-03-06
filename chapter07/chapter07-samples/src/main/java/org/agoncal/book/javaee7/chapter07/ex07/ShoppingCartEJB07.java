package org.agoncal.book.javaee7.chapter07.ex07;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import javax.ejb.StatefulTimeout;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Stateful
@StatefulTimeout(value = 20, unit = TimeUnit.SECONDS)
public class ShoppingCartEJB07 {

  // ======================================
  // =             Attributes             =
  // ======================================

  private List<Item07> cartItems = new ArrayList<>();

  // ======================================
  // =           Public Methods           =
  // ======================================

  public void addItem(Item07 item) {
    if (!cartItems.contains(item))
      cartItems.add(item);
  }

  public void removeItem(Item07 item) {
    if (cartItems.contains(item))
      cartItems.remove(item);
  }

  public Integer getNumberOfItems() {
    if (cartItems == null || cartItems.isEmpty())
      return 0;
    return cartItems.size();
  }

  public Float getTotal() {
    if (cartItems == null || cartItems.isEmpty())
      return 0f;

    Float total = 0f;
    for (Item07 cartItem : cartItems) {
      total += (cartItem.getPrice());
    }
    return total;
  }

  public void empty() {
    cartItems.clear();
  }

  @Remove
  public void checkout() {
    // Do some business logic
    cartItems.clear();
  }
}