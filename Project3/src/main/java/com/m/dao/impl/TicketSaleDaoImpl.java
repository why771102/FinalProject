package com.m.dao.impl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
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
import com.m.model.TicketSaleEarnBean;

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
	public String getGenre() {
		String hql = "SELECT genre FROM GenreBean";
		Session session = factory.getCurrentSession();
		List<String> genres = new ArrayList<>();
		genres = session.createQuery(hql).getResultList();

		String ans = "";
		ans += "<SELECT id='genres' onclick='sendGen()'>" + "<option value='' selected='' disabled=''>請選擇</option>"
				+ "<option value='all'>全部電影</option>";
		for (String gen : genres) {
			ans += "<option value='" + gen + "'>" + gen + "</option>";
		}
		ans += "</SELECT>";
		return ans;
	}

	// =======================================================================================

	// p1 method

	@SuppressWarnings("unchecked")
	@Override
	public List<TicketSaleEarnBean> getTicketSaleInfo(String sDate, String eDate) {
		Session session = factory.openSession();
		String hql = "FROM TicketSaleEarnBean WHERE orderdate BETWEEN :sDate AND :eDate";
		List<TicketSaleEarnBean> tsebList = new ArrayList<>();
		tsebList = session.createQuery(hql).setParameter("sDate", sDate).setParameter("eDate", eDate).getResultList();
		System.out.println("tsebList.size =>" + tsebList.size());
		System.out.println("tsebList.HSS =>" + tsebList.get(0).getHallSaleSeats());
		System.out.println("tsebList.HS =>" + tsebList.get(0).getHallSeats());

		String hql1 = "SELECT movieID FROM MovieBean";
		List<Integer> MIDs = new ArrayList<>();
		MIDs = session.createQuery(hql1).getResultList();
		System.out.println("MIDs.size =>" + MIDs.size());

		List<TicketSaleEarnBean> tbList = new ArrayList<>();

		for (Integer m : MIDs) {
			String title = null;
			Integer noPlayTimes = 0;
			Integer hallSeats = 0;
			Integer hallSaleSeats = 0;
			Double avgSeats = 0.0; // 要等場次數與座位數
			Double pricePerSeat = 0.0;
			Integer Subtotal = 0;

			Integer foodSaleTotal = 0;
			Integer ticketSaleTotal = 0;
			MovieBean mb = null;
			List<ShowTimeHistoryBean> sthbList = dao.getDetail(m, sDate, eDate);
			System.out.println("sthbList.size() =>" +  sthbList.size());
			noPlayTimes = sthbList.size();
			
			for (TicketSaleEarnBean tseb : tsebList) {
				if (m == tseb.getMovieBean().getMovieID()) {
					title = tseb.getMovieBean().getTitle();
//					hallSeats = hallSeats + tseb.getHallSeats();
					hallSaleSeats = hallSaleSeats + tseb.getHallSaleSeats();
					ticketSaleTotal = ticketSaleTotal + tseb.getTicketSaleTotal();
					foodSaleTotal = foodSaleTotal + tseb.getFoodSaleTotal();
					mb = tseb.getMovieBean();
					for (ShowTimeHistoryBean sthb : sthbList) {
						hallSeats = hallSeats + sthb.getHall().getNoOfSeats();
					}

				} else {
				}
				Subtotal = ticketSaleTotal + foodSaleTotal;
				System.out.println("ticketSaleTotal =>" + ticketSaleTotal);			
				System.out.println("foodSaleTotal =>" + foodSaleTotal);
				System.out.println("Subtotal =>" + Subtotal);
				System.out.println("hallSaleSeats =>" + hallSaleSeats);
				System.out.println("hallSeats =>" + hallSeats);
//				avgSeats = (double) ((hallSaleSeats / hallSeats) * 100);
			}
//			System.out.println("hallSaleSeats =>" + hallSaleSeats);
			avgSeats = 200.3;
//			avgSeats = (double) ((hallSaleSeats / hallSeats) * 100);
//			Double avgTemp = (double) (saleSubtotal / hallSaleSeats);
//			BigDecimal b = new BigDecimal(avgTemp);
//			pricePerSeat = b.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue(); 
			pricePerSeat = 100.2;
			TicketSaleEarnBean tb = new TicketSaleEarnBean(title, noPlayTimes, hallSeats, hallSaleSeats, avgSeats,
					pricePerSeat, Subtotal, mb);

			if (tb.getHallSaleSeats() != 0) {
				tbList.add(tb);
			} else {
			}
		}
		session.close();
		System.out.println("tbList.size =>" + tbList.size());
		return tbList;
	}
	
	// p1 method: 0

	// p1 method: 1
	
	// p1 method: 2
	
	// p1 method: 3
	
	// p1 method: 4
	
	
	
	
	
	

	@Override
	@SuppressWarnings("unchecked")
	public List<ShowTimeHistoryBean> getDetail(Integer movieID, String sDate, String eDate) {
		Session session = factory.openSession();
		String hql = "SELECT runID FROM RunningBean WHERE movieID = :movieID";
		List<Integer> runIDs = new ArrayList<>();
		runIDs = session.createQuery(hql).setParameter("movieID", movieID).getResultList();

		List<ShowTimeHistoryBean> sbList = new ArrayList<>();
//		List<TicketSaleEarnBean> tsebList = new ArrayList<>();

		for (Integer i : runIDs) {
			String hql1 = "FROM ShowTimeHistoryBean where runID = :runID";

			List<ShowTimeHistoryBean> sthbList = new ArrayList<>();
			sthbList = session.createQuery(hql1).setParameter("runID", i).getResultList();

			for (ShowTimeHistoryBean sthb : sthbList) {

				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
				LocalDate playDate = LocalDateTime.parse(sthb.getPlayStartTime(), formatter).toLocalDate();
				LocalDate Sd = LocalDate.parse(sDate);
				LocalDate Ed = LocalDate.parse(eDate);

				long SdOdDays = ChronoUnit.DAYS.between(Sd, playDate);
				long EdOdDays = ChronoUnit.DAYS.between(Ed, playDate);

				if (SdOdDays >= 0 && EdOdDays <= 0) {
					sbList.add(sthb);
				} else {
				}
			}
		}

		session.close();
		return sbList;
	}

	// =======================================================================================

