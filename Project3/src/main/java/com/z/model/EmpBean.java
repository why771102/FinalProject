package com.z.model;

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


@Entity
@Table(name="Employee")
public class EmpBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer empId;
	
	String empName;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "roleId")
	RoleBean roleBean;
	
	@Transient
	Integer roleId;
	
	String email;
	String password;
	
	@Transient
	String pwd;
	
	String uid;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "status")
	EmpStatusBean empStatusBean;
	
	@Transient
	Integer status;
	
	@Column(columnDefinition = "date")
	String startDate;
	@Column(columnDefinition = "date")
	String endDate;
	
	
	
	public EmpBean() {

	}


	public EmpStatusBean getEmpStatusBean() {
		return empStatusBean;
	}
	
	public void setEmpStatusBean(EmpStatusBean empStatusBean) {
		this.empStatusBean = empStatusBean;
	}
	
	public RoleBean getRoleBean() {
		return roleBean;
	}
	
	public void setRoleBean(RoleBean roleBean) {
		this.roleBean = roleBean;
	}
	
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}


	public String getUid() {
		return uid;
	}


	public void setUid(String uid) {
		this.uid = uid;
	}
	

	
	

	

}
