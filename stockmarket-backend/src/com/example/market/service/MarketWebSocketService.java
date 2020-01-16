package com.example.market.service;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.ejb.Singleton;
import javax.enterprise.event.ObservesAsync;
import javax.json.Json;
import javax.json.JsonObjectBuilder;
import javax.websocket.OnClose;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import com.example.market.domain.Order;

@Singleton
@ServerEndpoint("/stream")
public class MarketWebSocketService {
	private Map<String,Session> sessions = 
			   new ConcurrentHashMap<>();
	
	@OnOpen
	public void connected(Session session) {
		sessions.put(session.getId(), session);
	}
	
	@OnClose
	public void disconnected(Session session) {
		sessions.remove(session.getId());
	}
	
	public void listenOrder(@ObservesAsync Order order) {
		sessions.forEach( (id,session) -> {
			try {
				String json = getOrderAsJson(order);
				session.getBasicRemote().sendText(json);
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
		});
	}

	private String getOrderAsJson(Order order) {
		// JSON Processing (JSON-P: Java EE 7)
		JsonObjectBuilder builder = Json.createObjectBuilder();
		builder.add("symbol", order.getSymbol());
		builder.add("price", order.getPrice());
		builder.add("quantity", order.getQuantity());
		return builder.build().toString();
	}
}
