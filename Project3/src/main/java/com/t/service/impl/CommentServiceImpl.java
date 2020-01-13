package com.t.service.impl;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.a.model.MovieBean;
import com.p.model.MemberBean;
import com.t.dao.CommentDao;
import com.t.model.CommentBean;
import com.t.model.ExpectationBean;
import com.t.service.CommentService;

public class CommentServiceImpl implements CommentService{
	CommentDao dao;
	
	@Override
	public ExpectationBean getAvgGrade(Integer grade) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CommentBean getComment(Integer commentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CommentBean> memberComment() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<CommentBean> findAllComment() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteComment(CommentBean cb) {
		// TODO Auto-generated method stub
		
	}

	@Transactional
	@Override
	public void addComment(CommentBean cb) {
		dao.addComment(cb);
	}

	@Transactional
	@Override
	public MovieBean getMovieById(int movieID) {
		return dao.getMovieById(movieID);
	}

	@Transactional
	@Override
	public MemberBean getMemberById(int memberID) {
		return dao.getMemberById(memberID);
	}

	@Override
	public List<CommentBean> getCommentList() {
		// TODO Auto-generated method stub
		return null;
	}

}
