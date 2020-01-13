package com.p.dao;

import java.util.List;

import com.c.model.HallBean;
import com.p.model.HallOrderBean;
import com.p.model.HallOrderStatusBean;
import com.p.model.MemberBean;
import com.p.model.PayStatusBean;

public interface HallOrderDao {
	//包廳申請，要先抓從cookie抓會員ID，藉此綁定會員
	public HallOrderBean hallOrderApply(HallOrderBean Hob);
	
	//用戶自行查詢包廳狀況，用MemberID去找，要用大貨櫃包住
	public List<HallOrderBean> hallOrderMQuery(Integer MemberID);
	
	//後臺功能，讓員工可查詢一段時間內的包廳申請
	public List<HallOrderBean> hallOrderEQuery();
	
	//後臺功能，讓員工可進行包廳狀態調整，狀態調整完要記得發送email
	public HallOrderBean hallOrderStatusChange(HallOrderBean hob);
	
	//後臺功能，讓員工可進行包廳付款狀態調整
	public HallOrderBean payStatusChange(HallOrderBean hob);
	
	//動態新增廳號選單
	public List<String> getAllhallID();
	
	public HallBean getHallByHallID(String hallID);

	//存包廳狀態會用的方法
	public HallOrderStatusBean gethallOrderStatusBean(Integer hallOrderStatusNo);

	public List<HallOrderStatusBean> getHallOrderStatusList();
	
	//存memberID會用到的方法
	public MemberBean getMemberByMemberID(Integer memberID);
	
	//存包廳付款狀態會用到的方法
	public PayStatusBean getPayStatusByPSNo(Integer payStatusNo);

	
}
