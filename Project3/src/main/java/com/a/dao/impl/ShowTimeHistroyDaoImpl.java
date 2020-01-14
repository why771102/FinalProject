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
	//存入ShowTimeHistoryBean in DB  //ok
	@Override
	public void addShowTimeHistory(ShowTimeHistoryBean show) {
		Session session =factory.getCurrentSession();
		session.save(show);

	}
    //拿某一天的全部的show //ok
	@Override
	public List<ShowTimeHistoryBean> getshowMovie(LocalDate day) {
		// TODO Auto-generated method stub
		Session session =factory.getCurrentSession();
		List<ShowTimeHistoryBean> STHB_List =new ArrayList<>();
		String hql="from ShowTimeHistoryBean where  playStartTime <= :enddate  and playStartTime >= :startdate   ";
//		LocalDate date = playStartTime.toLocalDate();
		String startTime = ((day.toString())+" "+"00:00:00"); 
		String endTime = (day.toString())+" "+"23:59:59"; 
		STHB_List= session.createQuery(hql).setParameter("enddate", endTime)
                                       .setParameter("startdate", startTime)
                                       .getResultList();
		
		return STHB_List;
	}
	//拿指定runID的上映日到下檔日全部的show  ok
	@Override
	public List<ShowTimeHistoryBean> getRunBeanLastSTHB(RunningBean rb,String exOffDay,String release) {
		String hql="from ShowTimeHistoryBean where  playStartTime <= :enddate  and playStartTime >= :startdate and RunID = :ID ";
		Session session =factory.getCurrentSession();
		List<ShowTimeHistoryBean> STHB_List =new ArrayList<>();
		STHB_List= session.createQuery(hql).setParameter("enddate", exOffDay)
                                           .setParameter("startdate", release)
                                           .setParameter("ID", rb.getRunID())
                                           .getResultList();
		System.out.println(hql);
		System.out.println(exOffDay);
		System.out.println(release);
		System.out.println(rb.getRunID());
		return STHB_List;
		
	}
	
	
  // 把runBean 換成 showTime List ok
	@Override
	public List<ShowTimeHistoryBean> getShowTimeHistoryBean(RunningBean rb ) {
		// TODO Auto-generated method stub
		Session session =factory.getCurrentSession();
		
		List<ShowTimeHistoryBean> STHB_List =new ArrayList<>();
		String hql="from ShowTimeHistoryBean where  RunID = :ID ";
		//先拿出orderID
		
		STHB_List= session.createQuery(hql).setParameter("ID", rb.getRunID())
                                           .getResultList();
		
		
		
		return STHB_List;

	}
	

	

}
