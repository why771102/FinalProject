package com.l.dao;

import java.util.List;

import com.a.model.MovieBean;
import com.a.model.RunningBean;
import com.a.model.ShowTimeHistoryBean;
import com.l.model.MOrderBean;
import com.z.model.EmpBean;


public interface mOrdersDao {
	//查詢排片ID之所有電影ID
	public List<RunningBean> getRunbyID();
	
	//查詢電影ID之電影名字
	public MovieBean getMovieName(Integer movieID);
	//用排片ID查詢播放日期時間
	public List<ShowTimeHistoryBean> getShowTimebyID(RunningBean rb);
	//新增訂單
	public void addMOrder(MOrderBean mob);
	//修改訂單之員工ID原本null
	public List<EmpBean> updateEmpbyID(EmpBean eb);
	//修改票狀態、領票時間
	public MOrderBean updateTicket(MOrderBean mob);
}
