package com.example.service;

import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.xml.ws.WebServiceRef;

import com.example.imdb.CriteriaBean;
import com.example.imdb.Imdb;
import com.example.imdb.ImdbSoapService;

@Stateless
public class ImdbWebServiceClient {
	@WebServiceRef(type=ImdbSoapService.class,value=Imdb.class)
	private ImdbSoapService imdbSoapService;
	
	@Schedule(hour = "*", minute = "*", second = "*/10",persistent = false)
	public void callService() {
		CriteriaBean criteria = new CriteriaBean();
		criteria.setYearRangeSelected(true);
		criteria.setFrom(1970);
		criteria.setTo(1979);
		criteria.setGenreSelected(true);
		criteria.setGenre(2);
		imdbSoapService.search(criteria)
		    .forEach(movie -> System.out.println(movie.getTitle()));
	}
}
