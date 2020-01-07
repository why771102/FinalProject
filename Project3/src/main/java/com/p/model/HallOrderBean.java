package com.p.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="hallOrder")
public class HallOrderBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//要補會員的BEAN，只要有她的FK就要補她的BEAN
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer hallOrderNo;
	//Integer memeberID;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="memberID")
	private MemberBean mb;
	Timestamp stsrtTime;
	Timestamp endTime;
	String hallID;
	String hallPurpose;
	String hallPurposeDetail;
	Integer hallSubtotal;
	//Integer hallOrderStatusNo;
	//Integer payStatusNo;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="hallOrderStatusNo")
	private HallOrderStatusBean hob;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="payStatusNo")
	private PayStatusBean psb;
	
	public MemberBean getMb() {
		return mb;
	}

	public void setMb(MemberBean mb) {
		this.mb = mb;
	}

	public HallOrderStatusBean getHob() {
		return hob;
	}

	public void setHob(HallOrderStatusBean hob) {
		this.hob = hob;
	}

	public PayStatusBean getPsb() {
		return psb;
	}

	public void setPsb(PayStatusBean psb) {
		this.psb = psb;
	}

	public HallOrderBean(Integer hallOrderNo,Timestamp stsrtTime,Timestamp endTime,String hallID,
			String hallPurpose,String hallPurposeDetail,Integer hallSubtotal) {
		this.hallOrderNo = hallOrderNo;
		this.stsrtTime = stsrtTime;
		this.endTime = endTime;
		this.hallID = hallID;
		this.endTime = endTime;
		this.hallPurposeDetail = hallPurposeDetail;
		this.hallSubtotal = hallSubtotal;
	}
	
	public HallOrderBean() {
		
	}
	
	public Integer getHallOrderNo() {
		return hallOrderNo;
	}

	public void setHallOrderNo(Integer hallOrderNo) {
		this.hallOrderNo = hallOrderNo;
	}

	public Date getStsrtTime() {
		return stsrtTime;
	}
	public void setStsrtTime(Timestamp stsrtTime) {
		this.stsrtTime = stsrtTime;
	}
	public Date getEndTime() {
		return endTime;
	}
	public void setEndTime(Timestamp endTime) {
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
	public void setHallSubtotal(Integer hallSubtotal) {
		this.hallSubtotal = hallSubtotal;
	}
	
}
