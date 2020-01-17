package com.c.service;

import java.util.List;

import com.c.model.HallBean;
import com.c.model.SeatStatusBean;
import com.c.model.SeatsBean;
import com.c.model.TypeOfSeatBean;

public interface SeatsService {

	//在新增廳時有勾選的座位都要被存進來
	//在前端傳一個JSONARRAY到後端 用service將JSON轉成SeatsBean再呼叫此方法存入DB	
	public void insertSeats(SeatsBean sb);

	
	public HallBean getHallById(String hallID);

	public TypeOfSeatBean getTypeOfSeatById(Integer typeOfSeat);
	
	public SeatStatusBean getSeatStatusById(Integer seatStatus);
	
	
	public void updateSeatStatus(Integer status, String seatID, String flag);
	
	public List<SeatsBean> getAllSeatsUsingHallID(String hallID);
	
	//Turning string in the format of an array into a string[]
	public String[] stringToStringArray(String seats, String hallID);
	
	public void saveSeats(String seats, String hallID, Integer typeOfSeat);
	
	public String[] showSeatChart(List<SeatsBean> listSB, Integer colNum, Integer rowNum);
	
	public SeatsBean getSeat(String seatID);
	
}
