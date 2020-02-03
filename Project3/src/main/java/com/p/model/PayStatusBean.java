package com.p.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hallPayStatus")
public class PayStatusBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	Integer payStatusNO;
	String payStatus;
	
	public PayStatusBean() {
		
	}

	public PayStatusBean(Integer payStatusNO) {
		this.payStatusNO = payStatusNO;
	}
	
	public Integer getPayStatusNO() {
		return payStatusNO;
	}

	public void setPayStatusNO(Integer payStatusNO) {
		this.payStatusNO = payStatusNO;
	}

	public String getPayStatus() {
		return payStatus;
	}

	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}
	
	
}
