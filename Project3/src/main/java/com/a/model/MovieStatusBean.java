package com.a.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "movieStatus")
public class MovieStatusBean implements Serializable {
	
	@Id
	@Column(nullable=false,columnDefinition="TINYINT")
	Integer StatusID;
	@Column(columnDefinition="NVARCHAR(10)")
	String  Status;
	
	public MovieStatusBean() {
		
	}

	public Integer getStatusID() {
		return StatusID;
	}

	public void setStatusID(Integer statusID) {
		StatusID = statusID;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}
	
	
	
	
}