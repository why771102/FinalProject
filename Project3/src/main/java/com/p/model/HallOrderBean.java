package com.p.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.c.model.HallBean;

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
	@Column(columnDefinition = "datetime")
	String orderDate;
	@Column(columnDefinition = "datetime")
	String stsrtTime;
	@Column(columnDefinition = "datetime")
	String endTime;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="hallID")
	private HallBean hb;
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

	public HallBean getHb() {
		return hb;
	}

	public void setHb(HallBean hb) {
		this.hb = hb;
	}

	public HallOrderBean(Integer hallOrderNo,String orderDate,String stsrtTime,String endTime,
			String hallPurpose,String hallPurposeDetail,Integer hallSubtotal) {
		this.hallOrderNo = hallOrderNo;
		this.stsrtTime = stsrtTime;
		this.endTime = endTime;
		this.hallPurpose = hallPurpose;
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
	
	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public String getStsrtTime() {
		return stsrtTime;
	}
	public void setStsrtTime(String stsrtTime) {
		this.stsrtTime = stsrtTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
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
