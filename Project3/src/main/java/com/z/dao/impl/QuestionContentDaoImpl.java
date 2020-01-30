package com.z.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.z.dao.QuestionContentDao;
import com.z.model.EmpBean;
import com.z.model.QuestionBean;
import com.z.model.QuestionContentBean;

@Repository
public class QuestionContentDaoImpl implements QuestionContentDao {

	SessionFactory factory;

	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<QuestionContentBean> historyContent(Integer questionId) {
		String hql = "from QuestionContentBean where questionId = :questionId";
		Session session = factory.getCurrentSession();
		List<QuestionContentBean> list = session.createQuery(hql).setParameter("questionId", questionId).getResultList();
		return list;
	}

	@Override
	public void saveMessage(QuestionContentBean conBean) {
		Session session = factory.getCurrentSession();
		QuestionBean qb = session.get(QuestionBean.class, conBean.getQuestionId());
		conBean.setQuestionBean(qb);
		if(conBean.getEmpId() != null) {
			EmpBean eb = session.get(EmpBean.class, conBean.getEmpId());
			conBean.setEmpBean(eb);
		}
		session.save(conBean);
	}

}
