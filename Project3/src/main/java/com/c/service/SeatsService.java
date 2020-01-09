package com.c.service;

import java.util.List;

import com.c.model.HallBean;
import com.c.model.SeatsBean;

public interface SeatsService {

	//在新增廳時有勾選的座位都要被存進來
	//在前端傳一個JSONARRAY到後端 用service將JSON轉成SeatsBean再呼叫此方法存入DB	
	public void insertSeats(SeatsBean sb);
	
	public HallBean getHallById(String hallID);
	
	public void updateSeatStatus(Integer status, String seatID);
	
	public List<SeatsBean> getAllSeats(String hallID);
}
