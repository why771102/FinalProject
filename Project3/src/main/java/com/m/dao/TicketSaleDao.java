package com.m.dao;

import java.util.List;

import com.a.model.MovieBean;
import com.a.model.RunningBean;
import com.a.model.ShowTimeHistoryBean;
import com.c.model.NumberOfSeatsBean;
import com.m.model.TicketSaleBean;

public interface TicketSaleDao {
	
	//取得電影相關資訊
	public List<TicketSaleBean> getMovieInfo();
	//取得票卷銷售相關資訊
	public List<TicketSaleBean> getTicketSale(List<TicketSaleBean> tsbList);
	
	
	//HallSeats: 取得在x天的座位總數 DBT => numberOfSeats	
//	public List<NumberOfSeatsBean> getHallSeats(String sDate, String eDate);
	
	//計算x電影x天x場x廳售出座位數DBT: seatOrder =>count SeatID number
//	public List<SeatOrderBean> CountSeatSale(Integer showTimeID);
//	public List<ShowTimeHistoryBean> GetMoiveIDs(List<RunningBean> rb);
//	
//	public List<SeatOrderBean> CountSeatSale(List<ShowTimeHistoryBean> sthb, String date);
	
	//輸入特定日期範圍查電影 DBT=> running: 上映日release, 預計下映日expectedOffDate, 實際下映日offDate
	//會顯示的狀況:localDatetime
	//從rb中getMovieID可以得到每個mbBean,再從mbBean找到movieTitle, genre
	public List<RunningBean> ShowMovieByRunTime();
	//running and sth結合拿出sthb
	public List<ShowTimeHistoryBean> getshowTimeHistory(List<RunningBean> rb);
	//sthb放入nosb取得x電影x廳的總座位數
	public List<NumberOfSeatsBean> getNumberOfSeats(List<ShowTimeHistoryBean> sthb);
	
	//getMovieNames
	public List<MovieBean> getMovieNames(List<RunningBean> rbList);

	//	public List<NumberOfSeatsBean> getHallSeats(List<NumberOfSeatsBean> nosbList, String sDate, String eDate);
	
	//在特定時間區內, 根據類別下拉式選項出現相對的電影名稱DBT => movies: genre(0,1,2,3,4,全(全部是上面的方法DEFAULT))
//	public List<String> GetTitlesByGenre();
	
//	//DBT: showTimeHistory => hallID, runID, playStartTime播放日期時間
//	
//	//根據輸入的起迄時間, 取得廳院的mID跟RunID, DBT => running
//	public List<RunningBean> getRunningInfo(Date sDate, Date eDate);
//	
////	public List<Integer> getMovieID(Date sDate, Date eDate);
//	
//	//取得x電影的場次數
//	public Integer CountShow(String movieID);
//	
//	//ShowTimeID: 取得x電影的場次DBT => (movies & running) & showTimeHistory
//	public Integer getShowTime(Integer movieID);
//	
//	//HallID & Date年月日only: 取得x電影x場次的Hall, DBT => showTimeHistory
//	public ShowTimeHistoryBean getShowHallandDate(Integer showTimeID); 
//	
//	//HallSeats: 取得x電影在x天x廳的座位數 DBT => numberOfSeats
////	public Integer getHallSeats(String hallID, Date date);
//	
//	//DBT: movies => movieID, title, runningTime片長, status上映狀態
//	
//	//DBT: running => release上映日, offDate實際下映日
//	
//	//包廳DBT:hallOrder => hallID, startTime, endTime, hallSubtotal租借總價格, payStatusNo(必須是1才是已付款)
//	public List<HallOrderBean> getHallOrderInfo();
//	
//	//取得已付款包廳價 DBT:hallOrder => hallSubtotal租借總價格, payStatusNo(必須是1才是已付款)
//	public Integer getHallOrderPrice(String hallID);
}
