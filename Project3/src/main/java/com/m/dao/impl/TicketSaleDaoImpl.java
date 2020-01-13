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
	
//	@SuppressWarnings("unchecked")
//	@Override
//	//取得影廳總座位數
//	public List<NumberOfSeatsBean> getHallSeats(String sDate, String eDate){
//		String hql = "FROM numberOfSeats nos WHERE nos.date>= :sDate AND nos.date <= :eDate";
//		Session session = factory.getCurrentSession();
//		List<NumberOfSeatsBean> hallSeatsList = new ArrayList<>();
//		hallSeatsList = session.createQuery(hql)
//				.setParameter("sDate", sDate).setParameter("eDate", eDate).getResultList();
//		return hallSeatsList;
//	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<RunningBean> ShowMovieByRunTime() {
		String hql ="SELECT r.release, r.expectedOffDate, r.offDate FROM running r";
		Session session = factory.getCurrentSession();
		List<RunningBean> dateRangeList = new ArrayList<>();
		dateRangeList = session.createQuery(hql).getResultList();
		return dateRangeList;
	}
	
	@Override
	public List<ShowTimeHistoryBean> getshowTimeHistory(List<RunningBean> RBList) {
		List<ShowTimeHistoryBean> sthbList = new ArrayList<>();
		Session session = factory.getCurrentSession();
		for(RunningBean rb: RBList) {
			ShowTimeHistoryBean sthb = null;
			sthb = session.get(ShowTimeHistoryBean.class, rb.getRunID());
			sthbList.add(sthb);
		}
		return sthbList;
	}
	
	@Override
	public List<NumberOfSeatsBean> getNumberOfSeats(List<ShowTimeHistoryBean> sthbList) {
		List<NumberOfSeatsBean> nosbList = new ArrayList<>();
		Session session = factory.getCurrentSession();
		for(ShowTimeHistoryBean sthb : sthbList) {
			NumberOfSeatsBean nosb = null;
			nosb = session.get(NumberOfSeatsBean.class, sthb.getHallID());
			nosbList.add(nosb);
		}
		return nosbList;
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


	//抓取HallID去取得list中需要的list
}
