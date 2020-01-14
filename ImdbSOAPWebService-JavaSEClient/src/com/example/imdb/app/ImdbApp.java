package com.example.imdb.app;

import java.net.MalformedURLException;
import java.net.URL;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;

import com.example.imdb.CriteriaBean;
import com.example.imdb.ImdbSoapService;

// wsimport -s src http://localhost:8080/ImdbSOAPWebService/Imdb.wsdl
// wsimport -s src resources\Imdb.wsdl
public class ImdbApp {
    private final static QName _Search_QNAME = new QName("http://www.example.com/imdb", "Imdb");
    private static URL url = null ; 
    static {
    	try {
			url = new URL("http://localhost:8080/ImdbSOAPWebService/Imdb.wsdl");
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
    }
    
	public static void main(String[] args) {
		Service service = Service.create(url, _Search_QNAME);
		ImdbSoapService port = 
				service.getPort(ImdbSoapService.class);
		CriteriaBean criteria = new CriteriaBean();
		criteria.setYearRangeSelected(true);
		criteria.setFrom(1970);
		criteria.setTo(1979);
		criteria.setGenreSelected(true);
		criteria.setGenre(2);
		port.search(criteria)
		    .forEach(movie -> System.out.println(movie.getTitle()));
	}
}
