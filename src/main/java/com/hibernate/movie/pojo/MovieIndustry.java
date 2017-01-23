package com.hibernate.movie.pojo;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "industry")
public class MovieIndustry {

	private int id;
	private String name;

	@Id
	@GeneratedValue
	@Column(name = "id")
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	private Set<Movie> moviess;

	@OneToMany(mappedBy = "industry", cascade = CascadeType.ALL)
	public Set<Movie> getMovie() {
		return moviess;
	}

	public void setMovie(Set<Movie> movie) {
		this.moviess = moviess;
	}

	public MovieIndustry() {
	}

	public MovieIndustry(String name) {
		this.name = name;
	}
}
