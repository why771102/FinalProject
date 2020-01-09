package com.c.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="reservationStatus")
public class ReservationStatus implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	String reservationStatusID;
	Integer reservationStatusName;
	
	public ReservationStatus() {
		
	}
	
	public ReservationStatus(String reservationStatusID, Integer reservationStatusName) {
		this.reservationStatusID = reservationStatusID;
		this.reservationStatusName = reservationStatusName;
	}

	public String getReservationStatusID() {
		return reservationStatusID;
	}

	public void setReservationStatusID(String reservationStatusID) {
		this.reservationStatusID = reservationStatusID;
	}

	public Integer getReservationStatusName() {
		return reservationStatusName;
	}

	public void setReservationStatusName(Integer reservationStatusName) {
		this.reservationStatusName = reservationStatusName;
	}
	
	
	
}
