package com.example.market.resources;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

import javax.inject.Singleton;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.sse.OutboundSseEvent;
import javax.ws.rs.sse.Sse;
import javax.ws.rs.sse.SseBroadcaster;
import javax.ws.rs.sse.SseEventSink;

import com.example.market.domain.Order;

@Path("/orders")
@Singleton
public class OrderResource {
	private Map<String,SseEventSink> eventSinks
	                   = new ConcurrentHashMap<>();
	private SseBroadcaster broadcaster;
	
	@GET 
	@Path("subscribe")
	@Produces(MediaType.SERVER_SENT_EVENTS)
	public void subscribe(@Context SseEventSink ses,
			@Context Sse sse,
			@QueryParam("user") String user) {
		System.out.println("New subscriber has arrived!");
		eventSinks.put(user, ses);
		synchronized (this) {
			if (Objects.isNull(broadcaster)) {
				broadcaster = sse.newBroadcaster();
			}
		}
		broadcaster.register(ses);
	}
	
	@POST
	public Order connect(Order order,@Context Sse sse) {
		eventSinks.forEach((user,ses) -> {
			OutboundSseEvent event =
					sse.newEventBuilder()
					   .name("marketdata")
					   .id(String.valueOf(order.hashCode()))
					   .mediaType(MediaType.APPLICATION_JSON_TYPE)
					   .data(Order.class, order)
					   .reconnectDelay(1000)
					   .comment("real time market data")
					   .build();
			broadcaster.broadcast(event);
//			if ("jack".equals(user))
//				eventSinks.get("jack").send(event);
		});
		return order;
	}
}
