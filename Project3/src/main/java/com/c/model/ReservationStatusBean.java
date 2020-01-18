package com.c.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="reservationStatus")
public class ReservationStatusBean implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@Column(columnDefinition="TINYINT")
	Integer reservationStatusID;
//	@Column(columnDefinition="NVARCHAR(8)")
	String reservationStatusName;
	
	public ReservationStatusBean() {
		
	}
	
	public ReservationStatusBean(Integer reservationStatusID, String reservationStatusName) {
		this.reservationStatusID = reservationStatusID;
		this.reservationStatusName = reservationStatusName;
	}

	public Integer getReservationStatusID() {
		return reservationStatusID;
	}

	public void setReservationStatusID(Integer reservationStatusID) {
		this.reservationStatusID = reservationStatusID;
	}

	public String getReservationStatusName() {
		return reservationStatusName;
	}

	public void setReservationStatusName(String reservationStatusName) {
		this.reservationStatusName = reservationStatusName;
	}
	
	
	
}
