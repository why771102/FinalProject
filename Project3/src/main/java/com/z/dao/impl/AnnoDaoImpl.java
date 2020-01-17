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
	public void launchAnno(Integer annoId) {
		String hql = "update AnnoBean set status = 1 where annoId = :annoId";
		Session session = factory.getCurrentSession();
		session.createQuery(hql).setParameter("annoId", annoId).executeUpdate();

	}

	@Override
	public void takeOff(Integer annoId) {
		String hql = "update AnnoBean set status = 2 where annoId = :annoId";
		Session session = factory.getCurrentSession();
		session.createQuery(hql).setParameter("annoId", annoId).executeUpdate();
	}

	@Override
	public void updateAnno(AnnoBean ab) {
		String hql = "update AnnoBean set title = :title, content = :content, priority = :priority, startTime = :startTime, endTime = :endTime where annoId = :annoId ";
		Session session = factory.getCurrentSession();
		session.createQuery(hql).setParameter("title", ab.getTitle()).setParameter("content", ab.getContent())
				.setParameter("priority", ab.getPriority()).setParameter("startTime", ab.getStartTime())
				.setParameter("endTime", ab.getEndTime()).setParameter("annoId", ab.getAnnoId()).executeUpdate();
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
		ab.setStatus(ab.getAnnoStatusBean().getStatus());
		return ab;
	}

	@Override
	public List<AnnoStatusBean> getAnnoStatusList() {
		String hql = "from AnnoStatusBean";
		Session session = factory.getCurrentSession();
		List<AnnoStatusBean> list = session.createQuery(hql).getResultList();
		return list;
	}

	// 前端顯示用的method
	@SuppressWarnings("unchecked")
	@Override
	public List<AnnoBean> showAnnoToMember() {
		String hql = "from AnnoBean";
		Session session = factory.getCurrentSession();
		List<AnnoBean> list = new ArrayList<>();
		list = session.createQuery(hql).getResultList();
		AnnoBean temp = null;
		AnnoBean fir = null;
		AnnoBean sed = null;

		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = 0; j < list.size() - i -1; j++) {
				fir = list.get(j);
				sed = list.get(j + 1);
				if (fir.getPriority() > sed.getPriority()) {
					temp = fir;
					list.set(j, sed);
					list.set(j + 1, temp);
				}
			}
		}
		
		int len =  list.size() - 1;
		for (int i = len; i >= 0 ; i--) {
			System.out.println(list.get(i).getContent());
			System.out.println(list.get(i).getAnnoStatusBean().getStatus());
			if(list.get(i).getAnnoStatusBean().getStatus().equals(2)) {
				list.remove(i);
			}
		}

		return list;
	}

}
