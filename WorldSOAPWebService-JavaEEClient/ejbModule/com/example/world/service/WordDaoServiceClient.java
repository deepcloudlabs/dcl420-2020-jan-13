package com.example.world.service;

import java.util.Comparator;

import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.xml.ws.WebServiceRef;

import com.example.world.dao.Country;
import com.example.world.dao.inmemory.InMemoryWorldDaoService;
import com.example.world.dao.inmemory.WorldDao;

@Stateless
public class WordDaoServiceClient {
	@WebServiceRef(type = WorldDao.class, value = InMemoryWorldDaoService.class)
	private WorldDao worldDao;

	@Schedule(hour = "*", minute = "*", second = "*/10", persistent = false)
	public void callService() {

		worldDao.findCountriesByContinent("Asia").stream().sorted(Comparator.comparing(Country::getName))
				.forEach(System.out::println);
	}
}
