package com.l.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.a.model.showTimeHistoryBean;
import com.c.model.SeatsBean;
import com.p.model.MemberBean;
import com.z.model.EmpBean;

@Entity
@Table(name="mOrder")
public class mOrderBean implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer ordersID;
	Integer ticketSerial;
	Integer ticketStatus;
//	Timestamp  showTimeID;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="showTimeID")
	private showTimeHistoryBean showTimeID;
//	String  title;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="title")
	private showTimeHistoryBean title;
//	Integer hallID; 
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="hallID")
	private showTimeHistoryBean hallID;
//	Timestamp playStartTime;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="playStartTime")
	private showTimeHistoryBean playStartTime;
//	String row;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="row")
	private SeatsBean row;
//	Integer seatNo;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="seatNo")
	private SeatsBean seatNo;
//	Integer employeeID;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="employeeID")
	private EmpBean employeeID;
//	Integer memberID;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="memberID")
	private MemberBean memberID;
	Timestamp ticketTime;
	public Integer getOrdersID() {
		return ordersID;
	}
	public void setOrdersID(Integer ordersID) {
		this.ordersID = ordersID;
	}
	public Integer getTicketSerial() {
		return ticketSerial;
	}
	public void setTicketSerial(Integer ticketSerial) {
		this.ticketSerial = ticketSerial;
	}
	public Integer getTicketStatus() {
		return ticketStatus;
	}
	public void setTicketStatus(Integer ticketStatus) {
		this.ticketStatus = ticketStatus;
	}
	public showTimeHistoryBean getShowTimeID() {
		return showTimeID;
	}
	public void setShowTimeID(showTimeHistoryBean showTimeID) {
		this.showTimeID = showTimeID;
	}
	public showTimeHistoryBean getTitle() {
		return title;
	}
	public void setTitle(showTimeHistoryBean title) {
		this.title = title;
	}
	public showTimeHistoryBean getHallID() {
		return hallID;
	}
	public void setHallID(showTimeHistoryBean hallID) {
		this.hallID = hallID;
	}
	public showTimeHistoryBean getPlayStartTime() {
		return playStartTime;
	}
	public void setPlayStartTime(showTimeHistoryBean playStartTime) {
		this.playStartTime = playStartTime;
	}
	public SeatsBean getRow() {
		return row;
	}
	public void setRow(SeatsBean row) {
		this.row = row;
	}
	public SeatsBean getSeatNo() {
		return seatNo;
	}
	public void setSeatNo(SeatsBean seatNo) {
		this.seatNo = seatNo;
	}
	public EmpBean getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(EmpBean employeeID) {
		this.employeeID = employeeID;
	}
	public MemberBean getMemberID() {
		return memberID;
	}
	public void setMemberID(MemberBean memberID) {
		this.memberID = memberID;
	}
	public Timestamp getTicketTime() {
		return ticketTime;
	}
	public void setTicketTime(Timestamp ticketTime) {
		this.ticketTime = ticketTime;
	}

	
	
	
}