package org.agoncal.book.javaee7.chapter10.ex14;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Named
@RequestScoped
public class ItemController {

  // ======================================
  // =             Attributes             =
  // ======================================

  private Book book = new Book();
  private CD cd = new CD();
  private Item item = new Item();
  private List<Item> itemList = new ArrayList<>();

  // ======================================
  // =           Public Methods           =
  // ======================================

  public String doCreateBook() {
    return null;
  }

  public String doCreateCD() {
    return null;
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public Book getBook() {
    return book;
  }

  public void setBook(Book book) {
    this.book = book;
  }

  public CD getCd() {
    return cd;
  }

  public void setCd(CD cd) {
    this.cd = cd;
  }

  public List<Item> getItemList() {
    return itemList;
  }

  public void setItemList(List<Item> itemList) {
    this.itemList = itemList;
  }

  public Item getItem() {
    return item;
  }

  public void setItem(Item item) {
    this.item = item;
  }
}