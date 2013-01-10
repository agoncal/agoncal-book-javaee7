package org.agoncal.book.javaee7.chapter03.ex12;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
public class ItemServerConnection12 {

  // ======================================
  // =             Attributes             =
  // ======================================

  @URL
  private String resourceURL;
  @NotNull
  @URL(protocol = "http", host = "www.cdbookstore.com")
  private String itemURL;
  @URL(protocol = "ftp", port = 21)
  private String ftpServerURL;
  @URL(groups = Error.class)
  private Date lastConnectionDate;

  // ======================================
  // =            Constructors            =
  // ======================================

  public ItemServerConnection12() {
  }

  public ItemServerConnection12(String resourceURL, String itemURL, String ftpServerURL) {
    this.resourceURL = resourceURL;
    this.itemURL = itemURL;
    this.ftpServerURL = ftpServerURL;
  }

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  public String getResourceURL() {
    return resourceURL;
  }

  public void setResourceURL(String resourceURL) {
    this.resourceURL = resourceURL;
  }

  public String getItemURL() {
    return itemURL;
  }

  public void setItemURL(String itemURL) {
    this.itemURL = itemURL;
  }

  public String getFtpServerURL() {
    return ftpServerURL;
  }

  public void setFtpServerURL(String ftpServerURL) {
    this.ftpServerURL = ftpServerURL;
  }

  public Date getLastConnectionDate() {
    return lastConnectionDate;
  }

  public void setLastConnectionDate(Date lastConnectionDate) {
    this.lastConnectionDate = lastConnectionDate;
  }
}
