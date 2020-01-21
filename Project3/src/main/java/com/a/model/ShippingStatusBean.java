package com.a.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="shippingStatus")
public class ShippingStatusBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(columnDefinition="TINYINT")
	Integer shippingStatusID;
	@Column(columnDefinition="NCHAR(6)")
	String shippingStatus;
	
	public ShippingStatusBean() {
		
	}
	
	public ShippingStatusBean(Integer shippingStatusID, String shippingStatus) {
		this.shippingStatusID = shippingStatusID;
		this.shippingStatus = shippingStatus;
	}
	
	public Integer getShippingStatusID() {
		return shippingStatusID;
	}
	public void setShippingStatusID(Integer shippingStatusID) {
		this.shippingStatusID = shippingStatusID;
	}
	public String getShippingStatus() {
		return shippingStatus;
	}
	public void setShippingStatus(String shippingStatus) {
		this.shippingStatus = shippingStatus;
	}
	
	
}
