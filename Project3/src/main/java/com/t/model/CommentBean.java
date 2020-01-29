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
import javax.persistence.Transient;

import com.a.model.MovieBean;
import com.p.model.MemberBean;
import com.sun.istack.NotNull;


@Entity
@Table(name="Comment")
public class CommentBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@NotNull
	@Column(nullable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer commentID;
	@NotNull
	@Column(nullable=false, columnDefinition = "TINYINT")
	Integer watched;
	@NotNull
	@Column(nullable=false, columnDefinition = "TINYINT")
	Integer grade;
	@NotNull
	@Column(nullable=false, columnDefinition = "NVARCHAR(MAX)")
	String commentContent;
	@NotNull
	@Column(nullable=false, columnDefinition = "DATETIME")
	String commentTime;
	@NotNull
	@Column(nullable=false, columnDefinition = "TINYINT")
	Integer commentDelete;
	@NotNull
	@Column(nullable=false, columnDefinition = "TINYINT")
	Integer reportComment;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="movieID")
	private MovieBean movieBean;
	
	@Transient
	Integer movieID;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="memberID")
	private MemberBean memberBean;
	
	@Transient
	Integer memberID;
	
	public CommentBean() {
		
	}	

	public CommentBean(Integer commentID, Integer watched, Integer grade, String commentContent, String commentTime, Integer commentDelete, Integer movieID, Integer memberID,Integer reportComment) {
		this.commentID = commentID;
		this.watched = watched;
		this.grade = grade;
		this.commentContent = commentContent;
		this.commentTime = commentTime;
		this.commentDelete = commentDelete;
		this.movieID = movieID;
		this.memberID = memberID;
		this.reportComment = reportComment;
	}	

	public Integer getCommentID() {
		return commentID;
	}
	
	public void setCommentID(Integer commentID) {
		this.commentID = commentID;
	}
	
	public Integer getMovieID() {
		return movieID;
	}

	public void setMovieID(Integer movieID) {
		this.movieID = movieID;
	}

	public Integer getMemberID() {
		return memberID;
	}

	public void setMemberID(Integer memberID) {
		this.memberID = memberID;
	}
	
	public Integer getWatched() {
		return watched;
	}

	public void setWatched(Integer watched) {
		this.watched = watched;
	}

	public Integer getGrade() {
		return grade;
	}

	public void setGrade(Integer grade) {
		this.grade = grade;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public String getCommentTime() {
		return commentTime;
	}

	public void setCommentTime(String commentTime) {
		this.commentTime = commentTime;
	}

	public Integer getCommentDelete() {
		return commentDelete;
	}

	public void setCommentDelete(Integer commentDelete) {
		this.commentDelete = commentDelete;
	}
	
	public MovieBean getMovieBean() {
		return movieBean;
	}
	
//	public MovieBean getPreferenceBean() {
//		return getPreferenceBean();
//	}

	public void setMovieBean(MovieBean movieBean) {
		this.movieBean = movieBean;
	}

	public MemberBean getMemberBean() {
		return memberBean;
	}

	public void setMemberBean(MemberBean memberBean) {
		this.memberBean = memberBean;
	}
	
	public Integer getReportComment() {
		return reportComment;
	}

	public void setReportComment(Integer reportComment) {
		this.reportComment = reportComment;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}