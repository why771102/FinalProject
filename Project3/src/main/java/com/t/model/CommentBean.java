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
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@NotNull
	@Column(nullable=false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer commentId;
//	Integer movieID;
//	Integer memberID;
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
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="movieID")
	private MovieBean movieID;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="memberID")
	private MemberBean memberID;
	
	public CommentBean() {
		
	}
	
	public CommentBean(Integer commentId, Integer watched, Integer grade, String commentContent, String commentTime, Integer commentDelete, MovieBean movieID, MemberBean memberID) {
		this.commentId = commentId;
		this.watched = watched;
		this.grade = grade;
		this.commentContent = commentContent;
		this.commentTime = commentTime;
		this.commentDelete = commentDelete;
		this.movieID = movieID;
		this.memberID = memberID;
	}
	
	public Integer getCommentId() {
		return commentId;
	}
	
	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}
	
	public MovieBean getMovieID() {
		return movieID;
	}

	public void setMovieID(MovieBean movieID) {
		this.movieID = movieID;
	}

	public MemberBean getMemberID() {
		return memberID;
	}

	public void setMemberID(MemberBean memberID) {
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}