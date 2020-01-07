package com.c.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table (name="numberOfSeats")
public class NumberOfSeatsBean implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	Date date;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="hallID")
	private HallBean hallBean;
	
	Integer noOfSeats;
	
	public NumberOfSeatsBean() {
		
	}
	
	public NumberOfSeatsBean(Date date, HallBean hallBean, Integer noOfSeats) {
		this.date = date;
		this.hallBean = hallBean;
		this.noOfSeats = noOfSeats;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public HallBean getHallBean() {
		return hallBean;
	}

	public void setHallBean(HallBean hallBean) {
		this.hallBean = hallBean;
	}

	public Integer getNoOfSeats() {
		return noOfSeats;
	}
	public void setNoOfSeats(Integer noOfSeats) {
		this.noOfSeats = noOfSeats;
	}
	
	
}
