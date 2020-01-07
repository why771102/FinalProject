package com.c.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name="numberOfSeats")
public class NumberOfSeatsBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	Date date;
	Integer hallId;
	Integer noOfSeats;
	
	public NumberOfSeatsBean() {
		
	}
	
	public NumberOfSeatsBean(Date date, Integer hallId, Integer noOfSeats) {
		this.date = date;
		this.hallId = hallId;
		this.noOfSeats = noOfSeats;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="FK_Hall_id")
	public Integer getHallId() {
		return hallId;
	}
	public void setHallId(Integer hallId) {
		this.hallId = hallId;
	}
	public Integer getNoOfSeats() {
		return noOfSeats;
	}
	public void setNoOfSeats(Integer noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	
	
}
