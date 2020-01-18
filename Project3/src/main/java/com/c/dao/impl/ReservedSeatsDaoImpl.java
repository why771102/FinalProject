package com.c.dao.impl;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.a.model.ShowTimeHistoryBean;
import com.c.dao.ReservedSeatsDao;
import com.c.model.ReservationStatusBean;
import com.c.model.ReservedSeatsBean;
import com.c.model.SeatsBean;

@Repository
public class ReservedSeatsDaoImpl implements ReservedSeatsDao {

	SessionFactory factory;

	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void insertSeats() {

		Session session = factory.getCurrentSession();
		// (ShowTimeHistoryBean) need date, showtimeID and seatID,
		// reservationStatus(SeatsBean)
		// ShowTimeHistoryBean

		List<ShowTimeHistoryBean> listSTHB = new ArrayList<>();
			// first get today's date + 7 days
		String currentDate = ((LocalDate.now().toString())+" "+"00:00:00"); 
		String currentDatePlusAWeek = (((LocalDate.now().plusDays(7)).toString())+" "+"23:59:59");
//			LocalDate currentDate = LocalDate.now();
//			LocalDate currentDatePlusAWeek = currentDate.plusDays(days);
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
		}
		System.out.println("listSB.size() = " + listSB.size());
		for (ShowTimeHistoryBean sthBean : listSTHB) {
			String sthbHallID = sthBean.getHall().getHallID();
			System.out.println("sthbHallID in for (ShowTimeHistoryBean sthBean : listSTHB)" + sthbHallID);
			String date = sthBean.getPalyStartTime();
			date = date.substring(0, 10);
			System.out.println(date);
//			Integer showTimeId = sthBean.getShowTimeId();
			for (SeatsBean sBean : listSB) {
				boolean result = false;
				String sbHallID = sBean.getHallBean().getHallID();
				System.out.println("sbHallID in for (SeatsBean sBean : listSB)" + sbHallID);
				if (sthbHallID.equalsIgnoreCase(sbHallID)) {
//					String seatID = sBean.getSeatID();
					ShowTimeHistoryBean showTimeID = getShowTimeById(sthBean.getShowTimeId());
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

	}

	@Override
	public void reserveSeat(Integer showTimeID, String seatID) {
		Session session = factory.getCurrentSession();
		String hql = "FROM ReservedSeatsBean WHERE seatID= :seatID and showTimeID = :showTimeID and reservationStatus = 0";
		ReservedSeatsBean rsb = (ReservedSeatsBean) session.createQuery(hql).setParameter("seatID", seatID)
				.setParameter("showTimeID", showTimeID).getSingleResult();
		rsb.setReservationStatus(1);
		session.saveOrUpdate(rsb);
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
	public List<SeatsBean> getAllSeats(Integer showTimeID, Date date) {
		List<SeatsBean> list = new ArrayList<>();
		Session session = factory.getCurrentSession();
		String hql = "FROM ReservedSeatsBean WHERE showTimeID = :showTimeID and date = :date";
		list = session.createQuery(hql).setParameter("showTimeID", showTimeID).setParameter("date", date)
				.getResultList();
		return list;
	}

	@Override
	public ReservationStatusBean getReservationStatusById(Integer reservationStatus) {
		Session session = factory.getCurrentSession();
		ReservationStatusBean rsb = session.get(ReservationStatusBean.class, reservationStatus);
		return rsb;
	}

}
