package com.example.app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

import com.example.world.entity.Country;

@SuppressWarnings("serial")
public class ReadCountriesFromJsonFileUsingJsonb {

	public static void main(String[] args) throws FileNotFoundException {
    	Jsonb jsonb = JsonbBuilder.create();
    	File file = new File("resources","countries.json");
    	InputStream inputStream = new FileInputStream(file);
    	List<Country> countries = 
    			 jsonb.fromJson(inputStream, 
    					 new ArrayList<Country>(){}
    			              .getClass()
    			              .getGenericSuperclass());
    	countries.forEach(System.out::println);
	}

}
