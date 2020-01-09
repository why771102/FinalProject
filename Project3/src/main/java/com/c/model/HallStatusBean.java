package com.c.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hallStatus")
public class HallStatusBean implements Serializable{

	private static final long serialVersionUID = 1L;
	@Id
	String hallStatusID;
	Integer hallStatusName;
	
	public HallStatusBean() {
		
	}
	
	public HallStatusBean(String hallStatusID, Integer hallStatusName) {
		this.hallStatusID = hallStatusID;
		this.hallStatusName = hallStatusName;
	}
	
	public String getHallStatusID() {
		return hallStatusID;
	}

	public void setHallStatusID(String hallStatusID) {
		this.hallStatusID = hallStatusID;
	}

	public Integer getHallStatusName() {
		return hallStatusName;
	}

	public void setHallStatusName(Integer hallStatusName) {
		this.hallStatusName = hallStatusName;
	}

}
