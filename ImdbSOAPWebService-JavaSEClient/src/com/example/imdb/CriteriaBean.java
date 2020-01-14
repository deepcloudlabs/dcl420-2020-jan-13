
package com.example.imdb;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for criteriaBean complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="criteriaBean">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="yearRangeSelected" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="from" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="to" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="genreSelected" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="genre" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="directorSelected" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="director" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "criteriaBean", propOrder = {
    "yearRangeSelected",
    "from",
    "to",
    "genreSelected",
    "genre",
    "directorSelected",
    "director"
})
public class CriteriaBean {

    protected boolean yearRangeSelected;
    protected int from;
    protected int to;
    protected boolean genreSelected;
    protected int genre;
    protected boolean directorSelected;
    protected int director;

    /**
     * Gets the value of the yearRangeSelected property.
     * 
     */
    public boolean isYearRangeSelected() {
        return yearRangeSelected;
    }

    /**
     * Sets the value of the yearRangeSelected property.
     * 
     */
    public void setYearRangeSelected(boolean value) {
        this.yearRangeSelected = value;
    }

    /**
     * Gets the value of the from property.
     * 
     */
    public int getFrom() {
        return from;
    }

    /**
     * Sets the value of the from property.
     * 
     */
    public void setFrom(int value) {
        this.from = value;
    }

    /**
     * Gets the value of the to property.
     * 
     */
    public int getTo() {
        return to;
    }

    /**
     * Sets the value of the to property.
     * 
     */
    public void setTo(int value) {
        this.to = value;
    }

    /**
     * Gets the value of the genreSelected property.
     * 
     */
    public boolean isGenreSelected() {
        return genreSelected;
    }

    /**
     * Sets the value of the genreSelected property.
     * 
     */
    public void setGenreSelected(boolean value) {
        this.genreSelected = value;
    }

    /**
     * Gets the value of the genre property.
     * 
     */
    public int getGenre() {
        return genre;
    }

    /**
     * Sets the value of the genre property.
     * 
     */
    public void setGenre(int value) {
        this.genre = value;
    }

    /**
     * Gets the value of the directorSelected property.
     * 
     */
    public boolean isDirectorSelected() {
        return directorSelected;
    }

    /**
     * Sets the value of the directorSelected property.
     * 
     */
    public void setDirectorSelected(boolean value) {
        this.directorSelected = value;
    }

    /**
     * Gets the value of the director property.
     * 
     */
    public int getDirector() {
        return director;
    }

    /**
     * Sets the value of the director property.
     * 
     */
    public void setDirector(int value) {
        this.director = value;
    }

}
