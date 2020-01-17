package com.c.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.c.dao.SeatsDao;
import com.c.model.HallBean;
import com.c.model.SeatStatusBean;
import com.c.model.SeatsBean;
import com.c.model.TypeOfSeatBean;

@Repository
public class SeatsDaoImpl implements SeatsDao {

	SessionFactory factory;

	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	// 將廳勾選好的位子加入seats table
	@Override
	public void insertSeats(SeatsBean sb) {
		Session session = factory.getCurrentSession();
		HallBean hb = getHallById(sb.getHallID());
		sb.setHallBean(hb);
		TypeOfSeatBean tosb = getTypeOfSeatById(sb.getTypeOfSeat());
		sb.setTypeOfSeatBean(tosb);
		SeatStatusBean ssb = getSeatStatusById(sb.getSeatStatus());
		sb.setSeatStatusBean(ssb);
//		sb.setSeatID(sb.getHallID()+sb.getRow()+sb.getSeatNo());
		session.save(sb);

	}

	@Override
	public HallBean getHallById(String hallID) {
		Session session = factory.getCurrentSession();
		HallBean hb = session.get(HallBean.class, hallID);
		return hb;
	}

	public TypeOfSeatBean getTypeOfSeatById(Integer typeOfSeat) {
		Session session = factory.getCurrentSession();
		TypeOfSeatBean tosb = session.get(TypeOfSeatBean.class, typeOfSeat);
		return tosb;
	}

	public SeatStatusBean getSeatStatusById(Integer seatStatus) {
		Session session = factory.getCurrentSession();
		SeatStatusBean ssb = session.get(SeatStatusBean.class, seatStatus);
		return ssb;
	}

	// 後端更新此位是否可以出售
	@Override
	public void updateSeatStatus(Integer status, String seatID, String flag) {
		System.out.println("This is updatseatstatus");
		Session session = factory.getCurrentSession();
		SeatsBean sb = getSeat(seatID);
		String hql = "UPDATE SeatsBean SET seatStatus = :seatStatus WHERE seatID = :seatID";
		if (flag.equalsIgnoreCase("seats")) {
			if (sb.getSeatStatusBean().getSeatStatusID() == 1) {
				session.createQuery(hql).setParameter("seatStatus", 0).setParameter("seatID", seatID).executeUpdate();
			} else {
				session.createQuery(hql).setParameter("seatStatus", status).setParameter("seatID", seatID)
						.executeUpdate();
			}
		} else {
			session.createQuery(hql).setParameter("seatStatus", status).setParameter("seatID", seatID).executeUpdate();
		}

//		SeatsBean sb = session.get(SeatsBean.class, seatID);
//		sb.setSeatStatus(status);
//		session.saveOrUpdate(sb);
	}

	// 後端顯示
	@SuppressWarnings("unchecked")
	@Override
	public List<SeatsBean> getAllSeatsUsingHallID(String hallID) {
		Session session = factory.getCurrentSession();
		List<SeatsBean> list = new ArrayList<>();
		String hql = "FROM SeatsBean WHERE hallID = :hallID";
		list = session.createQuery(hql).setParameter("hallID", hallID).getResultList();
		return list;
	}

	@Override
	public SeatsBean getSeat(String seatID) {
		SeatsBean sb = new SeatsBean();
		Session session = factory.getCurrentSession();
		sb = session.get(SeatsBean.class, seatID);
		return sb;
	}

}
