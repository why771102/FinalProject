package com.c.service;

import java.util.List;

import com.a.model.ShowTimeHistoryBean;
import com.c.model.ReservedSeatsBean;
import com.c.model.SeatsBean;

public interface ReservedSeatsService {

	//將座位表裏的每廳座位匯入reserved seats table 供使用者使用
	public List<ShowTimeHistoryBean> insertSeats();
	
	//使用者定位將status從0(可訂位)改為1(已訂位)
	public void reserveSeat(ReservedSeatsBean rsb);
	
	public ReservedSeatsBean getSeat(Integer showTimeID, String seatID);
	
	public SeatsBean getSeatsById(String seatID);
	
	public ShowTimeHistoryBean getShowTimeById(Integer showTimeID);
	
	//取消訂位從1(已訂位)改為0(可訂位)
	public void cancelReservedSeat(Integer showTimeID, String seatID);
	
	//要顯示給使用者看的畫面
	public List<ReservedSeatsBean> getAllSeats(Integer showTimeID);
	
	public String[] showSeatChart(List<ReservedSeatsBean> listRSB, Integer colNum, Integer rowNum, String hallID);
	
}
