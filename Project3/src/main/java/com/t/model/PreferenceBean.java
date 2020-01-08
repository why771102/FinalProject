package com.t.model;



import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.p.model.MemberBean;
import com.sun.istack.NotNull;


@Entity
@Table(name="Preference")
public class PreferenceBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@NotNull
	@Column(nullable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer preferenceID;
//	Integer commentID;
//	Integer memberID;
	@NotNull
	@Column(nullable=false, columnDefinition = "TINYINT")
	Integer good;
	@NotNull
	@Column(nullable=false, columnDefinition = "TINYINT")
	Integer bad;
	@NotNull
	@Column(nullable=false, columnDefinition = "TINYINT")
	Integer block;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="commentID")
	private CommentBean commentID;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="memberID")
	private MemberBean memberID;
	

	public CommentBean getcommentID() {
		return commentID;
	}

	public void setMovieID(CommentBean commentID) {
		this.commentID = commentID;
	}
	
	public Integer getPreferenceID() {
		return preferenceID;
	}

	public void setPreferenceID(Integer preferenceID) {
		this.preferenceID = preferenceID;
	}

	public MemberBean getmemberID() {
		return memberID;
	}

	public void setmemberID(MemberBean memberID) {
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