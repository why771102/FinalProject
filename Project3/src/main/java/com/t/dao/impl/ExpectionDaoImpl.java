package com.t.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.NonUniqueResultException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.a.model.MovieBean;
import com.p.model.MemberBean;
import com.t.dao.ExpectionDao;
import com.t.model.CommentBean;
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
		MemberBean mb = getMemberById(eb.getMemberID());
		eb.setMovieBean(mvb);
		eb.setMemberBean(mb);
		session.save(eb);
	}
	
	//抓出該會員是否在該電影留過期待度
	@Override
	public boolean checkExpectationExist(Integer memberID,Integer movieID) {
		boolean exist = false;
		String hql = "From ExpectationBean Where memberID = :memberID and movieID = :movieID";
		Session session = factory.getCurrentSession();
		try{
			ExpectationBean pb = (ExpectationBean) session.createQuery(hql)
												.setParameter("memberID",memberID)
												.setParameter("movieID", movieID)
												.getSingleResult();
			if(pb != null) {
				exist = true;
			}
		}catch(NoResultException ex) {
			exist = false;
		}catch(NonUniqueResultException ex) {
			exist = false;
		}
		return exist;
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

	//列出未上映電影ID
	@Override
	public List<String> getStandbyMovies() {
		String hql="from MovieBean Where movieStatus = 0";
		Session session=factory.getCurrentSession();
		List<String> list=new ArrayList<>();
		list=session.createQuery(hql).getResultList();
		return list;
	}
	
	//列出電影ID
	@Override
	public List<String> getMovies() {
		String hql="from MovieBean Where movieStatus = 0 or movieStatus = 1";
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

	@Override
	public Integer getAvgExpectation(Integer movieID) {
		String hql = "From ExpectationBean where movieID = :movieID";
		Session session = factory.getCurrentSession();
		List<ExpectationBean> list = new ArrayList<>();
		list = session.createQuery(hql).setParameter("movieID", movieID).getResultList();
		Integer totalGrade = 0;
		Integer avgGrade = 0;
		if(list.size() == 0) {
			avgGrade = null;
		}else {
			for (int i = 0; i < list.size(); i++) {
				Integer grade = list.get(i).getExpective();
				totalGrade = totalGrade + grade*100;
			}
			avgGrade = totalGrade/list.size();
		}
		return avgGrade;
	}

//	@Override
//	public List<MemberBean> getMemberList() {
//		String hql = "FROM MemberBean";
//		Session session = factory.getCurrentSession();
//		List<MemberBean> list = session.createQuery(hql).getResultList();
//		return list;
//	}
}
