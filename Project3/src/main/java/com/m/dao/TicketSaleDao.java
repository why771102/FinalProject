package com.m.dao;

public interface TicketSaleDao {

	//廳院(包廳)座位數DBT:Hall ==>　hallId, noOfSeats
	public Integer getNumberOfSeats(Integer hallID);
	
	//DBT: movies => movieID, title, runningTime片長, status上映狀態

	//DBT: running => release上映日, offDate實際下映日
	
	//DBT: showTimeHistory => hallID, runID, palyStartTime播放日期時間
	
	//包廳DBT:HallOrder => hallNo(名稱不一致), startTime, endTime, hallSubtotal租借總價格, payStatusNo(必須是1才是已付款)
	
	//取得已付款包廳價 DBT:HallOrder => hallSubtotal租借總價格, payStatusNo(必須是1才是已付款)
	public Integer getHallPrice(Integer hallNo);
}
