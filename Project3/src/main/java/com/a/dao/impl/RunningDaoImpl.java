package com.a.dao.impl;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.a.dao.RunningDao;
import com.a.model.RunningBean;

@Repository
public class RunningDaoImpl implements RunningDao {
	SessionFactory factory;
	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	
	@Override
	public void addrunning(RunningBean run) {
		Session session =factory.getCurrentSession();
		session.save(run);

	}

	@Override
	public List<RunningBean> getComingSoonMovie(Timestamp release) {
		// TODO Auto-generated method stub
		Session session =factory.getCurrentSession();
		return null;
	}

	@Override
	public List<RunningBean> getAllOnMoive(Timestamp release, Timestamp expectedOffDate) {
		// TODO Auto-generated method stub
		Session session =factory.getCurrentSession();
		return null;
	}

	@Override
	public List<RunningBean> getOnRunnigBean(Timestamp release) {
		// TODO Auto-generated method stub
		Session session =factory.getCurrentSession();
		return null;
	}

}
