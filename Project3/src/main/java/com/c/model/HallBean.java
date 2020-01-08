package com.c.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name="Hall")
public class HallBean implements Serializable{


	private static final long serialVersionUID = 1L;
	@Id
	@NotNull
	@Column(nullable=false, columnDefinition = "NCHAR(1)")
	String hallID;
	@NotNull
	@Column(nullable=false)
	Integer noOfSeats;
	@NotNull
	@Column(nullable=false)
	Integer price;
	@NotNull
	@Column(nullable=false, columnDefinition="TINYINT")
	Integer hallStatus;
	
	public HallBean() {
		
	};
	
	public HallBean(String hallID, Integer noOfSeats, Integer price, Integer hallStatus) {
		this.hallID = hallID;
		this.noOfSeats = noOfSeats;
		this.price = price;
		this.hallStatus = hallStatus;
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
		return hallStatus;
	}
	public void setStatus(Integer status) {
		this.hallStatus = status;
	}
	
	
}
