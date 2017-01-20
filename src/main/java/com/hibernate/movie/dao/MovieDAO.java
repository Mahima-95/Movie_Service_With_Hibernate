package com.hibernate.movie.dao;

import java.util.List;

import com.hibernate.movie.pojo.Movie;

public interface MovieDAO {
	String addMovie(Movie movie);
	
	String deleteMovie(int movieId);
	
	public List<Movie>getMovie(Movie movie);
	
	String updateMovie(Movie movie);
}
