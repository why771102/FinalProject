package com.m.service;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.List;
import com.l.model.MOrderBean;
import com.m.model.TicketSaleBean;

public interface TicketSaleService {

	public List<MOrderBean> getMOrderBean();
	public List<TicketSaleBean> getTicketSaleBean(List<MOrderBean> modList);
	public List<TicketSaleBean> getMOrderDetailBeanList(List<TicketSaleBean> tsbList);

	public List<TicketSaleBean> comparedByTime(String sDate,String eDate); 	//input篩選
	//p1方法
	public List<TicketSaleBean> getTicketSaleOutput(List<TicketSaleBean> tsbList); //output:p1
	//p2方法
	public List<TicketSaleBean> getTicketSaleOutput2(List<TicketSaleBean> tsbListFromMovieList, String title);
	public LinkedHashMap<LocalDate, List<TicketSaleBean>> getInputTimeList(String sDate, String eDate, String title); //output:p2
	//p3方法
	public List<TicketSaleBean> getTicketSaleOutput3(List<TicketSaleBean> tsbListFromMovieList);
	
	public List<TicketSaleBean> getSum(List<TicketSaleBean> tsbListFromOrder);
	//缺少genre分類方法
	public List<String> getDistinctTitles();
	public Integer countRepeatedIntegers(List<Integer> ints);

}
