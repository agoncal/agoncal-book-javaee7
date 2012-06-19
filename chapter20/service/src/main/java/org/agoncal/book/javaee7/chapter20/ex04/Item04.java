package org.agoncal.book.javaee7.chapter20.ex04;

import javax.persistence.*;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish 3
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Entity
@Table(name = "ex58_item")
public class Item04 {

    // ======================================
    // =             Attributes             =
    // ======================================

    @Id
    @GeneratedValue
    protected Long id;
    @Column(nullable = false)
    protected String title;
    @Column(nullable = false)
    protected Float price;
    protected String description;

    // ======================================
    // =            Constructors            =
    // ======================================

    public Item04() {
    }

    public Item04(String title, Float price, String description) {
        this.title = title;
        this.price = price;
        this.description = description;
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}