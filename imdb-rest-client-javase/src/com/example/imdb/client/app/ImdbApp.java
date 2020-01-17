package com.example.imdb.client.app;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class ImdbApp {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception {
		HttpClient client = HttpClient.newHttpClient();
		long start = System.currentTimeMillis();
		IntStream.range(1,200)
		         .forEach( id -> {
		String resourceUri = "http://localhost:8080/imdb-rest-api/api/v1/movies/"
		         + id ;
		HttpRequest requestForJson = 
				HttpRequest.newBuilder()
				           .uri(URI.create(resourceUri))
				           .header("Accept", "application/json")
				           .build();
		HttpRequest requestForXml = 
				HttpRequest.newBuilder()
				.uri(URI.create(resourceUri))
				.header("Accept", "application/xml")
				.build();
			client.sendAsync(requestForXml,
						HttpResponse.BodyHandlers.ofString())
			   .thenApply(HttpResponse::body)
			   .thenAccept(System.out::println);
      });
		long stop = System.currentTimeMillis();
		System.out.println("Duration : "+(stop-start)+" ms.");
		TimeUnit.SECONDS.sleep(10);
	}

}
