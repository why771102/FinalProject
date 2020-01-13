package com.l.model;


import java.io.Serializable;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.a.model.ShowTimeHistoryBean;
import com.p.model.MemberBean;
import com.sun.istack.NotNull;
import com.z.model.EmpBean;

@Entity
@Table(name="mOrder")
public class MOrderBean implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer ordersID;
	@NotNull
	@Column(nullable=false, columnDefinition = "TINYINT")
	Integer ticketStatus;
	@NotNull
	@Column(nullable=false, columnDefinition = "DATETIME")
	
	String OrderTime;
	//	Integer showTimeID;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="showTimeID")
	private ShowTimeHistoryBean ShowTimeHistoryBean;
	@Transient
	Integer showTimeID;
	
	//	Integer memberID;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="memberID")
	private MemberBean MemberBean;
	@Transient
	Integer memberID;
	
	@NotNull
	@Column(nullable=false, columnDefinition = "DATETIME")
	String ticketTime;
//	Integer employeeID;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="employeeID")
	private EmpBean EmpBean;
	@Transient
	Integer empId;
	
	public MOrderBean() {}
	public MOrderBean(Integer ordersID,Integer ticketStatus,String OrderTime,Integer showTimeID,Integer memberID,String ticketTime,Integer empId) {
		this.ordersID=ordersID;
		this.ticketStatus=ticketStatus;
		this.OrderTime=OrderTime;
		this.showTimeID=showTimeID;
		this.memberID=memberID;
		this.ticketTime=ticketTime;
		this.empId=empId;
	}
	
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
	public String getOrderTime() {
		return OrderTime;
	}
	public void setOrderTime(String orderTime) {
		OrderTime = orderTime;
	}
	public Integer getShowTimeID() {
		return showTimeID;
	}
	public void setShowTimeID(Integer showTimeID) {
		this.showTimeID = showTimeID;
	}
	public Integer getMemberID() {
		return memberID;
	}
	public void setMemberID(Integer memberID) {
		this.memberID = memberID;
	}
	public String getTicketTime() {
		return ticketTime;
	}
	public void setTicketTime(String ticketTime) {
		this.ticketTime = ticketTime;
	}
	public Integer getEmployeeID() {
		return empId;
	}
	public void setEmployeeID(Integer empId) {
		this.empId = empId;
	}
	public ShowTimeHistoryBean getShowTimeHistoryBean() {
		return ShowTimeHistoryBean;
	}
	public void setShowTimeHistoryBean(ShowTimeHistoryBean showTimeHistoryBean) {
		ShowTimeHistoryBean = showTimeHistoryBean;
	}
	public MemberBean getMemberBean() {
		return MemberBean;
	}
	public void setMemberBean(MemberBean memberBean) {
		MemberBean = memberBean;
	}
	public EmpBean getEmpBean() {
		return EmpBean;
	}
	public void setEmpBean(EmpBean empBean) {
		EmpBean = empBean;
	}
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

}