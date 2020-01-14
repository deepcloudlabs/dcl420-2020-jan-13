package com.example.parser;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ContinentStatisticsHandler extends DefaultHandler {
	private String tag;
	private Map<String, Integer> continents = new HashMap<>();

	@Override
	public void startDocument() throws SAXException {
		System.out.println("Parsing is started.");
		continents.clear();
	}

	@Override
	public void endDocument() throws SAXException {
		System.out.println("Parsing is done.");
		continents.forEach((continent,count) -> 
		     System.out.println(continent + ": "+count)
		);
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		tag = qName;
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if ("continent".equals(tag)) {
			if (Character.isWhitespace(ch[start]))
				return;
			String continent = String.copyValueOf(ch, start, length);
			Integer count = continents.get(continent);
			if (Objects.isNull(count)) {
				continents.put(continent, 1);
			} else {
				continents.put(continent, count + 1);
			}
		}
	}

}
