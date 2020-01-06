package com.z.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.z.dao.AnnoDao;
import com.z.model.AnnoBean;

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
		session.save(ab);

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
		String hql = "update AnnoBean set title = :title, content = :content, "

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



}
