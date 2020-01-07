package com.p.dao;

import com.p.model.HallOrderBean;

public interface HallOrderDao {
	//包廳申請，要先抓從cookie抓會員ID，藉此綁定會員
	public HallOrderBean hallOrderApply(HallOrderBean Hob);
	
	//用戶自行查詢包廳狀況，用MemberID去找
	public HallOrderBean hallOrderMQuery(Integer MemberID);
	
	//後臺功能，讓員工可查詢一段時間內的包廳申請
	public HallOrderBean hallOrderEQuery();
	
	//後臺功能，讓員工可進行包廳狀態調整
	public HallOrderBean hallOrderStatusChange();
	
	//後臺功能，讓員工可進行包廳付款狀態調整
	public HallOrderBean payStatusChange();
}
