package com.a.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//參考：https://blog.csdn.net/MurcielagoAN/article/details/43966209
@Entity
@Table(name = "running" )
public class runningBean implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer runID;
//	Integer movieID;
	Timestamp release;
	Integer expectedOnDate;
	Integer onDate;
	Timestamp expectedOffDate;
	Timestamp offDate;
	Integer status;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="movieID")
	private MovieBean movie;
	
	public runningBean() {
	};

	public runningBean(Integer runID, MovieBean movie, Timestamp release, Integer expectedOnDate, Integer onDate,
			Timestamp expectedOffDate, Timestamp offDate, Integer status) {
		this.runID = runID;
		this.movie = movie;
		this.release = release;
		this.expectedOnDate = expectedOnDate;
		this.onDate = onDate;
		this.expectedOffDate = expectedOffDate;
		this.offDate = offDate;
		this.status = status;
	}

	public MovieBean getMovie() {
		return movie;
	}

	public void setMovie(MovieBean movie) {
		this.movie = movie;
	}

	public Integer getRunID() {
		return runID;
	}

	public void setRunID(Integer runID) {
		this.runID = runID;
	}

//	public Integer getMovieID() {
//		return movie;
//	}
//
//	public void setMovieID(Integer movieID) {
//		this.movie = movieID;
//	}

	public Timestamp getRelease() {
		return release;
	}

	public void setRelease(Timestamp release) {
		this.release = release;
	}

	public Integer getExpectedOnDate() {
		return expectedOnDate;
	}

	public void setExpectedOnDate(Integer expectedOnDate) {
		this.expectedOnDate = expectedOnDate;
	}

	public Integer getOnDate() {
		return onDate;
	}

	public void setOnDate(Integer onDate) {
		this.onDate = onDate;
	}

	public Timestamp getExpectedOffDate() {
		return expectedOffDate;
	}

	public void setExpectedOffDate(Timestamp expectedOffDate) {
		this.expectedOffDate = expectedOffDate;
	}

	public Timestamp getOffDate() {
		return offDate;
	}

	public void setOffDate(Timestamp offDate) {
		this.offDate = offDate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	
}
