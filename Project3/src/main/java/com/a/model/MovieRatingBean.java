package com.a.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movieRating")
public class MovieRatingBean implements Serializable {
	
	@Id
	@Column(nullable=false,columnDefinition="TINYINT")
	Integer movieRatingID;
	@Column(nullable=false,columnDefinition="TINYINT")
	Integer age;
	@Column(nullable=false, columnDefinition="NVARCHAR(10)")
	String rating;
	
	public MovieRatingBean(Integer movieRatingID, Integer age, String rating) {
		super();
		this.movieRatingID = movieRatingID;
		this.age = age;
		this.rating = rating;
		
	}
	public Integer getMovieRatingID() {
		return movieRatingID;
	}
	public void setMovieRatingID(Integer movieRatingID) {
		this.movieRatingID = movieRatingID;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getrating() {
		return rating;
	}
	public void setrating(String rating) {
		this.rating = rating;
	}
	
	
	
	
}