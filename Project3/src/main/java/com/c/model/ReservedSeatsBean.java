package com.c.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.a.model.ShowTimeHistoryBean;
import com.sun.istack.NotNull;

@Entity
@Table(name="reservedSeats")
public class ReservedSeatsBean implements Serializable{
	

	private static final long serialVersionUID = 1L;
	@Id
	@NotNull
	@Column(nullable=false, columnDefinition = "DATE")
	String date;
	@NotNull
	@Column(nullable=false, columnDefinition = "SMALLINT")
	Integer reservationStatus;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="showTimeID")
	private ShowTimeHistoryBean showtimeHistoryBean;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="seatID")
	private SeatsBean seatsBean;
	
	@Transient
	private String seatID;
	@Transient
	private Integer showTimeID;

	
	public ReservedSeatsBean() {
		
	}
	
	public ReservedSeatsBean(String date, String seatID, Integer showTimeID, Integer reservationStatus) {
		this.date = date;
		this.seatID = seatID;
		this.showTimeID = showTimeID;
		this.reservationStatus = reservationStatus;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
	public Integer getReservationStatus() {
		return reservationStatus;
	}

	public void setReservationStatus(Integer reservationStatus) {
		this.reservationStatus = reservationStatus;
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

	public Integer getSeatReservationStatus() {
		return reservationStatus;
	}
	public void setSeatReservationStatus(Integer seatReservationStatus) {
		this.reservationStatus = seatReservationStatus;
	}
	
	
}
