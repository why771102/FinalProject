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

import com.sun.istack.NotNull;


@Entity
@Table (name="seats")
public class SeatsBean implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@NotNull
	@Column(nullable=false, columnDefinition = "NCHAR(4)")
	String seatID;
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="hallID")
	private HallBean hallBean;
	@Transient
	private String hallID;
	@NotNull
	@Column(nullable=false, columnDefinition = "NCHAR(1)")
	String row;
	@NotNull
	@Column(nullable=false, columnDefinition = "SMALLINT")
	Integer seatNo;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="typeOfSeat")
	private TypeOfSeatBean typeOfSeatBean;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="seatStatus")
	private SeatStatusBean seatStatusBean;
	
	@Transient
	Integer typeOfSeat;

	@Transient
	Integer seatStatus;
	
	public SeatsBean(String seatID, String hallID, String row, Integer seatNo, Integer typeOfSeat, Integer seatStatus) {
		this.seatID = seatID;
		this.hallID = hallID;
		this.row = row;
		this.seatNo = seatNo;
		this.typeOfSeat = typeOfSeat;
		this.seatStatus = seatStatus;
	}

	public SeatsBean(String seatID, HallBean hallBean, String hallID, String row, Integer seatNo,
			TypeOfSeatBean typeOfSeatBean, SeatStatusBean seatStatusBean) {
		this.seatID = seatID;
		this.hallBean = hallBean;
		this.row = row;
		this.seatNo = seatNo;
		this.typeOfSeatBean = typeOfSeatBean;
		this.seatStatusBean = seatStatusBean;
	}

	public TypeOfSeatBean getTypeOfSeatBean() {
		return typeOfSeatBean;
	}

	public void setTypeOfSeatBean(TypeOfSeatBean typeOfSeatBean) {
		this.typeOfSeatBean = typeOfSeatBean;
	}

	public SeatStatusBean getSeatStatusBean() {
		return seatStatusBean;
	}

	public void setSeatStatusBean(SeatStatusBean seatStatusBean) {
		this.seatStatusBean = seatStatusBean;
	}

	public SeatsBean() {
		
	}
	
	public SeatsBean(String seatID, String row, Integer seatNo, Integer typeOfSeat, Integer seatStatus, String hallID) {
		this.seatID = seatID;
		this.row = row;
		this.seatNo = seatNo;
		this.typeOfSeat = typeOfSeat;
		this.seatStatus = seatStatus;
		this.hallID = hallID;
	}

	public SeatsBean(String seatID, HallBean hallBean,String row, Integer seatNo, Integer typeOfSeat, Integer seatStatus) {
		this.seatID = seatID;
		this.hallBean = hallBean;
		this.row = row;
		this.seatNo = seatNo;
		this.typeOfSeat = typeOfSeat;
		this.seatStatus = seatStatus;
	}

	public String getHallID() {
		return hallID;
	}

	public void setHallID(String hallID) {
		this.hallID = hallID;
	}

	public String getSeatID() {
		return seatID;
	}

	public void setSeatID(String seatID) {
		this.seatID = seatID;
	}

	public HallBean getHallBean() {
		return hallBean;
	}

	public void setHallBean(HallBean hallBean) {
		this.hallBean = hallBean;
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
