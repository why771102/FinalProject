package com.a.model;

import java.io.Serializable;
import java.sql.Blob;

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

import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name = "movies")
public class MovieBean implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer movieID;
	@Column(nullable=false, columnDefinition = "nvarchar(30)")
	String title;
	@Column(nullable=false, columnDefinition = "datetime")
	String contractDate;
	@Column(nullable=false)
	Integer expectedProfit;
	@Column(nullable=false, columnDefinition = "real")
	Double profitRatio;
	@Column(nullable=false, columnDefinition = "smallint")
	Integer runningTime;
	@Column(nullable=false, columnDefinition = "nvarchar(40)")
	String director;
	@Column(nullable=false, columnDefinition = "nvarchar(200)")
	String cast;
	@Transient
	Integer movieRating;
	@Transient
	Integer genre;
	@Column(nullable=false, columnDefinition = "varchar(max)")
	String trailer;
	@Column(nullable=false, columnDefinition = "nvarchar(max)")
	String plotSummary;
	@JsonIgnore
	Blob photo;
	@Transient
	Integer status;
	@JsonIgnore
	@Transient
	private MultipartFile	movieImage;  
	
	String fileName; 
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="genre")
	private GenreBean genreBean;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="movieRating")
	private MovieRatingBean movieRatingBean;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="movieStatus")
	private  MovieStatusBean movieStatusBean;
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public MultipartFile getMovieImage() {
		return movieImage;
	}

	public void setMovieImage(MultipartFile movieImage) {
		this.movieImage = movieImage;
	}

	public MovieBean() {}
	
	public MovieBean(Integer movieID, String title, String contractDate, Integer expectedProfit, Double profitRatio,
			Integer runningTime, String director, String cast, MovieRatingBean movieRatingBean, GenreBean genreBean, String trailer,
			String plotSummary, Blob photo,String fileName, MovieStatusBean movieStatusBean) {
		super();
		this.movieID = movieID;
		this.title = title;
		this.contractDate = contractDate;
		this.expectedProfit = expectedProfit;
		this.profitRatio = profitRatio;
		this.runningTime = runningTime;
		this.director = director;
		this.cast = cast;
		this.movieRatingBean = movieRatingBean;
		this.genreBean = genreBean;
		this.trailer = trailer;
		this.plotSummary = plotSummary;
		this.photo = photo;
		this.fileName = fileName;
		this.movieStatusBean = movieStatusBean;
	}

	public MovieBean(Integer movieID, String title, String contractDate, Integer expectedProfit, Double profitRatio,
			Integer runningTime, String director, String cast, Integer movieRating, Integer genre, String trailer,
			String plotSummary, Blob photo, String fileName, Integer status) {
		this.movieID = movieID;
		this.title = title;
		this.contractDate = contractDate;
		this.expectedProfit = expectedProfit;
		this.profitRatio = profitRatio;
		this.runningTime = runningTime;
		this.director = director;
		this.cast = cast;
		this.movieRating = movieRating;
		this.genre = genre;
		this.trailer = trailer;
		this.plotSummary = plotSummary;
		this.photo = photo;
		this.fileName = fileName;
		this.status = status;
	}

	public GenreBean getGenreBean() {
		return genreBean;
	}

	public void setGenreBean(GenreBean genreBean) {
		this.genreBean = genreBean;
	}

	public Integer getGenre() {
		return genre;
	}
	
	public void setGenre(Integer genre) {
		this.genre = genre;
	}

	public MovieRatingBean getMovieRatingBean() {
		return movieRatingBean;
	}

	public void setMovieRatingBean(MovieRatingBean movieRatingBean) {
		this.movieRatingBean = movieRatingBean;
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
	public String getContractDate() {
		return contractDate;
	}
	public void setContractDate(String contractDate) {
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
	public Integer getRunningTime() {
		return runningTime;
	}
	public void setRunningTime(Integer runningTime) {
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

	public MovieStatusBean getMovieStatusBean() {
		return movieStatusBean;
	}

	public void setMovieStatusBean(MovieStatusBean movieStatusBean) {
		this.movieStatusBean = movieStatusBean;
	}


	
	
}
