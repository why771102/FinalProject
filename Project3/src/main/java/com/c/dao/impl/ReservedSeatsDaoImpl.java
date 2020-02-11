package com.c.dao.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.a.model.ShowTimeHistoryBean;
import com.c.dao.ReservedSeatsDao;
import com.c.model.NumberOfSeatsBean;
import com.c.model.ReservationStatusBean;
import com.c.model.ReservedSeatsBean;
import com.c.model.SeatsBean;

@Repository
public class ReservedSeatsDaoImpl implements ReservedSeatsDao {

	SessionFactory factory;
//	NumberOfSeatsDaoImpl nosdImpl;

	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	

	@SuppressWarnings("unchecked")
	@Override
	public List<ShowTimeHistoryBean> insertSeats() {
		Session session = factory.getCurrentSession();
		List<ShowTimeHistoryBean> listSTHB = new ArrayList<>();
		String currentDate = ((LocalDate.now().toString())+" "+"02:00:00"); 
		String currentDatePlusAWeek = (((LocalDate.now().plusDays(9)).toString())+" "+"02:00:00");
			// 先判斷日期是今天加一週 -->
		String listSTHBhql = "FROM ShowTimeHistoryBean WHERE playStartTime >= :currentDate and playStartTime <= :currentDatePlusAWeek";
		listSTHB = session.createQuery(listSTHBhql)
				   .setParameter("currentDate", currentDate)
				   .setParameter("currentDatePlusAWeek", currentDatePlusAWeek)
				   .getResultList();
		System.out.println("listSTHB.size() = " + listSTHB.size());
		// 取得showtimeID and hallID
		List<SeatsBean> listSB = new ArrayList<>();
		for (ShowTimeHistoryBean stBean : listSTHB) {
			String hallID = stBean.getHall().getHallID();
			String hql = "FROM SeatsBean WHERE hallID = :hallID";
			listSB = session.createQuery(hql).setParameter("hallID", hallID).getResultList();
//		}
//		System.out.println("listSB.size() = " + listSB.size());
//		for (ShowTimeHistoryBean sthBean : listSTHB) {
			String sthbHallID = stBean.getHall().getHallID();
//			System.out.println("sthbHallID in for (ShowTimeHistoryBean sthBean : listSTHB)" + sthbHallID);
			String date = stBean.getPlayStartTime();
			date = date.substring(0, 10);
			System.out.println(date);
			for (SeatsBean sBean : listSB) {
				String sbHallID = sBean.getHallBean().getHallID();
				System.out.println("sbHallID in for (SeatsBean sBean : listSB)" + sbHallID);
				if (sthbHallID.equalsIgnoreCase(sbHallID)) {
					ShowTimeHistoryBean showTimeID = getShowTimeById(stBean.getShowTimeId());
					SeatsBean seatID = getSeatsById(sBean.getSeatID());
					Integer seatStatus = sBean.getSeatStatusBean().getSeatStatusID();
					ReservationStatusBean rstatusb = getReservationStatusById(seatStatus);
					ReservedSeatsBean rsb = new ReservedSeatsBean(date, rstatusb, showTimeID, seatID);
					session.save(rsb);
				}
			}
		}
		// showtimeID + date insert into reservedSeatsBean
		// SeatsBean
		// use hallID to get all seatID + seatStatus
		// seatStatus = 0 can be reserved
		// seatStatus = 1 cannot be reserved
		return listSTHB;
	}

	@Override
	public void reserveSeat(ReservedSeatsBean rsb) {
		Session session = factory.getCurrentSession();
		ReservationStatusBean rs = getReservationStatusById(1);
		ShowTimeHistoryBean sthb = getShowTimeById(rsb.getShowtimeHistoryBean().getShowTimeId());
		SeatsBean sb = getSeatsById(rsb.getSeatsBean().getSeatID());
		System.out.println("reserve seats reservation status: " + rs.getReservationStatusID());
		System.out.println("reserve seats showtime: " + sthb.getShowTimeId());
		System.out.println("reserve seats seatID: " + rsb.getSeatsBean().getSeatID());
		
		rsb.setShowtimeHistoryBean(sthb);
		rsb.setReservationStatusBean(rs);
		rsb.setSeatsBean(sb);
		session.saveOrUpdate(rsb);
	}
	
	@Override
	public ReservedSeatsBean getSeat(Integer showTimeID, String seatID) {
		Session session = factory.getCurrentSession();
		System.out.println("Getseat seatID: " + seatID);
		String hql = "FROM ReservedSeatsBean WHERE seatID= :seatID and showTimeID = :showTimeID and reservationStatus = 0";
		ReservedSeatsBean rsb = (ReservedSeatsBean) session.createQuery(hql).setParameter("seatID", seatID)
				.setParameter("showTimeID", showTimeID).getSingleResult();
		return rsb;
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

	@Override
	public void cancelReservedSeat(Integer showTimeID, String seatID) {
		Session session = factory.getCurrentSession();
		String hql = "FROM ReservedSeatsBean WHERE seatID= :seatID and showTimeID = :showTimeID and reservationStatus = 1";
		ReservedSeatsBean rsb = (ReservedSeatsBean) session.createQuery(hql).setParameter("seatID", seatID)
				.setParameter("showTimeID", showTimeID).getSingleResult();
		rsb.setReservationStatus(0);
		session.saveOrUpdate(rsb);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ReservedSeatsBean> getAllSeats(Integer showTimeID) {
		List<ReservedSeatsBean> list = new ArrayList<>();
		System.out.println("List<ReservedSeatsBean> getAllSeats");
		Session session = factory.getCurrentSession();
		System.out.println(showTimeID);
		String hql = "FROM ReservedSeatsBean WHERE showTimeID = :showTimeID";
		list = session.createQuery(hql).setParameter("showTimeID", showTimeID)
				.getResultList();
		System.out.println(list.get(0));
		return list;
	}

	@Override
	public ReservationStatusBean getReservationStatusById(Integer reservationStatus) {
		Session session = factory.getCurrentSession();
		System.out.println("reservationStatus: " + reservationStatus);
		ReservationStatusBean rsb = session.get(ReservationStatusBean.class, reservationStatus);
		return rsb;
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<ReservedSeatsBean> getAllSeats(String seatID) {
		Session session = factory.getCurrentSession();
		List<ReservedSeatsBean> list = new ArrayList<>();
		String hql = "FROM ReservedSeatsBean WHERE seatID = :seatID";
		System.out.println("ReservedSeatsDaoImpl --- List<ReservedSeatsBean> getAllSeats(String seatID): " + seatID);
		list = session.createQuery(hql).setParameter("seatID", seatID).getResultList();
		return list;
	}


	@Override
	public void updateSeatStatusForOutOfOrder(List<ReservedSeatsBean> list) {
		Session session = factory.getCurrentSession();
		for(ReservedSeatsBean rsb : list) {
			ReservationStatusBean rs = getReservationStatusById(1);
			rsb.setReservationStatusBean(rs);
			System.out.println("updateSeatStatusForOutOfOrder seatID: " + rsb.getSeatID());
			session.saveOrUpdate(rsb);
		}
		
	}
	
//	@Override
//	public Integer calculateNumberOfSeats(List<ReservedSeatsBean> listRSB) {
//		Integer noOfSeats;
//		
//		return noOfSeats;
//		
//	}

}
