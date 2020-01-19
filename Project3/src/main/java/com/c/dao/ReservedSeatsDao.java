package com.c.dao;

import java.util.List;

import com.a.model.ShowTimeHistoryBean;
import com.c.model.ReservationStatusBean;
import com.c.model.ReservedSeatsBean;
import com.c.model.SeatsBean;

public interface ReservedSeatsDao {
	
	//將座位表裏的每廳座位匯入reserved seats table 供使用者使用
	//應該在新增場次ID後生出一個禮拜內的位子共訂位
	public List<ShowTimeHistoryBean> insertSeats();
	
	//使用者定位將status從0(可訂位)改為1(已訂位)
	public void reserveSeat(ReservedSeatsBean rsb);
	
	public ReservedSeatsBean getSeat(Integer showTimeID, String seatID);
	
	public SeatsBean getSeatsById(String seatID);
	
	public ReservationStatusBean getReservationStatusById(Integer reservationStatus);
	
	public ShowTimeHistoryBean getShowTimeById(Integer showTimeID);
	
	//取消訂位從1(已訂位)改為0(可訂位)
	public void cancelReservedSeat(Integer showTimeID, String seatID);
	
	//要顯示給使用者看的畫面
	public List<ReservedSeatsBean> getAllSeats(Integer showTimeID);
	
//	public Integer calculateNumberOfSeats(List<ReservedSeatsBean> listRSB);
}
