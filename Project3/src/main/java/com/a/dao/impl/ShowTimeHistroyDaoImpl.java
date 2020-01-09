package com.a.dao.impl;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.a.dao.ShowTimeHistoryDao;
import com.a.model.RunningBean;
import com.a.model.ShowTimeHistoryBean;

@Repository
public class ShowTimeHistroyDaoImpl implements ShowTimeHistoryDao {
	SessionFactory factory;
	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	
	@Override
	public void addShowTimeHistory(ShowTimeHistoryBean show) {
		Session session =factory.getCurrentSession();
		session.save(show);

	}

	@Override
	public List<ShowTimeHistoryBean> getshowMovie(Timestamp playStartTime) {
		// TODO Auto-generated method stub
		Session session =factory.getCurrentSession();
		return null;
	}

	@Override
	public List<ShowTimeHistoryBean> getShowTimeHistoryBean(List<RunningBean> Orb ) {
		// TODO Auto-generated method stub
		Session session =factory.getCurrentSession();
		return null;
	}

}
