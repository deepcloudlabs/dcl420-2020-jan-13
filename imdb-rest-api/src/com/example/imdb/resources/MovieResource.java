package com.example.imdb.resources;

import java.util.Collection;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.example.imdb.entity.Director;
import com.example.imdb.entity.Movie;
import com.example.imdb.service.MovieService;

// http://localhost:8080/imdb/api/v1/movies
@Path("/movies")
@RequestScoped
public class MovieResource {
	@Inject private MovieService movieSrv;
	
    // GET http://localhost:8080/imdb/api/v1/movies/1
	@GET
	@Path("{id}")
	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
	public Movie elma(@PathParam("id") int id) {
		int wait = ThreadLocalRandom.current().nextInt(2, 6);
		try {
			TimeUnit.SECONDS.sleep(wait);
		} catch (InterruptedException e) { }
		return movieSrv.findMovieById(id);
	}

//	// GET http://localhost:8080/imdb/api/v1/movies/1
//	@POST
//	@Path("criteria")
//	@Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
//	@Consumes(MediaType.APPLICATION_JSON)
//	public Collection<Movie> bulgetir(CriteriaBean criteria) {
//		return movieSrv.findAllMoviesByYearRange(from, to);
//	}
	
	// GET http://localhost:8080/imdb/api/v1/movies/1/directors
	@GET
	@Path("{id}/directors")
	@Produces({MediaType.APPLICATION_JSON})
	public Collection<Director> armut(@PathParam("id") int id) {
		return movieSrv.findMovieById(id).getDirectors();
	}
	
	// GET http://localhost:8080/imdb/api/v1/movies/1/directors/1
	@GET
	@Path("{id}/directors/{seq}")
	@Produces({MediaType.APPLICATION_JSON})
	public Director kiraz(@PathParam("id") int id,
			@PathParam("seq") int seq) {
		return movieSrv.findMovieById(id)
				       .getDirectors()
				       .get(seq);
	}
	
}
