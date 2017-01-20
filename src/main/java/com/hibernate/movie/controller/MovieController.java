package com.hibernate.movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hibernate.movie.pojo.Movie;
import com.hibernate.movie.service.MovieService;

@RestController
public class MovieController {

	@Autowired
	private MovieService movieService;
	
	@RequestMapping(value="/addMovie")
	public String addMovie(){
		
		Movie movie = new Movie();
		System.out.println(movie);
		/*movie.setMovieId(3);
		movie.setMovieName("Dangal");
		movie.setMovieDirector("Nitesh Tiwari");
		movie.setMovieProducer("Aamir khan");
		movie.setMovieProductionAmount(11000000);*/
		return movieService.addMovie(movie);
	}
	
	@RequestMapping(value="/deleteMovie")
	public String deleteMovie(){
		return movieService.deleteMovie(2);
	}
	
	@RequestMapping(value="/getMovie")
	public List<Movie> getMovie(){
		Movie movie = new Movie();
		movie.getMovieId();
		return movieService.getMovie(movie);
	}
	
	@RequestMapping(value="/updateMovie")
	public String updateMovie(){
		Movie movie = new Movie();
		movie.setMovieId(1);
		movie.setMovieProductionAmount(22000002);
		return movieService.updateMovie(movie);
		
	}
}
