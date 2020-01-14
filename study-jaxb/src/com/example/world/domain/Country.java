package com.example.world.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlIDREF;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="country")
@XmlAccessorType(XmlAccessType.FIELD)
public class Country {
	@XmlID
	private String code;
	private String name;
	private String continent;
	private Long population;
	private Double surfaceArea;
	@XmlIDREF
	private City capital;
	@XmlElementWrapper
	@XmlElementRefs({ @XmlElementRef(type = City.class) })	
	private List<City> cities;

	public Country() {
	}

	public Country(String code, String name, String continent, Long population, Double surfaceArea) {
		this.code = code;
		this.name = name;
		this.continent = continent;
		this.population = population;
		this.surfaceArea = surfaceArea;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContinent() {
		return continent;
	}

	public void setContinent(String continent) {
		this.continent = continent;
	}

	public Long getPopulation() {
		return population;
	}

	public void setPopulation(Long population) {
		this.population = population;
	}

	public Double getSurfaceArea() {
		return surfaceArea;
	}

	public void setSurfaceArea(Double surfaceArea) {
		this.surfaceArea = surfaceArea;
	}

	public City getCapital() {
		return capital;
	}

	public void setCapital(City capital) {
		this.capital = capital;
	}

	public List<City> getCities() {
		return cities;
	}

	public void setCities(List<City> cities) {
		this.cities = cities;
	}

	@Override
	public String toString() {
		return "Country [code=" + code + ", name=" + name + "]";
	}

}
