package com.example.app;

import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import com.example.parser.ContinentStatisticsHandler;

public class SaxParserApp {

	public static void main(String[] args) throws Exception {
		SAXParserFactory saxParserFactory = 
				SAXParserFactory.newInstance();
	
		SAXParser saxParser = saxParserFactory.newSAXParser();
		saxParser.parse(new File("resources", "countries.xml"),
				new ContinentStatisticsHandler());	
	}

}
