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
@Table(name="hall")
public class HallBean implements Serializable{


	private static final long serialVersionUID = 1L;
	@Id
	@NotNull
	@Column(nullable=false, columnDefinition = "NCHAR(1)")
	String hallID;
	Integer noOfSeats;
	Integer price;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="hallStatus")
	private HallStatusBean hallStatusBean;
	
	@Column(columnDefinition="TINYINT")
	Integer rowNum;
	@Column(columnDefinition="TINYINT")
	Integer colNum;
	
	@Transient
	Integer hallStatus;
	
	public HallBean() {
		
	};
	
	public HallBean(String hallID, Integer noOfSeats, Integer price, HallStatusBean hallStatusBean, Integer rowNum,
			Integer colNum) {
		super();
		this.hallID = hallID;
		this.noOfSeats = noOfSeats;
		this.price = price;
		this.hallStatusBean = hallStatusBean;
		this.rowNum = rowNum;
		this.colNum = colNum;
	}



	public HallStatusBean getHallStatusBean() {
		return hallStatusBean;
	}



	public void setHallStatusBean(HallStatusBean hallStatusBean) {
		this.hallStatusBean = hallStatusBean;
	}



	public Integer getHallStatus() {
		return hallStatus;
	}

	public void setHallStatus(Integer hallStatus) {
		this.hallStatus = hallStatus;
	}

	public Integer getRowNum() {
		return rowNum;
	}

	public void setRowNum(Integer rowNum) {
		this.rowNum = rowNum;
	}

	public Integer getColNum() {
		return colNum;
	}

	public void setColNum(Integer colNum) {
		this.colNum = colNum;
	}

	public HallBean(String hallID, Integer noOfSeats, Integer price, Integer hallStatus) {
		this.hallID = hallID;
		this.noOfSeats = noOfSeats;
		this.price = price;
		this.hallStatus = hallStatus;
	}

	public HallBean(String hallID, Integer rowNum, Integer colNum) {
		this.hallID = hallID;
		this.rowNum = rowNum;
		this.colNum = colNum;
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
	
}
