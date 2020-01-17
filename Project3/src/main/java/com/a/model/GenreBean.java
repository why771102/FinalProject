package com.a.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "genre")
public class GenreBean implements Serializable {
	
	@Id
	@Column(nullable=false)
	Integer genreID;
	@Column(nullable=false)
	String  genre;
	
	
	
	
	public GenreBean(Integer genreID, String genre) {
		super();
		this.genreID = genreID;
		this.genre = genre;
	}
	public Integer getGenreID() {
		return genreID;
	}
	public void setGenreID(Integer genreID) {
		this.genreID = genreID;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	
	
}