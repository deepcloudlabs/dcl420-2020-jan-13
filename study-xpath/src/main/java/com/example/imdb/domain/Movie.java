package com.example.imdb.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "movie")
@XmlAccessorType(XmlAccessType.FIELD)
public class Movie {
	@XmlAttribute
	private String imdb;
	@XmlElement
	private String title;
	@XmlElement
	private int year;
	@XmlElementWrapper(name = "genres")
	@XmlElement(name = "genre")
	private List<String> genres;
	@XmlElementWrapper
	@XmlElementRefs({ @XmlElementRef(type = Director.class) })
	private List<Director> directors;

	public Movie() {
	}

	public String getImdb() {
		return imdb;
	}

	public void setImdb(String imdb) {
		this.imdb = imdb;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public List<String> getGenres() {
		return genres;
	}

	public void setGenres(List<String> genres) {
		this.genres = genres;
	}

	public List<Director> getDirectors() {
		return directors;
	}

	public void setDirectors(List<Director> directors) {
		this.directors = directors;
	}

	@Override
	public String toString() {
		return "Movie [imdb=" + imdb + ", title=" + title + ", year=" + year + "]";
	}

}
