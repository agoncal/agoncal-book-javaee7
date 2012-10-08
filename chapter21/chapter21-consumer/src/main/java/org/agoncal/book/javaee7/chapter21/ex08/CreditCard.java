package org.agoncal.book.javaee7.chapter21.ex08;

import javax.xml.bind.annotation.*;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CreditCard {

    // ======================================
    // =             Attributes             =
    // ======================================
    @XmlAttribute(required = true)
    private String number;
    @XmlElement(name = "expiry-date", defaultValue = "01/10")
    private String expiryDate;
    private String type;
    @XmlElement(name = "control-number")
    private Integer controlNumber;

    // ======================================
    // =            Constructors            =
    // ======================================

    public CreditCard() {
    }

    public CreditCard(String number, String expiryDate, Integer controlNumber, String type) {
        this.number = number;
        this.expiryDate = expiryDate;
        this.controlNumber = controlNumber;
        this.type = type;
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public Integer getControlNumber() {
        return controlNumber;
    }

    public void setControlNumber(Integer controlNumber) {
        this.controlNumber = controlNumber;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}