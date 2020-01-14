package com.t.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.a.model.MovieBean;
import com.p.model.MemberBean;
import com.t.dao.ExpectionDao;
import com.t.model.ExpectationBean;
import com.t.service.ExpectationService;

@Service
public class ExpectationServiceImpl implements ExpectationService{
	ExpectionDao dao;

	@Transactional
	@Override
	public List<ExpectationBean> getMemberExpectation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public List<ExpectationBean> getAllExpectation() {
		return null;
	}

	@Transactional
	@Override
	public void addExpect(ExpectationBean eb) {
		
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

}
