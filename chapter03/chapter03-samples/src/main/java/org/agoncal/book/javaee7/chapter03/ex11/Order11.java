package org.agoncal.book.javaee7.chapter03.ex11;

import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class Order11 {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Pattern.List({
          @Pattern(regexp = "[C,D,M][A-Z][0-9]*"),
          @Pattern(regexp = ".[A-Z].*?")
  })
  private String orderId;
  private Date creationDate;
  private Double totalAmount;
  private Date paymentDate;
  private Date deliveryDate;

  // ======================================
  // =            Constructors            =
  // ======================================

  public Order11() {
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public String getOrderId() {
    return orderId;
  }

  public void setOrderId(String orderId) {
    this.orderId = orderId;
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
}