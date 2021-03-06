package com.z.model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Timestamp;

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
@Table(name="Anno")
public class AnnoBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer annoId;
	@Column(columnDefinition = "smalldatetime")
	String startTime;
	@Column(columnDefinition = "smalldatetime")
	String endTime;
	@Column(columnDefinition = "NVARCHAR(50)")
	String title;
	@Column(columnDefinition = "NVARCHAR(MAX)")
	String content;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "status")
	AnnoStatusBean annoStatusBean;
	
	@Transient
	Integer status;
	Integer priority;
	
	public AnnoBean() {
		
	}
	
	public AnnoStatusBean getAnnoStatusBean() {
		return annoStatusBean;
	}




	public void setAnnoStatusBean(AnnoStatusBean annoStatusBean) {
		this.annoStatusBean = annoStatusBean;
	}




	public Integer getAnnoId() {
		return annoId;
	}
	
	public void setAnnoId(Integer annoId) {
		this.annoId = annoId;
	}
	
	public String getStartTime() {
		return startTime;
	}
	
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	
	public String getEndTime() {
		return endTime;
	}
	
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public Integer getStatus() {
		return status;
	}
	
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public Integer getPriority() {
		return priority;
	}
	
	public void setPriority(Integer priority) {
		this.priority = priority;
	}
	
	
}
