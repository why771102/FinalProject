package com.p.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="HallOrder")
public class HallOrderBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	Integer memeberID;
	Date stsrtTime;
	Date endTime;
	String hallID;
	String hallPurpose;
	String hallPurposeDetail;
	Integer hallSubtotal;
	Integer hallOrderStatusNo;
	Integer payStatusNo;
	
	public HallOrderBean() {
		
	}
	
	public Integer getMemeberID() {
		return memeberID;
	}
	public void setMemeberID(Integer memeberID) {
		this.memeberID = memeberID;
	}
	public Date getStsrtTime() {
		return stsrtTime;
	}
	public void setStsrtTime(Date stsrtTime) {
		this.stsrtTime = stsrtTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}
	public String getHallID() {
		return hallID;
	}
	public void setHallID(String hallID) {
		this.hallID = hallID;
	}
	public String getHallPurpose() {
		return hallPurpose;
	}
	public void setHallPurpose(String hallPurpose) {
		this.hallPurpose = hallPurpose;
	}
	public String getHallPurposeDetail() {
		return hallPurposeDetail;
	}
	public void setHallPurposeDetail(String hallPurposeDetail) {
		this.hallPurposeDetail = hallPurposeDetail;
	}
	public Integer getHallSubtotal() {
		return hallSubtotal;
	}
	public void setHallSubtotal(Integer hallSubTotal) {
		this.hallSubtotal = hallSubTotal;
	}
	public Integer getHallOrderStatusNo() {
		return hallOrderStatusNo;
	}
	public void setHallOrderStatusNo(Integer hallOrderStatusNo) {
		this.hallOrderStatusNo = hallOrderStatusNo;
	}
	public Integer getPayStatusNo() {
		return payStatusNo;
	}
	public void setPayStatusNo(Integer payStatusNo) {
		this.payStatusNo = payStatusNo;
	}
	
	
	
}
