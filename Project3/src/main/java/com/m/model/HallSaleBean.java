package com.m.model;

import java.io.Serializable;

public class HallSaleBean implements Serializable {

	private static final long serialVersionUID = 1L;

	String hallID; //hall => hallID
	Integer price; //hall => price
	Integer orderHours; //hallOrder => ???
	Integer hallSubtotal; //hallOrder => ???
	
	public HallSaleBean(String hallID, Integer price, Integer orderHours, Integer hallSubtotal) {
		this.hallID = hallID;
		this.price = price;
		this.orderHours = orderHours;
		this.hallSubtotal = hallSubtotal;
	}
	
	public String getHallID() {
		return hallID;
	}
	public void setHallID(String hallID) {
		this.hallID = hallID;
	}
	public Integer getPrice() {
		return price;
	}
	public void setPrice(Integer price) {
		this.price = price;
	}
	public Integer getOrderHours() {
		return orderHours;
	}
	public void setOrderHours(Integer orderHours) {
		this.orderHours = orderHours;
	}
	public Integer getHallSubtotal() {
		return hallSubtotal;
	}
	public void setHallSubtotal(Integer hallSubtotal) {
		this.hallSubtotal = hallSubtotal;
	}
	
}
