package com.m.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.a.model.GenreBean;
import com.a.model.MovieBean;
import com.a.model.RunningBean;
import com.a.model.ShowTimeHistoryBean;
import com.c.model.HallBean;
import com.c.model.NumberOfSeatsBean;
import com.l.model.MOrderBean;
import com.m.dao.TicketSaleDao;
import com.m.model.TicketSaleBean;

@Repository
public class TicketSaleDaoImpl implements TicketSaleDao {
	
	TicketSaleDao dao;
	SessionFactory factory;

	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	@Autowired
	public void setDao(TicketSaleDao dao) {
		this.dao = dao;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<MOrderBean> getMOrderBean() {
		String hql = "FROM mOrder";
		Session session = factory.getCurrentSession();
		List<MOrderBean> modList = new ArrayList<>();
		modList = session.createQuery(hql).getResultList();
	return modList;
	}
	
	@Override
	//取得電影資訊相關欄位的值
	public List<TicketSaleBean> getTicketSaleBean(List<MOrderBean> modList) {
		Session session = factory.getCurrentSession();
		List<TicketSaleBean> tsbListFromMovie = new ArrayList<>();

		for (MOrderBean mob : modList) {
			ShowTimeHistoryBean sth = mob.getShowTimeHistoryBean(); // getShowTimeHistoryBean
			HallBean hb = mob.getShowTimeHistoryBean().getHall(); // getHallBean
			RunningBean rb = mob.getShowTimeHistoryBean().getRun(); // getRunningBean
			MovieBean mb = mob.getShowTimeHistoryBean().getRun().getMovie(); // getMovieBean
			GenreBean gb = mob.getShowTimeHistoryBean().getRun().getMovie().getGenreBean(); //getGenreBean
			
			mob.getOrdersID(); //用來比對odb orderID用
			Integer showtimeID = sth.getShowTimeId();
			String title = mb.getTitle();
			Integer genre = gb.getGenreID(); //電影類型
			Integer movieHours = mb.getRunningTime(); // 片長(分鐘)
//		Double profitRatio = mob.getShowTimeHistoryBean().getRun().getMovie().getProfitRatio(); 營收表要
//			String hallID = mob.getShowTimeHistoryBean().getHall().getHallID();
			Integer hallSeats = session.get(NumberOfSeatsBean.class, hb.getHallID())
					.getNoOfSeats(); // 取得那廳的座位數
			String releaseDate = rb.getRelease(); // 上映日
			String offDate = rb.getOffDate(); // 實際下檔
			String expectOffDate = rb.getExpectedOffDate(); // 預計下檔
			//用來比對input輸入欄位的時間值
			String playStartTime = sth.getPalyStartTime(); // 電影播放年月日 => 消費計算的日期

			TicketSaleBean tsb = new TicketSaleBean(showtimeID, title, genre, movieHours, 0, hallSeats, 0, 0,
					0.0, 0L, releaseDate, expectOffDate, offDate, playStartTime);
			tsbListFromMovie.add(tsb);
		}
		return tsbListFromMovie;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	// 取得訂單販售資訊欄位的值
	public List<TicketSaleBean> getMOrderDetailBeanList(List<TicketSaleBean> tsbList) {
		String hql = "SELECT mod.productID, p.category, p.unitPrice, mod.quantity, mod.discount"
				+ "FROM mOrder mo LEFT JOIN mo.mOrderDetail mod"
				+ "LEFT JOIN mod.products p WHERE ordersID = :ordersID";
		Session session = factory.getCurrentSession();
		List<TicketSaleBean> tsbListFromOrder = new ArrayList<>(); //用來裝上面所查詢hql語法的資訊
//		List<TicketSaleBean> tsbFullLists = new ArrayList<>(); //用來裝前個方法與這個方法總資訊
		for (TicketSaleBean tsb : tsbList) {
			//根據ordersID將movieInfoList中的資訊結合(欄位只有上面查詢所獲得的資訊)
			tsbListFromOrder = session.createQuery(hql).setParameter("ordersID", tsb.getOrderID()).getResultList();
//			TicketSaleBean tsbfl = null;
//			tsbFullLists.add(tsbfl);
			//特別處理是根據category計算後 if c=3 && pid =15, 實際售出座位*2
			//0115待確認
//			ShowTimeHistoryBean sth = null;
//			sth = session.get(ShowTimeHistoryBean.class, tsb.getShowtimeID());
//			sth.getPalyStartTime();
			//從新的陣列資訊中取出所需的資訊: 
//			for(TicketSaleBean tsb1 : tsbLists){
//				tsb1.getQuantity(); //取得單筆訂單的產品數量
//				tsb1.getUnitPrice(); //取得單筆訂單的產品單價
//				tsb1.getCategory(); //取得單筆訂單產品所對應的種類
//			}
		}
		return tsbListFromOrder;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> getDistinctTitles() {
		Session session = factory.getCurrentSession();
		String hql = "SELECT DISTINCT title FROM movies";
		List<String> TitlesList = new ArrayList<>();
		TitlesList = session.createQuery(hql).getResultList();
		return TitlesList;
	}

	// ===========================================================================

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
}
