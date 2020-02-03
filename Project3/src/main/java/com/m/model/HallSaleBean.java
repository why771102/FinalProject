package com.m.model;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import com.c.model.HallBean;
import com.p.model.HallOrderBean;
import com.sun.istack.NotNull;

public class HallSaleBean implements Serializable {
	private static final long serialVersionUID = 1L;

	String hallID;
	Integer price;
	Integer orderHours;
	Integer hallSubtotal;
	Integer subtotal;
	String sDate;
	String eDate;

	public Integer getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Integer subtotal) {
		this.subtotal = subtotal;
	}

	public String getsDate() {
		return sDate;
	}

	public void setsDate(String sDate) {
		this.sDate = sDate;
	}

	public String geteDate() {
		return eDate;
	}

	public void seteDate(String eDate) {
		this.eDate = eDate;
	}

	public HallSaleBean() {}
	
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
