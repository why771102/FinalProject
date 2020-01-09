package com.l.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.c.model.HallBean;
import com.c.model.SeatsBean;

@Entity
@Table(name="ticket")
public class TicketBean implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
//	Integer ordersID;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="ordersID")
	private MOrderBean ordersID;
//	String seatID;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="seatID", columnDefinition = "NCHAR(4)")
	private SeatsBean seatID;
	
	public MOrderBean getOrdersID() {
		return ordersID;
	}
	public void setOrdersID(MOrderBean ordersID) {
		this.ordersID = ordersID;
	}
	public SeatsBean getSeatID() {
		return seatID;
	}
	public void setSeatID(SeatsBean seatID) {
		this.seatID = seatID;
	}
}
