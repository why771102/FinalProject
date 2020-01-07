package com.t.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.a.model.MovieBean;


@Entity
@Table(name="Expectation")
public class ExpectationBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	Integer expectation;
//	Integer movieID;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="movieID")
	private MovieBean movieID;		

	public MovieBean getMovieID() {
		return movieID;
	}

	public void setMovieID(MovieBean movieID) {
		this.movieID = movieID;
	}


	public Integer getExpectation() {
		return expectation;
	}

	public void setExpectation(Integer expectation) {
		this.expectation = expectation;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}