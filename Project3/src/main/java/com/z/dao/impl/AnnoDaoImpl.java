package com.z.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.z.dao.AnnoDao;
import com.z.model.AnnoBean;
import com.z.model.AnnoStatusBean;
import com.z.model.EmpStatusBean;

@Repository
public class AnnoDaoImpl implements AnnoDao {
	
	SessionFactory factory;
	
	
	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	@Override
	public void addNewAnno(AnnoBean ab) {
		Session session = factory.getCurrentSession();
		AnnoStatusBean asb = getAnnoStatusById(ab.getStatus());
		ab.setAnnoStatusBean(asb);
		session.saveOrUpdate(ab);

	}
	
	@Override
	public AnnoStatusBean getAnnoStatusById(Integer status) {
		Session session = factory.getCurrentSession();
		AnnoStatusBean asb = session.get(AnnoStatusBean.class, status);
		return asb;
	}
	
	@Override
	public void launchAnno(AnnoBean ab) {
		String hql = "update AnnoBean set status = 1 where annoId = :annoId";
		Session session = factory.getCurrentSession();
		session.createQuery(hql).setParameter("annoId", ab.getAnnoId()).executeUpdate();
	
		
	}

	@Override
	public void takeOff(AnnoBean ab) {
		String hql = "update AnnoBean set status = 0 where annoId = :annoId";
		Session session = factory.getCurrentSession();
		session.createQuery(hql).setParameter("annoId", ab.getAnnoId()).executeUpdate();
	}

	@Override
	public void updateAnno(AnnoBean ab) {
		String hql = "update AnnoBean set title = :title, content = :content, priority = :priority, startTime = :startTime, endTime = :endTime where annoId = :annoId ";
		Session session = factory.getCurrentSession();
		session.createQuery(hql).setParameter("title",ab.getTitle()).setParameter("content",ab.getContent()).setParameter("priority",ab.getPriority()).setParameter("startTime",ab.getStartTime()).setParameter("endTime",ab.getEndTime()).setParameter("annoId",ab.getAnnoId()).executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AnnoBean> showAnno() {
		String hql = "from AnnoBean";
		Session session = factory.getCurrentSession();
		List<AnnoBean> list = new ArrayList<>();
		list = session.createQuery(hql).getResultList();
		return list;
	}
	

	@Override
	public AnnoBean showOneAnno(Integer annoId) {
		String hql = "from AnnoBean where annoId = :annoId";
		Session session = factory.getCurrentSession();
		AnnoBean ab = (AnnoBean) session.createQuery(hql).setParameter("annoId", annoId).getSingleResult();
		return ab;
	}
	
	@Override
	public List<AnnoStatusBean> getAnnoStatusList() {
		String hql = "from AnnoStatusBean";
		Session session = factory.getCurrentSession();
		List<AnnoStatusBean> list = session.createQuery(hql).getResultList();
		return list;
	}



}
