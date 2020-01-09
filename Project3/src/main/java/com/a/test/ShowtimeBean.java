package com.a.test;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.sun.istack.NotNull;

//不存進DB

public class ShowtimeBean implements Serializable {
	private static final long serialVersionUID = 1L;
    
	Integer runID;
	Integer movieID;
	String title;
	LocalDate release;
    int runningTime;
	Integer expectedOnDay;
	LocalDate expectedOffDate;
	
	public ShowtimeBean() {}
	
	

	public ShowtimeBean(Integer runID, Integer movieID, String title, LocalDate release, int runningTime,
			Integer expectedOnDay, LocalDate expectedOffDate) {
		super();
		this.runID = runID;
		this.movieID = movieID;
		this.title = title;
		this.release = release;
		this.runningTime = runningTime;
		this.expectedOnDay = expectedOnDay;
		this.expectedOffDate = expectedOffDate;
	}



	public Integer getRunID() {
		return runID;
	}

	public void setRunID(Integer runID) {
		this.runID = runID;
	}

	public Integer getMovieID() {
		return movieID;
	}

	public void setMovieID(Integer movieID) {
		this.movieID = movieID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public LocalDate getRelease() {
		return release;
	}

	public void setRelease(LocalDate release) {
		this.release = release;
	}

	public int getRunningTime() {
		return runningTime;
	}

	public void setRunningTime(int runningTime) {
		this.runningTime = runningTime;
	}

	public Integer getExpectedOnDay() {
		return expectedOnDay;
	}

	public void setExpectedOnDay(Integer expectedOnDay) {
		this.expectedOnDay = expectedOnDay;
	}

	public LocalDate getExpectedOffDate() {
		return expectedOffDate;
	}

	public void setExpectedOffDate(LocalDate expectedOffDate) {
		this.expectedOffDate = expectedOffDate;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
	
	
	
}
