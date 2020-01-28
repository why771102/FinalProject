package com.m.dao.impl;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.a.model.GenreBean;
import com.a.model.MovieBean;
import com.a.model.ShowTimeHistoryBean;
import com.l.model.MOrderBean;
import com.l.model.MOrderDetailBean;
import com.l.model.ProductsBean;
import com.m.dao.TicketSaleEarnDao;
import com.m.model.ProductSaleEarnBean;
import com.m.model.TicketSaleEarnBean;

@Repository
public class TicketSaleEarnDaoImpl implements TicketSaleEarnDao {

	SessionFactory factory;
	TicketSaleEarnDao dao;

	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	@Autowired
	public void setDao(TicketSaleEarnDao dao) {
		this.dao = dao;
	}

//	@Override
//	@SuppressWarnings("unchecked")
//	public List<MOrderBean> saveTicketInfoToDB() {
//		Session session = factory.openSession();
//
//		String hql = "SELECT DISTINCT playStartTime FROM ShowTimeHistoryBean ORDER BY playStartTime ASC";
//
//		List<String> dates = new ArrayList<>();
//		dates = session.createQuery(hql).getResultList();
//
//		List<LocalDate> dates1 = new ArrayList<>();
//		for (String date : dates) {
//			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
//			LocalDate orderDate = LocalDateTime.parse(date, formatter).toLocalDate();
//			dates1.add(orderDate);
//		}
//		// 不重複的日期
//		List<LocalDate> newList = dates1.stream().distinct().collect(Collectors.toList());
//
//		String hql1 = "FROM MOrderBean";
//		List<MOrderBean> mobList = new ArrayList<>();
//		mobList = session.createQuery(hql1).getResultList();
//
//		String hql2 = "FROM MOrderDetailBean";
//		List<MOrderDetailBean> modList = new ArrayList<>();
//		modList = session.createQuery(hql2).getResultList();
//
////		String hql3 = "FROM ProductsBean WHERE categoryID BETWEEN 1 AND 3";
////		List<ProductsBean> pbList = new ArrayList<>();
////		pbList = session.createQuery(hql3).getResultList();
//
//		String hql4 = "SELECT movieID FROM MovieBean";
//		List<Integer> MIDs = new ArrayList<>();
//		MIDs = session.createQuery(hql4).getResultList();
//
//		List<TicketSaleEarnBean> resultList = new ArrayList<>();
//		
//		for (LocalDate date : newList) {
//			List<MOrderBean> moList = new ArrayList<>();
//
//			for (MOrderBean mob : mobList) {
//				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
//				LocalDate mOrderDate = LocalDateTime.parse(mob.getShowTimeHistoryBean().getPlayStartTime(), formatter)
//						.toLocalDate();
//				System.out.println("mOrderDate=== " + mOrderDate);
//				System.out.println("date=== " + date);
//				long Days = ChronoUnit.DAYS.between(mOrderDate, date);
//				List<Integer> OIDs = new ArrayList<>();
//				//日期一樣就存
//				if (Days == 0) {
//					moList.add(mob);
//					System.out.println("moList~~~" + moList.size());
//				}
//			}
//			
//			
////			String title = null; //電影名稱
//			GenreBean gb = null;
//			Integer hallSaleSeats = 0; //實際售出座位數
//			Integer ticketSaleTotal = 0;
////			Double pricePerSeat = 0.0;
////			Integer movieHours = 0;
//			MovieBean mb = null;
//			Integer movieID = 0;
//			//同個日期內的MOrderBean依mid排, 取相對應的來加
//			for (Integer i : MIDs) {
//				
//				for (MOrderBean mob : moList) {
//					if (i == mob.getShowTimeHistoryBean().getRun().getMovieID()){
//						//取相對應的mod
////						title = mob.getShowTimeHistoryBean().getRun().getMovie().getTitle();
//						gb = mob.getShowTimeHistoryBean().getRun().getMovie().getGenreBean();
////						movieHours = mob.getShowTimeHistoryBean().getRun().getMovie().getRunningTime(); //片長(分)
//						mb = mob.getShowTimeHistoryBean().getRun().getMovie();
//						movieID = mob.getShowTimeHistoryBean().getRun().getMovie().getMovieID();
//						for(MOrderDetailBean modb : modList) {
//							if (modb.getmOrderBean().getOrdersID() == mob.getOrdersID()) {
//								hallSaleSeats = hallSaleSeats + modb.getQuantity();
//								ticketSaleTotal =  ticketSaleTotal + modb.getProductsBean().getUnitPrice() * modb.getQuantity(); //該mod票價
//								
//							}
//						}
//					}
//				}
//			}
////			pricePerSeat = (double) (ticketSaleTotal / hallSaleSeats);
//			TicketSaleEarnBean tseb = new TicketSaleEarnBean();
////			tseb.setTitle(title);
//			tseb.setMovieBean(mb);
//			tseb.setGenreBean(gb);
//			tseb.setHallSaleSeats(hallSaleSeats);
//			tseb.setTicketSaleTotal(ticketSaleTotal);
////			tseb.setPricePerSeat(pricePerSeat);
////			tseb.setMovieHours(movieHours); //片長(分)
//			
//			TicketSaleEarnBean tsebDetail = dao.getDetailInfo(movieID, date);
//			tseb.setNumbersOfPlayTime(tsebDetail.getNumbersOfPlayTime());
//			tseb.setHallSeats(tsebDetail.getHallSeats());
//			tseb.setOrderDate(date.toString());
//			session.save(tseb);
//			
////			//飲食總額另外算 跟加總!!
////			String hql5 = "FROM ProductSaleEarnBean";
////			List<ProductSaleEarnBean> psebList = new ArrayList<>();
////			psebList = session.createQuery(hql).getResultList();
//			
////			Integer foodSubtotal = 0;
////			Integer subtotal = 0;
////			for(ProductSaleEarnBean pseb : psebList){
////				if(pseb.getOrderDate() == date.toString()) {
////					foodSubtotal = foodSubtotal + pseb.getSubtotal();
////				}
////			}
////			subtotal = foodSubtotal + ticketSaleTotal;
////			
////			tseb.setFoodSubtotal(foodSubtotal);
////			tseb.setSubtotal(subtotal);
//		}
//		session.close();
//		return mobList;
//	}

