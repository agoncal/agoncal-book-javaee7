package org.agoncal.book.javaee7.chapter13.ex06;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import java.util.HashMap;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 6 with Glassfish
 *         http://www.apress.com
 *         http://www.antoniogoncalves.org
 *         --
 */
@Entity
@NamedQuery(name = "CD06.findAllCDs", query = "SELECT c FROM CD06 c")
public class CD06 extends Item06 {

    // ======================================
    // =             Attributes             =
    // ======================================

    @Lob
    private byte[] cover;
    private String musicCompany;
    private Integer numberOfCDs;
    private Float totalDuration;
    private String genre;

    // ======================================
    // =            Constructors            =
    // ======================================

    public CD06() {
    }

    public CD06(String title, Float price, String description, HashMap<Integer, String> tracks) {
        this.title = title;
        this.price = price;
        this.description = description;
    }

    // ======================================
    // =          Getters & Setters         =
    // ======================================

    public byte[] getCover() {
        return cover;
    }

    public void setCover(byte[] cover) {
        this.cover = cover;
    }

    public String getMusicCompany() {
        return musicCompany;
    }

    public void setMusicCompany(String musicCompany) {
        this.musicCompany = musicCompany;
    }

    public Integer getNumberOfCDs() {
        return numberOfCDs;
    }

    public void setNumberOfCDs(Integer numberOfCDs) {
        this.numberOfCDs = numberOfCDs;
    }

    public Float getTotalDuration() {
        return totalDuration;
    }

    public void setTotalDuration(Float totalDuration) {
        this.totalDuration = totalDuration;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }
}