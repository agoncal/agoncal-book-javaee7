package org.agoncal.book.javaee7.chapter12.ex99;

import javax.xml.bind.annotation.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@XmlRootElement
@XmlType(propOrder = {"id", "creationDate", "customer", "orderLines", "creditCard"})
@XmlAccessorType(XmlAccessType.FIELD)
public class Order99 {

  // ======================================
  // =             Attributes             =
  // ======================================

  @XmlAttribute
  private Long id;
  @XmlAttribute(name = "date")
  @XmlJavaTypeAdapter(DateAdapter99.class)
  private Date creationDate;
  @XmlTransient
  private Double totalAmount;
  @XmlElementWrapper(name = "content")
  @XmlElement(name = "order_line", required = true)
  private List<OrderLine99> orderLines;
  @XmlElement(required = true)
  private Customer99 customer;
  @XmlElement(name = "credit_card")
  private CreditCard99 creditCard;

  // ======================================
  // =            Constructors            =
  // ======================================

  public Order99() {
  }

  public Order99(Long id, Double totalAmount, Date creationDate) {
    this.id = id;
    this.totalAmount = totalAmount;
    this.creationDate = creationDate;
  }

  // ======================================
  // =           Public Methods           =
  // ======================================

  public void addOrderLine(OrderLine99 orderLine) {
    if (orderLines == null)
      orderLines = new ArrayList<>();
    orderLines.add(orderLine);
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Date getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(Date creationDate) {
    this.creationDate = creationDate;
  }

  public List<OrderLine99> getOrderLines() {
    return orderLines;
  }

  public void setOrderLines(List<OrderLine99> orderLines) {
    this.orderLines = orderLines;
  }

  public Double getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(Double totalAmount) {
    this.totalAmount = totalAmount;
  }

  public Customer99 getCustomer() {
    return customer;
  }

  public void setCustomer(Customer99 customer) {
    this.customer = customer;
  }

  public CreditCard99 getCreditCard() {
    return creditCard;
  }

  public void setCreditCard(CreditCard99 creditCard) {
    this.creditCard = creditCard;
  }
}