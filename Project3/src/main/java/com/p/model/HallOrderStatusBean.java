package com.p.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hallOrderStatus")
public class HallOrderStatusBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer hallOrderStatusNo;
	String hallOrderStatus;
	
	public HallOrderStatusBean() {
		
	}

	public Integer getHallOrderStatusNo() {
		return hallOrderStatusNo;
	}

	public void setHallOrderStatusNo(Integer hallOrderStatusNo) {
		this.hallOrderStatusNo = hallOrderStatusNo;
	}

	public String getHallOrderStatus() {
		return hallOrderStatus;
	}

	public void setHallOrderStatus(String hallOrderStatus) {
		this.hallOrderStatus = hallOrderStatus;
	}
	
	
}
