package com.example;

import static java.util.stream.Collectors.toList;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Collection;
import java.util.List;

import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.JsonValue;

import com.example.world.entity.City;
import com.example.world.entity.Country;

public class JsonpReadJsonApp {
	public static void main(String[] args) throws FileNotFoundException {
		File file= new File("src/main/resources","countries.json");
		InputStream input = new FileInputStream(file);
		JsonReader jsonReader = Json.createReader(input);
		JsonArray countries = jsonReader.readArray();
		System.out.println("# of countries: "+countries.size());
		List<Country> worldCountries = 
				countries.stream()
		         .map(JsonpReadJsonApp::convert)
		         .collect(toList());
		worldCountries.forEach(System.out::println);
	}
	public static Country convert(JsonValue country) {
		Country worldCountry = new Country();
		JsonObject jsonObject = country.asJsonObject();
		System.err.println(jsonObject);
		worldCountry.setCode(jsonObject.getString("_id"));
		worldCountry.setName(jsonObject.getString("name"));
		worldCountry.setPopulation(jsonObject.getInt("population"));
		worldCountry.setSurfaceArea(jsonObject.getJsonNumber("population").doubleValue());
		if (jsonObject.containsKey("capital"))
		worldCountry.setCapital(jsonObject.getInt("capital"));
		worldCountry.setContinent(jsonObject.getString("continent"));
		worldCountry.setGnp(jsonObject.getJsonNumber("gnp").doubleValue());
		JsonArray cities = jsonObject.getJsonArray("cities");
		Collection<City> convertedCities = convertCities(cities);
		String countryCode = worldCountry.getCode();
		convertedCities.forEach(city -> city.setCountryCode(countryCode));
		worldCountry.getCities().addAll(convertedCities);
		return worldCountry;		
	}
	private static Collection<City> convertCities(JsonArray cities) {
		return cities.stream()
		         .map(JsonpReadJsonApp::convertCity)
		         .collect(toList());
	}
	private static City convertCity(JsonValue city) {
		JsonObject jo = city.asJsonObject();
		City countryCity = new City();
		countryCity.setId(jo.getInt("_id"));
		countryCity.setName(jo.getString("name"));
		countryCity.setPopulation(jo.getInt("population"));
		return countryCity;
	}
}
