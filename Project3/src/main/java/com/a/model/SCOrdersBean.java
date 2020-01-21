package com.a.model;

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

import com.p.model.MemberBean;
import com.p.model.PayStatusBean;

@Entity
@Table(name="scOrders")
public class SCOrdersBean implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer sCOrderID;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="memberID")
	private MemberBean memberBean;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="payStatusNO")
	private PayStatusBean payStatusBean;
	
	@Transient
	Integer paymentStatus;
	@Column(nullable=false, columnDefinition = "nvarchar(max)")
	String shippingAddress;
	@Column(nullable=false, columnDefinition = "datetime")
	String orderDate;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="shippingStatusID")
	private ShippingStatusBean shippingStatusBean;
	
	@Transient
	Integer shippingStatus;
	@Column(nullable=false)
	Integer total;
	@Column(columnDefinition = "nvarchar(max)")
	String memo;
	
	@Transient
	private Integer memberID;
	
	public SCOrdersBean() {
		
	}
	
	
	public SCOrdersBean(Integer sCOrderID, MemberBean memberBean, PayStatusBean payStatusBean, String shippingAddress,
			String orderDate, ShippingStatusBean shippingStatusBean, Integer total, String memo) {
		this.sCOrderID = sCOrderID;
		this.memberBean = memberBean;
		this.payStatusBean = payStatusBean;
		this.shippingAddress = shippingAddress;
		this.orderDate = orderDate;
		this.shippingStatusBean = shippingStatusBean;
		this.total = total;
		this.memo = memo;
	}

	public SCOrdersBean(Integer sCOrderID, Integer paymentStatus, String shippingAddress, String orderDate,
			Integer shippingStatus, Integer total, String memo, Integer memberID) {
		this.sCOrderID = sCOrderID;
		this.paymentStatus = paymentStatus;
		this.shippingAddress = shippingAddress;
		this.orderDate = orderDate;
		this.shippingStatus = shippingStatus;
		this.total = total;
		this.memo = memo;
		this.memberID = memberID;
	}



	public Integer getsCOrderID() {
		return sCOrderID;
	}

	public void setsCOrderID(Integer sCOrderID) {
		this.sCOrderID = sCOrderID;
	}

	public MemberBean getMemberBean() {
		return memberBean;
	}

	public void setMemberBean(MemberBean memberBean) {
		this.memberBean = memberBean;
	}

	public PayStatusBean getPayStatusBean() {
		return payStatusBean;
	}

	public void setPayStatusBean(PayStatusBean payStatusBean) {
		this.payStatusBean = payStatusBean;
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

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	public ShippingStatusBean getShippingStatusBean() {
		return shippingStatusBean;
	}

	public void setShippingStatusBean(ShippingStatusBean shippingStatusBean) {
		this.shippingStatusBean = shippingStatusBean;
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

	public Integer getMemberID() {
		return memberID;
	}

	public void setMemberID(Integer memberID) {
		this.memberID = memberID;
	}

	
}
