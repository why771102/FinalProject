package com.m.dao.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.a.model.MovieBean;
import com.a.model.RunningBean;
import com.a.model.ShowTimeHistoryBean;
import com.c.model.NumberOfSeatsBean;
import com.c.model.SeatOrderBean;
import com.m.dao.TicketSaleDao;
import com.p.model.HallOrderBean;

@Repository
public class TicketSaleDaoImpl implements TicketSaleDao {
	
	SessionFactory factory;
	
	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	
	//全部上下檔的電影名稱集
//	SELECT title FROM movies as m left join running as r 
//	on m.movieID = r.movieID left join showTimeHistory as sth on sth.runID = r.runID;
	
	
//	@SuppressWarnings("unchecked")
//	@Override
//	public List<Integer> getMovieID(Date sDate, Date eDate){
//		String hql = "FROM running r WHERE r.release= :sDate and r.offDate= :eDate";
//		Session session = factory.getCurrentSession();
//		List<Integer> mIDList = new ArrayList<>();
//		mIDList = session.createQuery(hql).setParameter("sDate", sDate)
//				.setParameter("eDate", eDate).list();
//		return mIDList;
//	}

	@Override
	public Integer CountShow(String movieID) {
		
		return null;
	}
		
	@SuppressWarnings("unchecked")
	@Override
	//取得影廳總座位數
	public List<NumberOfSeatsBean> getHallSeats(Date date){
		String hql = "FROM numberOfSeats nos WHERE nos.date= :date";
		Session session = factory.getCurrentSession();
		List<NumberOfSeatsBean> hallSeatsList = new ArrayList<>();
//		list = session.createQuery(hql).getResultList();
		hallSeatsList = session.createQuery(hql)
				.setParameter("date", date).list();
		return hallSeatsList;
	}

	@Override
	public List<RunningBean> getRunningInfo(Date sDate, Date eDate) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MovieBean> getFilm(Integer movieID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getShowTime(Integer movieID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ShowTimeHistoryBean getShowHallandDate(Integer showTimeID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SeatOrderBean> CountSeatSale(Integer showTimeID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HallOrderBean> getHallOrderInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer getHallOrderPrice(String hallID) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//抓取HallID去取得list中需要的list
}
