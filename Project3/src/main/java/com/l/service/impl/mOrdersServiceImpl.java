package com.l.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.a.model.MovieBean;
import com.a.model.RunningBean;
import com.a.model.ShowTimeHistoryBean;
import com.l.dao.ProductsDao;
import com.l.dao.mOrdersDao;
import com.l.model.ProductsBean;
import com.l.service.ProductsService;
import com.l.service.mOrdersService;

@Service
public class mOrdersServiceImpl implements mOrdersService{
	mOrdersDao dao;
	
	@Autowired
	public void setDao(mOrdersDao dao) {
		this.dao = dao;
	}
	
	//查詢排片ID之電影ID
	@Transactional
	@Override
	public List<RunningBean> getRunbyID(){
		return dao.getRunbyID();
	}
	
	//查詢電影ID之電影名字
//	@Transactional
//	@Override
//	public MovieBean getMovieName(Integer movieID); {
//		return dao.getMovieName(movieID);
//	}
//	@Transactional
//	@Override
//	public List<ShowTimeHistoryBean> getShowTimebyID(RunningBean rb) {
//		return dao.getShowTimebyID(rb);
//	}


}
