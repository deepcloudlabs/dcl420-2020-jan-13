package com.example;

import static org.joox.JOOX.$;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

import org.joox.Match;

import com.example.imdb.domain.Movie;
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
//		movieCollection.getMovies()
//		               .forEach(System.out::println);
		Match match = $(movieCollection).xpath(
				"//movie[number(year) >= 1970 " +
		        " and number(year) < 1980 " +
				" and genres/genre = 'Drama' ]"
		);
		match.unmarshal(Movie.class)
		     .forEach(System.out::println);
	}
}
