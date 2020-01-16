package com.m.service;

import java.util.List;
import com.a.model.RunningBean;
import com.a.model.ShowTimeHistoryBean;
import com.c.model.NumberOfSeatsBean;
import com.l.model.MOrderBean;
import com.m.model.TicketSaleBean;

public interface TicketSaleService {

	public List<MOrderBean> getMOrderBean();
	public List<TicketSaleBean> getTicketSaleBean(List<MOrderBean> modList);
	public List<TicketSaleBean> getMOrderDetailBeanList(List<TicketSaleBean> tsbList);

	public List<TicketSaleBean> comparedByTime(String sDate,String eDate); 	//input篩選
	public List<TicketSaleBean> getTicketSaleOutput(List<TicketSaleBean> tsbList); //title篩選
	public List<String> getDistinctTitles();
	public Integer countRepeatedIntegers(List<Integer> ints);
	public List<TicketSaleBean> getTicketSaleByTitle(List<TicketSaleBean> tsbList, String title); //P2 BY TITLE
	public List<TicketSaleBean> getTicketSaleByDateOutput(String sDate, String eDate); //P2 BY DATE
	//=======================================================================
	public List<RunningBean> ShowMovieByRunTime();
	public List<RunningBean> CompareByTime(String sDate, String eDate);
	public List<ShowTimeHistoryBean> getshowTimeHistory(List<RunningBean> RBList);
	public List<NumberOfSeatsBean> getNumberOfSeats(List<ShowTimeHistoryBean> sthbList);
	public List<NumberOfSeatsBean> getHallSeats(List<NumberOfSeatsBean> nosbList, String sDate, String eDate);

}
