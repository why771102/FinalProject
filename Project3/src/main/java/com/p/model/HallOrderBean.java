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
import javax.persistence.Transient;

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
	@Transient
	Integer memberID;
	
	@Column(columnDefinition = "datetime")
	String orderDate;
	@Column(columnDefinition = "datetime")
	String startTime;
	@Column(columnDefinition = "datetime")
	String endTime;
	Integer orderHours;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="hallID")
	private HallBean hb;
	@Transient
	String hallID;
	
	String mobile;
	String contactPerson;
	String mail;
	String hallPurpose;
	String hallPurposeDetail;
	Integer hallSubtotal;
	//Integer hallOrderStatusNo;
	//Integer payStatusNo;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="hallOrderStatusNo")
	private HallOrderStatusBean hob;
	@Transient
	Integer hallOrderStatusNo;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="payStatusNo")
	private PayStatusBean psb;
	@Transient
	Integer payStatusNo;
	
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

	public Integer getMemberID() {
		return memberID;
	}

	public void setMemberID(Integer memberID) {
		this.memberID = memberID;
	}

	public String getHallID() {
		return hallID;
	}

	public void setHallID(String hallID) {
		this.hallID = hallID;
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

	public HallOrderBean(Integer hallOrderNo,String orderDate,String startTime,String endTime,
			Integer orderHours,String mobile,String contactPerson,String mail,String hallPurpose,String hallPurposeDetail,Integer hallSubtotal) {
		this.hallOrderNo = hallOrderNo;
		this.startTime = startTime;
		this.endTime = endTime;
		this.orderHours = orderHours;
		this.hallPurpose = hallPurpose;
		this.hallPurposeDetail = hallPurposeDetail;
		this.hallSubtotal = hallSubtotal;
		this.mobile = mobile;
		this.contactPerson = contactPerson;
		this.mail = mail;
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

	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public Integer getOrderHours() {
		return orderHours;
	}

	public void setOrderHours(Integer orderHours) {
		this.orderHours = orderHours;
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
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getContactPerson() {
		return contactPerson;
	}

	public void setContactPerson(String contactPerson) {
		this.contactPerson = contactPerson;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}
	
	
	
	
	
}
