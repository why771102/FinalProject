package com.c.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.a.model.ShowTimeHistoryBean;
import com.c.dao.SeatOrderDao;
import com.c.model.SeatOrderBean;
import com.c.model.SeatsBean;

@Repository
public class SeatOrderDaoImpl implements SeatOrderDao {


	SessionFactory factory;

	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	
	@Override
	public void insertSeatOrder(SeatOrderBean sob) {
		Session session = factory.getCurrentSession();
		ShowTimeHistoryBean sthb = getShowTimeById(sob.getShowTimeID());
		SeatsBean sb = getSeatsById(sob.getSeatID());
		sob.setShowtimeHistoryBean(sthb);
		sob.setSeatsBean(sb);
		session.save(sob);
		
	}

	@Override
	public SeatsBean getSeatsById(String seatID) {
		Session session = factory.getCurrentSession();
		SeatsBean sb = session.get(SeatsBean.class, seatID);
		return sb;
	}

	@Override
	public ShowTimeHistoryBean getShowTimeById(Integer showTimeID) {
		Session session = factory.getCurrentSession();
		ShowTimeHistoryBean sthb = session.get(ShowTimeHistoryBean.class, showTimeID);
		return sthb;
	}

}
