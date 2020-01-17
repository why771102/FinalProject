package com.c.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="seatStatus")
public class SeatStatusBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(columnDefinition = "TINYINT")
	Integer seatStatusID;
	@Column(columnDefinition = "NVARCHAR(8)")
	String seatStatusName;
	
	public SeatStatusBean() {
		
	}
	
	public SeatStatusBean(Integer seatStatusID, String seatStatusName) {
		this.seatStatusID = seatStatusID;
		this.seatStatusName = seatStatusName;
	}

	public Integer getSeatStatusID() {
		return seatStatusID;
	}

	public void setSeatStatusID(Integer seatStatusID) {
		this.seatStatusID = seatStatusID;
	}

	public String getSeatStatusName() {
		return seatStatusName;
	}

	public void setSeatStatusName(String seatStatusName) {
		this.seatStatusName = seatStatusName;
	}
	
	
	
}
