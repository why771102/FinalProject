package com.t.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.a.model.MovieBean;
import com.p.model.MemberBean;
import com.sun.istack.NotNull;


@Entity
@Table(name="Expectation")
@IdClass(com.t.model.ExpectiveID.class)
public class ExpectationBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	
	@NotNull
	@Column(nullable=false)
	Integer expective;
	
	@Id
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="movieID")
	private MovieBean MovieBean;
	
	@Transient
	Integer movieID;
	
	@Id
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="memberID")
	private MemberBean MemberBean;
	
	@Transient
	Integer memberID;
	
	public ExpectationBean(Integer expective, Integer movieID, Integer memberID) {
		this.expective = expective;
		this.movieID = movieID;
		this.memberID = memberID;
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

	public ExpectationBean() {
		
	}

	public MovieBean getMovieBean() {
		return MovieBean;
	}

	public void setMovieBean(MovieBean movieBean) {
		MovieBean = movieBean;
	}

	public Integer getMovieID() {
		return movieID;
	}

	public void setMovieID(Integer movieID) {
		this.movieID = movieID;
	}


	public Integer getExpective() {
		return expective;
	}

	public void setExpective(Integer expective) {
		this.expective = expective;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}