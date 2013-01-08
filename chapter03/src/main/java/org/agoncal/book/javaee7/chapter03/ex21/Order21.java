package org.agoncal.book.javaee7.chapter03.ex21;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
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
public class Order21 {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Pattern.List({
          @Pattern(regexp = "[C,D,M][A-Z][0-9]*"),
          @Pattern(regexp = ".[A-Z].*?")
  })
  private String orderId;
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
  private List<CD21> orderLines;

  // ======================================
  // =            Constructors            =
  // ======================================

  public Order21() {
  }

  // ======================================
  // =           Public Methods           =
  // ======================================

  public void addCD(@NotNull @Valid CD21 cd) {
    if (orderLines == null)
      orderLines = new ArrayList<>();
    orderLines.add(cd);
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