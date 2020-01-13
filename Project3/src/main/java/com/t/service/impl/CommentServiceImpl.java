package com.t.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.a.model.MovieBean;
import com.p.model.MemberBean;
import com.t.dao.CommentDao;
import com.t.model.CommentBean;
import com.t.model.ExpectationBean;
import com.t.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService{
	CommentDao dao;
	@Transactional
	@Override
	public ExpectationBean getAvgGrade(Integer grade) {
		// TODO Auto-generated method stub
		return null;
	}
	@Transactional
	@Override
	public CommentBean getComment(Integer commentId) {
		// TODO Auto-generated method stub
		return null;
	}
	@Transactional
	@Override
	public List<CommentBean> memberComment() {
		// TODO Auto-generated method stub
		return null;
	}
	@Transactional
	@Override
	public List<CommentBean> findAllComment() {
		// TODO Auto-generated method stub
		return null;
	}
	@Transactional
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

	@Transactional
	@Override
	public List<MovieBean> getMovieList() {
		return dao.getMovieList();
	}

	@Transactional
	@Override
	public List<MemberBean> getMemberList() {
		return dao.getMemberList();
	}

}
