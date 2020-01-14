package com.m.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.a.model.MovieBean;
import com.a.model.RunningBean;
import com.a.model.ShowTimeHistoryBean;
import com.c.model.NumberOfSeatsBean;
import com.l.model.MOrderBean;
import com.l.model.MOrderDetailBean;
import com.m.dao.TicketSaleDao;
import com.m.model.TicketSaleBean;

@Repository
public class TicketSaleDaoImpl implements TicketSaleDao {
	SessionFactory factory;

	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TicketSaleBean> getMOrderDetailBeanList(List<TicketSaleBean> tsbList) {
		String hql = "SELECT m.ordersID, mo.unitPrice, mo.quantity, mo.productID,"
				+ "category FROM mOrder mo LEFT JOIN mo.mOrderDetail mod"
				+ "LEFT JOIN mod.products p WHERE showTimeID = :showTimeID";
		Session session = factory.getCurrentSession();
		List<TicketSaleBean> tsbLists = new ArrayList<>();
		for (TicketSaleBean tsb : tsbList) {
			tsbLists = session.createQuery(hql).setParameter("showTimeID", tsb.getShowtimeID()).getResultList();
		}
		return tsbLists;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TicketSaleBean> getTicketSaleBean(List<MOrderDetailBean> modbList) {
		String hql = "FROM mOrder";
		Session session = factory.getCurrentSession();
		List<MOrderBean> modList = new ArrayList<>();
		modList = session.createQuery(hql).getResultList();
	
		List<TicketSaleBean> tsbList = new ArrayList<>();
		
		for (MOrderBean mob : modList) {
			mob.getShowTimeHistoryBean(); //getShowTimeHistoryBean
			mob.getShowTimeHistoryBean().getHall(); //getHallBean
			mob.getShowTimeHistoryBean().getRun(); // getRunningBean
			mob.getShowTimeHistoryBean().getRun().getMovie(); // getMovieBean
			
			Integer showtimeID = mob.getShowTimeHistoryBean().getShowTimeId();
			String title = mob.getShowTimeHistoryBean().getRun().getMovie().getTitle();
			Integer genre = mob.getShowTimeHistoryBean().getRun().getMovie().getGenre();
			Integer movieHours = mob.getShowTimeHistoryBean().getRun().getMovie().getRunningTime(); // 片長(分鐘)
//			Double profitRatio = mob.getShowTimeHistoryBean().getRun().getMovie().getProfitRatio(); 營收表要
			String hallID = mob.getShowTimeHistoryBean().getHall().getHallID();
			Integer hallSeats = session.get(NumberOfSeatsBean.class, mob.getShowTimeHistoryBean().
					getHall().getHallID()).getNoOfSeats(); // 取得那廳的座位數
			String releaseDate = mob.getShowTimeHistoryBean().getRun().getRelease(); // 上映日
			String offDate = mob.getShowTimeHistoryBean().getRun().getOffDate(); // 實際下檔
			String expectOffDate = mob.getShowTimeHistoryBean().getRun().getExpectedOffDate(); // 預計下檔
			String playStartTime = mob.getShowTimeHistoryBean().getPalyStartTime(); //電影播放年月日
			
//			for() {
//			MOrderDetailBean modb = null;
//			modb = session.get(MOrderDetailBean.class, mob.getOrdersID());
//			modbList.add(modb);
//			}
			TicketSaleBean tsb = new TicketSaleBean(showtimeID, hallID, title, genre, 
					movieHours, 0, hallSeats, 0, 0.0, 0.0, 0, releaseDate, 
					expectOffDate, offDate, playStartTime);
			tsbList.add(tsb);
		}
		return tsbList;
	}

//	@Override
//	public List<TicketSaleBean> getTicketSale(List<TicketSaleBean> tsbList) {
//		Session session = factory.getCurrentSession();
//		List<TicketSaleBean> tsbLists = new ArrayList<>();
//		List<MOrderDetailBean> modbLists = new ArrayList<>();
//		
//		for (TicketSaleBean tsb : tsbList) {
//			MOrderBean mob = null;
//			MOrderDetailBean modb = null;
//			//取得售票相關販售資訊
//			mob = session.get(MOrderBean.class, tsb.getShowtimeID());
//			String playStartTime = mob.getShowTimeHistoryBean().getPalyStartTime(); //電影票購買日
////			LocalDate ticketSaleDate = 
////					LocalDateTime.parse(mob.getShowTimeHistoryBean().getPalyStartTime()).toLocalDate();
//			modb = session.get(MOrderDetailBean.class, mob.getOrdersID());
////			modb.getUnitPrice(); //取得該筆訂單票與產品的的價錢
//			Integer SaleNum = modb.getQuantity(); //單筆訂單電影票與產品的銷售數量 = 單筆訂單售出座位數
//			Integer ticketSaleTotal = modb.getUnitPrice() * modb.getQuantity(); //單個Bean的票與產品的銷售總額	
//			
//			modbLists.add(modb);
//			
//			tsb.setPlayStartTime(playStartTime);
//		}
//		return tsbLists;
//	}

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
