package com.l.dao;

import java.util.List;

import com.a.model.MovieBean;
import com.a.model.RunningBean;
import com.a.model.ShowTimeHistoryBean;
import com.l.model.MOrderBean;
import com.z.model.EmpBean;


public interface mOrdersDao {
	
	//查詢所有電影之狀態為1
	public List<MovieBean> getMovieStatus1();

	//用電影ID查詢runId
	public List<RunningBean> getRunningsByMovieId(Integer movieID);
	
	//查詢播放時間
	public List<ShowTimeHistoryBean> getplayStartTime(RunningBean rb);

	
	//新增訂單
	public void addMOrder(MOrderBean mob);
	//修改訂單之員工ID原本null
	public List<EmpBean> updateEmpbyID(EmpBean eb);
	//修改票狀態、領票時間
	public MOrderBean updateTicket(MOrderBean mob);
}
