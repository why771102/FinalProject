package com.a.dao.impl;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.a.dao.ShowTimeHistoryDao;
import com.a.model.RunningBean;
import com.a.model.ShowTimeHistoryBean;

@Repository
public class ShowTimeHistroyDaoImpl implements ShowTimeHistoryDao {
	SessionFactory factory;
	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	
	@Override
	public void addShowTimeHistory(ShowTimeHistoryBean show) {
		Session session =factory.getCurrentSession();
		session.save(show);

	}
    //拿幾天的電影
	@Override
	public List<ShowTimeHistoryBean> getshowMovie(LocalDateTime playStartTime) {
		// TODO Auto-generated method stub
		Session session =factory.getCurrentSession();
		ShowTimeHistoryBean sthb = new ShowTimeHistoryBean();
		List<ShowTimeHistoryBean> STHB_List =new ArrayList<>();
		String hql="from showTimeHistory where  playStartTime <= :enddate  and playStartTime >= :startdate   ";
		LocalDate date = playStartTime.toLocalDate();
		String startTime = (date.format( DateTimeFormatter.ofPattern("yyyy-MM-DD")))+" "+"00:00:00"; 
		String endTime = (date.format( DateTimeFormatter.ofPattern("yyyy-MM-DD")))+" "+"23:59:59"; 
		sthb=(ShowTimeHistoryBean) session.createQuery(hql).setParameter("endate", endTime)
                                       .setParameter("startdate", startTime)
                                       .getResultList();
		STHB_List.add(sthb);
		return STHB_List;
	}

	@Override
	public List<ShowTimeHistoryBean> getShowTimeHistoryBean(List<RunningBean> Orb ) {
		// TODO Auto-generated method stub
		Session session =factory.getCurrentSession();
		
		List<ShowTimeHistoryBean> STHB_List =new ArrayList<>();
		
		//先拿出orderID
		for(RunningBean rb: Orb) {
		
		ShowTimeHistoryBean sthb =null;
		sthb =session.get(ShowTimeHistoryBean.class,  rb.getRunID());
        sthb.setRun(rb);
		
		STHB_List.add(sthb);
		}
		
		return STHB_List;
		
	}

}