	@Override
	@SuppressWarnings("unchecked")
	public List<MOrderBean> saveTicketInfoToDB() {
		Session session = factory.openSession();

//		String hql = "SELECT DISTINCT playStartTime FROM ShowTimeHistoryBean ORDER BY playStartTime ASC";
//
//		List<String> dates = new ArrayList<>();
//		dates = session.createQuery(hql).getResultList();
//
//		List<LocalDate> dates1 = new ArrayList<>();
//		for (String date : dates) {
//			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
//			LocalDate orderDate = LocalDateTime.parse(date, formatter).toLocalDate();
//			dates1.add(orderDate);
//		}
//		// 不重複的日期
//		List<LocalDate> newList = dates1.stream().distinct().collect(Collectors.toList());

		String hql1 = "FROM MOrderBean";
		List<MOrderBean> mobList = new ArrayList<>();
		mobList = session.createQuery(hql1).getResultList();

		System.out.println("mobList.size() => " + mobList.size());
		
//		String hql2 = "FROM MOrderDetailBean WHERE productID in (1,2,3,13,15)";
//		List<MOrderDetailBean> modList = new ArrayList<>();
//		modList = session.createQuery(hql2).getResultList();
		
		String hql2 = "FROM MOrderDetailBean";
		List<MOrderDetailBean> modList = new ArrayList<>();
		modList = session.createQuery(hql2).getResultList();

		System.out.println("modList.size() => " + modList.size());
		
		String hql3 = "SELECT DISTINCT showTimeHistoryBean FROM MOrderBean";
		List<ShowTimeHistoryBean> sList = new ArrayList<>();
		sList = session.createQuery(hql3).getResultList();
		
		List<Integer> shList = new ArrayList<>();
		for(ShowTimeHistoryBean s : sList) {
			shList.add(s.getShowTimeId());
		}
		
		System.out.println("shList.size() => " + shList.size());
		
//		String hql4 = "FROM MOrderDetailBean WHERE productID in (4,5,6,7,8,9,10,11,12,14,16)";
//		List<MOrderDetailBean> mList = new ArrayList<>();
//		mList = session.createQuery(hql4).getResultList();

		List<TicketSaleEarnBean> resultList = new ArrayList<>();

//		for (LocalDate date : newList) {
//		List<MOrderBean> moList = new ArrayList<>();

//			for (MOrderBean mob : mobList) {
//				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
//				LocalDate mOrderDate = LocalDateTime.parse(mob.getShowTimeHistoryBean().getPlayStartTime(), formatter)
//						.toLocalDate();
//				System.out.println("mOrderDate=== " + mOrderDate);
//				System.out.println("date=== " + date);
//				long Days = ChronoUnit.DAYS.between(mOrderDate, date);
//				List<Integer> OIDs = new ArrayList<>();
//				// 日期一樣就存
//				if (Days == 0) {
//					moList.add(mob);
//					System.out.println("moList~~~" + moList.size());
//				}
//			}

//			String title = null; //電影名稱

		// 同個日期內的MOrderBean依mid排, 取相對應的來加
//			for (Integer i : MIDs) {
		for (Integer x : shList) {
			GenreBean gb = null;
			Integer hallSaleSeats = 0; // 實際售出座位數
			Integer ticketSaleTotal = 0;
			Integer foodSaleTotal = 0;
//				Double pricePerSeat = 0.0;
//				Integer movieHours = 0;
			MovieBean mb = null;
			Integer movieID = 0;
			ShowTimeHistoryBean sthb = null;
			String date = null;
			Integer hallSeats = 0;
			Integer foodCost = 0;
			for (MOrderBean mob : mobList) {
//					if (i == mob.getShowTimeHistoryBean().getRun().getMovieID()) {
				// 取相對應的mod
				if (x == mob.getShowTimeHistoryBean().getShowTimeId()) {
//						title = mob.getShowTimeHistoryBean().getRun().getMovie().getTitle();
					gb = mob.getShowTimeHistoryBean().getRun().getMovie().getGenreBean();
//						movieHours = mob.getShowTimeHistoryBean().getRun().getMovie().getRunningTime(); //片長(分)
					mb = mob.getShowTimeHistoryBean().getRun().getMovie();
					movieID = mob.getShowTimeHistoryBean().getRun().getMovie().getMovieID();
					sthb = mob.getShowTimeHistoryBean();
					date = mob.getShowTimeHistoryBean().getPlayStartTime().substring(0, 10);
					hallSeats = mob.getShowTimeHistoryBean().getHall().getNoOfSeats();
					
					for (MOrderDetailBean modb : modList) {
						if (modb.getmOrderBean().getOrdersID() == mob.getOrdersID()) {
							// 雙人套票要*2數量
							Integer p = modb.getProductsBean().getProductID();
							if (p == 15) {
								hallSaleSeats = hallSaleSeats + modb.getQuantity() * 2;
								ticketSaleTotal = ticketSaleTotal
										+ (modb.getProductsBean().getUnitPrice() * modb.getQuantity()); // 該mod票價
							} else if(p == 1 || p==2 || p==3 || p==13) {
								hallSaleSeats = hallSaleSeats + modb.getQuantity();
								ticketSaleTotal = ticketSaleTotal
										+ modb.getProductsBean().getUnitPrice() * modb.getQuantity(); // 該mod票價
							}else {
								foodCost = foodCost + modb.getProductsBean().getCost() * modb.getQuantity();
								foodSaleTotal = foodSaleTotal
										+ (int)(modb.getProductsBean().getUnitPrice() * modb.getDiscount() * modb.getQuantity()); 
							}
						}
					}

				} else {
				}
//					}
//				List<ShowTimeHistoryBean> sthb1 = dao.getDetail(movieID, date);
			}
			TicketSaleEarnBean tseb = new TicketSaleEarnBean();
			tseb.setMovieBean(mb);
			tseb.setGenreBean(gb);
			tseb.setHallSaleSeats(hallSaleSeats);
			tseb.setTicketSaleTotal(ticketSaleTotal);
			tseb.setOrderDate(date);
			tseb.setShowTimeHistoryBean(sthb);
			tseb.setHallSeats(hallSeats);
			tseb.setFoodSaleTotal(foodSaleTotal);
			tseb.setFoodCost(foodCost);
			resultList.add(tseb);
			System.out.println("resultList.size() => " + resultList.size());
			session.save(tseb);
		}
//			}

//			//飲食總額另外算 跟加總!!
//			String hql5 = "FROM ProductSaleEarnBean";
//			List<ProductSaleEarnBean> psebList = new ArrayList<>();
//			psebList = session.createQuery(hql).getResultList();

//			Integer foodSubtotal = 0;
//			Integer subtotal = 0;
//			for(ProductSaleEarnBean pseb : psebList){
//				if(pseb.getOrderDate() == date.toString()) {
//					foodSubtotal = foodSubtotal + pseb.getSubtotal();
//				}
//			}
//			subtotal = foodSubtotal + ticketSaleTotal;
//			
//			tseb.setFoodSubtotal(foodSubtotal);
//			tseb.setSubtotal(subtotal);
//		}
		session.close();
		return mobList;
	}

//	@Override
//	@SuppressWarnings("unchecked")
//	public List<ShowTimeHistoryBean> getDetail(Integer movieID, LocalDate date) {
//		Session session = factory.openSession();
//		String hql = "SELECT runID FROM RunningBean WHERE movieID = :movieID";
//		List<Integer> runIDs = new ArrayList<>();
//		runIDs = session.createQuery(hql).setParameter("movieID", movieID).getResultList();
//
//		List<ShowTimeHistoryBean> sbList = new ArrayList<>();
////		List<TicketSaleEarnBean> tsebList = new ArrayList<>();
//
//		for (Integer i : runIDs) {
//			String hql1 = "FROM ShowTimeHistoryBean where runID = :runID";
//
//			List<ShowTimeHistoryBean> sthbList = new ArrayList<>();
//			sthbList = session.createQuery(hql).setParameter("runID", i).getResultList();
//
//			for (ShowTimeHistoryBean sthb : sthbList) {
//
//				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.S");
//				LocalDate playDate = LocalDateTime.parse(sthb.getPlayStartTime(), formatter).toLocalDate();
//				long Days = ChronoUnit.DAYS.between(playDate, date);
//
//				if (Days == 0) {
//					sbList.add(sthb);
//				} else {
//				}
//			}
//		}
//
//		session.close();
//		return sbList;
//	}

}
