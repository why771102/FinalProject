package com.a.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.p.model.MemberBean;
import com.sun.istack.NotNull;

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
	@Column(nullable=false, columnDefinition = "tinyint")
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
	
	public SCOrdersBean() {
		
	}
	
	
	
	

	public SCOrdersBean(Integer sCOrderID, MemberBean memberBean, Integer paymentStatus,
			String shippingAddress, String orderDate, Integer shippingStatus, Integer total, String memo) {
		super();
		SCOrderID = sCOrderID;
		MemberBean = memberBean;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

	
	
	
}
