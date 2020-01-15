package com.m.dao;

import java.util.List;
import com.a.model.MovieBean;
import com.a.model.RunningBean;
import com.a.model.ShowTimeHistoryBean;
import com.c.model.NumberOfSeatsBean;
import com.l.model.MOrderBean;
import com.l.model.MOrderDetailBean;
import com.m.model.TicketSaleBean;

public interface TicketSaleDao {
	
	//回傳order, od, product表內的資訊
//	public List<TicketSaleBean> getMOrderDetailBeanList();
	public List<MOrderBean> getMOrderBean();
	public List<TicketSaleBean> getTicketSaleBean(List<MOrderBean> modList);
	public List<TicketSaleBean> getMOrderDetailBeanList(List<TicketSaleBean> tsbList);
	
	public List<String> getDistinctTitles();
	//取得票卷銷售相關資訊
//	public List<TicketSaleBean> getTicketSale(List<TicketSaleBean> tsbList);
	
	
	
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
	
//	//根據輸入的起迄時間, 取得廳院的mID跟RunID, DBT => running
//	public List<RunningBean> getRunningInfo(Date sDate, Date eDate);

//	//ShowTimeID: 取得x電影的場次DBT => (movies & running) & showTimeHistory
//	public Integer getShowTime(Integer movieID);

//	//DBT: movies => movieID, title, runningTime片長, status上映狀態
}
