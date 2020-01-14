package com.example;

import static org.joox.JOOX.$;

import java.io.File;
import java.util.Comparator;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.joox.Match;

import com.example.world.domain.Country;
import com.example.world.domain.World;

public class AsianCountries {
	// JAXP, JAXB
	public static void main(String[] args) throws Exception {
		JAXBContext context = 
				JAXBContext.newInstance(World.class);
		Unmarshaller unmarshaller = 
				context.createUnmarshaller();
		File file = new File("src/main/resources","countries.xml");
		World world = (World) unmarshaller.unmarshal(file);
		Match match = $(world).xpath(
				"//country[continent = 'Asia']"
		);
		match.unmarshal(Country.class)
		     .stream()
		     .sorted(Comparator.comparing(Country::getPopulation).reversed())
		     .forEach(System.out::println);
	}
}
