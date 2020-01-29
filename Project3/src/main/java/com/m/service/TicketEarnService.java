package com.m.service;

import java.util.List;

import com.m.model.TicketSaleEarnBean;

public interface TicketEarnService {
	public String getGenre();
	public List<TicketSaleEarnBean> getTicketEarnInfo(String sDate, String eDate);
	public List<TicketSaleEarnBean> getTicketEarnInfo0(String sDate, String eDate);
	public List<TicketSaleEarnBean> getTicketEarnInfo1(String sDate, String eDate);
	public List<TicketSaleEarnBean> getTicketEarnInfo2(String sDate, String eDate);
	public List<TicketSaleEarnBean> getTicketEarnInfo3(String sDate, String eDate);
	public List<TicketSaleEarnBean> getTicketEarnInfo4(String sDate, String eDate);
}
