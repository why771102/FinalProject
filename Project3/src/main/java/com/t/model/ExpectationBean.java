package com.t.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.a.model.MovieBean;
import com.sun.istack.NotNull;


@Entity
@Table(name="Expectation")
public class ExpectationBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@NotNull
	@Column(nullable=false)
	Integer expective;
	@NotNull
	@Column(nullable=false)
	Integer unexpective;
//	Integer movieID;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="movieID")
	private MovieBean movieID;	
	
	public ExpectationBean(Integer expective, Integer unexpective, MovieBean movieID) {
		this.expective = expective;
		this.unexpective = unexpective;
		this.movieID = movieID;
	}
	
	public ExpectationBean() {
		
	}

	public MovieBean getMovieID() {
		return movieID;
	}

	public void setMovieID(MovieBean movieID) {
		this.movieID = movieID;
	}


	public Integer getExpective() {
		return expective;
	}

	public void setExpective(Integer expective) {
		this.expective = expective;
	}
	
	public Integer getUnexpect() {
		return unexpective;
	}

	public void setUnexpect(Integer unexpective) {
		this.unexpective = unexpective;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}