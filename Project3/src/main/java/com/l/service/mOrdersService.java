package com.l.service;

import java.util.List;

import com.a.model.MovieBean;
import com.a.model.RunningBean;
import com.a.model.ShowTimeHistoryBean;
import com.l.model.MOrderBean;
import com.z.model.EmpBean;

public interface mOrdersService {
		//查詢所有電影之狀態為1
		public List<MovieBean> getMovieStatus1();
		//查詢播放時間
		public List<ShowTimeHistoryBean> getplayStartTime(Integer runID);
	

	
	
		//新增訂單
		public void addMOrder(MOrderBean mob);
		//修改訂單之員工ID原本null
		public List<EmpBean> updateEmpbyID(EmpBean eb);
		//修改票狀態、領票時間
		public MOrderBean updateTicket(MOrderBean mob);
}
