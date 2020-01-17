package com.example;

import java.util.Arrays;

import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;

import com.example.imdb.entity.Director;
import com.example.imdb.entity.Genre;
import com.example.imdb.entity.Movie;

public class JsonpWriteJsonApp {

	public static void main(String[] args) {
		Movie movie = new Movie(1, "New Movie", 2020, "tt123456");
		Genre drama = new Genre(1, "Drama");
		Genre thriller = new Genre(2,"Thriller");
		movie.setGenres(Arrays.asList(drama,thriller));
		Director firstDirector = new Director(1, "Jack Bauer", "nm123456");
		Director secondDirector = new Director(2, "Kate Austen", "nm654321");
		movie.setDirectors(Arrays.asList(firstDirector ,secondDirector));
		JsonObjectBuilder objectBuilder = 
				Json.createObjectBuilder();
		objectBuilder.add("id", movie.getId());
		objectBuilder.add("title", movie.getTitle());
		objectBuilder.add("year", movie.getYear());
		JsonArrayBuilder arrayBuilder = 
				    Json.createArrayBuilder();
		movie.getGenres()
		     .stream()
		     .map(JsonpWriteJsonApp::createGenreJsonObject)
		     .forEach(arrayBuilder::add);
		objectBuilder.add("genres", arrayBuilder.build());
		movie.getDirectors()
		.stream()
		.map(JsonpWriteJsonApp::createDirectorJsonObject)
		     .forEach(arrayBuilder::add);
		objectBuilder.add("directors", arrayBuilder.build());
		JsonObject myJsonObj = objectBuilder.build();
		System.out.println(myJsonObj.toString());
	}
	public static JsonObject createGenreJsonObject(Genre genre) {
	    return Json.createObjectBuilder() 
	    		   .add("id", genre.getId())
		           .add("name", genre.getName())
		           .build();
	}
	public static JsonObject createDirectorJsonObject(Director director) {
		return Json.createObjectBuilder() 
				.add("id", director.getId())
				.add("name", director.getName())
				.add("imdb", director.getImdb())
				.build();
	}
}
