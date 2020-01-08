package com.c.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.c.dao.HallDao;
import com.c.model.HallBean;

@Repository
public class HallDaoImpl implements HallDao{
	SessionFactory factory;
	
	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	//用廳名稱去抓資料傳回hallbean就可以用hb.get...()去抓取其他所需的資料
	@Override
	public HallBean getHall(String hallID) {
		Session session = factory.getCurrentSession();
		HallBean hb = session.get(HallBean.class, hallID);
		return hb;
	}

//	@Override
//	public Integer getNumberOfSeats(Integer hallID) {
//		Session session = factory.getCurrentSession();
//		HallBean hb = session.get(HallBean.class, hallID);
//		Integer seats = hb.getNoOfSeats();
//		return seats;
//	}

	
	//抓取多筆的廳資料 顯示在頁面上 for management purposes?
	@SuppressWarnings("unchecked")
	@Override
	public List<HallBean> getAllHalls(Integer status) {
		List<HallBean> list = new ArrayList<>();
		String hql = "FROM HallBean hb WHERE hb.status= :hbs";
		Session session = factory.getCurrentSession();
		
		list = session.createQuery(hql)
				.setParameter("hbs", status)
				.list();
		return list;
	}

//	@Override
//	public Integer getPrice(Integer hallID) {
//		Session session = factory.getCurrentSession();
//		HallBean hb = session.get(HallBean.class, hallID);
//		Integer price = hb.getPrice();
//		return price;
//	}

	//更新廳的狀態 可能整修或被包廳
	@Override
	public void updateStatus(Integer hallId, Integer status) {
		Session session = factory.getCurrentSession();
		HallBean hb = session.get(HallBean.class, hallId);
		hb.setStatus(status);
		session.saveOrUpdate(hb);
	}

	//新增廳
	@Override
	public void insertHall(HallBean hb) {
		Session session = factory.getCurrentSession();
		session.save(hb);
	}

	@Override
	public void updateHall(HallBean hb) {
		Session session = factory.getCurrentSession();
		session.saveOrUpdate(hb);
	}
	
	

}
