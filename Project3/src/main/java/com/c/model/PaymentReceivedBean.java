package com.c.model;

import java.io.Serializable;
import java.sql.Timestamp;

public class PaymentReceivedBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	Timestamp date;
	Integer paymentType;
	Integer employeeId;
	Integer amount;
	Integer numberOfTickets;
	
	public PaymentReceivedBean() {
		
	}
	
	public PaymentReceivedBean(Timestamp date, Integer paymentType, Integer employeeId, Integer amount,
			Integer numberOfTickets) {
		this.date = date;
		this.paymentType = paymentType;
		this.employeeId = employeeId;
		this.amount = amount;
		this.numberOfTickets = numberOfTickets;
	}
	public Timestamp getDate() {
		return date;
	}
	public void setDate(Timestamp date) {
		this.date = date;
	}
	public Integer getPaymentType() {
		return paymentType;
	}
	public void setPaymentType(Integer paymentType) {
		this.paymentType = paymentType;
	}
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	public Integer getAmount() {
		return amount;
	}
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	public Integer getNumberOfTickets() {
		return numberOfTickets;
	}
	public void setNumberOfTickets(Integer numberOfTickets) {
		this.numberOfTickets = numberOfTickets;
	}
	
	
}
