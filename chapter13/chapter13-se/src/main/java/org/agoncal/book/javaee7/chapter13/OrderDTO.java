package org.agoncal.book.javaee7.chapter13;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class OrderDTO implements Serializable {

  private Long orderId;
  private Date creationDate;
  private String customerName;
  private Float totalAmount;

  // ======================================
  // =            Constructors            =
  // ======================================

  public OrderDTO() {
  }

  public OrderDTO(Long orderId, Date creationDate, String customerName, Float totalAmount) {
    this.orderId = orderId;
    this.creationDate = creationDate;
    this.customerName = customerName;
    this.totalAmount = totalAmount;
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public Long getOrderId() {
    return orderId;
  }

  public void setOrderId(Long orderId) {
    this.orderId = orderId;
  }

  public Date getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(Date creationDate) {
    this.creationDate = creationDate;
  }

  public String getCustomerName() {
    return customerName;
  }

  public void setCustomerName(String customerName) {
    this.customerName = customerName;
  }

  public Float getTotalAmount() {
    return totalAmount;
  }

  public void setTotalAmount(Float totalAmount) {
    this.totalAmount = totalAmount;
  }

  // ======================================
  // =         hash, equals, toString     =
  // ======================================

  @Override
  public String toString() {
    final StringBuilder sb = new StringBuilder();
    sb.append("OrderDTO");
    sb.append("{orderId=").append(orderId);
    sb.append(", creationDate=").append(creationDate);
    sb.append(", customerName='").append(customerName).append('\'');
    sb.append(", totalAmount=").append(totalAmount);
    sb.append('}');
    return sb.toString();
  }
}