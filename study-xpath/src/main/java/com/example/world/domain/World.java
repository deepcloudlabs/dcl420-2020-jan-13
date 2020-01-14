package com.example.world.domain;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "world")
@XmlAccessorType(XmlAccessType.FIELD)
public class World {
	@XmlElementWrapper
	@XmlElementRefs({ @XmlElementRef(type = Country.class) })
	private List<Country> countries;

	public World() {
	}

	public List<Country> getCountries() {
		return countries;
	}

	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}

}
