package com.m.dao;

import java.util.Date;
import java.util.List;
import com.p.model.HallOrderBean;

public interface TicketSaleDao {

	//廳院(包廳)座位數DBT:numberOfSeats => hallId, noOfSeats, date
	//DBT: showTimeHistory => hallID, runID, palyStartTime播放日期時間
	
	//取得廳院的ID跟date
	
	//取得廳院&包廳座位數
	public Integer getHallSeats(String hallID, Date date);
	
	//DBT: movies => movieID, title, runningTime片長, status上映狀態

	//DBT: running => release上映日, offDate實際下映日
	
	//包廳DBT:hallOrder => hallID, startTime, endTime, hallSubtotal租借總價格, payStatusNo(必須是1才是已付款)
	public List<HallOrderBean> getHallOrderInfo();
	//取得已付款包廳價 DBT:hallOrder => hallSubtotal租借總價格, payStatusNo(必須是1才是已付款)
	public Integer getHallOrderPrice(String hallID);
}
