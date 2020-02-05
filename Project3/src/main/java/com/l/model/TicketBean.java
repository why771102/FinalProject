package com.l.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.c.model.SeatsBean;

@Entity
@IdClass(com.l.model.TicketID.class)
@Table(name="ticket")
public class TicketBean implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
//	Integer ordersID;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="ordersID")
	private MOrderBean mOrderBean;
	@Transient
	Integer ordersID;
	
//	String seatID;
	@Id
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="seatID", columnDefinition = "NCHAR(4)")
	private SeatsBean seatsBean;
	@Transient
	String seatID;
	
	public TicketBean() {}
	
	public TicketBean(MOrderBean mOrderBean,SeatsBean seatsBean) {
		this.mOrderBean=mOrderBean;
		this.seatsBean=seatsBean;

	}
	public MOrderBean getmOrderBean() {
		return mOrderBean;
	}
	public void setmOrderBean(MOrderBean mOrderBean) {
		this.mOrderBean = mOrderBean;
	}
	public Integer getOrdersID() {
		return ordersID;
	}
	public void setOrdersID(Integer ordersID) {
		this.ordersID = ordersID;
	}
	public SeatsBean getSeatsBean() {
		return seatsBean;
	}
	public void setSeatsBean(SeatsBean seatsBean) {
		this.seatsBean = seatsBean;
	}
	public String getSeatID() {
		return seatID;
	}
	public void setSeatID(String seatID) {
		this.seatID = seatID;
	}
	
	
}
