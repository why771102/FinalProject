package com.a.dao.impl;

import java.sql.Timestamp;
import java.time.Duration;
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
import com.a.model.MovieStatusBean;
import com.a.model.RunningBean;
import com.a.model.ShowTimeHistoryBean;

@Repository
public class ShowTimeHistoryDaoImpl implements ShowTimeHistoryDao {
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
		String startTime = ((day.toString())+" "+"02:00:00"); 
		String endTime = (day.plusDays(1).toString())+" "+"02:00:00"; 
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
	
	@Override
	public List<ShowTimeHistoryBean> getRunBeanLastSTHB(String startdate) {
		String hql="from ShowTimeHistoryBean where    playStartTime >= :startdate ";
		Session session =factory.getCurrentSession();
		List<ShowTimeHistoryBean> STHB_List =new ArrayList<>();
		STHB_List= session.createQuery(hql).setParameter("startdate",  startdate)
                                           .getResultList();
		System.out.println(hql);
		System.out.println(startdate);
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
	//抓指定日期的某一聽
	public List<ShowTimeHistoryBean> getshowMovie(LocalDate day,String hallID) {
		// TODO Auto-generated method stub
		Session session =factory.getCurrentSession();
		List<ShowTimeHistoryBean> STHB_List =new ArrayList<>();
		String hql="from ShowTimeHistoryBean where  playStartTime <= :enddate  and playStartTime >= :startdate  and hallID=:ID ";
//		LocalDate date = playStartTime.toLocalDate();
		String startTime = ((day.toString())+" "+"02:00:00"); 
		String endTime = (day.plusDays(1).toString())+" "+"02:00:00"; 
		STHB_List= session.createQuery(hql).setParameter("enddate", endTime)
                                       .setParameter("startdate", startTime)
                                       .setParameter("ID", hallID)
                                       .getResultList();
		
		return STHB_List;
	}
	
	//修改showtimeHistoryBean
	public boolean updateShowTimeHistoryBean(ShowTimeHistoryBean sthb ) {
		Session session =factory.getCurrentSession();
		List<ShowTimeHistoryBean> STHB_List =new ArrayList<>();
		String hql="from ShowTimeHistoryBean set hallID =:hb ,runID=:rb,playStartTime=:sttime where   hallID=:ID";
		int n = session.createQuery(hql).setParameter("hb", sthb.getHall())
				.setParameter("rb", sthb.getRun())
				.setParameter("sttime",sthb.getPlayStartTime())
                .setParameter("ID", sthb.getHallID())
                .executeUpdate();
if(n==0) {
return false;
}
		return true;
	}
	//如果只換排序// 沒包場的情況
	public List<ShowTimeHistoryBean> changeSTHBSortTime( List<ShowTimeHistoryBean> sthb_list ) {
		Session session =factory.getCurrentSession();
		List<ShowTimeHistoryBean> STHB_List =new ArrayList<>();
		ShowTimeHistoryBean sthb=getShowTimeHistoryBeanById(sthb_list.get(0).getShowTimeId() );
		ShowTimeHistoryBean sthb2=getShowTimeHistoryBeanById(sthb_list.get(1).getShowTimeId() );
		sthb.getPlayStartTime();
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.0");
		LocalDateTime dateTime = LocalDateTime.parse(sthb.getPlayStartTime(), fmt);
		LocalDateTime dateTime2 = LocalDateTime.parse(sthb2.getPlayStartTime(), fmt);
		Duration duration = Duration.between(dateTime2,dateTime);
		int restTime = (int) duration.toMinutes();
		for(ShowTimeHistoryBean sthb3:STHB_List) {
			
			sthb3.setPlayStartTime(dateTime.toLocalDate().toString()+" "+dateTime.toLocalTime().toString());
			dateTime= dateTime.plusMinutes(sthb3.getRun().getMovie().getRunningTime()+restTime);
			STHB_List.add(sthb3);
		}
		return STHB_List;
	}
	public ShowTimeHistoryBean  getShowTimeHistoryBeanById(int showTimeID) {
		Session session =factory.getCurrentSession();
		ShowTimeHistoryBean sthb =session.get(ShowTimeHistoryBean.class,  showTimeID);
		return sthb;
	}

	

}
