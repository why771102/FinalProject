package com.a.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.sun.istack.NotNull;

//參考：https://blog.csdn.net/MurcielagoAN/article/details/43966209
@Entity
@Table(name = "running" )
public class RunningBean implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer runID;
//	Integer movieID;(FK)
	@Column(nullable=false,columnDefinition = "datetime")
	String release;
	@Column(nullable=false, columnDefinition = "TINYINT")
	Integer expectedOnDate;
	@Column(nullable=false, columnDefinition = "TINYINT")
	Integer onDate;
	@Column(nullable=false,columnDefinition = "datetime")
	String expectedOffDate;
	@Column(nullable=false,columnDefinition = "datetime")
	String offDate;
	@Column(nullable=false, columnDefinition = "TINYINT")
	Integer status;
	
	@Transient
	Integer movieID;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="movieID")
	private MovieBean movie;
	
	public RunningBean() {
	}
//有movieBean
	public RunningBean(Integer runID, String release, Integer expectedOnDate, Integer onDate, String expectedOffDate,
			String offDate, Integer status, MovieBean movie) {
		super();
		this.runID = runID;
		this.release = release;
		this.expectedOnDate = expectedOnDate;
		this.onDate = onDate;
		this.expectedOffDate = expectedOffDate;
		this.offDate = offDate;
		this.status = status;
		this.movie = movie;
	}
	//沒有runID
	public RunningBean( String release, Integer expectedOnDate, Integer onDate, String expectedOffDate,
			String offDate, Integer status, MovieBean movie) {
		super();
		this.release = release;
		this.expectedOnDate = expectedOnDate;
		this.onDate = onDate;
		this.expectedOffDate = expectedOffDate;
		this.offDate = offDate;
		this.status = status;
		this.movie = movie;
	}
	
	//如果沒有movieBean 只有movieID
	public RunningBean(Integer runID, String release, Integer expectedOnDate, Integer onDate, String expectedOffDate,
			String offDate, Integer status, Integer movieID) {
		super();
		this.runID = runID;
		this.release = release;
		this.expectedOnDate = expectedOnDate;
		this.onDate = onDate;
		this.expectedOffDate = expectedOffDate;
		this.offDate = offDate;
		this.status = status;
		this.movieID = movieID;
	}
	
	public Integer getMovieID() {
		return movieID;
	}

	public void setMovieID(Integer movieID) {
		this.movieID = movieID;
	}


	public Integer getRunID() {
		return runID;
	}

	public void setRunID(Integer runID) {
		this.runID = runID;
	}

	public String getRelease() {
		return release;
	}

	public void setRelease(String release) {
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

	public String getExpectedOffDate() {
		return expectedOffDate;
	}

	public void setExpectedOffDate(String expectedOffDate) {
		this.expectedOffDate = expectedOffDate;
	}

	public String getOffDate() {
		return offDate;
	}

	public void setOffDate(String offDate) {
		this.offDate = offDate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public MovieBean getMovie() {
		return movie;
	}

	public void setMovie(MovieBean movie) {
		this.movie = movie;
	}
	
	

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	
	
	
}
