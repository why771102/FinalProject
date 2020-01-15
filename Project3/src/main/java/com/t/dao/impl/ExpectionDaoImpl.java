package com.t.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.a.model.MovieBean;
import com.p.model.MemberBean;
import com.t.dao.ExpectionDao;
import com.t.model.ExpectationBean;

@Repository
public class ExpectionDaoImpl implements ExpectionDao{
	SessionFactory factory;
	
	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	@Override
	public void addExpect(ExpectationBean eb) {
		Session session = factory.getCurrentSession();
		MovieBean mvb = getMovieById(eb.getMovieID());
		eb.setMovieBean(mvb);
		session.save(eb);
	}
	
	@Override
	public MovieBean getMovieById(int movieID) {
		MovieBean mvb = null;
		Session session = factory.getCurrentSession();
		mvb = session.get(MovieBean.class,movieID);
		return mvb;
	}

	@Override
	public List<ExpectationBean> getMemberExpectation() {
		
		return null;
	}

	@Override
	public List<ExpectationBean> getAllExpectation() {
		String hql = "FROM ExpectationBean";
		Session session = factory.getCurrentSession();
		List<ExpectationBean> list = new ArrayList<>();
		list = session.createQuery(hql).getResultList();
		return list;
	}
	
	@Override
	public List<ExpectationBean> getExpectation() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberBean getMemberById(int memberID) {
		MemberBean mb = null;
		Session session = factory.getCurrentSession();
		mb = session.get(MemberBean.class,memberID);
		return mb;
	}
	
}
