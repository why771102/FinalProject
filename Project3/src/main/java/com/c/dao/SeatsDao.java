package com.c.dao;

import java.util.List;

import com.c.model.HallBean;
import com.c.model.SeatsBean;

//基本座位表
public interface SeatsDao {
	
	//在新增廳時有勾選的座位都要被存進來
	//在前端傳一個JSONARRAY到後端 用service將JSON轉成SeatsBean再呼叫此方法存入DB	
	public void insertSeats(SeatsBean sb);
	
	public HallBean getHallById(String hallID);
	
	public void updateSeatStatus(Integer status, String seatID, String flag);
	
	public List<SeatsBean> getAllSeatsUsingHallID(String hallID);
	
	public SeatsBean getSeat(String seatID);

}
