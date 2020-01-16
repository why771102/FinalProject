package com.l.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.a.model.RunningBean;
import com.l.dao.mOrdersDao;
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
		List<RunningBean> list = dao.getRunbyID();
		ArrayList<Object> midList = new ArrayList<>();
		for(int i = 0; i < list.size(); i++) {
			Integer movieId = list.get(i).getMovieID();
			midList.add(movieId);
		}
		return list;
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