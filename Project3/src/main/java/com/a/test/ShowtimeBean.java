package com.a.test;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.a.model.RunningBean;
import com.p.model.HallOrderBean;
import com.sun.istack.NotNull;

//不存進DB

public class ShowtimeBean implements Serializable {
	private static final long serialVersionUID = 1L;
    
	Integer stID;
//	Integer movieID;
//	String title;
//	LocalDate release;
    int runningTime;
    double price_time;
    RunningBean rb;
    HallOrderBean hob;
    LocalDateTime StartTime;
    
//	Integer expectedOnDay;
//	LocalDate expectedOffDate;
	

	public ShowtimeBean() {}
	public ShowtimeBean(Integer stID, int runningTime, double price_time, RunningBean rb, HallOrderBean hob) {
		super();
		this.stID = stID;
		this.runningTime = runningTime;
		this.price_time = price_time;
		this.rb = rb;
		this.hob = hob;
	}
	public ShowtimeBean(Integer stID, int runningTime, double price_time, RunningBean rb) {
		super();
		this.stID = stID;
		this.runningTime = runningTime;
		this.price_time = price_time;
		this.rb = rb;
		
	}
	public ShowtimeBean(Integer stID, int runningTime, HallOrderBean hob) {
		super();
		this.stID = stID;
		this.runningTime = runningTime;
		this.hob = hob;
	}
	public ShowtimeBean(Integer stID, int runningTime) {
		super();
		this.stID = stID;
		this.runningTime = runningTime;
		
	}
	public LocalDateTime getStartTime() {
		return StartTime;
	}
	public void setStartTime(LocalDateTime startTime) {
		StartTime = startTime;
	}
public Integer getStID() {
		return stID;
	}

	public void setStID(Integer stID) {
		this.stID = stID;
	}

	public int getRunningTime() {
		return runningTime;
	}

	public void setRunningTime(int runningTime) {
		this.runningTime = runningTime;
	}

	public double getPrice_time() {
		return price_time;
	}

	public void setPrice_time(double price_time) {
		this.price_time = price_time;
	}

	public RunningBean getRb() {
		return rb;
	}

	public void setRb(RunningBean rb) {
		this.rb = rb;
	}

	public HallOrderBean getHob() {
		return hob;
	}

	public void setHob(HallOrderBean hob) {
		this.hob = hob;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	

}
	
	