//	@SuppressWarnings("unchecked")
//	@Override
//	public List<MOrderBean> getMOrderBean() {
//		String hql = "FROM mOrder";
//		Session session = factory.getCurrentSession();
//		List<MOrderBean> modList = new ArrayList<>();
//		modList = session.createQuery(hql).getResultList();
//	return modList;
//	}
//	
//	@Override
//	//取得電影資訊相關欄位的值
//	public List<TicketSaleBean> getTicketSaleBean(List<MOrderBean> modList) {
//		Session session = factory.getCurrentSession();
//		List<TicketSaleBean> tsbListFromMovie = new ArrayList<>();
//
//		for (MOrderBean mob : modList) {
//			ShowTimeHistoryBean sth = mob.getShowTimeHistoryBean(); // getShowTimeHistoryBean
//			HallBean hb = mob.getShowTimeHistoryBean().getHall(); // getHallBean
//			RunningBean rb = mob.getShowTimeHistoryBean().getRun(); // getRunningBean
//			MovieBean mb = mob.getShowTimeHistoryBean().getRun().getMovie(); // getMovieBean
//			GenreBean gb = mob.getShowTimeHistoryBean().getRun().getMovie().getGenreBean(); //getGenreBean
//			
//			mob.getOrdersID(); //用來比對odb orderID用
//			Integer showtimeID = sth.getShowTimeId();
//			String title = mb.getTitle();
//			Integer genre = gb.getGenreID(); //電影類型
//			Integer movieHours = mb.getRunningTime(); // 片長(分鐘)
////		Double profitRatio = mob.getShowTimeHistoryBean().getRun().getMovie().getProfitRatio(); 營收表要
////			String hallID = mob.getShowTimeHistoryBean().getHall().getHallID();
//			Integer hallSeats = session.get(NumberOfSeatsBean.class, hb.getHallID())
//					.getNoOfSeats(); // 取得那廳的座位數
//			String releaseDate = rb.getRelease(); // 上映日
//			String offDate = rb.getOffDate(); // 實際下檔
//			String expectOffDate = rb.getExpectedOffDate(); // 預計下檔
//			//用來比對input輸入欄位的時間值
//			String playStartTime = sth.getPlayStartTime(); // 電影播放年月日 => 消費計算的日期
//
//			TicketSaleBean tsb = new TicketSaleBean(showtimeID, title, genre, movieHours, 0, hallSeats, 0, 0,
//					0.0, 0L, releaseDate, expectOffDate, offDate, playStartTime);
//			tsbListFromMovie.add(tsb);
//		}
//		return tsbListFromMovie;
//	}
//	
//	@SuppressWarnings("unchecked")
//	@Override
//	// 取得訂單販售資訊欄位的值
//	public List<TicketSaleBean> getMOrderDetailBeanList(List<TicketSaleBean> tsbList) {
//		String hql = "SELECT mod.productID, p.category, p.unitPrice, mod.quantity, mod.discount"
//				+ "FROM mOrder mo LEFT JOIN mo.mOrderDetail mod"
//				+ "LEFT JOIN mod.products p WHERE ordersID = :ordersID";
//		Session session = factory.getCurrentSession();
//		List<TicketSaleBean> tsbListFromOrder = new ArrayList<>(); //用來裝上面所查詢hql語法的資訊
////		List<TicketSaleBean> tsbFullLists = new ArrayList<>(); //用來裝前個方法與這個方法總資訊
//		for (TicketSaleBean tsb : tsbList) {
//			//根據ordersID將movieInfoList中的資訊結合(欄位只有上面查詢所獲得的資訊)
//			tsbListFromOrder = session.createQuery(hql).setParameter("ordersID", tsb.getOrderID()).getResultList();
////			TicketSaleBean tsbfl = null;
////			tsbFullLists.add(tsbfl);
//			//特別處理是根據category計算後 if c=3 && pid =15, 實際售出座位*2
//			//0115待確認
////			ShowTimeHistoryBean sth = null;
////			sth = session.get(ShowTimeHistoryBean.class, tsb.getShowtimeID());
////			sth.getPalyStartTime();
//			//從新的陣列資訊中取出所需的資訊: 
////			for(TicketSaleBean tsb1 : tsbLists){
////				tsb1.getQuantity(); //取得單筆訂單的產品數量
////				tsb1.getUnitPrice(); //取得單筆訂單的產品單價
////				tsb1.getCategory(); //取得單筆訂單產品所對應的種類
////			}
//		}
//		return tsbListFromOrder;
//	}
//
//	@SuppressWarnings("unchecked")
//	@Override
//	public List<String> getDistinctTitles() {
//		Session session = factory.getCurrentSession();
//		String hql = "SELECT DISTINCT title FROM movies";
//		List<String> TitlesList = new ArrayList<>();
//		TitlesList = session.createQuery(hql).getResultList();
//		return TitlesList;
//	}

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
