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
@Table(name="SCOrders")
public class SCOrdersBean implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer SCOrderID;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="memberID")
	private MemberBean MemberBean;
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="payStatusNO")
	private PayStatusBean payStatusBean;
	
	@Transient
	Integer paymentStatus;
	@Column(nullable=false, columnDefinition = "nvarchar(max)")
	String shippingAddress;
	@Column(nullable=false, columnDefinition = "datetime")
	String orderDate;
	@Column(nullable=false, columnDefinition = "tinyint")
	Integer shippingStatus;
	@Column(nullable=false)
	Integer total;
	@Column(nullable=false, columnDefinition = "nvarchar(max)")
	String memo;
	
	@Transient
	private Integer memberID;
	
	public SCOrdersBean() {
		
	}
	
	public SCOrdersBean(Integer sCOrderID, Integer paymentStatus, String shippingAddress, String orderDate,
			Integer shippingStatus, Integer total, String memo, Integer memberID) {
		this.SCOrderID = sCOrderID;
		this.paymentStatus = paymentStatus;
		this.shippingAddress = shippingAddress;
		this.orderDate = orderDate;
		this.shippingStatus = shippingStatus;
		this.total = total;
		this.memo = memo;
		this.memberID = memberID;
	}

	
	
	public SCOrdersBean(Integer sCOrderID, MemberBean memberBean,
			PayStatusBean payStatusBean, String shippingAddress, String orderDate,
			Integer shippingStatus, Integer total, String memo) {
		this.SCOrderID = sCOrderID;
		this.MemberBean = memberBean;
		this.payStatusBean = payStatusBean;
		this.shippingAddress = shippingAddress;
		this.orderDate = orderDate;
		this.shippingStatus = shippingStatus;
		this.total = total;
		this.memo = memo;
	}

	public PayStatusBean getPaymentStatusBean() {
		return payStatusBean;
	}

	public void setPaymentStatusBean(PayStatusBean payStatusBean) {
		payStatusBean = payStatusBean;
	}

	public Integer getMemberID() {
		return memberID;
	}

	public void setMemberID(Integer memberID) {
		this.memberID = memberID;
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

	public String getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(String orderDate) {
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
