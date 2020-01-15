package com.example.imdb.service;

import java.util.concurrent.CompletableFuture;

import javax.annotation.Resource;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.enterprise.concurrent.ManagedExecutorService;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

@Stateless
public class RestClientService {
	@Resource
	private ManagedExecutorService mes;
	
	private static int id = 1 ;
	@Schedule(hour = "*", minute = "*", second = "*/1")
	public void callImdbRestApi() {
		CompletableFuture.supplyAsync( () -> {
			Client client = ClientBuilder.newClient();
			WebTarget target = client.target("http://localhost:8080/imdb-rest-api/api/v1/movies/"+id++%200);
			
			String response = target.request("application/json")
					                .get(String.class);
			return response;
		},mes).thenAccept(System.out::println);
	}
}
