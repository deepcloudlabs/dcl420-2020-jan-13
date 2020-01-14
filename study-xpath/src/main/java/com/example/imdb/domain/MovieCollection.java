package com.example.imdb.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="collection")
@XmlAccessorType(XmlAccessType.FIELD)
public class MovieCollection {
	@XmlElementWrapper
	@XmlElementRefs({
		@XmlElementRef(type=Movie.class)
	})
	private List<Movie> movies;

	public MovieCollection() {
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

}
