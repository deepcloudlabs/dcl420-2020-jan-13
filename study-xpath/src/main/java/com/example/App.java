package com.example;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import com.example.imdb.domain.MovieCollection;

public class App {
	public static void main(String[] args) throws Exception {
		// JAXB : Object <==> XML
		// Marshal: Object ==> XML
		// Unmarshal: XML ==> Object
		JAXBContext context = 
				JAXBContext.newInstance(MovieCollection.class);
		Unmarshaller unmarshaller = 
				context.createUnmarshaller();
		File file = new File("src/main/resources","movies.xml");
		MovieCollection movieCollection =
				(MovieCollection) unmarshaller.unmarshal(file);
		movieCollection.getMovies()
		               .forEach(System.out::println);
	}
}
