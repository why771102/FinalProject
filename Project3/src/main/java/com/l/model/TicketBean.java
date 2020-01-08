package com.l.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.c.model.HallBean;

@Entity
@Table(name="Ticket")
public class TicketBean implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
//	Integer ordersID;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="ordersID")
	private mOrderBean ordersID;
//	String seatID;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="seatID")
	private HallBean seatID;
	
	public mOrderBean getOrdersID() {
		return ordersID;
	}
	public void setOrdersID(mOrderBean ordersID) {
		this.ordersID = ordersID;
	}
	public HallBean getSeatID() {
		return seatID;
	}
	public void setSeatID(HallBean seatID) {
		this.seatID = seatID;
	}
}
