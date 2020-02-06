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
import com.a.model.MovieBean;
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
	 //拿某一天的全部的show //ok
		@Override
		public List<ShowTimeHistoryBean> getshowMovieByDayAndHallID(LocalDate day,String hallID) {
			// TODO Auto-generated method stub
			Session session =factory.getCurrentSession();
			List<ShowTimeHistoryBean> STHB_List =new ArrayList<>();
			String hql="from ShowTimeHistoryBean where  playStartTime <= :enddate  and playStartTime >= :startdate  and hallID = :hallID ";
//			LocalDate date = playStartTime.toLocalDate();
			String startTime = ((day.toString())+" "+"02:00:00"); 
			String endTime = (day.plusDays(1).toString())+" "+"02:00:00"; 
			STHB_List= session.createQuery(hql).setParameter("enddate", endTime)
	                                       .setParameter("startdate", startTime)
	                                       .setParameter("hallID", hallID)
	                                       .getResultList();
			
			return STHB_List;
		}
	
	
	//拿指定runID的上映日到下檔日全部的show  ok
	@Override
	public List<ShowTimeHistoryBean> getRunBeanLastSTHB(RunningBean rb,String exOffDay,String release) {
		String hql="from ShowTimeHistoryBean where  playStartTime <= :enddate  and playStartTime >= :startdate and RunID = :ID ";
		Session session =factory.getCurrentSession();
		List<ShowTimeHistoryBean> STHB_List =new ArrayList<>();
		STHB_List= session.createQuery(hql).setParameter("enddate", exOffDay+" "+"02:00:00")
                                           .setParameter("startdate", release+" "+"02:00:00")
                                           .setParameter("ID", rb.getRunID())
                                           .getResultList();
		System.out.println(hql);
		System.out.println(rb.getRunID());
		System.out.println(exOffDay);
		System.out.println(release);
		System.out.println(rb.getRunID());
		return STHB_List;
		
	}
	
	//拿指定runID的上映日到下檔日全部的show  ok
		@Override
		public List<ShowTimeHistoryBean> getShowTimeHistoryListByRunIDAndTime(String runID,String exOffDay,String release) {
			String hql="from ShowTimeHistoryBean where  playStartTime <= :enddate  and playStartTime >= :startdate and RunID = :ID ORDER BY playStartTime ASC ";
			Session session =factory.getCurrentSession();
			List<ShowTimeHistoryBean> STHB_List =new ArrayList<>();
			STHB_List= session.createQuery(hql).setParameter("enddate", exOffDay+" "+"02:00:00")
	                                           .setParameter("startdate", release+" "+"02:00:00")
	                                           .setParameter("ID", runID)
	                                           .getResultList();
			System.out.println(hql);
			
			System.out.println("end:"+exOffDay);
			System.out.println("start:"+release);
			
			return STHB_List;
			
		}
	
	//拿的上映日到下檔日全部的show  ok
	@Override
	public List<ShowTimeHistoryBean> getShowTimeHistoryByTime(String endDay,String startDay) {
		String hql="from ShowTimeHistoryBean where  playStartTime <= :enddate  and playStartTime >= :startdate ";
		Session session =factory.getCurrentSession();
		List<ShowTimeHistoryBean> STHB_List =new ArrayList<>();
		STHB_List= session.createQuery(hql).setParameter("enddate", endDay+" "+"02:00:00")
				.setParameter("startdate", startDay+" "+"02:00:00")
				.getResultList();
		System.out.println(hql);
		System.out.println(endDay);
		System.out.println(startDay);
		
		return STHB_List;
		
	}
	
	//拿的上映日到下檔日全部的show  (有指定聽）
		@Override
		public List<ShowTimeHistoryBean> getShowTimeHistoryByDate(String endDay,String startDay,String hallID) {
			String hql="from ShowTimeHistoryBean where  playStartTime <= :enddate  and playStartTime >= :startdate and hallID=:hallID ";
			Session session =factory.getCurrentSession();
			List<ShowTimeHistoryBean> STHB_List =new ArrayList<>();
			STHB_List= session.createQuery(hql).setParameter("enddate", endDay+" "+"02:00:00")
					.setParameter("startdate", startDay+" "+"02:00:00")
					.setParameter("hallID", hallID)
					.getResultList();
			
			
			return STHB_List;
			
		}
	//拿指定的playStartTime 取showTimeId
	@Override
	public int  getShowTimeIdByTime(String playStartTime) {
		int showTimeId=0;
		Session session =factory.getCurrentSession();
		String hql="select showTimeId from ShowTimeHistoryBean where playStartTime = :playStartTime ";
		showTimeId = session.createQuery(hql).setParameter("playStartTime",  playStartTime)
                     .getFirstResult();
		return showTimeId;
	}
	
	
	@Override
	//抓某天的showTime
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
	@Override
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
	@Override
	public boolean updateShowTimeHistoryBean(ShowTimeHistoryBean sthb ) {
		Session session =factory.getCurrentSession();
		List<ShowTimeHistoryBean> STHB_List =new ArrayList<>();
		String hql="update ShowTimeHistoryBean set hallID =:hb ,runID=:rb,playStartTime=:time where   showTimeId=:showID";
		int n = session.createQuery(hql)
				.setParameter("rb", Integer.parseInt(sthb.getRunID()))
				.setParameter("time",sthb.getPlayStartTime())
                .setParameter("hb", sthb.getHallID())
                .setParameter("showID",(sthb.getShowTimeId()))
                .executeUpdate();
		System.out.println(" n"+n);
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

	@SuppressWarnings("unchecked")
	@Override
	public List<ShowTimeHistoryBean> getDistinctMovieID(LocalDateTime startDay){
		Session session = factory.getCurrentSession();
		LocalDate et = startDay.toLocalDate();
		String now = startDay.toLocalDate().toString() + " " + startDay.toLocalTime().toString();
		System.out.println("startDay:" + startDay);
		String enddate = (et.plusDays(7).toString())+" "+"00:00:00"; 
		System.out.println("enddate:" + enddate);
		String hql = "SELECT DISTINCT run FROM ShowTimeHistoryBean where playStartTime <= :enddate  and playStartTime >= :startdate";
		List<ShowTimeHistoryBean> list = new ArrayList<>();
		try {
		list = session.createQuery(hql).setParameter("enddate", enddate)
								.setParameter("startdate", now)
								.getResultList();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ShowTimeHistoryBean> getAWeekShowTimeHistoryBean(LocalDateTime starttime){
		List<ShowTimeHistoryBean> list = new ArrayList<>();
		Session session = factory.getCurrentSession();
		String start = starttime.toString();
		LocalDate et = starttime.toLocalDate();
		String enddate = (et.plusDays(7).toString())+" "+"00:00:00";  
		try {
		String hql="from ShowTimeHistoryBean where  playStartTime <= :enddate  and playStartTime >= :startdate";
		list = session.createQuery(hql).setParameter("enddate", enddate)
				.setParameter("startdate", start)
				.getResultList();
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
		
	}

}
