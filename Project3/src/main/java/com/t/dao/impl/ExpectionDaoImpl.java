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
		MemberBean mb = getMemberById(eb.getMemberID());
		eb.setMemberBean(mb);
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
	public MemberBean getMemberById(int memberID) {
		MemberBean mb = null;
		Session session = factory.getCurrentSession();
		mb = session.get(MemberBean.class,memberID);
		return mb;
	}

	//列出電影ID
	@Override
	public List<String> getMovies() {
		String hql="Select Distinct movieID from MovieBean";
		Session session=factory.getCurrentSession();
		List<String> list=new ArrayList<>();
		list=session.createQuery(hql).getResultList();
		return list;
	}
	
	//用列出的電影ID查Expectation
	@Override
	public List<ExpectationBean> getExpectationByMovie(Integer movieID) {
		String hql="from ExpectationBean where movieID = :movieID";
		Session session=factory.getCurrentSession();
		List<ExpectationBean> list=new ArrayList<>();
		list=session.createQuery(hql).setParameter("movieID", movieID).getResultList();
		return list;
	}

}
