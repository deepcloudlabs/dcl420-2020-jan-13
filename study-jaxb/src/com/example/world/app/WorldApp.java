package com.example.world.app;

import java.io.File;
import java.util.Arrays;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import com.example.world.domain.City;
import com.example.world.domain.Country;

public class WorldApp {

	public static void main(String[] args) throws Exception {
		Country turkey = new Country("TUR", "Turkey",
				"Asia", 80_000_000L, 10000.0);
		City ankara = new City("1", "Ankara", 5_000_000);
		City istanbul = new City("2", "İstanbul", 20_000_000);
        ankara.setCountry(turkey);
        istanbul.setCountry(turkey);
        turkey.setCapital(ankara);
        turkey.setCities(Arrays.asList(ankara,istanbul));
        // Write turkey to XML file using JAXB
        JAXBContext context = JAXBContext.newInstance(Country.class);
        Marshaller marshaller = context.createMarshaller();
        File file= new File("src","turkey.xml");
		marshaller.marshal(turkey, file);
	}

}
