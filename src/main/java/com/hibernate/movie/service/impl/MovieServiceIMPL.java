package com.hibernate.movie.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hibernate.movie.dao.MovieDAO;
import com.hibernate.movie.pojo.Movie;
import com.hibernate.movie.service.MovieService;

@Service
public class MovieServiceIMPL implements MovieService {

	@Autowired
	private MovieDAO movieDAO;

	public String addMovie(Movie movie) {

		return movieDAO.addMovie(movie);
	}

	public String deleteMovie(int movieId) {
		return movieDAO.deleteMovie(movieId);
	}

	public List<Movie> getMovie(Movie movie) {
		return movieDAO.getMovie(movie);
	}

	public String updateMovie(Movie movie) {
		return movieDAO.updateMovie(movie);
	}

}
