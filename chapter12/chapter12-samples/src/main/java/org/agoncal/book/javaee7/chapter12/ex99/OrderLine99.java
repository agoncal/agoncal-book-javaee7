package org.agoncal.book.javaee7.chapter12.ex99;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class OrderLine99 {

  // ======================================
  // =             Attributes             =
  // ======================================

  @XmlAttribute
  private String item;
  @XmlElement(name = "unit_price")
  private Double unitPrice;
  @XmlAttribute
  private Integer quantity;

  // ======================================
  // =            Constructors            =
  // ======================================

  public OrderLine99() {
  }

  public OrderLine99(String item, Double unitPrice, Integer quantity) {
    this.item = item;
    this.unitPrice = unitPrice;
    this.quantity = quantity;
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public String getItem() {
    return item;
  }

  public void setItem(String item) {
    this.item = item;
  }

  public Double getUnitPrice() {
    return unitPrice;
  }

  public void setUnitPrice(Double unitPrice) {
    this.unitPrice = unitPrice;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }
}