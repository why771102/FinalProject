package com.c.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class ReservedSeatsBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Date date;
	Integer showTimeId;
	String seatId;
	Integer seatReservationStatus;
	
	
	public ReservedSeatsBean() {
		
	}
	
	public ReservedSeatsBean(Date date, Integer showTimeId, String seatId, Integer seatReservationStatus) {
		this.date = date;
		this.showTimeId = showTimeId;
		this.seatId = seatId;
		this.seatReservationStatus = seatReservationStatus;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "showTimeId")
	public Integer getShowTimeId() {
		return showTimeId;
	}
	public void setShowTimeId(Integer showTimeId) {
		this.showTimeId = showTimeId;
	}
	public String getSeatId() {
		return seatId;
	}
	public void setSeatId(String seatId) {
		this.seatId = seatId;
	}
	public Integer getSeatReservationStatus() {
		return seatReservationStatus;
	}
	public void setSeatReservationStatus(Integer seatReservationStatus) {
		this.seatReservationStatus = seatReservationStatus;
	}
	
	
}
