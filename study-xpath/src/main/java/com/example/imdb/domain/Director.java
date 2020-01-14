package com.example.imdb.domain;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="director")
public class Director {
	private String name;
	private String imdb;

	public Director() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getImdb() {
		return imdb;
	}

	public void setImdb(String imdb) {
		this.imdb = imdb;
	}

	@Override
	public String toString() {
		return "Director [name=" + name + ", imdb=" + imdb + "]";
	}

}
