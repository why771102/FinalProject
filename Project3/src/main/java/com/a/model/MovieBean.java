package com.a.model;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.eclipse.persistence.jpa.jpql.parser.DateTime;



@Entity
@Table(name = "movies")
public class MovieBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer movieID;
	String title;
	Timestamp contractDate;
	Integer expectedProfit;
	Double profitRatio;
	Timestamp runningTime;
	String director;
	String cast;
	Integer movieRating;
	String genre;
	String trailer;
	String plotSummary;
	Blob photo;
	Integer status;

	public MovieBean() {

	};

	public MovieBean(Integer movieID, String title, Timestamp contractDate, Integer expectedProfit, Double profitRatio,
			Timestamp runningTime, String director, String cast, Integer plotSummary, String genre, String trailer,
			String plotSummary1, Blob photo, Integer status) {
		
		this.movieID = movieID;
		this.title = title;
		this.contractDate = contractDate;
		this.expectedProfit = expectedProfit;
		this.runningTime =runningTime;
		this.profitRatio =profitRatio;
		this.director =director;
		this.cast =cast;
		this.movieRating = movieRating;
		this.genre =genre;
		this.trailer =trailer;
		this.plotSummary = plotSummary1;
		this.photo =photo;
		this.status =status;
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

	public Timestamp getContractDate() {
		return contractDate;
	}

	public void setContractDate(Timestamp contractDate) {
		this.contractDate = contractDate;
	}

	public Integer getExpectedProfit() {
		return expectedProfit;
	}

	public void setExpectedProfit(Integer expectedProfit) {
		this.expectedProfit = expectedProfit;
	}

	public Double getProfitRatio() {
		return profitRatio;
	}

	public void setProfitRatio(Double profitRatio) {
		this.profitRatio = profitRatio;
	}

	public Timestamp getRunningTime() {
		return runningTime;
	}

	public void setRunningTime(Timestamp runningTime) {
		this.runningTime = runningTime;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getCast() {
		return cast;
	}

	public void setCast(String cast) {
		this.cast = cast;
	}

	public Integer getMovieRating() {
		return movieRating;
	}

	public void setMovieRating(Integer movieRating) {
		this.movieRating = movieRating;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public String getTrailer() {
		return trailer;
	}

	public void setTrailer(String trailer) {
		this.trailer = trailer;
	}

	public String getPlotSummary() {
		return plotSummary;
	}

	public void setPlotSummary(String plotSummary) {
		this.plotSummary = plotSummary;
	}

	public Blob getPhoto() {
		return photo;
	}

	public void setPhoto(Blob photo) {
		this.photo = photo;
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
