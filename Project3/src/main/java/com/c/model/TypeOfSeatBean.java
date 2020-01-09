package com.c.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="typeofSeat")
public class TypeOfSeatBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	String typeofSeatID;
	Integer typeofSeatName;
	
	public TypeOfSeatBean() {
		
	}
	
	public TypeOfSeatBean(String typeofSeatID, Integer typeofSeatName) {
		this.typeofSeatID = typeofSeatID;
		this.typeofSeatName = typeofSeatName;
	}

	public String getTypeofSeatID() {
		return typeofSeatID;
	}

	public void setTypeofSeatID(String typeofSeatID) {
		this.typeofSeatID = typeofSeatID;
	}

	public Integer getTypeofSeatName() {
		return typeofSeatName;
	}

	public void setTypeofSeatName(Integer typeofSeatName) {
		this.typeofSeatName = typeofSeatName;
	}
	
	
	
}
