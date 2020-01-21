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
@Table(name="reservedSeats")
public class ReservedSeatsBean implements Serializable{
	

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer seatsno;
	@NotNull
	@Column(nullable=false, columnDefinition = "DATE")
	String date;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="reservationStatus")
	private ReservationStatusBean reservationStatusBean;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="showTimeID")
	private ShowTimeHistoryBean showtimeHistoryBean;

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="seatID")
	private SeatsBean seatsBean;
	
	@Transient
	Integer reservationStatus;
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
	
	public ReservedSeatsBean(String date, Integer reservationStatus, ShowTimeHistoryBean showtimeHistoryBean,
			SeatsBean seatsBean) {
		this.date = date;
		this.reservationStatus = reservationStatus;
		this.showtimeHistoryBean = showtimeHistoryBean;
		this.seatsBean = seatsBean;
	}
	
	public ReservedSeatsBean(String date, ReservationStatusBean reservationStatusBean,
			ShowTimeHistoryBean showtimeHistoryBean, SeatsBean seatsBean) {
		super();
		this.date = date;
		this.reservationStatusBean = reservationStatusBean;
		this.showtimeHistoryBean = showtimeHistoryBean;
		this.seatsBean = seatsBean;
	}
	
	public Integer getSeatsno() {
		return seatsno;
	}

	public void setSeatsno(Integer seatsno) {
		this.seatsno = seatsno;
	}

	public ReservationStatusBean getReservationStatusBean() {
		return reservationStatusBean;
	}

	public void setReservationStatusBean(ReservationStatusBean reservationStatusBean) {
		this.reservationStatusBean = reservationStatusBean;
	}

	public String getSeatID() {
		return seatID;
	}

	public void setSeatID(String seatID) {
		this.seatID = seatID;
	}

	public Integer getShowTimeID() {
		return showTimeID;
	}

	public void setShowTimeID(Integer showTimeID) {
		this.showTimeID = showTimeID;
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
