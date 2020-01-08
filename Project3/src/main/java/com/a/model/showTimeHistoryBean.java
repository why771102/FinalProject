package com.a.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.c.model.HallBean;

@Entity
@Table(name = "showTimeHistory" )
public class ShowTimeHistoryBean implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer showTimeId;
//	String hallID;
//	Integer runID;
	Timestamp palyStartTime;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="runID")
	RunningBean run;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="hallID")
	HallBean hall;
	
	
	public ShowTimeHistoryBean() {
	}

	public ShowTimeHistoryBean(Integer showTimeId, HallBean hall, RunningBean run, Timestamp palyStartTime) {

		this.showTimeId = showTimeId;
		this.hall = hall;
		this.run = run;
		this.palyStartTime = palyStartTime;
	};
	

	public RunningBean getRun() {
		return run;
	}

	public void setRun(RunningBean run) {
		this.run = run;
	}

	public HallBean getHall() {
		return hall;
	}

	public void setHall(HallBean hall) {
		this.hall = hall;
	}

	public Integer getShowTimeId() {
		return showTimeId;
	}

	public void setShowTimeId(Integer showTimeId) {
		this.showTimeId = showTimeId;
	}

//	public String getHallID() {
//		return hallID;
//	}
//
//	public void setHallID(String hallID) {
//		this.hallID = hallID;
//	}
//
//	public Integer getRunID() {
//		return runID;
//	}
//
//	public void setRunID(Integer runID) {
//		this.runID = runID;
//	}

	public Timestamp getPalyStartTime() {
		return palyStartTime;
	}

	public void setPalyStartTime(Timestamp palyStartTime) {
		this.palyStartTime = palyStartTime;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}
