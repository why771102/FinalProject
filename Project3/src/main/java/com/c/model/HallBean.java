package com.c.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="Hall")
public class HallBean implements Serializable{


	private static final long serialVersionUID = 1L;

	String hallID;
	Integer noOfSeats;
	Integer price;
	Integer status;
	
	public HallBean() {
		
	};
	
	public HallBean(String hallID, Integer noOfSeats, Integer price, Integer status) {
		this.hallID = hallID;
		this.noOfSeats = noOfSeats;
		this.price = price;
		this.status = status;
	}

	public String getHallID() {
		return hallID;
	}
	public void setHallID(String hallID) {
		this.hallID = hallID;
	}

	public Integer getNoOfSeats() {
		return noOfSeats;
	}
	public void setNoOfSeats(Integer noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	
}
