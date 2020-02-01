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
	
	

//	public List<MOrderBean> getMOrderBean();
//	public List<TicketSaleBean> getTicketSaleBean(List<MOrderBean> modList);
//	public List<TicketSaleBean> getMOrderDetailBeanList(List<TicketSaleBean> tsbList);
//
//	public List<TicketSaleBean> comparedByTime(String sDate,String eDate); 	//input篩選
//	//p1方法
//	public List<TicketSaleBean> getTicketSaleOutput(List<TicketSaleBean> tsbList); //output:p1
//	//p2方法
//	public List<TicketSaleBean> getTicketSaleOutput2(List<TicketSaleBean> tsbListFromMovieList, String title);
//	public LinkedHashMap<LocalDate, TicketSaleBean> getInputTimeList(String sDate, String eDate, String title); //output:p2
//	//p3方法
//	public List<TicketSaleBean> getTicketSaleOutput3(List<TicketSaleBean> tsbListFromMovieList, String title);
//	public LinkedHashMap<String, TicketSaleBean> countRepeatedString(List<TicketSaleBean> tsbList3); //output: p3
//	
//	public List<TicketSaleBean> getSum(List<TicketSaleBean> tsbListFromOrder);
//	//缺少genre分類方法
//	public List<String> getDistinctTitles();
//	public Integer countRepeatedIntegers(List<Integer> ints);

}
