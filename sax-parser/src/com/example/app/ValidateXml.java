package com.example.app;

import java.io.File;

import javax.xml.XMLConstants;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;

import org.w3c.dom.Document;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

public class ValidateXml {
	static final String JAXP_SCHEMA_LANGUAGE = "http://java.sun.com/xml/jaxp/properties/schemaLanguage";

	static final String W3C_XML_SCHEMA = "http://www.w3.org/2001/XMLSchema";

	static final String JAXP_SCHEMA_SOURCE = "http://java.sun.com/xml/jaxp/properties/schemaSource";

	@SuppressWarnings("unused")
	public static void main(String[] args) throws Exception {

		// Create schema to validate
		File xsdFile = new File("resources", "otomobil.xsd");
		SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema = schemaFactory.newSchema(xsdFile);
		Validator validator = schema.newValidator();
		validator.validate(new StreamSource("resources/otomobil.xml"));

		// Create a validating parser
		DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
		docBuilderFactory.setValidating(true);
		docBuilderFactory.setNamespaceAware(true);
		docBuilderFactory.setSchema(schema);

		DocumentBuilder documentBuilder = docBuilderFactory.newDocumentBuilder();
		documentBuilder.setErrorHandler(new ErrorHandler() {

			@Override
			public void warning(SAXParseException exception) throws SAXException {
				System.err.println(exception.getLineNumber() + ": " + exception.getMessage());
			}

			@Override
			public void fatalError(SAXParseException exception) throws SAXException {
				System.err.println(exception.getLineNumber() + ": " + exception.getMessage());
			}

			@Override
			public void error(SAXParseException exception) throws SAXException {
				System.err.println(exception.getLineNumber() + ": " + exception.getMessage());
			}
		});
		File xmlFile = new File("resources", "otomobil.xml");
		Document document = documentBuilder.parse(xmlFile);

		SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
		saxParserFactory.setValidating(true);
		saxParserFactory.setNamespaceAware(true);
		SAXParser saxParser = saxParserFactory.newSAXParser();

		saxParser.setProperty(JAXP_SCHEMA_LANGUAGE, W3C_XML_SCHEMA);
		saxParser.parse(new File("resources", "otomobil.xml"), new DefaultHandler());

	}

}
