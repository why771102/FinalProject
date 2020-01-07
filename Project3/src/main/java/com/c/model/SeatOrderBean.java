package com.c.model;

import java.io.Serializable;
import java.sql.Date;

public class SeatOrderBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	Date date;
	Integer showTimeID;
	String seatId;
	
	public SeatOrderBean() {
		
	}
	
	public SeatOrderBean(Date date, Integer showTimeID, String seatId) {
		this.date = date;
		this.showTimeID = showTimeID;
		this.seatId = seatId;
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public Integer getShowTimeID() {
		return showTimeID;
	}
	public void setShowTimeID(Integer showTimeID) {
		this.showTimeID = showTimeID;
	}
	public String getSeatId() {
		return seatId;
	}
	public void setSeatId(String seatId) {
		this.seatId = seatId;
	}
	
	
}
