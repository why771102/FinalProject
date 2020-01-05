package com.c.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table (name="seats")
public class SeatsBean implements Serializable{

	private static final long serialVersionUID = 1L;

	Integer hallId;
	String row;
	Integer seatNo;
	Integer typeOfSeat;
	Integer seatStatus;
	
	public SeatsBean() {
		
	}
	
	public SeatsBean(Integer hallId, String row, Integer seatNo, Integer typeOfSeat, Integer seatStatus) {
		this.hallId = hallId;
		this.row = row;
		this.seatNo = seatNo;
		this.typeOfSeat = typeOfSeat;
		this.seatStatus = seatStatus;
	}
	
	@ManyToOne(cascade=CascadeType.ALL)
	public Integer getHallId() {
		return hallId;
	}
	public void setHallId(Integer hallId) {
		this.hallId = hallId;
	}
	public String getRow() {
		return row;
	}
	public void setRow(String row) {
		this.row = row;
	}
	public Integer getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(Integer seatNo) {
		this.seatNo = seatNo;
	}
	public Integer getTypeOfSeat() {
		return typeOfSeat;
	}
	public void setTypeOfSeat(Integer typeOfSeat) {
		this.typeOfSeat = typeOfSeat;
	}
	public Integer getSeatStatus() {
		return seatStatus;
	}
	public void setSeatStatus(Integer seatStatus) {
		this.seatStatus = seatStatus;
	}
	
	
}
