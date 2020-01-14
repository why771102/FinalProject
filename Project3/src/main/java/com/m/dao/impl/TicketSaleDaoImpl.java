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
import com.l.model.MOrderBean;
import com.l.model.MOrderDetailBean;
import com.l.model.TicketBean;
import com.m.dao.TicketSaleDao;
import com.m.model.TicketSaleBean;
import com.p.model.HallOrderBean;

@Repository
public class TicketSaleDaoImpl implements TicketSaleDao {
	SessionFactory factory;

	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TicketSaleBean> getMovieInfo() {
		String hql = "FROM showTimeHistory";
		Session session = factory.getCurrentSession();
		List<ShowTimeHistoryBean> sthbList = new ArrayList<>();
		sthbList = session.createQuery(hql).getResultList();

		List<TicketSaleBean> tsbList = new ArrayList<>();
		for (ShowTimeHistoryBean sthb : sthbList) {
			sthb.getHall(); // getHallBean
			sthb.getRun(); // getRunningBean
			sthb.getRun().getMovie(); // getMovieBean
			Integer showtimeID = sthb.getShowTimeId();
			String title = sthb.getRun().getMovie().getTitle();
			Integer genre = sthb.getRun().getMovie().getGenre();
			Integer movieHours = sthb.getRun().getMovie().getRunningTime(); // 片長(分鐘)
//			Double profitRatio = sthb.getRun().getMovie().getProfitRatio(); 營收表要
			String hallID = sthb.getHall().getHallID();
			Integer hallSeats = session.get(NumberOfSeatsBean.class, sthb.getHall().getHallID()).getNoOfSeats(); // 取得那廳的座位數
			String releaseDate = sthb.getRun().getRelease(); // 上映日
			String offDate = sthb.getRun().getOffDate(); // 實際下檔
			String expectOffDate = sthb.getRun().getExpectedOffDate(); // 預計下檔
//			String playStartTime = sthb.getPalyStartTime(); //電影播放年月日

			TicketSaleBean tsb = new TicketSaleBean(showtimeID, hallID, title, genre, hallSeats, releaseDate,
					expectOffDate, offDate, null, movieHours);
			tsbList.add(tsb);
		}
		return tsbList;
	}

	@Override
	public List<TicketSaleBean> getTicketSale(List<TicketSaleBean> tsbList) {
		Session session = factory.getCurrentSession();
		List<TicketSaleBean> tsbLists = new ArrayList<>();
		
		for (TicketSaleBean tsb : tsbList) {
			MOrderBean mob = null;
			MOrderDetailBean modb = null;
			mob.getShowTimeHistoryBean(); //電影票購買日
			mob = session.get(MOrderBean.class, tsb.getShowtimeID());
			modb = session.get(MOrderDetailBean.class, mob.getOrdersID());
//			modb.getUnitPrice(); //取得該筆訂單電影票的價錢
//			modb.getQuantity(); //取得該筆訂單電影票數量
			Integer ticketSaleTotal = modb.getUnitPrice() * modb.getQuantity();
			
			
			tsb.setMob(mob);
			tsbLists.add(tsb);
		}
		return null;
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
		String hql = "SELECT r.release, r.expectedOffDate, r.offDate FROM running r";
		Session session = factory.getCurrentSession();
		List<RunningBean> dateRangeList = new ArrayList<>();
		dateRangeList = session.createQuery(hql).getResultList();
		return dateRangeList;
	}

	@Override
	public List<MovieBean> getMovieNames(List<RunningBean> rbList) {
		List<MovieBean> mbList = new ArrayList<>();

		return null;
	}

	@Override
	public List<ShowTimeHistoryBean> getshowTimeHistory(List<RunningBean> RBList) {
		List<ShowTimeHistoryBean> sthbList = new ArrayList<>();
		Session session = factory.getCurrentSession();
		for (RunningBean rb : RBList) {
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
		for (ShowTimeHistoryBean sthb : sthbList) {
			NumberOfSeatsBean nosb = null;
			nosb = session.get(NumberOfSeatsBean.class, sthb.getHallID());
			nosbList.add(nosb);
		}
		return nosbList;
	}

	// 全部上下檔的電影名稱集
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

	// 抓取HallID去取得list中需要的list
}
