package org.agoncal.book.javaee7.chapter08.ex02;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.ejb.embeddable.EJBContainer;
import javax.naming.Context;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class ShoppingCartEJB02IT {

  // ======================================
  // =             Attributes             =
  // ======================================

  private static EJBContainer ec;
  private static Context ctx;

  // ======================================
  // =          Lifecycle Methods         =
  // ======================================

  @BeforeClass
  public static void initContainer() throws Exception {
    Map<String, Object> properties = new HashMap<>();
    properties.put(EJBContainer.MODULES, new File("target/classes"));
    ec = EJBContainer.createEJBContainer(properties);
    ctx = ec.getContext();
  }

  @AfterClass
  public static void closeContainer() throws Exception {
    if (ctx != null)
      ctx.close();
    if (ec != null)
      ec.close();
  }

  // ======================================
  // =              Unit tests            =
  // ======================================

  @Test
  public void shouldAddTwoItemsToTheShoppingCart() throws Exception {

    // Check JNDI dependencies
    assertNotNull(ctx.lookup("java:global/classes/ShoppingCartEJB02!org.agoncal.book.javaee7.chapter08.ex02.ShoppingCartEJB02"));
    assertNotNull(ctx.lookup("java:global/classes/ShoppingCartEJB02"));

    // Looks up the EJB
    ShoppingCartEJB02 shoppingCartEJB = (ShoppingCartEJB02) ctx.lookup("java:global/classes/ShoppingCartEJB02!org.agoncal.book.javaee7.chapter08.ex02.ShoppingCartEJB02");

    // Checks the shopping cart is empty
    assertEquals("Cart should have no items", new Integer(0), shoppingCartEJB.getNumberOfItems());
    assertEquals("Total price should be zero", new Float(0), shoppingCartEJB.getTotal());

    // Creates an instance of book
    Item02 book = new Item02();
    book.setTitle("The Hitchhiker's Guide to the Galaxy");
    book.setPrice(12.5F);
    book.setDescription("Science fiction comedy book");

    // Adds the book to the shopping cart
    shoppingCartEJB.addItem(book);
    assertEquals("Cart should have one item", new Integer(1), shoppingCartEJB.getNumberOfItems());
    assertEquals("Total price should be 12.5F", new Float(12.5), shoppingCartEJB.getTotal());

    Item02 cd = new Item02();
    cd.setTitle("Zoot Allure");
    cd.setPrice(23f);
    cd.setDescription("Another Zappa's master piece");

    // Adds the cd to the shopping cart
    shoppingCartEJB.addItem(cd);
    assertEquals("Cart should have two items", new Integer(2), shoppingCartEJB.getNumberOfItems());
    assertEquals("Total price should be 35.5F", new Float(35.5), shoppingCartEJB.getTotal());

    // Empties the shopping cart
    shoppingCartEJB.empty();
    assertEquals("Cart should have no items", new Integer(0), shoppingCartEJB.getNumberOfItems());
    assertEquals("Total price should be zero", new Float(0), shoppingCartEJB.getTotal());

    // Checks out the shopping cart
    shoppingCartEJB.checkout();
    try {
      shoppingCartEJB.getNumberOfItems();
      fail("The checkout method has a @Remove annotation that clears the EJB. From here the EJB does not exist anymore");
    } catch (Exception e) {
    }
  }
}
