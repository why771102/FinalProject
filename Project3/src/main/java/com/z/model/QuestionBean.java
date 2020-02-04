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
import javax.persistence.Transient;

import com.p.model.MemberBean;


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
	@JoinColumn(name="memberId")
	MemberBean memberBean;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "status")
	QuestionStatusBean questionStatusBean;
	
	@Transient
	Integer status;
	
	public MemberBean getMemberBean() {
		return memberBean;
	}

	public void setMemberBean(MemberBean memberBean) {
		this.memberBean = memberBean;
	}

	public QuestionStatusBean getQuestionStatusBean() {
		return questionStatusBean;
	}

	public void setQuestionStatusBean(QuestionStatusBean questionStatusBean) {
		this.questionStatusBean = questionStatusBean;
	}

	
	
	public QuestionBean() {

	}
	
	public Integer getQuestionId() {
		return questionId;
	}
	
	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	public MemberBean getUserBean() {
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
