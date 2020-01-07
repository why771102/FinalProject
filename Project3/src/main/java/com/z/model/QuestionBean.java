package com.z.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.z.model.EmpBean;


@Entity
@Table(name="Question")
public class QuestionBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer questionId;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="userId")
	MemberBean memberBean;
	Integer status;
	
	
	
	public Integer getQuestionId() {
		return questionId;
	}
	
	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public EmpBean getUserBean() {
		return memberBean;
	}
	
	public void setUserBean(MemberBean memberBean) {
		this.memberBean = memberBean;
	}
	
	public Integer getStatus() {
		return status;
	}
	
	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
