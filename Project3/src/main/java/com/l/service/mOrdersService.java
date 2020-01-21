package com.l.service;

import java.util.List;

import com.a.model.MovieBean;
import com.a.model.RunningBean;
import com.a.model.ShowTimeHistoryBean;
import com.l.model.MOrderBean;
import com.z.model.EmpBean;

public interface mOrdersService {
		//查詢排片ID之電影ID
		public List<RunningBean> getRunbyID();
		//查詢電影ID之所有電影名字
		public List<MovieBean> getMovieName();
		//查詢所有場次ID
		public List<String> getAllShowTimeID();
		//查詢場次ID之播放日期時間
		public List<ShowTimeHistoryBean> getShowTimebyID(Integer runID);
		//新增訂單
		public void addMOrder(MOrderBean mob);
		//修改訂單之員工ID原本null
		public List<EmpBean> updateEmpbyID(EmpBean eb);
		//修改票狀態、領票時間
		public MOrderBean updateTicket(MOrderBean mob);
}
