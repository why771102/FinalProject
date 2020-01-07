package com.c.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.a.model.showTimeHistoryBean;

public class ReservedSeatsBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	Date date;
	Integer reservationStatus;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="showTimeID")
	private showTimeHistoryBean showtimeHistoryBean;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="seatID")
	private SeatsBean seatsBean;
	
	public ReservedSeatsBean() {
		
	}
	
	public ReservedSeatsBean(Date date, showTimeHistoryBean showtimeHistoryBean, SeatsBean seatsBean, Integer reservationStatus) {
		this.date = date;
		this.showtimeHistoryBean = showtimeHistoryBean;
		this.seatsBean = seatsBean;
		this.reservationStatus = reservationStatus;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Integer getReservationStatus() {
		return reservationStatus;
	}

	public void setReservationStatus(Integer reservationStatus) {
		this.reservationStatus = reservationStatus;
	}

	public showTimeHistoryBean getShowtimeHistoryBean() {
		return showtimeHistoryBean;
	}

	public void setShowtimeHistoryBean(showTimeHistoryBean showtimeHistoryBean) {
		this.showtimeHistoryBean = showtimeHistoryBean;
	}

	public SeatsBean getSeatsBean() {
		return seatsBean;
	}

	public void setSeatsBean(SeatsBean seatsBean) {
		this.seatsBean = seatsBean;
	}

	public Integer getSeatReservationStatus() {
		return reservationStatus;
	}
	public void setSeatReservationStatus(Integer seatReservationStatus) {
		this.reservationStatus = seatReservationStatus;
	}
	
	
}
