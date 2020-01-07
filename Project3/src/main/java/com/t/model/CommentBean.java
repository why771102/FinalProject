package com.t.model;



import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.a.model.MovieBean;
import com.p.model.MemberBean;


@Entity
@Table(name="Comment")
public class CommentBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer commentId;
//	Integer movieID;
//	Integer memberID;
	Integer grade;
	String commentContent;
	Date commentTime;
	Integer commentDelete;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="movieID")
	private MovieBean movieID;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="memberID")
	private MemberBean memberID;
	

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

	public MemberBean getmemberID() {
		return memberID;
	}

	public void setmemberID(MemberBean memberID) {
		this.memberID = memberID;
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

	public Date getCommentTime() {
		return commentTime;
	}

	public void setCommentTime(Date commentTime) {
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