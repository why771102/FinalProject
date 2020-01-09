package com.m.dao;

import java.util.Date;
import java.util.List;

import com.a.model.MovieBean;
import com.a.model.RunningBean;
import com.a.model.ShowTimeHistoryBean;
import com.c.model.NumberOfSeatsBean;
import com.c.model.SeatOrderBean;
import com.p.model.HallOrderBean;

public interface TicketSaleDao {
	
	//HallSeats: 取得x電影在x天的座位總數 DBT => numberOfSeats	
	public List<NumberOfSeatsBean> getHallSeats(Date date);
	
	//取得電影名稱 DBT => movies
	public List<MovieBean> getFilm(Integer movieID);
	
	//計算x電影x天x場x廳售出座位數DBT: seatOrder =>count SeatID number
	public List<SeatOrderBean> CountSeatSale(Integer showTimeID);
	
	//DBT: showTimeHistory => hallID, runID, playStartTime播放日期時間
	
	//根據輸入的起迄時間, 取得廳院的mID跟RunID, DBT => running
	public List<RunningBean> getRunningInfo(Date sDate, Date eDate);
	
//	public List<Integer> getMovieID(Date sDate, Date eDate);
	
	//取得x電影的場次數
	public Integer CountShow(String movieID);
	
	//ShowTimeID: 取得x電影的場次DBT => (movies & running) & showTimeHistory
	public Integer getShowTime(Integer movieID);
	
	//HallID & Date年月日only: 取得x電影x場次的Hall, DBT => showTimeHistory
	public ShowTimeHistoryBean getShowHallandDate(Integer showTimeID); 
	
	//HallSeats: 取得x電影在x天x廳的座位數 DBT => numberOfSeats
//	public Integer getHallSeats(String hallID, Date date);
	
	//DBT: movies => movieID, title, runningTime片長, status上映狀態
	
	//DBT: running => release上映日, offDate實際下映日
	
	//包廳DBT:hallOrder => hallID, startTime, endTime, hallSubtotal租借總價格, payStatusNo(必須是1才是已付款)
	public List<HallOrderBean> getHallOrderInfo();
	
	//取得已付款包廳價 DBT:hallOrder => hallSubtotal租借總價格, payStatusNo(必須是1才是已付款)
	public Integer getHallOrderPrice(String hallID);
}
