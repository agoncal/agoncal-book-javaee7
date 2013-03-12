package org.agoncal.book.javaee7.chapter15.ex05;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@XmlRootElement
@XmlSeeAlso(Item05.class)
public class Items05 extends ArrayList<Item05> {

  // ======================================
  // =          Getters & Setters         =
  // ======================================

  @XmlElement(name = "item")
  public List<Item05> getItems() {
    return this;
  }
}