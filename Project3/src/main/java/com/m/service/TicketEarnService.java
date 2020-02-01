package com.m.service;

import java.util.List;

import com.m.model.TicketSaleEarnBean;

public interface TicketEarnService {
	public String getGenre();
	public String getMovieTitle(Integer movieID);
	public List<TicketSaleEarnBean> getTicketEarnInfo(String sDate, String eDate);
	public List<TicketSaleEarnBean> getTicketEarnInfo0(String sDate, String eDate);
	public List<TicketSaleEarnBean> getTicketEarnInfo1(String sDate, String eDate);
	public List<TicketSaleEarnBean> getTicketEarnInfo2(String sDate, String eDate);
	public List<TicketSaleEarnBean> getTicketEarnInfo3(String sDate, String eDate);
	public List<TicketSaleEarnBean> getTicketEarnInfo4(String sDate, String eDate);
	public List<TicketSaleEarnBean> getTicketEarnInfoByDate(Integer movieID, String sDate, String eDate);
	public List<TicketSaleEarnBean> getWithinDate(String date, Integer movieID);
}
