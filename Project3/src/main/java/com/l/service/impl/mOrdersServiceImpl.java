package com.l.service.impl;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;



import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.a.model.MovieBean;
import com.a.model.RunningBean;
import com.a.model.ShowTimeHistoryBean;
import com.l.dao.mOrdersDao;
import com.l.model.MOrderBean;
import com.l.service.mOrdersService;
import com.z.model.EmpBean;

@Service
public class mOrdersServiceImpl implements mOrdersService{
	mOrdersDao dao;
	
	@Autowired
	public void setDao(mOrdersDao dao) {
		this.dao = dao;
	}

	//查詢所有runID時間在現在時間和expectedOffDate之間之電影ID
	@Transactional
//	@Override
	public List<RunningBean> getAllOnMoive(LocalDate day){
		return dao.getAllOnMoive(day);
	}
		
	//用runID查所有上映時間
	@Transactional
//	@Override
	public List<ShowTimeHistoryBean> getplayStartTime(Integer runID){
		return dao.getplayStartTime(runID);
	}
	
	
	
//	//查詢所有場次ID	
//	@Transactional
//	@Override
//	public List<MovieBean> getMovieStatus1() {
//		return dao.getMovieStatus1();
//	}
//	
//	//用電影Id查詢runId;用offDate實際下映日擋
//	@Transactional
//	@Override
//	public List<RunningBean> getRunningsByMovieId(Integer movieID) {
//		
//		List<RunningBean> Allmovies = null ;
//		for(RunningBean rb:Allmovies) {
//			DateFormat sdf = null;
//			try {
//				Date date = new Date();
//				if(sdf.parse(rb.getOffDate()).after(date)) {
//					Allmovies=dao.getRunningsByMovieId(movieID);
//				}
//			} catch (ParseException e) {
//			
//				e.printStackTrace();
//			}
//		}
//	
//		return Allmovies;
//		
//	}
//	
//	//查詢播放時間
//	@Transactional
//	@Override
//	public List<ShowTimeHistoryBean> getplayStartTime(Integer rb) {
//		return dao.getplayStartTime(rb);
//	}

	
	
	
	
	@Transactional
	@Override
	public void addMOrder(MOrderBean mob) {
		// TODO Auto-generated method stub
		
	}
	
	@Transactional
	@Override
	public List<EmpBean> updateEmpbyID(EmpBean eb) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	@Override
	public MOrderBean updateTicket(MOrderBean mob) {
		// TODO Auto-generated method stub
		return null;
	}
	
	


}
