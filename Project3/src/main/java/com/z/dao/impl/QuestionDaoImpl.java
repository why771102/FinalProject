package com.z.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.p.model.MemberBean;
import com.z.dao.QuestionDao;
import com.z.model.QuestionBean;
import com.z.model.QuestionStatusBean;

@Repository
public class QuestionDaoImpl implements QuestionDao {

	SessionFactory factory;

	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<QuestionBean> allQuestion(Integer memberId) {
		String hql = "from QuestionBean where memberId = :memberId";
		Session session = factory.getCurrentSession();
		List<QuestionBean> list = null;
		try {
		list = session.createQuery(hql).setParameter("memberId", memberId).getResultList();
		}catch(Exception e) {
			
		}
		return list;
	}


	@Override
	public Integer newQuestion(Integer memberId) {
		
		Session session = factory.getCurrentSession();
		MemberBean member = session.get(MemberBean.class, memberId);
		QuestionBean newQues = new QuestionBean();
		newQues.setUserBean(member);
		newQues.setQuestionStatusBean(session.get(QuestionStatusBean.class, 1));
		session.save(newQues);
		
		String hql = "from QuestionBean where memberId = :memberId";
		List<QuestionBean> list = null;
		list = session.createQuery(hql).setParameter("memberId", memberId).getResultList();
		Integer questionId = null;
		for(QuestionBean qb : list) {
			Integer qid = qb.getQuestionId();
			if(questionId == null || qid > questionId) {
				questionId = qid;
			}
		}
		return questionId;
	}


	@Override
	public boolean checkMember(Integer memberId, Integer questionId) {
		List<QuestionBean> list = allQuestion(memberId);
		boolean exist = false;
		for(QuestionBean qb : list) {
			if(qb.getQuestionId() == questionId) {
				exist = true;
				break;
			}
		}
		return exist;
	}


	@Override
	public List<QuestionBean> allQuestionForEmp() {
		String hql = "from QuestionBean";
		Session session = factory.getCurrentSession();
		List<QuestionBean> list = null;
		list = session.createQuery(hql).getResultList();
		return list;
		
	}


	@Override
	public void closeQuestion(Integer questionId) {
		String hql = "update QuestionBean set status = 2 where questionId = :questionId";
		Session session = factory.getCurrentSession();
		session.createQuery(hql).setParameter("questionId", questionId).executeUpdate();
		
		
	}


	@Override
	public void openQuestion(Integer questionId) {
		String hql = "update QuestionBean set status = 1 where questionId = :questionId";
		Session session = factory.getCurrentSession();
		session.createQuery(hql).setParameter("questionId", questionId).executeUpdate();
		
		
	}


	@Override
	public QuestionBean question(Integer questionId) {
		Session session = factory.getCurrentSession();
		QuestionBean qb = session.get(QuestionBean.class, questionId);
		return qb;
	}
	
	

	

}
