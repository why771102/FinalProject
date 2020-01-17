package com.c.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="hallStatus")
public class HallStatusBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(columnDefinition="TINYINT")
	Integer hallStatusID;
	@Column(columnDefinition="NVARCHAR(6)")
	String hallStatusName;
	
	public HallStatusBean() {
		
	}
	
	public HallStatusBean(Integer hallStatusID, String hallStatusName) {
		this.hallStatusID = hallStatusID;
		this.hallStatusName = hallStatusName;
	}
	
	public Integer getHallStatusID() {
		return hallStatusID;
	}

	public void setHallStatusID(Integer hallStatusID) {
		this.hallStatusID = hallStatusID;
	}

	public String getHallStatusName() {
		return hallStatusName;
	}

	public void setHallStatusName(String hallStatusName) {
		this.hallStatusName = hallStatusName;
	}

}
