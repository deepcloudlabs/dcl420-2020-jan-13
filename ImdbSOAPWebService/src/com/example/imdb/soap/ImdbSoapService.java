package com.example.imdb.soap;

import java.util.Collection;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;

import com.example.imdb.entity.Movie;
import com.example.imdb.model.CriteriaBean;
import com.example.imdb.service.MovieService;

@WebService(targetNamespace = "http://www.example.com/imdb",serviceName = "Imdb")
public class ImdbSoapService {
	@Inject private MovieService movieSrv;
	
	@WebMethod(operationName = "search")
	public Collection<Movie> findMoviesByCriteria(
			@WebParam(name = "criteria")
			@XmlElement(required = true) CriteriaBean criteria){
		return movieSrv.findAllMoviesByCriteria(criteria);
	}
}
