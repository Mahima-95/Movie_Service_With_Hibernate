package com.hibernate.movie.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import com.hibernate.movie.dao.MovieDAO;
import com.hibernate.movie.pojo.Movie;

@Repository
public class MovieDaoIMPL implements MovieDAO {

	private Session session;
	private Transaction transaction;

	public MovieDaoIMPL() {
		super();
	}

	@Autowired
	private SessionFactory sessionFactory;

	public String addMovie(Movie movie) {
		if (StringUtils.isEmpty(session) || !session.isOpen()) {
			session = getSession();
		}
		System.out.println(transaction);
		session.save(movie);
		transaction.commit();
		session.close();
		return "successfully added...!!!!";
	}

	private Session getSession() {
		session = sessionFactory.getCurrentSession();
		transaction = session.beginTransaction();
		return session;
	}

	public String deleteMovie(int movieId) {
		if (StringUtils.isEmpty(session) || !session.isOpen()) {
			session = getSession();
		}

		Movie movie = session.get(Movie.class, movieId);
		System.out.println(movie);
		session.delete(movie);
		transaction.commit();
		session.close();
		System.out.println("successfully deleted...!!!!");
		return "successfully deleted...!!!!";
	}

	public List<Movie> getMovie(Movie movie) {
		if (StringUtils.isEmpty(session) || !session.isOpen()) {
			session = getSession();
		}
		return session.createCriteria(Movie.class).list();
	}

	public String updateMovie(Movie movie) {
		String response = null;
		if (StringUtils.isEmpty(session) || !session.isOpen()) {
			session = getSession();
		}

		if (movie.getMovieId() > 0) {
			Movie movies = session.get(Movie.class, movie.getMovieId());
			if (!StringUtils.isEmpty(movies)) {
				if (!StringUtils.isEmpty(movie.getMovieName())) {
					movies.setMovieName(movie.getMovieName());
				}
				if (!StringUtils.isEmpty(movie.getMovieDirector())) {
					movies.setMovieDirector(movie.getMovieDirector());
				}
				if (!StringUtils.isEmpty(movie.getMovieProducer())) {
					movies.setMovieProducer(movie.getMovieProducer());
				}
				if (!StringUtils.isEmpty(movie.getMovieProductionAmount())) {
					movies.setMovieProductionAmount(movie
							.getMovieProductionAmount());
				}
				try {
					session.update(movies);
					transaction.commit();
					response = "Successfully updated..!!!";
				} catch (Exception exception) {
					response = "Exception occurs..!!!";
					exception.printStackTrace();
				} finally {
					session.close();
				}
			}
		} else {
			response = "No movie exists for given Id";
		}
		return response;
	}
}
