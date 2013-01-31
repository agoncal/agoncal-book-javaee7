package org.agoncal.book.javaee7.chapter05.ex45;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Entity
@Table(name = "ex45_order")
public class Order45 {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Id
  @GeneratedValue
  private Long id;
  @Temporal(TemporalType.TIMESTAMP)
  private Date creationDate;
  @OneToMany(fetch = FetchType.EAGER)
  @JoinColumn(name = "order_fk")
  private List<OrderLine45> orderLines;

  // ======================================
  // =            Constructors            =
  // ======================================

  public Order45() {
    this.creationDate = new Date();
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public Long getId() {
    return id;
  }

  public Date getCreationDate() {
    return creationDate;
  }

  public void setCreationDate(Date creationDate) {
    this.creationDate = creationDate;
  }

  public List<OrderLine45> getOrderLines() {
    return orderLines;
  }

  public void setOrderLines(List<OrderLine45> orderLines) {
    this.orderLines = orderLines;
  }
}