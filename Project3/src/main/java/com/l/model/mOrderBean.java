package com.l.model;

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

import com.a.model.showTimeHistoryBean;
import com.c.model.SeatsBean;
import com.p.model.MemberBean;
import com.sun.istack.NotNull;
import com.z.model.EmpBean;

@Entity
@Table(name="mOrder")
public class mOrderBean implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer ordersID;
	@NotNull
	@Column(nullable=false, columnDefinition = "TINYINT")
	Integer ticketStatus;
//	Integer showTimeID;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="showTimeID")
	private ShowTimeHistoryBean showTimeID;
//	Integer memberID;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="memberID")
	private MemberBean memberID;
	Timestamp ticketTime;
//	Integer employeeID;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="employeeID")
	private MemberBean employeeID;
	public Integer getOrdersID() {
		return ordersID;
	}
	public void setOrdersID(Integer ordersID) {
		this.ordersID = ordersID;
	}
	public Integer getTicketStatus() {
		return ticketStatus;
	}
	public void setTicketStatus(Integer ticketStatus) {
		this.ticketStatus = ticketStatus;
	}
	public ShowTimeHistoryBean getShowTimeID() {
		return showTimeID;
	}
	public void setShowTimeID(ShowTimeHistoryBean showTimeID) {
		this.showTimeID = showTimeID;
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
	public MemberBean getEmployeeID() {
		return employeeID;
	}
	public void setEmployeeID(MemberBean employeeID) {
		this.employeeID = employeeID;
	}
}