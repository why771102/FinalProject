package com.c.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="typeofSeat")
public class TypeOfSeatBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(columnDefinition="TINYINT")
	Integer typeofSeatID;
	@Column(columnDefinition="NVARCHAR(6)")
	String typeofSeatName;
	
	public TypeOfSeatBean() {
		
	}
	
	public TypeOfSeatBean(Integer typeofSeatID, String typeofSeatName) {
		this.typeofSeatID = typeofSeatID;
		this.typeofSeatName = typeofSeatName;
	}

	public Integer getTypeofSeatID() {
		return typeofSeatID;
	}

	public void setTypeofSeatID(Integer typeofSeatID) {
		this.typeofSeatID = typeofSeatID;
	}

	public String getTypeofSeatName() {
		return typeofSeatName;
	}

	public void setTypeofSeatName(String typeofSeatName) {
		this.typeofSeatName = typeofSeatName;
	}
	
	
	
}
