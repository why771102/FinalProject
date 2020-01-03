package com.c.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Hall")
public class HallBean implements Serializable{


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer hallID;
	String hallName;
	Integer noOfSeats;
	Integer price;
	Integer status;
	
	public HallBean() {
		
	};
	
	public HallBean(Integer hallID, String hallName, Integer noOfSeats, Integer price, Integer status) {
		super();
		this.hallID = hallID;
		this.hallName = hallName;
		this.noOfSeats = noOfSeats;
		this.price = price;
		this.status = status;
	}
	public Integer getHallID() {
		return hallID;
	}
	public void setHallID(Integer hallID) {
		this.hallID = hallID;
	}
	public String getHallName() {
		return hallName;
	}
	public void setHallName(String hallName) {
		this.hallName = hallName;
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
