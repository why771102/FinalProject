package com.c.dao;

public interface ReservedSeatsDao {
	
	public void insertSeats();
	
	public void reserveSeat(Integer showTimeID, String seatID);
	
}
