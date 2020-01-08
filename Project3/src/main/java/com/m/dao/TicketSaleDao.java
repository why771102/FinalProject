package com.m.dao;

import java.util.Date;
import java.util.List;

import com.a.model.showTimeHistoryBean;
import com.c.model.NumberOfSeatsBean;
import com.p.model.HallOrderBean;

public interface TicketSaleDao {
	//DBT: showTimeHistory => hallID, runID, playStartTime播放日期時間
	
	//取得廳院的ID跟date
	
	//取得x電影的場次數
	public Integer CountShow(String movieID);
	
	//ShowTimeID: 取得x電影的場次DBT => (movies & running) & showTimeHistory
	public Integer getShowTime(Integer movieID);
	
	//HallID & Date年月日only: 取得x電影x場次的Hall, DBT => showTimeHistory
	public showTimeHistoryBean getShowHallandDate(Integer showTimeID); 
	
	//HallSeats: 取得x電影在x天x廳的座位數 DBT => numberOfSeats
	public Integer getHallSeats(String hallID, Date date);
	
	public List<NumberOfSeatsBean> getHallSeat(showTimeHistoryBean sthb);
	
	//HallSeats: 取得x電影在x天的座位總數 DBT => numberOfSeats	
	public List<NumberOfSeatsBean> getHallSeats1(Date date);
	
	//計算x電影x天x場x廳售出座位數DBT => seatOrder, count SeatID number
	public Integer CountSeatSale(Integer showTimeID);
	
	//DBT: movies => movieID, title, runningTime片長, status上映狀態

	//DBT: running => release上映日, offDate實際下映日
	
	//包廳DBT:hallOrder => hallID, startTime, endTime, hallSubtotal租借總價格, payStatusNo(必須是1才是已付款)
	public List<HallOrderBean> getHallOrderInfo();
	
	//取得已付款包廳價 DBT:hallOrder => hallSubtotal租借總價格, payStatusNo(必須是1才是已付款)
	public Integer getHallOrderPrice(String hallID);
}
