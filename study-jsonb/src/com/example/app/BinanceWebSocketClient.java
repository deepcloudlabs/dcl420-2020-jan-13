package com.example.app;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.WebSocket;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;
import java.util.concurrent.TimeUnit;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.json.bind.JsonbException;

import com.example.binance.dto.Trade;

public class BinanceWebSocketClient {

	public static void main(String[] args) throws InterruptedException {
		HttpClient client = HttpClient.newHttpClient();
		
		WebSocket.Builder builder = client.newWebSocketBuilder();
		builder.buildAsync(
			URI.create("wss://stream.binance.com:9443/ws/btcusdt@trade"),
			new WebSocket.Listener() {

				@Override
				public CompletionStage<?> onText(
						WebSocket webSocket, 
						CharSequence data, boolean last) {
					webSocket.request(1);
					return CompletableFuture.completedFuture(data)
							    .thenAccept( json -> {
							    	System.err.println(json);
							    	Jsonb jsonb = JsonbBuilder.create();
							    	Trade trade;
									try {
										trade = jsonb.fromJson(json.toString(), Trade.class);
										System.err.println(trade);
									} catch (JsonbException e) {
										e.printStackTrace(System.err);
										System.exit(1);
									}
							    });
				}
				
			}
		).join();
		TimeUnit.SECONDS.sleep(60);

	}

}
