package com.l.service;

import java.time.LocalDate;
import java.util.List;

import com.a.model.MovieBean;
import com.a.model.RunningBean;
import com.a.model.ShowTimeHistoryBean;
import com.l.model.MOrderBean;
import com.z.model.EmpBean;

public interface mOrdersService {

	//查詢所有runID時間在現在時間和expectedOffDate之間之電影ID
	public List<RunningBean> getAllOnMoive(LocalDate today);	
	
	//用runID查所有上映時間
	public List<ShowTimeHistoryBean> getplayStartTime(Integer runID);
	
	
	
	
	
	
	//		//查詢所有電影之狀態為1
//		public List<MovieBean> getMovieStatus1();
//
//		//用電影Id查詢runId
//		public List<RunningBean> getRunningsByMovieId(Integer movieID);
//		
//		//查詢播放時間
//		public List<ShowTimeHistoryBean> getplayStartTime(Integer rb);

	
	
		//新增訂單
		public void addMOrder(MOrderBean mob);
		//修改訂單之員工ID原本null
		public List<EmpBean> updateEmpbyID(EmpBean eb);
		//修改票狀態、領票時間
		public MOrderBean updateTicket(MOrderBean mob);

		
}
