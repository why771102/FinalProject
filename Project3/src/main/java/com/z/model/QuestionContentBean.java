package com.z.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="QuestionContent")
public class QuestionContentBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="questionId")
	QuestionBean questionBean;
	Date datetime;
	String content;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="empId")
	EmpBean empBean;
	
	public QuestionBean getQuestionBean() {
		return questionBean;
	}
	
	public void setQuestionBean(QuestionBean questionBean) {
		this.questionBean = questionBean;
	}
	
	public Date getDatetime() {
		return datetime;
	}
	
	public void setDatetime(Date datetime) {
		this.datetime = datetime;
	}
	
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public EmpBean getEmpBean() {
		return empBean;
	}
	
	public void setEmpBean(EmpBean empBean) {
		this.empBean = empBean;
	}
	
}
