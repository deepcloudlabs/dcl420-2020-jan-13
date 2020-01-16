package com.example.market.app;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.WebSocket;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.TimeUnit;

public class WebsocketClientApp {

	public static void main(String[] args) throws InterruptedException {
		HttpClient client = HttpClient.newHttpClient();
		
		WebSocket.Builder builder = client.newWebSocketBuilder();
		builder.buildAsync(
			URI.create("ws://localhost:8080/stockmarket-backend/stream"),
			new WebSocket.Listener() {

				@Override
				public CompletionStage<?> onText(
						WebSocket webSocket, 
						CharSequence data, boolean last) {
					webSocket.request(1);
					return CompletableFuture.completedFuture(data)
							    .thenAccept(System.out::println);
				}
				
			}
		).join();
		TimeUnit.SECONDS.sleep(60);
	}

}
