package com.c.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.a.model.ShowTimeHistoryBean;
import com.sun.istack.NotNull;
@Entity
@Table(name="seatOrder")
public class SeatOrderBean implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer seatsno;
	
	@NotNull
	@Column(columnDefinition = "DATE")
	String date;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="showTimeID")
	private ShowTimeHistoryBean showtimeHistoryBean;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="seatID")
	private SeatsBean seatsBean;
	
	@Transient
	private Integer showTimeID;
	
	@Transient
	private String seatID;
	
	public SeatOrderBean() {
		
	}
	
	public SeatOrderBean(String date, Integer showTimeID, String seatID) {
//		super();
		this.date = date;
		this.showTimeID = showTimeID;
		this.seatID = seatID;
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

	public Integer getShowTimeID() {
		return showTimeID;
	}

	public void setShowTimeID(Integer showTimeID) {
		this.showTimeID = showTimeID;
	}

	public String getSeatID() {
		return seatID;
	}

	public void setSeatID(String seatID) {
		this.seatID = seatID;
	}

	public ShowTimeHistoryBean getShowtimeHistoryBean() {
		return showtimeHistoryBean;
	}

	public void setShowtimeHistoryBean(ShowTimeHistoryBean showtimeHistoryBean) {
		this.showtimeHistoryBean = showtimeHistoryBean;
	}

	public SeatsBean getSeatsBean() {
		return seatsBean;
	}

	public void setSeatsBean(SeatsBean seatsBean) {
		this.seatsBean = seatsBean;
	}
	
	
	
}
