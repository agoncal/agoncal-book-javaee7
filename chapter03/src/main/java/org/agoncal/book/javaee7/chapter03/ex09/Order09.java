package org.agoncal.book.javaee7.chapter03.ex09;

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
public class Order09 {

  // ======================================
  // =             Attributes             =
  // ======================================

  @NotNull
  private Long id;
  @NotNull
  @Past
  private Date creationDate;
  private Double totalAmount;
  @NotNull(groups = Payment.class)
  @Past(groups = Payment.class)
  private Date paymentDate;
  @NotNull(groups = Delivery.class)
  @Past(groups = Delivery.class)
  private Date deliveryDate;
  private List<OrderLine09> orderLines;

  // ======================================
  // =            Constructors            =
  // ======================================

  public Order09() {
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

  public List<OrderLine09> getOrderLines() {
    return orderLines;
  }

  public void setOrderLines(List<OrderLine09> orderLines) {
    this.orderLines = orderLines;
  }
}