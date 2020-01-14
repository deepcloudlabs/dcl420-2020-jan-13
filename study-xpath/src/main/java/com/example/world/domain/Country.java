package com.example.world.domain;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "country")
@XmlAccessorType(XmlAccessType.FIELD)
public class Country {
	@XmlElement(name = "code")
	private String code;
	@XmlElement(name = "name")
	private String name;
	@XmlElement(name = "continent")
	private String continent;
	@XmlElement(name = "population")
	private Long population;
	@XmlElement(name = "surfacearea")
	private Double surfaceArea;

	public Country() {
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

	@Override
	public String toString() {
		return "Country [code=" + code + ", name=" + name + ", continent=" + continent + ", population=" + population
				+ ", surfaceArea=" + surfaceArea + "]";
	}

}
