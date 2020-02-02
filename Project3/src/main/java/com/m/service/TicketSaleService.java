package com.m.service;

import java.util.List;
import com.a.model.ShowTimeHistoryBean;
import com.m.model.TicketSaleEarnBean;

public interface TicketSaleService {
	
	public String getGenre();
	public String getMovieTitle(Integer movieID);
	public List<TicketSaleEarnBean> getTicketSaleInfo(String sDate, String eDate);
	public List<TicketSaleEarnBean> getTicketSaleInfo0(String sDate, String eDate);
	public List<TicketSaleEarnBean> getTicketSaleInfo1(String sDate, String eDate);
	public List<TicketSaleEarnBean> getTicketSaleInfo2(String sDate, String eDate);
	public List<TicketSaleEarnBean> getTicketSaleInfo3(String sDate, String eDate);
	public List<TicketSaleEarnBean> getTicketSaleInfo4(String sDate, String eDate);
	public List<ShowTimeHistoryBean> getDetail(Integer movieID, String sDate, String eDate);
	public List<ShowTimeHistoryBean> getDetail(Integer movieID, String date);
	//p2
	public List<TicketSaleEarnBean> getTicketSaleInfoByDate(Integer movieID, String sDate, String eDate);
	//p3
	public List<TicketSaleEarnBean> getWithinDate(String date, Integer movieID);
}
