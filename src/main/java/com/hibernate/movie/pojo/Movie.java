package com.hibernate.movie.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "movie")
public class Movie {

	private int movieId;
	/*@Column(name = "movieName", nullable = false)*/
	private String movieName;
	/*@Column(name = "movieDirector", nullable = false)*/
	private String movieDirector;
	/*@Column(name = "movieProducer", nullable = true)*/
	private String movieProducer;
	/*@Column(name = "movieProductionAmount", nullable = true)*/
	private double movieProductionAmount;

	private MovieIndustry movieIndustry;

	@Id
	@Column(name = "movieId")
	@GeneratedValue
	public int getMovieId() {
		return movieId;
	}

	@ManyToOne
	@JoinColumn(name = "id")
	public MovieIndustry getMovieIndustry() {
		return movieIndustry;
	}

	public Movie() {

	}

	public Movie(String movieName, String movieDirector, String movieProducer, double movieProductionAmount,
			MovieIndustry movieIndustry) {
		super();
		this.movieName = movieName;
		this.movieDirector = movieDirector;
		this.movieProducer = movieProducer;
		this.movieProductionAmount = movieProductionAmount;
		this.movieIndustry = movieIndustry;
	}

	public void setMovieIndustry(MovieIndustry movieIndustry) {
		this.movieIndustry = movieIndustry;
	}

	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getMovieDirector() {
		return movieDirector;
	}

	public void setMovieDirector(String movieDirector) {
		this.movieDirector = movieDirector;
	}

	public String getMovieProducer() {
		return movieProducer;
	}

	public void setMovieProducer(String movieProducer) {
		this.movieProducer = movieProducer;
	}

	public double getMovieProductionAmount() {
		return movieProductionAmount;
	}

	public void setMovieProductionAmount(double movieProductionAmount) {
		this.movieProductionAmount = movieProductionAmount;
	}

}
