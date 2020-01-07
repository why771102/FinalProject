package com.a.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.p.model.MemberBean;

@Entity
@Table(name="SCOrders")
public class SCOrdersBean implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer SCOrderID;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="memberID")
	private MemberBean MemberBean;
	
	Integer paymentStatus;
	String shippingAddress;
	Timestamp orderDate;
	Integer shippingStatus;
	Integer total;
	String memo;
	
	public SCOrdersBean() {
		
	}
	
	
	public SCOrdersBean(Integer sCOrderID, MemberBean memberBean, Integer paymentStatus, String shippingAddress,
			Timestamp orderDate, Integer shippingStatus, Integer total, String memo) {
		this.SCOrderID = sCOrderID;
		this.MemberBean = memberBean;
		this.paymentStatus = paymentStatus;
		this.shippingAddress = shippingAddress;
		this.orderDate = orderDate;
		this.shippingStatus = shippingStatus;
		this.total = total;
		this.memo = memo;
	}
	
	public Integer getSCOrderID() {
		return SCOrderID;
	}
	public void setSCOrderID(Integer sCOrderID) {
		SCOrderID = sCOrderID;
	}
	public MemberBean getMemberBean() {
		return MemberBean;
	}
	public void setMemberBean(MemberBean memberBean) {
		MemberBean = memberBean;
	}
	public Integer getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(Integer paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	public String getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public Timestamp getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(Timestamp orderDate) {
		this.orderDate = orderDate;
	}
	public Integer getShippingStatus() {
		return shippingStatus;
	}
	public void setShippingStatus(Integer shippingStatus) {
		this.shippingStatus = shippingStatus;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	
	
	
}
