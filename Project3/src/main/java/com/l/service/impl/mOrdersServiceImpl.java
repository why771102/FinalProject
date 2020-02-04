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
import com.l.model.MOrderDetailBean;
import com.l.model.ProductsBean;
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
	@Override
	public List<RunningBean> getAllOnMoive(LocalDate day){
		return dao.getAllOnMoive(day);
	}
	
	//用runID查出exOffDay和release
	@Transactional
	@Override
	public RunningBean getDayAndRelease(Integer runID){
		return dao.getDayAndRelease(runID);
	}
	
	
	//用runID查所有上映時間
	@Transactional
//	@Override
	public List<ShowTimeHistoryBean> getplayStartTime(Integer runID,String dateTime,String exOffDay){
		return dao.getplayStartTime(runID,dateTime,exOffDay);
	}
	
	@Transactional
	@Override
	public Object getStartTimeByID(Integer showTimeId) {
		return dao.getStartTimeByID(showTimeId);
		}
	

	
	@Transactional
	@Override
	public void addMOrder(MOrderBean mob) {
		 dao.addMOrder(mob);
		
	}
	@Transactional
	@Override
	public void addMOrderDetail(MOrderDetailBean modb) {
		dao.addMOrderDetail(modb);
		
	}



	@Transactional
	@Override
	public MOrderBean updateTicket(MOrderBean mob) {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Transactional
	@Override
	public MOrderBean getOrderID(Integer orderID) {
		
		return dao.getOrderID(orderID);
	}

	
	
	}
	
	



