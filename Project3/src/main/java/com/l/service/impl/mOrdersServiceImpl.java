package com.l.service.impl;


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
	
	//查詢排片ID之電影ID
	@Transactional
	@Override
	public List<RunningBean> getRunbyID(){
		List<RunningBean> list = dao.getRunbyID();
//		ArrayList<Object> midList = new ArrayList<>();
//		for(int i = 0; i < list.size(); i++) {
//			Integer movieId = list.get(i).getMovieID();
//			midList.add(movieId);
//		}
		return list;
	}
	
	//查詢電影ID之電影名字
	@Transactional
	@Override
	public List<MovieBean> getMovieName() {
		return dao.getMovieName();
	}
	//查詢所有場次ID	
	@Transactional
	@Override
	public List<String> getAllShowTimeID() {
		return dao.getAllShowTimeID();
	}
	
	//用runID查詢播放日期時間
	@Transactional
	@Override
	public List<ShowTimeHistoryBean> getShowTimebyID(Integer runID) {
		return dao.getShowTimebyID(runID);
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
