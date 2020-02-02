package com.m.dao;

import java.util.List;

import com.a.model.ShowTimeHistoryBean;
import com.m.model.TicketSaleEarnBean;

public interface TicketSaleDao {
	//下拉式genre
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
	public List<TicketSaleEarnBean> getTicketSaleInfoByDate(Integer movieID, String sDate, String eDate);
	public List<TicketSaleEarnBean> getWithinDate(String date, Integer movieID);

//	public List<TicketSaleBean> getMOrderDetailBeanList();
//	public List<MOrderBean> getMOrderBean();
//	public List<TicketSaleBean> getTicketSaleBean(List<MOrderBean> modList);
//	public List<TicketSaleBean> getMOrderDetailBeanList(List<TicketSaleBean> tsbList);
//	
//	public List<String> getDistinctTitles();
	//取得票卷銷售相關資訊
//	public List<TicketSaleBean> getTicketSale(List<TicketSaleBean> tsbList);
}
