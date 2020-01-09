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
import com.c.model.ReservedSeatsBean;
import com.c.model.SeatsBean;

@Repository
public class ReservedSeatsDaoImpl implements ReservedSeatsDao {

	SessionFactory factory;

	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	
	@Override
	public void insertSeats() {
		Session session = factory.getCurrentSession();
		//(ShowTimeHistoryBean) need date, showtimeID and seatID, reservationStatus(SeatsBean)
		//ShowTimeHistoryBean

		List<ShowTimeHistoryBean> listSTHB= new ArrayList<>();
		for(int days = 0; days <=7; days++) {
			//first get today's date + 7 days
			LocalDate currentDate = LocalDate.now();
			LocalDate currentDatePlusAWeek = currentDate.plusDays(days);
			//先判斷日期是今天加一週 --> 
			String hql = "FROM ShowTimeHistoryBean WHERE CONVERT(varchar(100), playStartTime, 23) = :playStartTime";
			ShowTimeHistoryBean sthb = (ShowTimeHistoryBean) session.createQuery(hql).setParameter("playStartTime", currentDatePlusAWeek).getSingleResult();
			listSTHB.add(sthb);
		}
		//取得showtimeID and hallID
		List<SeatsBean> listSB = new ArrayList<>();
		for(ShowTimeHistoryBean stBean : listSTHB) {
			String hallID = stBean.getHall().toString();
			String hql = "FROM SeatsBean WHERE hallID = :hallID";
			listSB = session.createQuery(hql).getResultList();
		}
		
		for(ShowTimeHistoryBean sthBean : listSTHB) {
			String sthbHallID = sthBean.getHall().toString();
			String date = sthBean.getPalyStartTime();
			date = date.substring(0, 10);
			Integer showTimeId = sthBean.getShowTimeId();
			for(SeatsBean sBean : listSB) {
				String sbHallID = sBean.getHallBean().toString();
				if(sthbHallID == sbHallID) {
					SeatsBean seatID = sBean.getSeatID();
					Integer seatStatus = sBean.getSeatStatus();
					ReservedSeatsBean rsb = new ReservedSeatsBean(date, showTimeId, seatID, seatStatus);
				}
			}
		}
		//showtimeID + date insert into reservedSeatsBean
		//SeatsBean
		//use hallID to get all seatID + seatStatus
		//seatStatus = 0 can be reserved
		//seatStatus = 1 cannot be reserved

	}

	@Override
	public void updateReservationStatus() {
		

	}

}
