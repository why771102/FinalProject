package com.l.service;

import java.time.LocalDate;
import java.util.List;

import com.a.model.MovieBean;
import com.a.model.RunningBean;
import com.a.model.ShowTimeHistoryBean;
import com.l.model.MOrderBean;
import com.l.model.MOrderDetailBean;
import com.l.model.ProductsBean;
import com.z.model.EmpBean;

public interface mOrdersService {

	//查詢所有runID時間在現在時間和expectedOffDate之間之電影ID
	public List<RunningBean> getAllOnMoive(LocalDate today);	
	
	//用runID查所有上映時間
	public List<ShowTimeHistoryBean> getplayStartTime(Integer runID,String dateTime,String exOffDay);
	
	//用runID查出exOffDay和release
	public RunningBean getDayAndRelease(Integer runID);
	
	//用StartTimeID查	單筆
	public Object getStartTimeByID(Integer showTimeId);
	
	//新增訂單
	public void addMOrder(MOrderBean mob);
	//新增訂單明細
	public void addMOrderDetail(MOrderDetailBean modb);
	
	//修改票狀態、領票時間、員工ID原本1
	public MOrderBean updateTicket(MOrderBean mob);

	//查詢單筆訂單	
	public void getOrderID(Integer orderID);
		
}
