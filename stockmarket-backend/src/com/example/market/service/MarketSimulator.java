package com.example.market.service;

import java.util.concurrent.ThreadLocalRandom;

import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;

import com.example.market.domain.Order;

@Stateless
public class MarketSimulator {
	@Inject
	private Event<Order> event;

	@Schedule(hour = "*", minute = "*", second = "*/1")
	public void sendOrder() {
		double price = ThreadLocalRandom.current().nextDouble(100.0, 120.0);
		double quantity = ThreadLocalRandom.current().nextDouble(1000.0, 10000.0);

		Order newOrder = new Order("ORCL", price, quantity);
		event.fireAsync(newOrder); // fire-and-forget
	}
}
