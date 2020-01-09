package com.c.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.c.dao.SeatsDao;
import com.c.model.HallBean;
import com.c.model.SeatsBean;

@Repository
public class SeatsDaoImpl implements SeatsDao {

	SessionFactory factory;

	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	//將廳勾選好的位子加入seats table
	@Override
	public void insertSeats(SeatsBean sb){
		Session session = factory.getCurrentSession();
		HallBean hb = getHallById(sb.getHallID());
		sb.setHallBean(hb);
		session.save(sb);
		
	}
	
	@Override
	public HallBean getHallById(String hallID) {
		Session session = factory.getCurrentSession();
		HallBean hb = session.get(HallBean.class, hallID);
		return hb;
	}

	//後端更新此位是否可以出售
	@Override
	public void updateSeatStatus(Integer status, String seatID) {
		Session session = factory.getCurrentSession();
		SeatsBean sb = session.get(SeatsBean.class, seatID);
		sb.setSeatStatus(status);
		session.saveOrUpdate(sb);
	}

	
	//後端顯示
	@SuppressWarnings("unchecked")
	@Override
	public List<SeatsBean> getAllSeats(String hallID) {
		Session session = factory.getCurrentSession();
		List<SeatsBean> list = new ArrayList<>();
		String hql = "FROM SeatsBean";
		list = session.createQuery(hql).getResultList();
		return list;
	}

	

}
