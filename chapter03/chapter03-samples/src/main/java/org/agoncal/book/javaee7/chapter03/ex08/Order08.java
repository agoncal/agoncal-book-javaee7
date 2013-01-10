package org.agoncal.book.javaee7.chapter03.ex08;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;
import java.util.List;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@ChronologicalDates(groups = Delivery.class)
public class Order08 {

  // ======================================
  // =             Attributes             =
  // ======================================

  @NotNull(groups = {Creation.class, Payment.class, Delivery.class})
  private Long id;
  @NotNull(groups = {Creation.class, Payment.class, Delivery.class})
  @Past(groups = {Creation.class, Payment.class, Delivery.class})
  private Date creationDate;
  @NotNull(groups = {Creation.class, Payment.class, Delivery.class})
  private Double totalAmount;
  @NotNull(groups = {Payment.class, Delivery.class})
  @Past(groups = {Payment.class, Delivery.class})
  private Date paymentDate;
  @NotNull(groups = Delivery.class)
  @Past(groups = Delivery.class)
  private Date deliveryDate;
  private List<OrderLine08> orderLines;

  // ======================================
  // =            Constructors            =
  // ======================================

  public Order08() {
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

  public Double getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(Double totalAmount) {
    this.totalAmount = totalAmount;
  }

  public Date getPaymentDate() {
    return paymentDate;
  }

  public void setPaymentDate(Date paymentDate) {
    this.paymentDate = paymentDate;
  }

  public Date getDeliveryDate() {
    return deliveryDate;
  }

  public void setDeliveryDate(Date deliveryDate) {
    this.deliveryDate = deliveryDate;
  }

  public List<OrderLine08> getOrderLines() {
    return orderLines;
  }

  public void setOrderLines(List<OrderLine08> orderLines) {
    this.orderLines = orderLines;
  }
}