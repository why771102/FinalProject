package com.t.model;


import java.io.Serializable;

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

import com.p.model.MemberBean;
import com.sun.istack.NotNull;


@Entity
@IdClass(com.t.model.PreferenceID.class)
@Table(name="Preference")
public class PreferenceBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="commentID")
	private CommentBean CommentBean;
	
	@Transient
	Integer commentID;
	
	@Id
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="memberID")
	private MemberBean MemberBean;
	
	@Transient
	Integer memberID;
	
	@NotNull
	@Column(nullable=false, columnDefinition = "TINYINT")
	Integer good;
	@NotNull
	@Column(nullable=false, columnDefinition = "TINYINT")
	Integer bad;
	@NotNull
	@Column(nullable=false, columnDefinition = "TINYINT")
	Integer block;
	
	public PreferenceBean() {
		
	}
	
	public PreferenceBean(Integer good, Integer bad, Integer block, Integer commentID, Integer memberID) {
		this.good = good;
		this.bad = bad;
		this.block = block;
		this.commentID = commentID;
		this.memberID = memberID;
	}
	

	public CommentBean getCommentBean() {
		return CommentBean;
	}

	public void setCommentBean(CommentBean commentBean) {
		CommentBean = commentBean;
	}

	public Integer getCommentID() {
		return commentID;
	}

	public void setCommentID(Integer commentID) {
		this.commentID = commentID;
	}

	public MemberBean getMemberBean() {
		return MemberBean;
	}

	public void setMemberBean(MemberBean memberBean) {
		MemberBean = memberBean;
	}

	public Integer getMemberID() {
		return memberID;
	}

	public void setMemberID(Integer memberID) {
		this.memberID = memberID;
	}

	public Integer getGood() {
		return good;
	}

	public void setGood(Integer good) {
		this.good = good;
	}

	public Integer getBad() {
		return bad;
	}

	public void setBad(Integer bad) {
		this.bad = bad;
	}

	public Integer getBlock() {
		return block;
	}

	public void setBlock(Integer block) {
		this.block = block;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}