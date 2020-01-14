package com.example.world.app;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Comparator;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.example.world.dao.Country;
import com.example.world.dao.inmemory.WorldDao;

public class WorldApp {
	private final static QName SERVICE_QNAME = new QName("http://inmemory.dao.world.example.com/",
			"InMemoryWorldDaoService");
	private static URL url = null;
	static {
		try {
			url = new URL("http://localhost:8080/ImdbSOAPWebService/InMemoryWorldDaoService.wsdl");
		} catch (MalformedURLException ex) {
		}
	}

	public static void main(String[] args) {
		Service service = Service.create(url, SERVICE_QNAME);
		WorldDao port = service.getPort(WorldDao.class);
		port.findCountriesByContinent("Asia")
		    .stream()
		    .sorted(Comparator.comparing(Country::getName))
		    .forEach(System.out::println);
	}
}
