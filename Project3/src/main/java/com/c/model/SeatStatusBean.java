package com.c.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="seatStatus")
public class SeatStatusBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	String seatStatusID;
	Integer seatStatusName;
	
	public SeatStatusBean() {
		
	}
	
	public SeatStatusBean(String seatStatusID, Integer seatStatusName) {
		this.seatStatusID = seatStatusID;
		this.seatStatusName = seatStatusName;
	}

	public String getSeatStatusID() {
		return seatStatusID;
	}

	public void setSeatStatusID(String seatStatusID) {
		this.seatStatusID = seatStatusID;
	}

	public Integer getSeatStatusName() {
		return seatStatusName;
	}

	public void setSeatStatusName(Integer seatStatusName) {
		this.seatStatusName = seatStatusName;
	}
	
	
	
}
