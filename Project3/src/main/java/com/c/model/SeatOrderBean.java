package com.c.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.a.model.ShowTimeHistoryBean;
import com.sun.istack.NotNull;
@Entity
@Table(name="seatOrder")
public class SeatOrderBean implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@NotNull
	@Column(nullable=false, columnDefinition = "DATE")
	String date;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="showTimeID")
	private ShowTimeHistoryBean showtimeHistoryBean;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="seatID")
	private SeatsBean seatsBean;
	
	public SeatOrderBean() {
		
	}
	
	public SeatOrderBean(String date, ShowTimeHistoryBean showtimeHistoryBean, SeatsBean seatsBean) {
		this.date = date;
		this.showtimeHistoryBean = showtimeHistoryBean;
		this.seatsBean = seatsBean;
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}
