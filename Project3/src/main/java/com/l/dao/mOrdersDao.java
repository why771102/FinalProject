package com.l.dao;

import java.time.LocalDate;
import java.util.List;

import com.a.model.MovieBean;
import com.a.model.RunningBean;
import com.a.model.ShowTimeHistoryBean;
import com.l.model.MOrderBean;
import com.p.model.MemberBean;
import com.z.model.EmpBean;


public interface mOrdersDao {
	
	//查詢所有runID時間在現在時間和expectedOffDate之間之電影ID
	public List<RunningBean> getAllOnMoive(LocalDate day);
	
	//用runID查出playStartTime
	public List<ShowTimeHistoryBean> getplayStartTime(Integer runID,String dateTime,String exOffDay);
	
	//用runID查出exOffDay和release
	public RunningBean getDayAndRelease(Integer runID);
	
	//用StartTimeID查	單筆
	public Object getStartTimeByID(Integer showTimeId);

	//新增訂單
	public void addMOrder(MOrderBean mob);
	//修改訂單之員工ID原本null
	public List<EmpBean> updateEmpbyID(EmpBean eb);
	//修改票狀態、領票時間
	public MOrderBean updateTicket(MOrderBean mob);

	
	//新增用
	
	ShowTimeHistoryBean getShowTimeHistory(int showTimeId);

	EmpBean getEmp(int empID);

	MemberBean getMemberById(int memberID);
}
