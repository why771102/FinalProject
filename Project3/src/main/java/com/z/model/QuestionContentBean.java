package com.z.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;


@Entity
@Table(name="QuestionContent")
@IdClass(com.z.model.QuestionContentID.class)
public class QuestionContentBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="questionId")
	private QuestionBean questionBean;
	
	@Transient
	Integer questionId;
	
	@Id
	@Column(columnDefinition = "datetime")
	String datetime;
	
	String content;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="empId")
	EmpBean empBean;
	
	@Transient
	Integer empId;
	
	String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public QuestionContentBean() {

	}

	public QuestionBean getQuestionBean() {
		return questionBean;
	}
	
	public void setQuestionBean(QuestionBean questionBean) {
		this.questionBean = questionBean;
	}
	
	public String getDatetime() {
		return datetime;
	}
	
	public void setDatetime(String datetime) {
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

	public Integer getQuestionId() {
		return questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	
	
	
	
}
