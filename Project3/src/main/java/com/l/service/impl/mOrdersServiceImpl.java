package com.l.service.impl;


import java.util.List;



import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.a.model.MovieBean;
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
	//查詢所有場次ID	
	@Transactional
	@Override
	public List<MovieBean> getMovieStatus1() {
		return dao.getMovieStatus1();
	}
	
	@Transactional
	@Override
	public List<ShowTimeHistoryBean> getplayStartTime(Integer runID) {
		return dao.getplayStartTime(runID);
	}

	
	
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
