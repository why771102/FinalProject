package com.c.service;

import com.a.model.ShowTimeHistoryBean;
import com.c.model.SeatOrderBean;
import com.c.model.SeatsBean;

public interface SeatOrderService {

	public void insertSeatOrder(SeatOrderBean sob);

	public SeatsBean getSeatsById(String seatID);

	public ShowTimeHistoryBean getShowTimeById(Integer showTimeID);
}
