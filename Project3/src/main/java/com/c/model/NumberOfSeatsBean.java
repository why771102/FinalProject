package com.c.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.sun.istack.NotNull;

@Entity
@Table (name="numberOfSeats")
public class NumberOfSeatsBean implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@NotNull
	@Column(nullable=false, columnDefinition="DATE")
	String date;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="hallID")
	private HallBean hallBean;
	@NotNull
	@Column(nullable=false)
	Integer noOfSeats;
	
	@Transient
	private String hallID;
	
	public NumberOfSeatsBean() {
		
	}
	
	public NumberOfSeatsBean(String date, Integer noOfSeats, String hallID) {
		this.date = date;
		this.noOfSeats = noOfSeats;
		this.hallID = hallID;
	}

	public NumberOfSeatsBean(String date, HallBean hallBean, Integer noOfSeats) {
		this.date = date;
		this.hallBean = hallBean;
		this.noOfSeats = noOfSeats;
	}
	
	public String getHallID() {
		return hallID;
	}

	public void setHallID(String hallID) {
		this.hallID = hallID;
	}

	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public HallBean getHallBean() {
		return hallBean;
	}

	public void setHallBean(HallBean hallBean) {
		this.hallBean = hallBean;
	}

	public Integer getNoOfSeats() {
		return noOfSeats;
	}
	public void setNoOfSeats(Integer noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	
	
}
