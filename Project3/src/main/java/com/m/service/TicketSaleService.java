package com.m.service;

import java.util.List;
import com.a.model.RunningBean;
import com.a.model.ShowTimeHistoryBean;
import com.c.model.NumberOfSeatsBean;

public interface TicketSaleService {

	public List<RunningBean> ShowMovieByRunTime();
	public List<RunningBean> CompareByTime(String sDate, String eDate);
	public List<ShowTimeHistoryBean> getshowTimeHistory(List<RunningBean> RBList);
	public List<NumberOfSeatsBean> getNumberOfSeats(List<ShowTimeHistoryBean> sthbList);
	public List<NumberOfSeatsBean> getHallSeats(List<NumberOfSeatsBean> nosbList, String sDate, String eDate);
//	public List<MovieBean> ShowMovieBean(List<RunningBean> RBListToPage);

}
